const d = document;


d.addEventListener("click", e => {


    if (e.target.matches("#crear")) {

        let cantidadValue = d.getElementById("cantidad").value;

        if (cantidadValue != "") {
            cantidadValue = parseInt(cantidadValue);
            let seccion = d.getElementById("seccion");

            let contenedorTemporal = d.createElement("div");
            contenedorTemporal.setAttribute("id", "seccion-padre");

            for (let index = 0; index < cantidadValue; index++) {

                let div = d.createElement("div");
                div.setAttribute("id", index + 1);
                div.setAttribute("class", "caja");
                div.innerHTML = `<p>${index + 1}</p>`;

                contenedorTemporal.appendChild(div);

            }

            seccion.replaceChildren(contenedorTemporal);

        }




    }
    if (e.target.matches("#antes")) {

        let indiceNumeroAnterior = d.getElementById("numeroAnterior").value;

        if (indiceNumeroAnterior != "") {

            indiceNumeroAnterior = parseInt(indiceNumeroAnterior);
            let seccionPadre = d.getElementById("seccion-padre");
            let divHermano = d.getElementById(indiceNumeroAnterior);
            let newDiv = d.createElement("div");
            newDiv.setAttribute("class", "caja amarillo");

            seccionPadre.insertBefore(newDiv, divHermano);



        }

    }
    if (e.target.matches("#despues")) {

        let indiceNumeroPosterior = d.getElementById("numeroPosterior").value;

        if (indiceNumeroPosterior != "") {
            indiceNumeroPosterior = parseInt(indiceNumeroPosterior);

            let seccionPadre = d.getElementById("seccion-padre");
            let divHermano = d.getElementById(indiceNumeroPosterior).nextSibling;

            let newDiv = d.createElement("div");
            newDiv.setAttribute("class", "caja naranja");

            seccionPadre.insertBefore(newDiv, divHermano);
        }

    }

    if (e.target.matches("#circulo")) {
        let indiceNumeroCirculo = d.getElementById("valorCirculo").value;

        if (indiceNumeroCirculo != "") {
            // indiceNumeroCirculo = parseInt(indiceNumeroCirculo);
            d.getElementById(indiceNumeroCirculo).classList.add("circulo");
        }
    }



});

d.addEventListener("mouseover", e => {


    if (e.target.matches(".caja")) {
        e.target.classList.toggle("azul");
    }

})
d.addEventListener("mouseout", e => {


    if (e.target.matches(".caja")) {
        e.target.classList.toggle("azul");
    }

})