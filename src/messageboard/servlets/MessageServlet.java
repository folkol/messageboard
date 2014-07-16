package messageboard.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/index.html")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "comp/DefaultDataSource")
	DataSource ds;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	{
	    try (Connection conn = ds.getConnection()) {
	        Statement statement = conn.createStatement();
	        ResultSet result = statement.executeQuery("SELECT * FROM messages");
	        while(result.next()) {
	            System.out.println(result.getString("author"));
	        }
	        request.setAttribute("comments", "hej");
	        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	    } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
