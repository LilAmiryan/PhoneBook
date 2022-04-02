package validator;

import java.util.Scanner;

import static validator.Validator.*;

public final class GetValidInputs {
    private static final Scanner SCANNER = new Scanner(System.in);

    private GetValidInputs() {
    }

    public static int validChoice(int min, int max) {
        String choice = "-1";
        boolean isValidInput = true;
        while (!isValidChoice(min, max, choice)) {
            if (!isValidInput) {
                System.out.printf("You can input only one digit number between %d and %d.\n", min, max);
            }
            System.out.print("Enter your choice: ");
            choice = SCANNER.nextLine();
            isValidInput = false;
        }
        return Integer.parseInt(choice);
    }

    public static String validContactName() {
        String contactName = "";
        boolean isValidInput = true;
        while (!isValidContactName(contactName)) {
            if (!isValidInput) {
                System.out.println("You can input anything with a length between 1 and 50.");
            }
            System.out.print("Enter contact name: ");
            contactName = SCANNER.nextLine();
            isValidInput = false;
        }
        return contactName;
    }

    public static String validPhoneNumber() {
        String phoneNumber = "";
        boolean isValidInput = true;
        while (!isValidPhoneNumber(phoneNumber)) {
            if (!isValidInput) {
                System.out.println("You can input only numbers and this 4 symbols +, (), - and space.");
            }
            System.out.print("Enter phone number: ");
            phoneNumber = SCANNER.nextLine();
            isValidInput = false;
        }
        return phoneNumber;
    }

    public static String validEmail() {
        String email = "";
        boolean isValidInput = true;
        while (!isValidEmail(email)) {
            if (!isValidInput) {
                System.out.println("You can input only latin letters, numbers and this symbols . _ % + - before @" +
                        "with length between 6 and 30,\nafter it you can input latin letters, numbers and symbols . - " +
                        "for domain name with length between 2 and 30\nand only latin letters for " +
                        "domain name extension with length between 2 and 6.");
            }
            System.out.print("Enter email: ");
            email = SCANNER.nextLine();
            isValidInput = false;
        }
        return email;
    }

    public static String validCompanyName() {
        String companyName = "";
        boolean isValidInput = true;
        while (!isValidCompanyName(companyName)) {
            if (!isValidInput) {
                System.out.println("You can input anything with a length between 1 and 50.");
            }
            System.out.print("Enter company name: ");
            companyName = SCANNER.nextLine();
            isValidInput = false;
        }
        return companyName;
    }

    public static String validSearchValue() {
        String searchValue = "";
        boolean isValidInput = true;
        while (searchValue.length() < 1) {
            if (!isValidInput) {
                System.out.println("You can input anything at least with a length of 1.");
            }
            System.out.print("Enter searching value: ");
            searchValue = SCANNER.nextLine();
            isValidInput = false;
        }
        return searchValue;
    }
}
