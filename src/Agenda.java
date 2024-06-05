import components.FloatingActionButton;
import database.ContactDAO;
import models.Contact;
import panels.MainPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Agenda extends JFrame {
    private JPanel body;
    private MainPanel mainPanel;
    private List<Contact> contactList;

    public Agenda() {
        try {
            contactList = ContactDAO.getAllContacts();
            System.out.println("[!] Usuarios obtenidos");
        } catch (SQLException e) {
            System.err.println("[ERROR] No se ha podido obtener los usuarios");
        }

        body = new JPanel();
        body.setBackground(Color.WHITE);
        body.setBorder(new EmptyBorder(0, 20, 0, 20));
        body.setLayout(new BorderLayout());

        mainPanel = new MainPanel(contactList);
        FloatingActionButton floatingActionButton = new FloatingActionButton();
        floatingActionButton.setRefContactsList(mainPanel.getContactsList());

        setTitle("Agenda");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        setLocationRelativeTo(null);
        setContentPane(body);

        add(new JLayer<>(mainPanel, floatingActionButton));
    }
}
