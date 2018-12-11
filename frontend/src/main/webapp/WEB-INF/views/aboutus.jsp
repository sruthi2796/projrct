<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="home.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
<body>
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">PURPLE GIRL</a>
  </div>
</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="resources/images/br.jpg" alt="Hamburger Catering" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
    <h1 class="w3-xxlarge">PURPLE GIRL</h1>
  </div>
</header>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->
  <div class="w3-row w3-padding-64" id="about">
    <div class="w3-col m6 w3-padding-large w3-hide-small">
     <img src="resources/images/image.jpg" class="w3-round w3-image w3-opacity-min" alt="Table Setting" width="600" height="750">
    </div>

    <div class="w3-col m6 w3-padding-large">
      <h1 class="w3-center">About PURPLE GIRL</h1><br>
      <h5 class="w3-center">Tradition since 2005</h5>
      <p class="w3-large">In 2005 We founded PURPLE GIRL as THE go-to place that would fulfil all your beauty and grooming desires. Now, after 11 years in business, we're proudly Europe's largest online beauty retailer, giving you over 400 brands at your fingertips. Every day we're growing and innovating, so watch this space! <span class="w3-tag w3-light-grey">seasonal</span> Brands</p>
      <p class="w3-large w3-text-grey w3-hide-medium">Our beliefs fuel our commitment to offer this impressive range of brands and products; we believe everyone should have access to beauty, regardless of where you are, who you are, and how much
you can spend.</p>
    </div>
  </div>
  
  <hr>
  
 
  <div class="w3-row w3-padding-64" id="menu">
    <div class="w3-col l6 w3-padding-large">
      <h1 class="w3-center">Our BRANDS</h1><br>
      <h4>LAKME</h4>
      <p class="w3-text-grey">ALL BEST PRODUCT OF LAKME UDER ONE ROOF</p><br>
    
      <h4>MAC</h4>
      <p class="w3-text-grey">WILL MAKE THE GIRL FEEL QUEEN</p><br>
    
      <h4>REVLON</h4>
      <p class="w3-text-grey">TRENDY GIRL LOOK</p><br>
    
      <h4>URBAN DECAY</h4>
      <p class="w3-text-grey">MAKE YOUR MAKEP READY IN A MINUTE</p><br>
    
      <h4>SEPHORA</h4>
      <p class="w3-text-grey">LONG LASTING MAKEUP</p>    
    </div>
    
    <div class="w3-col l6 w3-padding-large">
      <img src="resources/images/GIR.jpg" class="w3-round w3-image w3-opacity-min" alt="Menu" style="width:100%">
    </div>
  </div>

  <hr>

  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Contact</h1><br>
    <p>We offer all brands with quality.pick your makeup and glow. your comments are always welcome</p>
    <p class="w3-text-blue-grey w3-large"><b>PURPLE GIRL, 42nd Living St, 43043 New York, NY<br>contact no :282828281</b></p>
   
    <form action="/action_page.php" target="_blank">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-padding-16" type="number" placeholder="Phonenumber" required name="number"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Productdetails" required name="product"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="message" required name="comment"></p>
      <p><button class="w3-button w3-light-grey w3-section" type="submit">SEND MESSAGE</button></p>
    </form>
  </div>
  
<!-- End page content -->
</div>


</body>
</html>
