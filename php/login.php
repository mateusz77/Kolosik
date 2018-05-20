<?php
   // require("password.php");
       $con = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK");

    $username = $_POST["username"];
    $haslo = $_POST["haslo"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND haslo = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $haslo);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $imie, $nazwisko, $klasa, $id, $username, $status, $haslo);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        
        $response["imie"] = $imie;
        $response["nazwisko"] = $nazwisko;
        $response["klasa"] = $klasa;
        $response["id"] = $id;
        $response["username"] = $username;
        $response["status"] = $status;
        $response["haslo"] = $haslo;
    }
    
    echo json_encode($response);
?>