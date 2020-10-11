<!-- Zsigmond Réka, 2020-10-10 -->
<?php

echo file_get_contents('templatesFormFeladat/head.tpl');

$betet=$_POST['betet'
];
$kamat=$_POST['kamat'
];
$szam = $_POST['szam'];
$tenyleges;

if($kamat>0 and $kamat<1000 and $szam!=0){
    szamitas();
}
else
  {echo "<p class='hibaUzi'>Valós adatokat adjon meg!</p>"; 
  echo "<a href='formFeladat.php' class='button'> Új adatokat adok meg!</a>";} 


//$valasz=printf("%d", $osszeg);

function szamitas(){
    global $betet, $kamat, $szam,$tenyleges;
    $tenyleges=$betet*(pow((1+$kamat/(100*$szam)),$szam)-1);
    echo "<div id='eredmenyForm' style='display:grid;grid-column: 4/6;margin:1vh auto;grid-row:2/5'>";
    echo "<form>";
    echo "<fieldset>";

    echo "<legend> Kamatszámítás</legend>";
    echo "<label>Betét: ".$betet.
    "<br></label>";
	echo "<label>Névleges kamat(%): ".$kamat."<br></label>";
    echo "<label>Évenkénti tőkésítések száma: ".$szam."<br></label>";
    echo "</fieldset><fieldset>";
echo "<label>Tényleges éves kamat: ".$tenyleges."</label>";
echo "</fieldset>
</form>";
echo "</div>";
 echo "<div>";
echo "<a href='formFeladat.php'> Új adatokat adok meg!</a>";
 echo "</div>";
    

}

echo file_get_contents('templatesFormFeladat/foot.tpl');
?>


