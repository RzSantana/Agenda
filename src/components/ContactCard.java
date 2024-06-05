package components;

import models.ContactID;
import models.ContactName;
import models.ContactNumberPhone;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ContactCard extends JPanel {
    private ContactID id;
    private ContactName name;
    private ContactNumberPhone numberPhone;

    public ContactCard(int id, String name, String numberPhone) {
        this.id = new ContactID(id);
        this.name = new ContactName(name);
        this.numberPhone = new ContactNumberPhone(numberPhone);

        setBackground(new Color(213, 213, 213, 255));
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 5, 10, 5));

        JPanel contentText = new JPanel();
        contentText.setBackground(null);
        contentText.setLayout(new BoxLayout(contentText, BoxLayout.Y_AXIS));
        contentText.setBorder(new EmptyBorder(5, 15, 5, 15));

        JLabel textName = new JLabel(this.name.toString());
        textName.setBackground(null);
        textName.setFont(new Font(getName(), Font.BOLD, 20));

        JLabel textNumberPhone = new JLabel(this.numberPhone.toString());
        textNumberPhone.setBackground(null);
        textNumberPhone.setFont(new Font(getName(), Font.PLAIN, 16));

        contentText.add(textName);
        contentText.add(textNumberPhone);

        add(contentText);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }
}
