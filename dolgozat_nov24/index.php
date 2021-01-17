<?php

echo file_get_contents('templates/header.tpl');




include 'src/inc/fajlkezeles.php';
$fajlSrc="datas/adatok.txt";
$tomb=beolvas($fajlSrc);
$page=file_get_contents('templates/index.tpl');
if($tomb){
    foreach ($tomb as $sor) {
     $sorTomb = explode(":", $sor);
        $fizetes = $sorTomb[4];
    echo "fizetes:".$fizetes;
        }
    }
else
    echo "tomb üres vagy nem letezik";

 
echo $page;



echo file_get_contents('templates/footer.tpl');?>