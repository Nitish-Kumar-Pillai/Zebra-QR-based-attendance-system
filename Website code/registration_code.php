<?php
require_once('connection.php');
$fname = $lname  = $email = $subject = $password = $pwd = '';

$fname = $_POST['firstname'];
$lname = $_POST['lastname'];
$email = $_POST['email'];
$subject = $_POST['subject'];
$pwd = $_POST['password'];
$password = MD5($pwd);

$sql = "INSERT INTO info (Firstname,Lastname,Email,subject,Password) VALUES ('$fname','$lname','$email','$subject','$password')";
$result = mysqli_query($conn, $sql);
if($result)
{
	header("Location: login.php");
}
else
{
	echo "Error :".$sql;
}
?>
