package database;

import models.Contact;
import models.ContactID;
import models.ContactName;
import models.ContactNumberPhone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public static List<Contact> getAllContacts() throws SQLException {
        String query = "SELECT * FROM contacts";
        List<Contact> contacts = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Contact contact = new Contact(
                        new ContactID(resultSet.getInt("id")),
                        new ContactName(resultSet.getString("name")),
                        new ContactNumberPhone(resultSet.getString("numberPhone"))
                );
                contacts.add(contact);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Al obtener los contactos: " + e.getMessage());
            throw e;
        }
        return contacts;
    }

    public static void insertContact(ContactName name, ContactNumberPhone numberPhone) throws SQLException {
        String query = "INSERT INTO contacts(name, numberPhone) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name.toString());
            statement.setString(2, numberPhone.toString());
            statement.executeUpdate();

            System.out.println("[INFO] Contacto insertado con éxito");
        } catch (SQLException e) {
            System.err.println("[ERROR] Al guardar el nuevo contacto: " + e.getMessage());
            throw e;
        }
    }
}

