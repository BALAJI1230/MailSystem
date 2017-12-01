package mail.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.service.mailservice;


@WebServlet("/mail")
public class mailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public mailservlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String froma = request.getParameter("email");
			String password = request.getParameter("password");
			String subject = request.getParameter("subject");
			String body = request.getParameter("body");
			if (froma == null || froma.isEmpty() || password == null || password.isEmpty()) {
				out.println("Fill the required fields!");
			} else {
				String to="rslbalaji@gmail.com";
				mailservice.send(to,froma,password, subject, body);
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
