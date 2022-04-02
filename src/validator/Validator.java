package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    /**
     * We have to give documentation for all patterns!
     */
    public static final Pattern VALID_NAME_PATTERN = Pattern.compile("^(.){1,50}$");
    public static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?[0-9 ]{6,35}$");
    /**
     * (?=.{6,30}@)            # local-part min 6 max 30
     *
     * [A-Za-z0-9_-]+          # Start with chars in the bracket [ ], one or more (+)
     *                         # dot (.) not in the bracket[], it can't start with a dot (.)
     *
     * (\\.[A-Za-z0-9_-]+)*	 # follow by a dot (.), then chars in the bracket [ ] one or more (+)
     *                         # * means this is optional
     *                         # this rule for two dots (.)
     *
     * @                       # must contain a @ symbol
     *
     * [^-]                    # domain can't start with a hyphen (-)
     *
     * [A-Za-z0-9-]+           # Start with chars in the bracket [ ], one or more (+)
     *
     * (\\.[A-Za-z0-9-]+)*      # follow by a dot (.), optional
     *
     * (\\.[A-Za-z]{2,})       # the last tld, chars in the bracket [ ], min 2
     */
    public static final Pattern VALID_EMAIL_PATTERN =
            Pattern.compile("^(?=.{6,30}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+" +
                    "(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
//    public static final Pattern VALID_EMAIL_PATTERN =
//     Pattern.compile("^([A-Z0-9._%+-]{5,31})+@([A-Z0-9.-]{2,30})+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidChoice(int min, int max, String choice) {
        int length = choice.length();
        if (length != 1) {
            return false;
        }
        if (!isStringNumeric(choice)) {
            return false;
        }
        int choiceNumber = Integer.parseInt(choice);
        return (choiceNumber >= min && choiceNumber <= max);
    }

    private static boolean isStringNumeric(String str) {
        return str.charAt(0) >= '0' && str.charAt(0) <= '9';
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
