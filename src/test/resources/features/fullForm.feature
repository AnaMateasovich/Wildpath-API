Feature: Envío del formulario de paquete turístico

  Scenario: El usuario completa y envía el formulario con datos válidos
    Given el usuario completa el formulario de empresa y paquete
    When el usuario envia el formulario
    Then se muestra un mensaje de confirmacion de envío exitoso
