<?php
    $con = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK php");
    

    $nazwatb = $_POST["nazwatb"];
    $Pytanie = $_POST["Pytanie"];
    $OdpowiedzA = $_POST["OdpowiedzA"];
    $OdpowiedzB = $_POST["OdpowiedzB"];
    $OdpowiedzC = $_POST["OdpowiedzC"];
    $OdpowiedzD = $_POST["OdpowiedzD"];
    $PrawidlowaO = $_POST["PrawidlowaO"];
    
    //$statement = mysqli_prepare($con, "INSERT INTO {$nazwatb} (Pytanie, OdpowiedzA, OdpowiedzB, OdpowiedzC, OdpowiedzD, PrawidlowaO) VALUES (?, ?, ?, ?, ?, ?)");
    
    //mysqli_stmt_bind_param($statement, "ssssss", $Pytanie, $OdpowiedzA, $OdpowiedzB, $OdpowiedzC, $OdpowiedzD, $PrawidlowaO) ;
    
    
     $statement = mysqli_prepare($con, "INSERT INTO {$nazwatb} (Pytanie, OdpowiedzA, OdpowiedzB, OdpowiedzC, OdpowiedzD, PrawidlowaO) VALUES ('{$Pytanie}', '{$OdpowiedzA}', '{$OdpowiedzB}', '{$OdpowiedzC}', '{$OdpowiedzD}', '{$PrawidlowaO}')");
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    $response["dupa"] = $nazwatb;
    $response["pytanie"] = $Pytanie;
    $response["OdpowiedzA"] = $OdpowiedzA;
    $response["OdpowiedzB"] = $OdpowiedzB;
    $response["OdpowiedzC"] = $OdpowiedzC;
    $response["OdpowiedzD"] = $OdpowiedzD;
    $response["PrawidlowaO"] = $PrawidlowaO;
    echo json_encode($response);
?>