<?php
 
$connect = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK");

$nazwaKolosa = $_POST["nazwaKolosa"];

//mysql_select_db("id5222790_user");
$sql = "SELECT * FROM  $nazwaKolosa";

$stmt = $connect->prepare($sql);

$stmt->execute();
$stmt->bind_result($Pytanie, $OdpowiedzA,$OdpowiedzB,$OdpowiedzC,$OdpowiedzD,$PrawidlowaO);

$studenci = array();
while($stmt->fetch()){
    $temp = array();
    $temp['Pytanie'] = $Pytanie;
    $temp['OdpowiedzA'] = $OdpowiedzA;
    $temp['OdpowiedzB'] = $OdpowiedzB;
    $temp['OdpowiedzC'] = $OdpowiedzC;
    $temp['OdpowiedzD'] = $OdpowiedzD;
    $temp['PrawidlowaO'] = $PrawidlowaO;
    
    array_push($studenci,$temp);
    
}

//$hoho['success'] = true;
//array_push($studenci,$hoho);

echo json_encode($studenci);


?>


