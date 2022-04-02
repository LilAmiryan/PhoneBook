package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final Pattern VALID_NAME_PATTERN = Pattern.compile("(.*){1,50}$");
    public static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    public static final Pattern VALID_EMAIL_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidChoice(int min, int max, int choice) {
            return (choice>=min && choice<=max);
    }

    private Validator(){}
    public static boolean isValidContactName(String contactName) {
        Matcher matcher = VALID_NAME_PATTERN.matcher(contactName);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Matcher matcher = VALID_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidCompanyName(String companyName) {
        Matcher matcher = VALID_NAME_PATTERN.matcher(companyName);
        return matcher.matches();
    }
}
