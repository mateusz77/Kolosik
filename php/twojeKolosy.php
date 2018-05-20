<?php
    $connect = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK");
    
    $username = $_POST["username"];
    
    $sql = "SHOW TABLES FROM  id5222790_user LIKE '%$username%' "; 

    $stmt = $connect->prepare($sql);
    
    $stmt->execute();
    $stmt->bind_result($nazwaKolosa);
    
    $kolosy = array();
    while($stmt->fetch()){
        $temp = array();
        $temp['nazwaKolosa'] = $nazwaKolosa;
       
        
        array_push($kolosy,$temp);
        
}

    echo json_encode($kolosy);


?>