import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        MySQLUtil sqlUtil = new MySQLUtil();
      //display list of active active drinkers

        out.print("<!DOCTYPE html>");
						out.print("<html lang='en'><head><title>Solo Drinker</title><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1'>");
						out.print("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script><script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script><link href='css/main.css' rel='stylesheet'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script></head>");
						out.print("<body><div class='container-fluid nopadding'><div class='collapse navbar-collapse' id='mainNavBar'><ul class='nav navbar-nav'>");
            out.print("<li><a href='login.jsp'>Login/Register</a></li><li><a href='myprofile.html'>My Profile</a></li><li><a href='how.html'>How it Works</a></li><li><a href='.html'>About Us</a></li>");
            String user_name=""+(String)session.getAttribute("user_name");
            out.print("<li style='color: red;''><a href='#''>Welcome "+user_name +"</a></li><ul>");

            out.print("<a href='homepage.html'><img src='images/solodrinkerlogo.gif' class='img-rounded' style='position:absolute;z-index:2;display: block;margin-left:850px'></a><div class='navbar-header'><button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#mainNavBar'><span class='glyphicon glyphicon-menu-hamburger'></span></button></div>");
           // Add drinker list

            ArrayList<Users> userlist = sqlUtil.getActiveUsers();

            out.print("<hr style='width: 95%'><h2 style='font-size: 35px;'>List of Active Drinkers </h2><hr style='width: 95%'>");
             out.print("<br><br><br><br><br>");
            out.print("<div><table id='bestseller' width='80%'>");

            out.print("<tr><td style='font-size:20px;color:black'><b>Profile Pic</b></td><td style='font-size:20px;color:black'><b>Name </b> </td><td style='font-size:20px;color:black'> <b>Pub Name </b></td><td style='font-size:20px;color:black'><b> Pub Location</b></td><td style='font-size:20px;color:black'><b> Time From </b></td><td style='font-size:20px;color:black'><b>Time To</b></td></tr>");

            for(Users ul: userlist){
                  out.print("<form method='post'><tr><td><img name='profile' src='"+ul.getProfile()+"' required></td><td><input type='text' name='uname' value='"+ul.getUser_name()+"' style='font-size:10pt;color:black' readonly></td><td><input type='text' name='pubName' value='"+ul.getPubName()+"' style='font-size:10pt;color:black' readonly></td><td><input type='text' name='location' value='"+ul.getLocation()+"' style='font-size:10pt;color:black' readonly></td><td><input type='text' name='timeFrom' value='"+ul.getTimeFrom()+"' style='font-size:10pt;color:black' readonly></td><td><input type='text' name='timeTo' value='"+ul.getTimeTo()+"' style='font-size:10pt;color:black' readonly></td>"+
                            "<td><input type='submit' class='btn1' name='update' value='Contact' onclick='#'>"
                          +"</td></tr></form>");
            }

            out.print("</table></div>");



    }
  }
