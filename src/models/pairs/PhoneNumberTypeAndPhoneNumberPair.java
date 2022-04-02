package models.pairs;

import models.PhoneNumberType;

public class PhoneNumberTypeAndPhoneNumberPair {
    private PhoneNumberType phoneNumberType;
    private String phoneNumber;

    public PhoneNumberTypeAndPhoneNumberPair(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumberType.getType() + ": " + phoneNumber;
    }
}
