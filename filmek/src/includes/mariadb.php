<?php

include "config.php";

function connectDb(){
    global $db;

    $conn=mysqli_connect($db['host'], $db['user'], $db['pass'], $db['db']);
    if (!$conn)
        error_log("hiba a kapcsolódás során");
    else{
        //echo "kapcsolat létrejött");
        mysqli_set_charset($conn,'utf8');
        return $conn;}
    }


function closeDb($conn){
    mysqli_close($conn);
    //echo "bezártam a kapcsolatot sikeresen";

}