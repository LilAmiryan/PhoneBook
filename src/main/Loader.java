package main;

import contacts.PhoneBookDB;
import models.Contact;
import models.pairs.IdContactNamePair;
import service.ContactService;

import java.util.Scanner;
import java.util.TreeMap;

import static validator.Validator.*;

public class Loader {
    public static void start() {
        showMenu();

        Scanner scanner = new Scanner(System.in);
        int choice=0;

        while (true) {
            while (!isValidChoice(1,2,3)) {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }

            ContactService contactService = new ContactService();

            switch (choice) {
                case 1:
                    contactService.create();
                    break;
                case 2:
                    contactService.search("aaaaa");
                    break;
                case 3:
                    contactService.update();
                    break;
                case 4:
                    contactService.delete();
                    break;
                case 5:
                    TreeMap<IdContactNamePair, Contact> contacts = PhoneBookDB.getContacts();
                    showContacts(contacts);
                    break;
                case 6:
                    showMenu();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("Enter 1 to add a new contact.");
        System.out.println("Enter 2 to search a contact.");
        System.out.println("Enter 3 to update a contact.");
        System.out.println("Enter 4 to delete a contact.");
        System.out.println("Enter 5 to view contacts list.");
        System.out.println("Enter 9 to view the menu list.");
        System.out.println("Enter 0 to exit from application");
    }

    //This method maybe needs to change return type to String
    private static void showContacts(TreeMap<IdContactNamePair, Contact> contacts) {

    }
}
