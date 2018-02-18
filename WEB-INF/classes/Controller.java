import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.sql.*;

public class Controller extends HttpServlet {

  MySQLUtil sqlUtil = new MySQLUtil();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        		response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
	}

	protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
		     response.setContentType("text/html");
		     PrintWriter out = response.getWriter();

         String user_name = request.getParameter("user_name");
         String user_email = request.getParameter("user_email");
         String profile = request.getParameter("profile");
         String gender = request.getParameter("gender");
         String fbID = request.getParameter("fbID");

         int result = sqlUtil.addUser(user_name,user_email,profile,gender,fbID);

         HttpSession session = request.getSession(true);
         session.setAttribute("user_name",user_name);
         session.setAttribute("fbID",fbID);
         session.setAttribute("profile",profile);
         response.sendRedirect("index.jsp");

	}


}
