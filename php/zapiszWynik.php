<?php
$servername = "localhost";
$username = "id5222790_guru";
$password = "haslotrzaslo";

$nazwaKolosa = $_POST["nazwaKolosa"];
$nazwaUzytkownika = $_POST["username"];
$punkty = $_POST["punkty"];


$conn = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");

// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "UPDATE Wyniki SET $nazwaKolosa = $punkty WHERE NazwaUżytkownika = '$nazwaUzytkownika'";



$statement = mysqli_prepare($conn, $sql) or die(mysqli_error($conn));

mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;  
    
echo json_encode($response);


?>


