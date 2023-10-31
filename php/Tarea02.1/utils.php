<?php

function lista_informacion_ficheros(string $clave_array, string $ruta): void
{

    if (!file_exists($ruta))
        mkdir($ruta, 0770, true);


    // echo "<pre>";
    // print_r($array_ficheros);
    // echo "</pre>";

    $array_ficheros = $_FILES[$clave_array];
    //Se obtienen las claves del array asociativo
    $keys = array_keys($array_ficheros);


    //Como todas las claves tienen un array  asociado con la misma cantidad de elementos que coincide con el número de archivos enviados, cualquiera sirve para obtener el número de archivos que se ha enviado
    $cantidad_archivos = sizeof($array_ficheros[$keys[0]]);
    $array_ficheros_validos = [];
    $array_exito = ["exito" => true, "name" => ""];
    $array_error = ["exito" => false, "error" => ""];

    //Cada indice de los elementos de los arrays asociados a las claves coinciden con la información de un archivo especifico, es decir, cada indice 0 hara referencia a un dato del primer archivo.
    for ($i = 0; $i < $cantidad_archivos; $i++) {
        $numero_fichero = $i + 1;
        echo "<p>Fichero $numero_fichero </p>";


        $error = $array_ficheros["error"][$i];
        $tmp_name = $array_ficheros["tmp_name"][$i];


        if (is_uploaded_file($tmp_name) && $error == UPLOAD_ERR_OK) {

            echo "<ol>";
            foreach ($keys as $key) {
                $value = $array_ficheros[$key][$i];

                echo "<li>$key: $value</li>";
            }
            echo "</ol>";

            $archivo = $ruta . DIRECTORY_SEPARATOR .  basename($array_ficheros["name"][$i]);


            if (move_uploaded_file($tmp_name, $archivo)) {
                $array_exito["name"] = $array_ficheros["name"][$i];
                $array_ficheros_validos[] = $array_exito;
            } else {
                $array_error["error"] = array(
                    "name" => $array_ficheros["name"][$i],
                    "error" => $array_ficheros["error"][$i],
                    "size" => $array_ficheros["size"][$i]
                );

                $array_ficheros_validos[] = $array_error;
            }
        } else {
            echo "<p>Fichero no válido</p>";
            $array_error["error"] = array(
                "name" => $array_ficheros["name"][$i],
                "error" => $array_ficheros["error"][$i],
                "size" => $array_ficheros["size"][$i]
            );

            $array_ficheros_validos[] = $array_error;
        }
    }


    for ($k = 0; $k < sizeof($array_ficheros_validos); $k++) {

        if ($array_ficheros_validos[$k]["exito"]) {
            $name = $array_ficheros_validos[$k]["name"];
            echo "<p>Se ha guardado con éxito el fichero: $name</p>";
        } else {
            $name = $array_ficheros_validos[$k]["error"]["name"];
            $error = $array_ficheros_validos[$k]["error"]["error"];
            $size = $array_ficheros_validos[$k]["error"]["size"];

            echo "<p>No se ha podido guardar el fichero:<br>Nombre: $name<br>Código error: $error<br>Tamaño: $size</p>";
        }
    }
}
