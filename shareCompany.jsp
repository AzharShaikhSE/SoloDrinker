<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Solo Drinker</title>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="first.js" ></script>
        <style>
          .jumbotron {
           padding:0px!important;
           margin:0px!important;
           }
         </style>
 </head>
  <body>
              <div class="container-fluid nopadding">


                <div class="collapse navbar-collapse" id="mainNavBar" >
                    <ul class="nav navbar-nav">
              <!-- Implement as a popup? Using JS -->
              <!-- Make this be replaced by My Profile when its clicked -->

                <li><a href="login.jsp">Login/Register</a></li>
                        <li style="margin-right:1200px;"><a href="myprofile.html">My Profile</a></li>
                        <li><a href="how.html">How it Works</a></li>
                        <li><a href=".html">About Us</a></li>
                        <% String  user_name = "";
                          String  fbID = "";
                          String  profile = "";
                         if((String)session.getAttribute("user_name")!=null){
                          user_name=""+(String)session.getAttribute("user_name");
                          fbID=""+(String)session.getAttribute("fbID");
                          profile=""+(String)session.getAttribute("profile");
                          %>
                          <li style="color: red;"><a href="#">Welcome <%=user_name %></a></li>
                          <%} %>


                    </ul>
                </div>
              <a href="homepage.html"><img src="images/solodrinkerlogo.gif" class="img-rounded" style="position:absolute;z-index:2;display: block;margin-left:850px"></a>
              <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                  <span class="glyphicon glyphicon-menu-hamburger"></span>

              </button>

              </div>
              <div class="jumbotron nopadding">
                <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>
              </div>
              <div class="container" style="margin-top:20px">
            					<form name="loginform" method="GET" action="ShareCompany" >
            						<table align="left" border="0" style="width: 250pt; height: 120pt">
                          <input type="hidden" id="user_name" name="user_name" value=<%=user_name %>/>
                          <input type="hidden" id="fbID" name="fbID"   value=<%=fbID %> >
                          <input type="hidden" id="profile" name="profile"  value=<%=profile %>  >
            							<tr>
            								<th>Pub Name:</th>
            								<td colspan="2"><input type="text" id="pubName" name="pubName" style="font-size:10pt;color:black">  <br></td>  <br>
            							</tr>

            							<tr>
            								<th>Location:</th>
            								<td colspan="2"><input type="text" id="location" name="location" style="font-size:10pt;color:black" >  <br></td>
            							</tr>

                          <tr>
            								<th>Time From:</th>
            								<td colspan="2"><input type="datetime-local" id="timeFrom" name="timeFrom" style="font-size:10pt;color:black" >  <br></td>
            							</tr>

                          <tr>
            								<th>Time To:</th>
            								<td colspan="2"><input type="datetime-local" id="timeTo" name="timeTo" style="font-size:10pt;color:black" >  <br></td>
            							</tr>

            							<tr>
            								<td colspan="3">
            									<center>
            										<input type="submit" value="  Submit  " style="font-size:15pt;color:white;background-color:#0000A0;padding:3px">
            									</center></td>
            							</tr>

            						</table>
            					</form>
</div>
                      <script>
                      	$(document).ready(function () {
                      		var _control = $('input[name="location"]')[0];
                      		return new google.maps.places.Autocomplete(_control, {
                      			types: ["geocode"]
                      		});
                      	});
                      </script>
                      <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC8qu5K7E4LmcHbH0BxP06Eqx6EZKqcLVQ&libraries=places"
                          async defer></script>


              </div>

      </body>

</html>
