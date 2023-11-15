const d = document;


d.addEventListener("submit", (e) => {

    if (e.target.matches(".form_date")) {
        e.preventDefault();

        let dateArray = (d.querySelector("#date").value).split("-");
        let message = d.querySelector(".message");

        // console.log(dateArray);
        // console.log(parseInt(dateArray[2]));

        let year = parseInt(dateArray[0]);
        let month = parseInt(dateArray[1]) - 1;
        let day = parseInt(dateArray[2]);
        let dateEvent = new Date(year, month, day);
        let dateNow = new Date();

        let time = dateEvent.getTime() - dateNow.getTime();

        let days = Math.floor(time / (1000 * 60 * 60 * 24));
        let hours = Math.floor((time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        let minutes = Math.floor((time % (1000 * 60 * 60 )) / (1000 * 60));
        let seconds = Math.floor((time % (1000 * 60 )) / (1000));


        console.log(`${days} días ${hours} horas ${minutes} minutos y ${seconds} seconds`);





    }

});