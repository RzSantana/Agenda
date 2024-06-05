package panels;

import components.ContactCard;
import components.ContactsList;
import components.HeaderMain;
import components.Search;
import models.Contact;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel {
    private HeaderMain header;
    private Search search;
    public ContactsList contactsList;

    public MainPanel(List<Contact> refContacts) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(null);

        header = new HeaderMain();
        search = new Search("Buscar Contacto...");
        contactsList = new ContactsList();

        add(header);
        add(search);
        add(contactsList);

       if (refContacts != null) {
            for (Contact contact: refContacts){
                System.out.println(contact.toString());

                ContactCard card = new ContactCard(contact.getId(), contact.getName(), contact.getNumberPhone());
                contactsList.addContact(card);

                contactsList.revalidate();
                contactsList.repaint();
            }
        }

    }

    public ContactsList getContactsList() {
        return this.contactsList;
    }
}
