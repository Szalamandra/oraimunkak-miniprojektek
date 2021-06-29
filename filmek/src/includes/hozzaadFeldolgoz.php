<?php
include "db_functions.php";

$kiadoAdat[0]=$_POST['id'];
$kiadoAdat[1]= $_POST['nevKiado'];
insertItem($kiadoAdat);

header('Location: ..\\..\\hozzaad.php');
