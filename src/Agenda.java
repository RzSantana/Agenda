import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Agenda extends JFrame {
    private JPanel mainPanel;
    private JPanel header;
    private JTextField inputText;
    private JButton btnAddContact;
    private JList<String> listContacts;

    String[] data = {"one", "two", "three", "four"};


    public Agenda() {
        setTitle("Agenda");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new BorderLayout(0, 20));
        setContentPane(mainPanel);

        header = new JPanel();
        header.setLayout(new BorderLayout(10, 0));
        header.setBorder(new EmptyBorder(10, 10, 10, 10));
        header.setBackground(Color.DARK_GRAY);
        add(BorderLayout.BEFORE_FIRST_LINE, header);

        inputText = new JTextFieldPrompt("Nombre", 20);
        header.add(BorderLayout.WEST, inputText);

        btnAddContact = new JButton("Add");
        header.add(BorderLayout.EAST, btnAddContact);

        listContacts = new JList<String>(data);
        listContacts.setBackground(Color.DARK_GRAY);
        listContacts.setForeground(Color.WHITE);
        listContacts.setBorder(new EmptyBorder(0, 30, 0, 30));
        add(BorderLayout.CENTER, listContacts);
    }
}
