<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{

width: 100%;
height: 100vh;
display: flex;
flex-direction: column;
justify-content: center;
background: silver;
}


.d1{
margin-left: 13cm;

}

.d1 .sign1, .d1 sign2{
font-size: 30px;
margin-bottom: 10px;
}

.sign1,.sign2  {

margin-left:3cm;

margin-bottom: 10px;
}
.sign2 a{
color: red;
text-decoration: none;


}

 label{
width: 100px;
text-align:center;
display:inline-block;
font-size: 20px;

}

.s1 input{
padding: 14px 80px;
border:1px solid black;
border-radius: 5px;




}

.s1 input::placeholder{
text-align: center;
}

.d1 .b1{
padding: 15px 19.5px;
margin-top: 0.5cm;
margin-left:3.2cm;
background: orange;
cursor: pointer;
border: 0;
outline: 0;


}








</style>
</head>
<body>

<div class="d1">

<div class="sign1">Sent successfully</div>
<span>
<div class="sign2">Enter the Code</div>
</span>



</div >

<div class="d1">

<form action="verifyServlet" method="post">
<div class="s1">

<input type="text" name="authcode"><br />
<input class="b1" type="submit" value="Signup">
</div>
</div>
</form>
</body>
</html>

