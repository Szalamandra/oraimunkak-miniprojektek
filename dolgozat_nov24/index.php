<!-- Zsigmond Réka, 2021-01-10, esti Szoft  -->

<?php

echo file_get_contents('templates/header.tpl');


include 'src/inc/fajlkezeles.php';
include "src/inc/feladat.php";

$fajlSrc="datas/adatok.txt";
$tomb=beolvas($fajlSrc);
$eredmeny=ketMillaFelettiFizukSzama($tomb);
$dolgozokSzama=count($tomb);


$page=file_get_contents('templates/index.tpl');
$page=str_replace('{tombMeret}',$dolgozokSzama,$page);
$page=str_replace('{eredmény}',$eredmeny,$page);

 
echo $page;



echo file_get_contents('templates/footer.tpl');?>