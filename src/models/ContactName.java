package models;

public class ContactName{
    private String value;

     public ContactName(String name) {
         this.value = name;
     }

    public String getValue() {
        return value;
    }

    public void setValue(String name) {
        this.value = name;
    }

    @Override
    public String toString() {
        return value;
    }
}

