<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    <title>Crear libro</title>
</head>

<body>
    <?php
    require_once 'conexion.php';
    require_once 'util.php';

    $pdate = null;
    $isbn = null;
    $pub_Id = null;
    //todos los autores disponibles en BD
    $authors = null;
    //los ids de los autores del libro
    $book_author_ids = null;
    $title = "";
    $exito = true;



    //title
    //isbn
    //pdate
    //publisher
    $publishers = findAllPublishers();
    $authors = findAllAuthors();

    if (isset($_POST["title"])) {
        if (isNotEmpty($_POST["title"])) {
            $title = $_POST["title"];
        }

        if (isset($_POST["isbn"]) &&  isNotEmpty($_POST["isbn"])) {
            $isbn = $_POST["isbn"];
        }

        if (isset($_POST["pdate"]) &&  isNotEmpty($_POST["pdate"])) {
            $pdate = $_POST["pdate"];
            $pdate_converted = DateTimeImmutable::createFromFormat("Y-m-d", $pdate);
            if ($pdate_converted !== false) {
                $pdate = $pdate_converted;
            }
        }

        if (isset($_POST["publisher"]) &&  isNotEmpty($_POST["publisher"])) {
            $pub_Id = $_POST["publisher"];
        }
        if (isset($_POST["author_ids"])) {
            $book_author_ids = $_POST["author_ids"];
        }

        transaccion();
    }

    ?>
    <div class="container-fluid">
        <header class="mb-5">
            <div class="p-5 text-center " style="margin-top: 58px;">
                <h1 class="mb-3"> Crear libro </h1>

            </div>
        </header>
        <form class='form-control ' method="post">
            <div>
                <label for="title" class="form-label col-3">Título</label>
                <input name="title" type="text" class="form-control col-9" id="title" pattern="^(?!\s*$).+" required />
            </div>
            <div>
                <label for="isbn" class="form-label col-3">ISBN</label>
                <input name="isbn" type="text" class="form-control col-9" id="isbn" pattern="^(?!\s*$).+" />
            </div>

            <div>
                <label for="pdate" class="form-label col-3">Fecha de publicación</label>
                <input name="pdate" type="date" class="form-control col-9" id="pdate" />
            </div>

            <div class='row form-group my-3'>
                <label for="publisher" class="col-form-label col-2">Editorial</label>
                <div class='col-6'>
                    <select name="publisher" id="publisher" class="form-control col-3" required>

                        <option value="" disabled>----</option>
                        <?php
                        if (count($publishers) > 0) :
                            foreach ($publishers as $publisher) :
                        ?>
                                <option value="<?= $publisher["publisher_id"] ?>"><?= $publisher["name"] ?></option>
                        <?php
                            endforeach;
                        endif;
                        ?>


                    </select>
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="authors" class="col-form-label col-2">Autor</label>

                <div class="col-6">
                    <select name="author_ids[]" id="authors" class="form-control" multiple>

                        <option value="">----</option>
                        <?php

                        $authors = findAllAuthors();
                        foreach ($authors as  $author) {
                            $name = $author["name"];
                            $author_id = $author["author_id"];
                            echo "<option value=$author_id >$name</option>";
                        }

                        ?>


                    </select>
                </div>


            </div>
            <div class="row d-flex justify-content-center">
                <button type="submit" class="btn btn-primary my-3 col-3">Crear libro</button>
            </div>

        </form>
        <a href="listado.php" class="btn btn-link mt-2">Volver</a>

        <?php if (($exito) && isset($_POST["title"])) : ?>
            <div class="alert alert-success" role="alert">
                El libro se ha creado correctamente
            </div>

        <?php endif;


        /**
         * findAllPublishers
         * Crea una consulta con PDO y obtiene todos los datos de la tabla publishers
         * @return array Array con todas las tuplas de la tabla publishers como array asociativo
         */
        function findAllPublishers(): array
        {
            $conProyecto = getConnection();

            $pdostmt = $conProyecto->prepare("SELECT *FROM publishers ORDER BY name");

            $pdostmt->execute();
            $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);


            return $array;
        }

        /**
         * Devuelve un array asociativo conformado con el id, y el nombre y apellido del autor concantenado.
         * @return array
         */
        function findAllAuthors(): array
        {
            //completar
            $conProyecto = getConnection();

            $pdostmt = $conProyecto->prepare("SELECT author_id, concat(coalesce(first_name, \"\"), \" \", coalesce(middle_name, \"\"), \" \",  coalesce(last_name, \"\")) name FROM authors order by last_name");

            $pdostmt->execute();
            $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);


            return $array;
        }

        function transaccion(): bool
        {
            $exito = false;


            $title = $_POST["title"];
            $pdate = $_POST["pdate"];
            $isbn = $_POST["isbn"];
            $publisher = $_POST["publisher"];
            $book_author_ids = $_POST["author_ids"];

            try {
                $conProyecto = getConnection();
                $conProyecto->beginTransaction();

                $addLibro = "INSERT INTO books (title, isbn, published_date, publisher_id) values(:title, :isbn, :pdate, :id)";

                $addAutor = "INSERT INTO book_authors(book_id,author_id) values(:author_id, :book_id)";

                $stmt_libro = $conProyecto->prepare($addLibro);
                $stmt_autor = $conProyecto->prepare($addAutor);

                $exito = $stmt_libro->execute(array("isbn" => $isbn, "title" => $title, "pdate" => $pdate, "id" => $publisher));

                $id_libro=$conProyecto->lastInsertId();

                foreach ($book_author_ids as  $value) {
                    if ($exito) {
                        $exito = $stmt_autor->execute(array("book_id"=>$id_libro, "author_id"=>$value));
                    }
                }


                if($exito){
                    $conProyecto->commit();
                } else{
                    $conProyecto->rollBack();
                }

                //code...
            } catch (PDOException $ex) {
                $conProyecto->rollBack();
                $exito = false;
            }

            return $exito;
        }



        ?>




    </div>
</body>

</html>