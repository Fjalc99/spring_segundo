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

        if (email != null && !email.isEmpty()) {
            try {

                InternetAddress.parse(email);

                String subject = "Activa tu cuenta";
                String activationUrl = "http://localhost:8080/users/activate?token=" + token;
                String body = "Haz clic en el siguiente enlace para activar tu cuenta: " + activationUrl;

                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject(subject);
                message.setText(body);
                javaMailSender.send(message);

            } catch (AddressException e) {

                System.err.println("Dirección de correo inválida: " + email);

            }
        } else {

            System.err.println("La dirección de correo electrónico no puede ser nula o vacía.");

        }
    }
}

