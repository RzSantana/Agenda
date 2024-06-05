package models;

public class ContactID {
    private int value;

    public ContactID(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int id) {
        this.value = id;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
