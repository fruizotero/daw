<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHPWebPage.php to edit this template
-->
<html>

<head>
    <meta charset="UTF-8">
    <title>Change password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>

<body>

    <div class="container-fluid">
        <h1>Cambio de contraseña</h1>
        <div class="row justify-content-center">
            <div class="col-sm-12 col-md-6">
                <form method="post">
                    <!-- Email input -->
                    <div class="form-group mb-4 ">
                        <label class="form-label" for="email">Email address</label>
                        <input type="email" id="email" class="form-control" name="email" required />

                    </div>

                    <!-- Current Password input -->
                    <div class="form-group mb-4">
                        <label class="form-label" for="currentPwd">Contraseña actual</label>
                        <input type="password" id="currentPwd" class="form-control" name="pwd" required />

                    </div>

                    <!-- New Password input 1-->
                    <div class="form-group mb-4">
                        <label class="form-label" for="newPwd1">Nueva contraseña</label>
                        <input type="password" id="newPwd1" class="form-control" name="newPwd1" required />

                    </div>

                    <!-- New Password input 2-->
                    <div class="form-group mb-4">
                        <label class="form-label" for="newPwd2">Repita nueva contraseña</label>
                        <input type="password" id="newPwd2" class="form-control" name="newPwd2" required />

                    </div>

                    <!-- Submit button -->
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Cambiar contraseña"></button>


                </form>

                <?php
                require_once "utils.php";

                ini_set("display_errors", "1");

                const MIN_LENGH = 6;
                $usuarios = array(
                    "user1@edu.es" => array("pwd" => "Abc123.", "pwd-1" => "aBc123.", "pwd-2" => "abC123."),
                    "user2@edu.es" => array("pwd" => "123Abc.", "pwd-1" => "123aBc.", "pwd-2" => "123abC.")
                );
                $simbolos = [".", "?", "@"];

                $numeros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

                const USER_DOES_NOT_EXIST = "No existe usuario";
                const PWD_INCORRECT = "La contraseña no es correcta";
                const PWD_MISMATCH = "Las contraseñas no coinciden";
                const MIN_LENGTH_ERROR = "La longitud mínima es " . MIN_LENGH;
                const PWD_USED = "La contraseña es una de las 2 últimas utilizadas";
                const UPPER_CASE_NEEDED = "La nueva contraseña debe contener al menos una letra mayúscula";
                const NUMBER_NEEDED = "La nueva contraseña debe contener al menos un número";
                const SYMBOL_NEEDED = "La nueva contraseña debe contener al menos un símbolo: ";

                //Completar

                $errors = [];
                $email;
                $pass;
                $pass1;
                $pass2;
                $passValida = false;
                $nuevasPassCoinciden;
                $longitudValida;
                $passUtilizado;
                $passMayuscula;
                $passNumeros;
                $passSimbolos;
                $pwd1;
                $formulario_valido = false;

                if ($_SERVER['REQUEST_METHOD'] === 'POST') {
                    $email = $_POST["email"];
                    $esValido =  comprobarUsuario($usuarios, $email);

                    if (!$esValido) {
                        $errors[] = USER_DOES_NOT_EXIST;
                    }

                    if ($esValido) {
                        $pass = $_POST["pwd"];
                        $passValida = comprobarPass($usuarios[$email], $pass);

                        if (!$passValida) {
                            $errors[] = PWD_INCORRECT;
                        }
                    }

                    if ($passValida) {
                        $pass1 = $_POST["newPwd1"];
                        $pass2 = $_POST["newPwd2"];
                        $nuevasPassCoinciden = passCoinciden($pass1, $pass2);

                        if (!$nuevasPassCoinciden) {
                            $errors[] = PWD_MISMATCH;
                        }

                        if ($nuevasPassCoinciden) {
                            $longitudValida = longitudMinima($pass1);

                            if (!$longitudValida) {
                                $errors[] = MIN_LENGTH_ERROR;
                            }

                            if ($longitudValida) {
                                $passUtilizado = passUtilizada($usuarios[$email], $pass1);

                                if (!$passUtilizado) {
                                    $errors[] = PWD_USED;
                                }

                                if ($passUtilizado) {
                                    $passMayuscula = contieneMayuscula($pass1);

                                    if (!$passMayuscula) {
                                        $errors[] = UPPER_CASE_NEEDED;
                                    }

                                    if ($passMayuscula) {
                                        $passNumeros = contieneNumeros($pass1);

                                        if (!$passNumeros) {
                                            $errors[] = NUMBER_NEEDED;
                                        }

                                        if ($passNumeros) {
                                            $passSimbolos = contieneSimbolos($pass1);

                                            if (!$passSimbolos) {

                                                $errors[] = SYMBOL_NEEDED . implode(",", $simbolos);
                                            } else {
                                                $formulario_valido = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                ?>



                <div class="alert alert-danger" role="alert">
                    <?php
                    foreach ($errors as  $error) {
                        echo "<p>$error</p>";
                    }
                    ?>
                </div>


                <div class="alert alert-success" role="alert">
                    <?php

                    if ($formulario_valido) {
                        $pwd1 = $usuarios[$email]["pwd-1"];
                        $usuarios[$email]["pwd"] = $pass1;
                        $usuarios[$email]["pwd-1"] = $pass;
                        $usuarios[$email]["pwd-2"] = $pwd1;
                        echo " Se ha actualizado correctamente la contraseña ";
                        print_r($usuarios[$email]);
                    }

                    ?>
                </div>

            </div>
        </div>
    </div>


</body>

</html>