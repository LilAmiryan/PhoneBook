package contacts;

import models.Contact;
import models.pairs.EmailTypeAndEmailPair;
import models.pairs.IdAndContactNamePair;
import models.pairs.PhoneNumberTypeAndPhoneNumberPair;

import java.util.*;

public class PhoneBookDB {
    private static final TreeMap<IdAndContactNamePair, Contact> CONTACTS = new TreeMap<>();

    public static TreeMap<IdAndContactNamePair, Contact> getContacts() {
        return CONTACTS;
    }

    public static void addIdCntNamePairAndContactToContacts(IdAndContactNamePair idAndContactNamePair, Contact contact) {
        CONTACTS.put(idAndContactNamePair, contact);
    }

    public static TreeMap<IdAndContactNamePair, Contact> searchInContactsByName(String searchValue) {
        searchValue = searchValue.toLowerCase();
        TreeMap<IdAndContactNamePair, Contact> result = new TreeMap<>();
        for (IdAndContactNamePair pair : CONTACTS.navigableKeySet()) {
            if ((pair.getContactName().toLowerCase()).contains(searchValue)) {
                result.put(pair, CONTACTS.get(pair));
            }
        }
        return result;
    }

    public static TreeMap<IdAndContactNamePair, Contact> searchInContactsByPhoneNumber(String searchValue) {
        TreeMap<IdAndContactNamePair, Contact> result = new TreeMap<>();
        for (Map.Entry<IdAndContactNamePair, Contact> set : CONTACTS.entrySet()) {
            for (PhoneNumberTypeAndPhoneNumberPair pair : set.getValue().getPhoneNumbers()) {
                if (pair.getPhoneNumber().contains(searchValue)) {
                    result.put(set.getKey(), set.getValue());
                    break;
                }
            }
        }
        return result;
    }

    public static TreeMap<IdAndContactNamePair, Contact> searchInContactsByEmail(String searchValue) {
        TreeMap<IdAndContactNamePair, Contact> result = new TreeMap<>();
        for (Map.Entry<IdAndContactNamePair, Contact> set : CONTACTS.entrySet()) {
            for (EmailTypeAndEmailPair pair : set.getValue().getEmails()) {
                if (pair.getEmail().contains(searchValue)) {
                    result.put(set.getKey(), set.getValue());
                    break;
                }
            }
        }
        return result;
    }

    public static TreeMap<IdAndContactNamePair, Contact> searchInContactsByCompanyName(String searchValue) {
        TreeMap<IdAndContactNamePair, Contact> result = new TreeMap<>();
        for (Map.Entry<IdAndContactNamePair, Contact> set : CONTACTS.entrySet()) {
            if (set.getValue().getCompanyName().contains(searchValue)) {
                result.put(set.getKey(), set.getValue());
            }
        }
        return result;
    }

    public static void showAllContacts() {

    }
}
