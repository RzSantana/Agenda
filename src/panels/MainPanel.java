package panels;

import components.ContactsList;
import components.HeaderMain;
import components.Search;

import javax.swing.*;

public class MainPanel extends JPanel {
    private HeaderMain header;
    private Search search;
    private ContactsList contactsList;

    public MainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(null);

        header = new HeaderMain();
        search = new Search("Buscar Contacto...");
        contactsList = new ContactsList();

        add(header);
        add(search);
        add(contactsList);
    }
}
