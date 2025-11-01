<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen" />
  <img src="https://img.shields.io/badge/MySQL-8-blue" />
  <img src="https://img.shields.io/badge/JWT-Security-yellow" />
  <img src="https://img.shields.io/badge/Maven-Build-purple" />
</p>

# 🌿 WildPath API — Plataforma de Reservas de Turismo Aventura

WildPath es una **plataforma de reservas de experiencias de turismo aventura**, donde los usuarios pueden explorar paquetes, registrarse, iniciar sesión y reservar actividades de naturaleza y aventura.

Este repositorio contiene el **Backend en Java + Spring Boot**, con autenticación JWT, roles, MySQL y seed automático de datos.

---

## 🚀 Tecnologías

| Área | Tech |
|------|------|
Lenguaje | Java 17  
Framework | Spring Boot  
ORM | Hibernate + JPA  
DB | MySQL 8  
Seguridad | Spring Security + JWT + BCrypt  
Build | Maven  
Mail | SMTP (Gmail App Password)

---

## ✅ Funcionalidades

- Registro e inicio de sesión
- Roles `USER` & `ADMIN`
- Exploración de paquetes turísticos
- Reservas de actividades
- Gestión de disponibilidad y cupos
- Notificaciones por email (registro & confirmación)
- Datos seed automáticos para pruebas

---

## 🏗 Requisitos

| Herramienta | Versión |
|-------------|--------|
Java | 17+  
MySQL | 8+  
Maven | 3+  

---

## ⚙️ Instalación & Ejecución

### 1️⃣ Clonar el repo
```bash
git clone https://github.com/AnaMateasovich/Wildpath-API.git
cd Wildpath-API
```

### 2️⃣ Crear archivo .env
Crea un archivo .env en la raíz del proyecto o exporta estas variables en tu entorno. No subas el .env al repo.

```bash
DB_URL=jdbc:mysql://localhost:3306/wildpath?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
DB_USERNAME=tu_usuario_mysql
DB_PASSWORD=tu_password_mysql

MAIL_USER=tu_email@gmail.com
MAIL_PASS=tu_app_password_gmail

FRONTEND_URL=http://localhost:3000
BACKEND_URL=http://localhost:8081
```
⚠ MAIL_PASS corresponde a una App Password de Gmail (no tu contraseña normal).
Si prefieres no configurar email en local, dejá MAIL_USER y MAIL_PASS vacíos y la app seguirá funcionando sin enviar correos.

### 3️⃣ Instalar dependencias
```bash
mvn clean install
```

### 4️⃣ Ejecutar la API
```bash
mvn spring-boot:run
```
La API quedará corriendo en:
➡ http://localhost:8081

## 🗄 Base de Datos

Este proyecto incluye:

| Archivo      | Función                              |
|--------------|--------------------------------------|
| `schema.sql` | Crea todas las tablas (estructura)   |
| `data.sql`   | Inserta datos demo (seed)            |

Spring ejecuta `schema.sql` primero y luego `data.sql` automáticamente (configurado en `application.properties`).

> ✅ No es necesario importar manualmente; el proyecto crea la base y carga los datos en el primer arranque si las variables están correctas.

---

## 👤 Usuarios Demo

| Rol   | Email                     | Pass     |
|-------|---------------------------|----------|
| Admin | `demo.admin@wildpath.com` | `demo123` |
| User  | `demo.user@wildpath.com`  | `demo123` |

> Las contraseñas en la BD están hasheadas (BCrypt).

---

## 📬 Endpoints principales (resumen)

| Método | Endpoint                | Función                        |
|--------|-------------------------|--------------------------------|
| POST   | `/auth/register`       | Registrar usuario              |
| POST   | `/auth/login`          | Login → devuelve JWT           |
| GET    | `/packages`            | Listar paquetes turísticos     |
| GET    | `/packages/{id}`       | Ver detalle de paquete         |
| POST   | `/reservations`        | Crear reserva                  |
| GET    | `/reservations/me`     | Ver mis reservas               |
| GET    | `/admin/reservations`  | Panel admin (gestión reservas) |

> Sugerido: Documentar con **Postman / Swagger** 📌

---

## 🎨 Frontend

El frontend está desarrollado en **React** (repositorio separado).

---

## 🧿 Roadmap

- ✅ Seed automático (`schema.sql` + `data.sql`)
- ✅ Autenticación + roles
- ✅ CRUD de paquetes y reservas
- 📩 Envío de email de confirmación de reserva

---

## ✨ Autor

**Ana Mateasovich**  
Full Stack Developer — Java | Spring | React | MySQL

---

## ⭐ Contribuciones & ⭐

Si este proyecto te gustó, dejá una ⭐ en GitHub ✨
