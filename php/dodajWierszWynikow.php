<?php
$servername = "localhost";
$username = "id5222790_guru";
$password = "haslotrzaslo";

$nazwaUzytkownika = $_POST["username"];
$imie = $_POST["imie"];
$nazwisko = $_POST["nazwisko"];
$klasa = $_POST["klasa"];

$conn = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");

// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "INSERT INTO Wyniki (NazwaUżytkownika, imie, nazwisko, klasa) VALUES ('$nazwaUzytkownika', '$imie', '$nazwisko', '$klasa')";



$statement = mysqli_prepare($conn, $sql) or die(mysqli_error($conn));

mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true; 
$response["nazwaUzytkownika"] = $nazwaUzytkownika; 
$response["imie"] = $imie; 
$response["nazwisko"] = $nazwisko; 
$response["klasa"] = $klasa; 

    
echo json_encode($response);


?>


 