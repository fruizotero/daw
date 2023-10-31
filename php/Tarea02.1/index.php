<?php

require_once "utils.php";

const RUTA =   "archivos";
const CLAVE_INPUT = "archivos";

if (isset($_FILES[CLAVE_INPUT])) {
    lista_informacion_ficheros(CLAVE_INPUT, RUTA);
} else {
    echo "<p>Error, el name de tu campo no es válido o no estás utilizando él método POST</p>";
}
