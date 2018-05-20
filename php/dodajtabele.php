<?php
$servername = "localhost";
$username = "id5222790_guru";
$password = "haslotrzaslo";

$nazwatb = $_POST["nazwatb"];

// Create connection
//$conn = new mysqli($servername, $username, $password);
$conn = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");

// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


/*
// Create database
$sql = "CREATE DATABASE '$nazwatb'";
if ($conn->query($sql) === TRUE) {
    echo "Database created successfully";
} else {
    echo "Error creating database: " . $conn->error;
}
*/

/*************************************/

$sql = "CREATE TABLE  $nazwatb (
Pytanie varchar(400),
OdpowiedzA varchar(400),
OdpowiedzB varchar(400),
OdpowiedzC varchar(400),
OdpowiedzD varchar(400),
PrawidlowaO varchar(400)
)";



$statement = mysqli_prepare($conn, $sql) or die(mysqli_error($conn));

mysqli_stmt_execute($statement);

/**********************************
mysql_select_db("id5222790_user", $conn);

$sql = "CREATE TABLE '$nazwatb' (
Pytanie varchar(400),
OdpowiedzA varchar(400),
OdpowiedzB varchar(400),
OdpowiedzC varchar(400),
OdpowiedzD varchar(400),
PrawidlwaO varchar(400)
)";

mysql_query($sql, $conn);
*/


$response = array();
$response["success"] = true;  
    
echo json_encode($response);


?>


 