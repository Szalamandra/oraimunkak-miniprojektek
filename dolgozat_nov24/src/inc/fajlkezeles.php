<?php
/* Zsigmond Réka, 2021-01-10, esti Szoft */


function beolvas($fajlSrc) {
    $tomb = array();
    
    $fp = fopen($fajlSrc, "r");
    if(file_exists($fajlSrc)){
    while(!feof($fp)) {
        $sor = fgets($fp);
        array_push($tomb, $sor);
    }    
fclose($fp);}
else
        echo "fajlkezelés fv:nem találom a fájlt";
    return $tomb;
}
