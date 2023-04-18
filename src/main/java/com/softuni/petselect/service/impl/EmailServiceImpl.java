package com.softuni.petselect.service.impl;

import com.softuni.petselect.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final MessageSource messageSource;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine, MessageSource messageSource) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.messageSource = messageSource;
    }



    @Override
    public void sendRegistrationEmail(
            String userEmail,
            String userName,
            Locale preferredLocale
    ) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setFrom("petselect23@gmail.com");
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject(getRegistrationEmailSubject(preferredLocale));
            mimeMessageHelper.setText(generateRegistrationMessageContent(preferredLocale, userName), true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendResetPasswordEmail(String userEmail,
                                       String userName,
                                       String link,
                                       Locale preferredLocale) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setFrom("petselect23@gmail.com");
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject(getResetPasswordEmailSubject(preferredLocale));
            mimeMessageHelper.setText(generateResetPasswordMessageContent(preferredLocale, userName, link), true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRegistrationEmailSubject(Locale locale) {
        return messageSource.getMessage(
                "registration_subject",
                new Object[0],
                locale);
    }

    private String getResetPasswordEmailSubject(Locale locale) {
        return messageSource.getMessage(
                "password_reset_subject",
                new Object[0],
                locale);
    }

    private String generateRegistrationMessageContent(Locale locale,
                                          String userName) {
        Context ctx = new Context();
        ctx.setLocale(locale);
        ctx.setVariable("userName", userName);

        return templateEngine.process("email/registration", ctx);
    }

    private String generateResetPasswordMessageContent(Locale locale, String userName,
                                                      String link) {
        Context ctx = new Context();
        ctx.setLocale(locale);
        ctx.setVariable("userName", userName);
        ctx.setVariable("link", link);

        return templateEngine.process("email/reset-password", ctx);
    }

}

