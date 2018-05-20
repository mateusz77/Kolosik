<?php
$servername = "localhost";
$username = "id5222790_guru";
$password = "haslotrzaslo";
$nazwatb = $_POST["nazwatb"];
$Pytanie = $_POST["Pytanie"];

$conn = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "DELETE FROM {$nazwatb} WHERE Pytanie = '{$Pytanie}'";

$statement = mysqli_prepare($conn, $sql);

mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;  
$response["dupa"] = $nazwatb;
$response["pytanie"] = $Pytanie;
echo json_encode($response);

?>


 