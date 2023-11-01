<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarea02.1</title>
</head>

<body>

    <form enctype="multipart/form-data" action="" method="post">

        <label for="archivos">Subir archivos</label>
        <br>
        <input type="file" id="archivos" name="archivos[]" accept="image/jpeg, image/jpg" multiple required>
        <br>
        <button type="submit">Enviar</button>



    </form>


    <?php
    require_once "utils.php";

    const PATH =   "archivos";
    const CLAVE_INPUT = "archivos";

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {

        if (isset($_FILES[CLAVE_INPUT])) {
            lista_informacion_ficheros(CLAVE_INPUT);
        } else {
            echo "<p>Error, el 'name' de tu campo no es válido </p>";
        }
    } 
    // else{
    //     echo "<p>No estás utilizando él método POST</p>";
    // }

    ?>
</body>

</html>