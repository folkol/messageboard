package messageboard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import messageboard.model.Message;


public class MessageService
{
    private final DataSource ds;

    public MessageService(DataSource ds) {
        this.ds = ds;
    }

    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM messages");
            while(result.next()) {
                String author = result.getString("author");
                String message = result.getString("message");
                messages.add(new Message(author, message));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public void add(Message message) {
        try (Connection conn = ds.getConnection()) {
            Statement statement = conn.createStatement();
            String query = String.format("INSERT INTO messages (author, message) VALUES ('%s', '%s')",
                                         message.getAuthor(),
                                         message.getMessage());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
