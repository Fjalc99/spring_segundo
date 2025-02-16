package com.salesianostriana.dam.jwt.security.security.jwt.access;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendActivationEmail(String email, String token) {
        // Verificar que el email no sea nulo ni vacío
        if (email != null && !email.isEmpty()) {
            try {
                // Intentar parsear el email para asegurarse de que es una dirección válida
                InternetAddress.parse(email); // Esta línea valida el email

                String subject = "Activa tu cuenta";
                String activationUrl = "http://localhost:8080/users/activate?token=" + token;
                String body = "Haz clic en el siguiente enlace para activar tu cuenta: " + activationUrl;

                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject(subject);
                message.setText(body);
                javaMailSender.send(message);

            } catch (AddressException e) {
                // Manejar el caso en que la dirección de correo es inválida
                System.err.println("Dirección de correo inválida: " + email);
                // Aquí puedes lanzar una excepción personalizada o manejar el error según sea necesario
            }
        } else {
            // Manejar el caso en el que el correo es nulo o vacío
            System.err.println("La dirección de correo electrónico no puede ser nula o vacía.");
            // Lanzar una excepción o devolver un mensaje adecuado
        }
    }
}

