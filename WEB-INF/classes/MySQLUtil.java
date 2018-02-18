import java.sql.*;
import java.util.*;

public class MySQLUtil{
	   Connection con = null;

     private static final String Drivername="com.mysql.jdbc.Driver";
	   private static final String USERNAME="root";
	   private static final String PASSWORD="root";
	   private static final String URL="jdbc:mysql://localhost:3306/getcompanydb?useSSL=false";

       public void MySQLUtil(){}

       public Connection getConnection(){
            try{
              Class.forName(Drivername);
              con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }catch(NullPointerException e){
						 e.printStackTrace();
		        }
		        catch(ClassNotFoundException e){
						e.printStackTrace();
		        }
		        catch (SQLException e){
						 e.printStackTrace();
		        }
            return con;
       }

       public void closeConnection(){
            try{
                con.close();
            }
            catch (SQLException se){
                se.printStackTrace();
            }
        }

        public int addUser(String user_name,String user_email,String profile,String gender, String fbID){
          System.out.println(user_name + ","+user_email);
          con = getConnection();
         PreparedStatement ps1=null;
         String command1=null;
         int result1=0;
          String isPresent = "notFound";
         try{
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery("Select * from users where fbID='"+fbID+"'");

                while(rs.next()){
                  isPresent = rs.getString("fbID");
                }
                rs.close();
                stmt.close();
        } catch (NullPointerException e){
                    e.printStackTrace();
          }catch (SQLException e) {
                    e.printStackTrace();
                }


         if(ps1==null && isPresent.equals("notFound")){
             try{
                 command1 = "insert into users(fullname,email,profilePic,gender,fbID) values(?,?,?,?,?)";

                 ps1=con.prepareStatement(command1);

                 ps1.setString(1, user_name);
                 ps1.setString(2, user_email);
                 ps1.setString(3, profile);
                 ps1.setString(4, gender);
                 ps1.setString(5, fbID);
                 result1=ps1.executeUpdate();
                 ps1.close();

             }
             catch (NullPointerException e){
                 e.printStackTrace();
             }
             catch (SQLException e) {
                 e.printStackTrace();
             }
             finally{
                 closeConnection();
             }
         }
         return result1;
        }

        public void addActiveDrinker(String user_name,String fbID,String profile,String pubName,String location,String timeFrom,String timeTo){

         con = getConnection();
         PreparedStatement ps1=null;
         String command1=null;
         int result1=0;

         if(ps1==null){
             try{
                 command1 = "insert into activedrinkers(fullname,fbID,profilePic,pubName,location,timeFrom,timeTo) values(?,?,?,?,?,?,?)";

                 ps1=con.prepareStatement(command1);

                 ps1.setString(1, user_name);
                 ps1.setString(2, fbID);
                 ps1.setString(3, profile);
                 ps1.setString(4, pubName);
                 ps1.setString(5, location);
                 ps1.setString(6, timeFrom);
                 ps1.setString(7, timeTo);
                 result1=ps1.executeUpdate();
                 ps1.close();

             }
             catch (NullPointerException e){
                 e.printStackTrace();
             }
             catch (SQLException e) {
                 e.printStackTrace();
             }
             finally{
                 closeConnection();
             }
         }
        }

        public ArrayList<Users> getActiveUsers(){
            ArrayList<Users> userlist = new ArrayList<Users>();
            Users user = null;
            try{
                con = getConnection();
                con.setAutoCommit(true);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("Select * from activedrinkers");
                while(rs.next()){
                    user=new Users();
                    user.setUser_name(rs.getString("fullname"));
                    user.setFbID(rs.getString("fbID"));
                    user.setProfile(rs.getString("profilePic"));
                    user.setPubName(rs.getString("pubName"));
                    user.setLocation(rs.getString("location"));
                    user.setTimeFrom(rs.getString("timeFrom"));
                    user.setTimeTo(rs.getString("timeTo"));

                    userlist.add(user);

                }
                rs.close();
                stmt.close();
            }catch(SQLException exception){
                exception.printStackTrace();
            }catch(Exception exception){
                exception.printStackTrace();
            }
            finally{
                closeConnection();
            }
            return userlist;
	   }




}
