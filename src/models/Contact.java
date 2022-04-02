package models;

import models.pairs.EmailTypeAndEmailPair;
import models.pairs.PhoneNumberTypeAndPhoneNumberPair;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers = new ArrayList<>();
    private String companyName;
    private List<EmailTypeAndEmailPair> emails = new ArrayList<>();

    public List<PhoneNumberTypeAndPhoneNumberPair> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<EmailTypeAndEmailPair> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailTypeAndEmailPair> emails) {
        this.emails = emails;
    }

    public void addElementToPhoneNumbers(int phoneNumberTypeChoice, String phoneNumber) {
        PhoneNumberType phoneNumberType = PhoneNumberType.findById(phoneNumberTypeChoice);
        PhoneNumberTypeAndPhoneNumberPair phoneNumberTypeAndPhoneNumberPair =
                new PhoneNumberTypeAndPhoneNumberPair(phoneNumberType, phoneNumber);
        phoneNumbers.add(phoneNumberTypeAndPhoneNumberPair);
    }

    public void addElementToEmails(int emailTypeChoice, String email) {
        EmailType emailType = EmailType.findById(emailTypeChoice);
        EmailTypeAndEmailPair emailTypeAndEmailPair =
                new EmailTypeAndEmailPair(emailType, email);
        emails.add(emailTypeAndEmailPair);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PhoneNumberTypeAndPhoneNumberPair pair : phoneNumbers) {
            result.append(pair).append('\n');
        }
        if (companyName != null) {
            result.append("Company: ").append(companyName).append('\n');
        }
        for (EmailTypeAndEmailPair pair : emails) {
            result.append(pair).append('\n');
        }
        return result.toString();
    }
}
