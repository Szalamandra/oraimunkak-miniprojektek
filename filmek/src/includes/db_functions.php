<?php

include "mariadb.php";

function insertItem($kiadoData){
    $conn=connectDb();
    $sql="insert into kiado (id, nev) values (?,?)";

    $stmt=mysqli_prepare($conn,$sql);
    mysqli_stmt_bind_param($stmt,"ss", $kiadoData[0], $kiadoData[1]);
    mysqli_stmt_execute($stmt);
    closeDb($conn);


}

function lekerKiado(){
$conn=connectDb();
$sql="select * from kiado";
$res=mysqli_query($conn,$sql);

for($data=array(); $row=mysqli_fetch_assoc($res);
$data[]=$row);

closeDb($conn);
return $data;

}
function modositKiado($kiadoData){




}