<?php
/*Zsigmond Réka, 2021-01-10, esti Szoft */



function ketMillaFelettiFizukSzama($tomb){
    $eredmeny=0;
        if($tomb){
    foreach ($tomb as $sor) {
     $sorTomb = explode(":", $sor);
        $fizetes = $sorTomb[4];
    /*echo "fizetes:".$fizetes;*/
        if($fizetes>2000000)
            $eredmeny++;
        }
    }
else
    echo "tomb üres vagy nem letezik";

return $eredmeny;
}