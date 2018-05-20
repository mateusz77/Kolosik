<?php
   // require("password.php");
       $connect = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK");

    $nazwa = $_POST["nazwa"];
    $numerPytania =$_POST["numerPytania"];
 
    
    $statement = mysqli_prepare($connect, "SELECT * FROM {$nazwa} LIMIT 1 OFFSET {$numerPytania}");
   
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$Pytanie, $OdpowiedzA, $OdpowiedzB, $OdpowiedzC, $OdpowiedzD, $PrawidlowaO);
    
    $response = array();
    $response["success"] = false;  
    $response["nazwa"] = $nazwa;
    $response["numer"] = $numerPytania;
    $response["praw"] = $PrawidlowaO;
    
    
    while(mysqli_stmt_fetch($statement)){
       
            $response["success"] = true;  
            $response["Pytanie"] = $Pytanie;
            $response["OdpowiedzA"] = $OdpowiedzA;
            $response["OdpowiedzB"] = $OdpowiedzB;
            $response["OdpowiedzC"] = $OdpowiedzC;
            $response["OdpowiedzD"] = $OdpowiedzD;
            $response["PrawidlowaO"] = $PrawidlowaO;
            
        
    }
    echo json_encode($response);
?>