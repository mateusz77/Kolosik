<?php
 
$connect = mysqli_connect("localhost","id5222790_guru","haslotrzaslo", "id5222790_user")  or die(" COŚ POSZŁO NIE TAK");

$nazwaKolosa = $_POST["nazwaKolosa"];
$nazwaKlasy = $_POST["klasa"];

//mysql_select_db("id5222790_user");
//$sql = "SELECT imie, nazwisko, klasa, $nazwaKolosa FROM `Wyniki` WHERE $nazwaKolosa > 0 AND klasa = '2T'";
//SELECT imie, nazwisko,klasa, kek_admin FROM `Wyniki` WHERE kek_admin > 0 AND klasa = '2T'

$sql = "SELECT imie, nazwisko, klasa, $nazwaKolosa FROM `Wyniki` WHERE $nazwaKolosa > 0 AND klasa='{$nazwaKlasy}'";
$stmt = $connect->prepare($sql);

$stmt->execute();
$stmt->bind_result($imie, $nazwisko,$klasa,$kek_admin);

$studenci = array();
while($stmt->fetch()){
    $temp = array();
    $temp['imie'] = $imie;
    $temp['nazwisko'] = $nazwisko;
    $temp['klasa'] = $klasa;
    $temp['punkty'] = $kek_admin;
    
    array_push($studenci,$temp);
    
}

echo json_encode($studenci);


?>


