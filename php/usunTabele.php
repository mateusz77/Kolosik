<?php
$servername = "localhost";
$username = "id5222790_guru";
$password = "haslotrzaslo";

$nazwatb = $_POST["nazwatb"];

echo $nazwatb;

$conn = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

echo $nazwatb;

//$sql = "DROP TABLE ".$nazwatb;

//$statement = mysqli_prepare($conn, $sql);
//mysqli_stmt_bind_param($statement);
//mysqli_stmt_execute($statement);

/*
$stmt = $link->prepare($conn, "DROP TABLE ?");
    $stmt->bind_param('s',$nazwatb); 
    $stmt->execute();*/
    
    $statement = mysqli_prepare($conn, "DROP TABLE {$nazwatb}");
    
    //mysqli_stmt_bind_param($statement, "s", $nazwatb);
    mysqli_stmt_execute($statement);

echo $nazwatb;

$response = array();
$response["success"] = true;  
$response["dupa"] = $nazwatb;
    
echo json_encode($response);


?>


 