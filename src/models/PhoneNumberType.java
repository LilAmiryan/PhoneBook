package models;

public enum PhoneNumberType {
    MOBILE(1, "Mobile"),
    HOME(2, "Home"),
    WORK(3, "Work"),
    SCHOOL(4, "School"),
    OTHER(5, "Other");

    private final int id;
    private final String type;

    private PhoneNumberType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return this.type;
    }

    public static PhoneNumberType findById(int id) {
        for (PhoneNumberType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
