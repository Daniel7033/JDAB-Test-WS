$(document).ready(function () {
    loadData();
    loadOrigen();
    loadDestino();
    vuelosIda();
    // vuelosRegreso();
});

function loadData() {
    console.log("loadData ejecutandose");
    $.ajax({
        url: "http://localhost:7033/test/v1/api/schedules",
        method: "GET",
        dataType: "json",
        success: function (response) {
            var html = ""
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>${item.departure}</td>
                        <td>${item.arrival}</td>
                        <td>${item.date}</td>
                        <td>${item.time}</td>
                        <td>${item.flightNumber}</td>
                        <td>${item.economyPrice}</td>
                </tr>`;
                });
            }
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
        },
    });
}

//AUTOCOMPLETE
function loadOrigen() {
    $.ajax({
        url: "http://localhost:7033/test/v1/api/airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var origenes = response.data.map(function (origen) {
                    return {
                        label: origen.name,
                        value: origen.id
                    };
                });

                $(" #departure_airports_id").autocomplete({

                    source: origenes,
                    select: function (event, ui) {
                        $("#selected_departure_airports_id").val(ui.item.value);
                        $("#departure_airports_id").val(ui.item.label);
                        console.log("ID del aeropuerto destino seleccionada: " + ui.item.value);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });

            } else {
                console.error("Error con el autocomplete (Vuelos de Origen)")
            }
        },
        error: function (error) {
            console.error("Error autocomplete " + error);
        }
    });
}

function loadDestino() {
    $.ajax({
        url: "http://localhost:7033/test/v1/api/airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var destinos = response.data.map(function (destino) {
                    return {
                        label: destino.name,
                        value: destino.id
                    };
                });

                $("#arrival_airports_id").autocomplete({

                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(destinos, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selected_arrival_airports_id").val(ui.item.value);
                        $("#arrival_airports_id").val(ui.item.label);
                        console.log("ID del aeropuerto destino seleccionada: " + ui.item.value);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });


            } else {
                console.error("Error con el autocomplete (Vuelos de Destino)")
            }
        },
        error: function (error) {
            console.error("Error autocomplete " + error);
        }
    });
}

//METODO DE FILTRO
function filterData() {
    try {
        var selectOrigen = parseInt($("#selected_departure_airports_id").val());
        
        
        var selectDestino = parseInt($("#selected_arrival_airports_id").val());
        
        
        var origen = {'departure_airports_id' : { 'id': selectOrigen }}
        var destino = {'arrival_airports_id' : { 'id': selectDestino }}
        var fechaSalida = {'fechaSalida' : $('#fechaSalida').val()}
        var fechaFin = {'fechaFin' : $('#fechaFin').val()}

        $.ajax({
            url: "http://localhost:7033/test/v1/api/schedules/findViajes",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                origenId: origen,
                destinoId: destino,
                fechaSalida: fechaSalida,
                fechaFin: fechaFin
            }),
            success: function (response) {
                if (response) {
                    vuelosIda(response);
                    // vuelosRegreso(response);
                } else {
                    console.error("Error con la tabla de origen", data);
                }
            },
            error: function (error) {
                console.error("ERROR CON LA FUNCION: " + error);
            }
        });
    } catch {

    }
}

//TABLAS DE LOS VUELOS
function vuelosIda(data) {
    var html = ""
    if (Array.isArray(data)) {
        data.forEach(function (item) {
            html +=
                `<tr>
                <td>${item.departure}</td>
                <td>${item.arrival}</td>
                <td>${item.date}</td>
                <td>${item.time}</td>
                <td>${item.flightNumber}</td>
                <td>${item.economyPrice}</td>
            </tr>`;
        });
    } else {
        console.error("ERROR CON LOS DATOS FILTRADOS");
    }
    // $("#tablaIda").html(html);

    // $("#tablaIda").show();
    // $("#tablaRegreso").hide();
    // console.error("Error con la tabla de destino", data);

    $("#tablaIda").html(html);

    $("#tablaIda tr").click(function () {
        $("#tablaIda tr").removeClass("selected");
        $(this).addClass("selected");
    });
}



/* function vuelosRegreso() {



    var origen = parseInt($('#departure_airports_id').val());
    var destino = parseInt($('#arrival_airports_id').val());
    var fechaSalida = $('#fechaSalida').val();
    var fechaRegreso = $('#fechaRegreso').val();

    var data = {
        origenId: origen,
        destinoId: destino,
        fechaSalida: fechaSalida,
        fechaRegreso: fechaRegreso
    }

    console.log("vuelos regreso: ", data);
    $.ajax({
        url: "http://localhost:7033/test/v1/api/schedules/findViajes",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        dataType: "json",
        success: function (response) {
            var html = ""
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                        `<tr>
                            <td>${item.departure}</td>
                            <td>${item.arrival}</td>
                            <td>${item.date}</td>
                            <td>${item.time}</td>
                            <td>${item.flightNumber}</td>
                            <td>${item.economyPrice}</td>
                        </tr>`;
                });
            } else {
                console.error("Error con la tabla de destino", data);
            }
            // $("#tablaRegreso").html(html);

            // $("#tablaRegreso tr").click(function () {
            //     $("#tablaRegreso tr").removeClass("selected");
            //     $(this).addClass("selected");
            // });
            $("#tablaIda").html(html);

            $("#tablaIda").show();
            $("#tablaRegreso").hide();

        },
        error: function (error) {
            console.error("Error en la solicitud", error);
        }

    });
} */