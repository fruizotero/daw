<?php

const NAME = "name";
const ERROR = "error";
const SIZE = "size";
const TMP_NAME = "tmp_name";
const SUCCESS = "exito";

function lista_informacion_ficheros(string $clave_files): void
{

    //Si no existe la carpeta indicada en el "path", se crea una
    if (!file_exists(PATH))
        mkdir(PATH, 0770, true);


    $array_ficheros = $_FILES[$clave_files];
    $keys = array_keys($array_ficheros);
    $cantidad_archivos = sizeof($array_ficheros[$keys[0]]);

    $array_ficheros_validos = [];
    $array_exito = [SUCCESS => true, "datos" => ""];
    $array_error = [SUCCESS => false, "datos" => ""];

    for ($i = 0; $i < $cantidad_archivos; $i++) {

        $numero_fichero = $i + 1;
        echo "<p>Fichero $numero_fichero </p>";
        // Lista ordernada
        echo "<ol>";
        foreach ($keys as $key) {
            $value = $array_ficheros[$key][$i];

            echo "<li>$key: $value</li>";
        }
        echo "</ol>";

        $error = $array_ficheros[ERROR][$i];
        $tmp_name = $array_ficheros[TMP_NAME][$i];


        if (is_uploaded_file($tmp_name) && $error == UPLOAD_ERR_OK) {

            $archivo = PATH . DIRECTORY_SEPARATOR .  basename($array_ficheros[NAME][$i]);


            if (move_uploaded_file($tmp_name, $archivo)) {
                $array_exito["datos"] = datos_array($array_ficheros, $i);
                $array_ficheros_validos[] = $array_exito;
            } else {
                $array_error["datos"] = datos_array($array_ficheros, $i);
                $array_ficheros_validos[] = $array_error;
            }
        } else {

            $array_error["datos"] = datos_array($array_ficheros, $i);
            $array_ficheros_validos[] = $array_error;
        }
    }


    for ($k = 0; $k < sizeof($array_ficheros_validos); $k++) {

        if ($array_ficheros_validos[$k][SUCCESS]) {

            $name = $array_ficheros_validos[$k]["datos"][NAME];
            $error = $array_ficheros_validos[$k]["datos"][ERROR];
            $size = number_format($array_ficheros_validos[$k]["datos"][SIZE] / 1024, 2);

            echo "<p>Se ha guardado con éxito el fichero: <br>Nombre: $name<br>Código error: $error<br>Tamaño: $size KB</p>";
        } else {

            $name = $array_ficheros_validos[$k]["datos"][NAME];
            $error = $array_ficheros_validos[$k]["datos"][ERROR];
            $size = number_format($array_ficheros_validos[$k]["datos"][SIZE] / 1024, 2);

            echo "<p>No se ha podido guardar el fichero:<br>Nombre: $name<br>Código error: $error<br>Tamaño: $size KB</p>";
        }
    }
}


function datos_array($array, $index)
{

    return array(
        NAME => $array[NAME][$index],
        ERROR => $array[ERROR][$index],
        SIZE => $array[SIZE][$index]
    );
}
