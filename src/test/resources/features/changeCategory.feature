Feature: Cambiar de categoría el paquete turístico

  Scenario: El usuario cambia el paquete de categoría
    Given el usuario elige el paquete que desea cambiar
    When el usuario cambia la categoría
    Then se muestra un mensaje de confirmación de envío exitoso
