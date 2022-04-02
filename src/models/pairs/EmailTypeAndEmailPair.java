package models.pairs;

import models.EmailType;

public class EmailTypeAndEmailPair {
    private EmailType emailType;
    private String email;

    public EmailTypeAndEmailPair(EmailType emailType, String email) {
        this.emailType = emailType;
        this.email = email;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return emailType.getType() + ": " + email;
    }
}
