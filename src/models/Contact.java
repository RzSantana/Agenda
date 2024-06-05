package models;

public class Contact {
    private ContactID id;
    private ContactName name;
    private ContactNumberPhone numberPhone;

    public Contact(ContactID id, ContactName name, ContactNumberPhone numberPhone) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return Integer.parseInt(id.toString());
    }

    public String getName() {
        return name.toString();
    }

    public String getNumberPhone() {
        return numberPhone.toString();
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone.setValue(numberPhone);
    }

    @Override
    public String toString() {
        return String.format("Contacto {\n\tid=%s\n\tname=%s\n\tnumberPhone=%s\n}", id.toString(), name, numberPhone);
    }
}