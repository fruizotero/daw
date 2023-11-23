<?php

//Comprobación 1
function comprobarUsuario(array $usuarios, $usuario): bool
{

    $existe = false;
    foreach ($usuarios as $user => $value) {
        if ($user == $usuario) {
            $existe = true;
            break;
        }
    }

    return $existe;
}

//Comprobación 2
function comprobarPass(array $usuario, string $pass): bool
{
   
    return $usuario["pwd"] == $pass;
}

//Comprobación 3
function passCoinciden(string $newPass1, string $newPass2): bool
{
    return $newPass1 == $newPass2;
}

//Comprobación 4
function longitudMinima(string $value): bool
{
    return strlen($value) >= 6;
}

//Comprobación 5
function passUtilizada(array $usuario, string $pass): bool
{
    return $usuario["pwd-1"] != $pass && $usuario["pwd-2"] != $pass;
}

//Comprobación 6
function contieneMayuscula(string $pass): bool
{
    return !ctype_lower($pass);
}

//Comprobación 7
function contieneNumeros(string $pass): bool
{

    $passConNumeros = false;
    if (preg_match('~[0-9]+~', $pass)) {
        $passConNumeros = true;
    }

    return $passConNumeros;
}

//Comprobación 8
function contieneSimbolos(string $pass):bool{

    $passConSimbolos = false;
    if(preg_match('~[\.?@]+~', $pass)){
        $passConSimbolos = true;
    }

    return $passConSimbolos;
}