package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ContactsList extends JScrollPane {
    private JPanel list;
    private JScrollBar scrollBar;
    private JLabel textMessage;

    public ContactsList() {
        textMessage = new JLabel("No hay Contactos");
        textMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        textMessage.setAlignmentY(Component.CENTER_ALIGNMENT);
        textMessage.setFont(new Font(getFont().getFontName(), Font.BOLD, 25));
        textMessage.setForeground(new Color(0, 0, 0, 50));


        list = new JPanel();
        list.setBackground(Color.WHITE);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(textMessage);


        scrollBar = new JScrollBar();
        scrollBar.setBackground(null);
        scrollBar.setBorder(null);
        scrollBar.setUnitIncrement(25);
        scrollBar.setBlockIncrement(50);

        setBackground(null);
        setBorder(new EmptyBorder(20, 0, 0, 0));
        setVerticalScrollBar(scrollBar);
        setViewportView(list);
        setPreferredSize(new Dimension(Integer.MAX_VALUE, 500));

        updateMessageEmptyContacts();
    }

    public void addContact(ContactCard newContactCard) {
        list.add(newContactCard);
        list.add(Box.createRigidArea(new Dimension(0, 20)));
        updateMessageEmptyContacts();
        list.revalidate();
        list.repaint();
    }

    public void removeContact(ContactCard contactCard) {
        list.remove(contactCard);
        updateMessageEmptyContacts();
        list.revalidate();
        list.repaint();
    }

    public void updateMessageEmptyContacts() {
        boolean hasContacts = list.getComponentCount() > 1;
        textMessage.setVisible(!hasContacts);
    }
}
