<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookshop|Registration failed</title>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: gold;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #CFB53B;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: gold;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
  display: block;
}
.input {
  background-color: gold
  border: none;
  color: white;
  
  text-align: center;
  text-decoration: none;
  display: inline-block; 
  font-size: 14px;
 
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.search1 {
  background-color: white; 
  color: black; 
  border: 2px solid grey;
  margin-top: 6px;
  margin-bottom: 2px;
}
.search2 {
  background-color: gold; 
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 2px 2px;
  cursor: pointer;
  border-radius: 12px;
}
.search1:hover {
  background-color: gold;
  color: white;
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: gold;
   color: black;
   text-align: center;
}

</style>
</head>
<body bgcolor="lightgrey">
<ul>
  <li><a href="index.html"><i class='fas fa-home' style='font-size:24px'></i></a></li>
  <li><a href="AvailableBooks">Books in stock</a></li>
   <li><a href="Bestsellers">Bestsellers</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">My account</a>
    <div class="dropdown-content">
      <a href="signIn.html">Sign in</a>
      <a href="register.html">Register</a>
      <a href="WishListServlet">My wishlist</a>
      <a href="MyOrders">My orders</a>
       <a href="SignOut">Sign out</a>
    </div>
    <li><form action='SearchTitle'>

<input type="text" name="search"  size="40" style="height: 38px;" placeholder="Search by title"/>
<input class="input search1" type="submit" size="60" style="height: 40px;" value="Search"/>

</form></li>
    
    <li><a href="advancedSearch.html">Advanced search</a></li>
  
</ul>

<div style="margin: 30px 85px; "><p style="font-size:150%">Username already exists. Please try again</p></div>
<div class="footer">

  <p align="center">Follow us</p>
  
<p align="center"><i class='fab fa-facebook-square' style='font-size:24px'></i>&nbsp;
   <i class='fab fa-instagram' style='font-size:24px'></i>&nbsp;<i class="fab fa-pinterest" style='font-size:24px'></i>
   </p>
   
</div>
</body>
</html>