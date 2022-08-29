package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;
import main.Client;

/**
 * Servlet implementation class BlueskyServlet
 */
@WebServlet(urlPatterns = {"/create", "/delete", "/update"})
public class BlueskyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Client client = new Client();
	ClientDAO clientDAO = new ClientDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlueskyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/delete")) {
			delete(request, response);
		} else if(action.equals("/update")) {
			update(request, response);
		} else if(action.equals("/create")) {
			create(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		client.setId(clientDAO.find(id).getId());		
		clientDAO.delete(client.getId());
		response.sendRedirect("list.jsp");
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		client.setId(Integer.parseInt(request.getParameter("id")));		
		client.setName(request.getParameter("name"));
		client.setEmail(request.getParameter("email"));
		client.setPhone(Integer.parseInt(request.getParameter("phone")));
		client.setType_of_service(request.getParameter("type_of_service"));
		client.setMessage(request.getParameter("message"));
		
		clientDAO.update(client);
		response.sendRedirect("list.jsp");
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("phone"));
		if(id >= 0 ) {
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPhone(id);
			client.setType_of_service(request.getParameter("type_of_service"));
			client.setMessage(request.getParameter("message"));
			clientDAO.save(client);
			response.sendRedirect("index.html");
		}else {
			PrintWriter pw = response.getWriter();
			pw.print("Phone must to be a number/n");
			pw.print("<a href=\"index.html\">Back to index</a>");
		}
	}
	

}
