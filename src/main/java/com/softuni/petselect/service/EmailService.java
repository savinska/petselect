package com.softuni.petselect.service;

import java.util.Locale;

public interface EmailService {
    void sendRegistrationEmail(String userEmail, String username, Locale preferredLocale);

}
