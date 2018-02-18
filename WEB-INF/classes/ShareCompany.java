//ShareCompany
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.sql.*;

public class ShareCompany extends HttpServlet {

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

         String fbID = request.getParameter("fbID");
         String profile = request.getParameter("profile");
         String pubName = request.getParameter("pubName");
         String location = request.getParameter("location");
         String timeFrom = request.getParameter("timeFrom");
         String timeTo = request.getParameter("timeTo");

         System.out.println(pubName);

         sqlUtil.addActiveDrinker(user_name,fbID,profile,pubName,location,timeFrom,timeTo);

         response.sendRedirect("index.jsp");

	}


}
