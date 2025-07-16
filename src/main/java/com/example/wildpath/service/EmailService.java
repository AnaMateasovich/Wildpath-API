package com.example.wildpath.service;

import com.example.wildpath.entity.User;
import com.example.wildpath.entity.VerificationToken;
import com.example.wildpath.repository.IUserRepository;
import com.example.wildpath.repository.IVerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${frontend.url}")
    private String frontendUrl;

    private final IVerificationTokenRepository tokenRepository;
    private final IUserRepository userRepository;

    public EmailService(IVerificationTokenRepository tokenRepository, IUserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    public void sendVerificationEmail(String to, String verificationLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirm your account");
        message.setText("Click the following link to verify your email:\n" + verificationLink);
        message.setFrom("wildpathturismo@gmail.com");

        mailSender.send(message);
    }

    public String verifyUser(String token) {
        var maybeToken = tokenRepository.findByToken(token);
        if (maybeToken.isEmpty()) {
            // Ya sea porque expiró, o porque ya se usó y borraste el registro:
            return "Este enlace no es válido o ya fue usado. Si necesitas uno nuevo, solicítalo nuevamente.";

        }

        VerificationToken verificationToken = maybeToken.get();

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return "El enlace ha expirado. Por favor solicita uno nuevo.";
        }

        User user = verificationToken.getUser();
        if (Boolean.TRUE.equals(user.getEnabled())) {
            return "Tu cuenta ya esta activada. Puedes iniciar sesión.";
        }

        // Activo al usuario y limpio el token
        user.setEnabled(true);
        userRepository.save(user);

        return "Your account has been activated. You can now log in.";
    }

    public void sendConfirmationReserve(String to, String pkgName,LocalDateTime reservationDateTime , String date, String enterpriseContact, String token) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm");
        String formattedReservation = reservationDateTime.format(fmt);

        String confirmationLink = frontendUrl + "/booking/confirm?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirmación de tu reserva");
        message.setText("Hola!\n\nGracias por tu reserva. \n\n"
                + "Detalles de la reserva:\n"
                + "- Paquete: " + pkgName +"\n"
                + "- Fecha de salida: " + date + "\n"
                + "- Fecha y hora de la reserva: " + formattedReservation + "\n"
                + "- Contacto del proveedor: " + enterpriseContact + "\n\n"
                + "Por favor, confirma tu reserva haciendo clic en el siguiente enlace:\n"
                + confirmationLink + "\n\n"
                + "¡Gracias por elegirnos!"
        );
        mailSender.send(message);
    }
}
