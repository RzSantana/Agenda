package models;

public class ContactNumberPhone {
    private String value;

    public ContactNumberPhone(String number) {
        this.value = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
