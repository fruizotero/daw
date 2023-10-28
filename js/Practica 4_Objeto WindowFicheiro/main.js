const d = document;
const w = window;

let ventana;
let windowFeatures;
const patron = /[0-9]+/;
let ancho, alto, coordenadaX, coordenadaY, message;
d.addEventListener("click", (e) => {
    if (e.target.matches(".crear")) {

        let btnCrear = d.querySelector(".crear");
        ancho = d.getElementById("ancho").value;
        alto = d.getElementById("alto").value;
        coordenadaX = d.getElementById("coordenada_x").value;
        coordenadaY = d.getElementById("coordenada_y").value;
        message = document.querySelector(".message");
        btnCrear.disabled = true;


        if (!patron.test(ancho) || !patron.test(alto) || !patron.test(coordenadaX) || !patron.test(coordenadaY)) {
            message.textContent = "Valores no válidos";
        } else {
            message.textContent = "";
            const botones = d.querySelectorAll(".boton-secundario");


            botones.forEach(boton => boton.disabled = false);

            windowFeatures = `left=${coordenadaX},top=${coordenadaY},width=${ancho},height=${alto}`;
            ventana = window.open("", "", windowFeatures);
            ventana.document.write("<p>ESTA ES LA VENTANA QUE SE HA CREADO<br> ventana</p>");

            // Deshabilita los botones secundarios cuando se cierra la ventana
            ventana.addEventListener("unload", () => {
                botones.forEach(boton => boton.disabled = true);
                btnCrear.disabled=false;
            })
        }

    }

    if (e.target.matches(".cerrar")) {
        ventana.close();

    }
    if (e.target.matches(".mover")) {

        coordenadaX = d.getElementById("coordenada_x").value;
        coordenadaY = d.getElementById("coordenada_y").value;

        if (!patron.test(coordenadaX) || !patron.test(coordenadaY)) {
            message.textContent = "Valores no válidos";
        } else {

            ventana.moveTo(parseInt(coordenadaX), parseInt(coordenadaY));
        }

    }
    if (e.target.matches(".redimensionar")) {
        ancho = d.getElementById("ancho").value;
        alto = d.getElementById("alto").value;

        if (!patron.test(ancho) || !patron.test(alto)) {
            message.textContent = "Valores no válidos";
        } else {

            ventana.resizeTo(parseInt(ancho), parseInt(alto));
        }
    }


});

