package models;

public enum EmailType {
    GMAIL(1, "Gmail"),
    MAIL_RU(2, "Mail.ru"),
    OUTLOOK(3, "Outlook"),
    ICLOUD(4, "iCloud"),
    YAHOO(5, "Yahoo"),
    OTHER(6, "Other");

    private final int id;
    private final String type;

    private EmailType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return this.type;
    }

    public static EmailType findById(int id) {
        for (EmailType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
