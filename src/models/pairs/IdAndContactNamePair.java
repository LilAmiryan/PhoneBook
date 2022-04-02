package models.pairs;

import java.util.ArrayList;

public class IdAndContactNamePair implements Comparable<IdAndContactNamePair> {
    private String contactName;
    private final int id;
    private static final ArrayList<Integer> ID_LIST = new ArrayList<>();

    public IdAndContactNamePair(String contactName) {
        this.contactName = contactName;
        addElementToIdList();
        this.id = getLastElementOfIdList();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getId() {
        return id;
    }

    private void addElementToIdList() {
        int size = ID_LIST.size();
        if (size > 0) {
            int lastElement = ID_LIST.get(size - 1);
            ID_LIST.add(lastElement + 1);
        } else {
            ID_LIST.add(1);
        }
    }

    private int getLastElementOfIdList() {
        int size = ID_LIST.size();
        return ID_LIST.get(size - 1);
    }

    @Override
    public String toString() {
        return id + ". " + contactName;
    }

    @Override
    public int compareTo(IdAndContactNamePair o) {
        return this.contactName.compareTo(o.contactName) != 0 ?
                this.contactName.compareTo(o.contactName) :
                (this.id - o.id);
    }
}
