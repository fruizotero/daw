const d = document;

d.addEventListener("click", e => {

    if (e.target.matches(".button_calcular_edad")) {
        let fecha = (d.getElementById("fecha").value).split("-");
        let fechaActual = new Date();
        let anio = parseInt(fecha[0]);
        let mes = parseInt(fecha[1] - 1);
        let dia = parseInt(fecha[2]);

        let anioActual = fechaActual.getFullYear() - anio;

        console.log(anioActual);

    }

    if (e.target.matches(".crear")) {
        let lista = d.querySelector(".listas");

        let ul = d.createElement("ul");
        ul.setAttribute("class", "lista_ul");
        ul.innerHTML = "<li>1</li><li>2</li><li>3</li>";

        lista.append(ul);

    }
    if (e.target.matches(".destruir")) {
        d.querySelector(".lista_ul").remove();

    }


})