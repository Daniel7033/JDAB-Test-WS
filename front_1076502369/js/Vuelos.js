$(document).ready(function () {
    loadOrigen();
    loadDestino();
});

function filtro() {
    return filterDataIda(), filterDataRetorno();
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
                        label: `${origen.code} - ${origen.name}`,
                        value: origen.id
                    };
                });

                $(" #departure").autocomplete({

                    source: origenes,
                    select: function (event, ui) {
                        $("#selected_departure_airport_id").val(ui.item.value);
                        $("#departure").val(ui.item.label);
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
                        label: `${destino.code} - ${destino.name}`,
                        value: destino.id
                    };
                });

                $("#arrival").autocomplete({

                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(destinos, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selected_arrival_airport_id").val(ui.item.value);
                        $("#arrival").val(ui.item.label);
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
function filterDataIda() {
    try {

        let origen = parseInt($("#selected_departure_airport_id").val())
        let llegada = parseInt($("#selected_arrival_airport_id").val())
        let fechaSalida = $('#date').val()
        let fechaDestino = $('#date').val()

        $.ajax({
            url: "http://localhost:7033/test/v1/api/schedules/findViajes",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                salida: origen,
                destino: llegada,
                fechaOrigen: fechaSalida,
                fechaLlegada: fechaDestino
            }),
            success: function (response) {
                if (response) {
                    vuelosIda(response);
                } else {
                    console.error("Error con la tabla de origen", data);
                }
            },
            error: function (error) {
                console.error("ERROR CON LA FUNCION: " + error);
            }
        });
    } catch {
        //
    }
}

function filterDataRetorno() {
    try {

        let llegada = parseInt($("#selected_arrival_airport_id").val())
        let fechaSalida = $('#date').val()
        let fechaDestino = $('#date').val()
        $.ajax({
            url: "http://localhost:7033/test/v1/api/schedules/findViajesRetorno",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                salida: llegada,
                fechaOrigen: fechaSalida,
                fechaLlegada: fechaDestino
            }),
            success: function (response) {
                if (response) {
                    vuelosRetorno(response);
                } else {
                    console.error("Error con la tabla de origen", data);
                }
            },
            error: function (error) {
                console.error("ERROR CON LA FUNCION: " + error);
            }
        });
    } catch {
        //
    }
}

//TABLAS DE LOS VUELOS
function vuelosIda(data) {
    var html = ""
    if (Array.isArray(data)) {
        data.forEach(function (item) {
            html +=
                `<tr>
                <td>${item.salida}</td>
                <td>${item.destino}</td>
                <td>${item.date}</td>
                <td>${item.time}</td>
                <td>${item.flightNumber}</td>
                <td>${item.economyPrice}</td>
                <td>${item.sillasOcupadas}</td>
                <td>${item.sillasDisponibles}</td>
            </tr>`;
        });
    } else {
        console.error("ERROR CON LOS DATOS FILTRADOS");
    }

    $("#tablaIda").html(html);
    $("#tablaIda tr").click(function () {
        $("#tablaIda tr").removeClass("selected");
        $(this).addClass("selected");
    });
}



function vuelosRetorno(data) {
    var html = ""
    if (Array.isArray(data)) {
        data.forEach(function (item) {
            html +=
                `<tr>
                <td>${item.salida}</td> 
                <td>${item.destino}</td>
                <td>${item.date}</td>
                <td>${item.time}</td>
                <td>${item.flightNumber}</td>
                <td>${item.economyPrice}</td>
                <td>${item.sillasOcupadas}</td>
                <td>${item.sillasDisponibles}</td>
            </tr>`;
        });
    } else {
        console.error("Error con la tabla de destino", data);
    }

    $("#tablaRegreso").html(html);
    $("#tablaRegreso tr").click(function () {
        $("#tablaRegreso tr").removeClass("selected");
        $(this).addClass("selected");
    });
}