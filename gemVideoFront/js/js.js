$(document)
    .ready(function () {
        $("#agregarVideo")
            .click(function () {
                anadirEvento();
            });
        $("#playLists").delegate("a", "click", function () {
            anadirEvento();
        });
        function anadirEvento() {
            $("#vista").toggleClass("isHide");
        }
    });