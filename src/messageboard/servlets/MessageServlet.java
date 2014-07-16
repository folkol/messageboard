package messageboard.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import messageboard.dao.MessageService;
import messageboard.model.Message;


@WebServlet("/index.html")
public class MessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private MessageService messageService;

	@Resource(name = "comp/DefaultDataSource")
	DataSource ds;

	@Override
	public void init() throws ServletException {
	    messageService = new MessageService(ds);
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	{
	    request.setAttribute("messages", messageService.findAll());
	    request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
	{
	    messageService.add(new Message(request.getParameter("author"), request.getParameter("message")));
	    response.sendRedirect("index.html");
	}

}
