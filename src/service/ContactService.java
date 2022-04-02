package service;

import models.Contact;
import models.EmailType;
import models.PhoneNumberType;
import models.pairs.IdAndContactNamePair;

import java.util.TreeMap;

import static validator.GetValidInputs.*;
import static contacts.PhoneBookDB.*;

public class ContactService {
    public void create(String contactName) {
        IdAndContactNamePair idAndContactNamePair = new IdAndContactNamePair(contactName);
        Contact contact = new Contact();
        while (true) {
            showActionsListForCreate();
            int createChoice = validChoice(0, 3);
            switch (createChoice) {
                case 1:
                    showPhoneNumberTypes();
                    int phoneNumberTypeChoice = validChoice(1, 5);
                    String phoneNumber = validPhoneNumber();
                    contact.addElementToPhoneNumbers(phoneNumberTypeChoice, phoneNumber);
                    break;
                case 2:
                    showEmailTypes();
                    int emailTypeChoice = validChoice(1, 6);
                    String email = validEmail();
                    contact.addElementToEmails(emailTypeChoice, email);
                    break;
                case 3:
                    String companyName = validCompanyName();
                    contact.setCompanyName(companyName);
                    break;
                case 0:
                    addIdCntNamePairAndContactToContacts(idAndContactNamePair, contact);
                    System.out.printf("Contact %s successfully saved.\n", contactName);
                    return;
            }
        }
    }

    public void search() {
        while (true) {
            showActionsListForSearch();
            int searchChoice = validChoice(0, 4);
            if (searchChoice == 0) {
                return;
            }
            String searchValue = validSearchValue();
            TreeMap<IdAndContactNamePair, Contact> treeMap;
            switch (searchChoice) {
                case 1:
                    treeMap = searchInContactsByName(searchValue);
                    printSearchResult(treeMap);
                    break;
                case 2:
                    treeMap = searchInContactsByPhoneNumber(searchValue);
                    printSearchResult(treeMap);
                    break;
                case 3:
                    treeMap = searchInContactsByEmail(searchValue);
                    printSearchResult(treeMap);
                    break;
                case 4:
                    treeMap = searchInContactsByCompanyName(searchValue);
                    printSearchResult(treeMap);
                    break;
            }
        }

    }

    public void update() {

    }

    private void showActionsListForUpdate() {
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To enter contact's phone number label and phone number.\n" +
                "2. To enter contact's email label and email.\n" +
                "3. To enter contact's company name.\n" +
                "0. To save contact.");
    }

    public void delete() {

    }

    private void showActionsListForCreate() {
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To enter contact's phone number label and phone number.\n" +
                "2. To enter contact's email label and email.\n" +
                "3. To enter contact's company name.\n" +
                "0. To save contact.");
    }

    private void showPhoneNumberTypes() {
        System.out.println("\nEnter the appropriate line number to choose phone number label you want:");
        int number = 0;
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            System.out.println(++number + ". " + phoneNumberType.getType());
        }
    }

    private void showEmailTypes() {
        System.out.println("\nEnter the appropriate line number to choose email label you want:");
        int number = 0;
        for (EmailType emailType : EmailType.values()) {
            System.out.println(++number + ". " + emailType.getType());
        }
    }

    private void printSearchResult(TreeMap<IdAndContactNamePair, Contact> treeMap) {
        if (treeMap.size() == 0) {
            System.out.println("There is no contact matching your input.");
        } else if (treeMap.size() == 1) {
            System.out.println(treeMap.firstEntry().getKey().getContactName() + '\n' +
                    treeMap.firstEntry().getValue());
        } else {
            int itemNumber = 0;
            for (IdAndContactNamePair pair : treeMap.navigableKeySet()) {
                System.out.println(++itemNumber + ". " + pair.getContactName() + '\n' + treeMap.get(pair).toString());
            }
        }
    }

    private void showActionsListForSearch() {
        System.out.println("\nEnter the appropriate line number of the criteria by which you want to search:\n" +
                "1. Search by contact's name.\n" +
                "2. Search by contact's phone number.\n" +
                "3. Search by contact's email.\n" +
                "4. Search by contact's company name.\n" +
                "0. Finish searching.");
    }
}
