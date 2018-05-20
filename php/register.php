<?php
    $con = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");
    
    $imie = $_POST["imie"];
    $nazwisko = $_POST["nazwisko"];
    $klasa = $_POST["klasa"];
    $id = $_POST["id"];
    $username = $_POST["username"];
    $status = $_POST["status"];
    $haslo = $_POST["haslo"];
    
    $statement = mysqli_prepare($con, "INSERT INTO user (imie, nazwisko, klasa, id, username, status, haslo) VALUES (?, ?, ?, ?, ?, ?, ?)");
    
    mysqli_stmt_bind_param($statement, "sssssss", $imie, $nazwisko, $klasa, $id, $username, $status, $haslo);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>