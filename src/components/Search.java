package components;

import utils.styling.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class Search extends JPanel {
    private TextFieldPrompt inputSearch;

    public Search(String placeholder) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(new RoundedBorder(2, 14, Color.DARK_GRAY));

        inputSearch = new TextFieldPrompt(placeholder, 0);
        inputSearch.setBorder(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(inputSearch, gbc);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }
}
