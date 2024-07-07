$(document).ready(function () {
    loadOrigen();
    loadDestino();
});

//AUTOCOMPLETE
function loadOrigen() {
    $.ajax({
        url: "http://localhost:7033/test/v1/api/airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var variable = response.data.map(function (origen) {
                    return {
                        label: origen.name,
                        value: origen.id
                    };
                });
                $("#departure_airports_id").autocomplete({
                    source: variable,
                    select: function (even, ui) {
                        $("#selected_departure_airports_id").val(ui.item.value);
                        $("#departure_airports_id").val(ui.item.label);
                        return false;
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
                var variable = response.data.map(function (destino) {
                    return {
                        label: destino.name,
                        value: destino.id
                    };
                });
                $("#arrival_airports_id").autocomplete({
                    source: variable,
                    select: function (even, ui) {
                        $("#selected_arrival_airports_id").val(ui.item.value);
                        $("#arrival_airports_id").val(ui.item.label);
                        return false;
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
function filterData(){
    var origen = parseInt($('#selected_departure_airports_id').val());
    var destino = parseInt($('#selected_arrival_airports_id').val());
    var fechaSalida = $('#fechaSalida').val();
    var fechaRegreso = $('#fechaRegreso').val();
    
    $.ajax({
        url: "http://localhost:7033/test/v1/api/schedules/findViajes",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            origenId: origen,
            destinoId: destino,
            fechaSalida: fechaSalida,
            fechaRegreso: fechaRegreso
        }),
        success: function (response) {
            if (response) {
                vuelosIda(response);
            } else {
                console.error("ERROR: " + response);
            }
        },
        error: function (error) {
            console.error("ERROR CON LA FUNCION: " + error);
        }
    });
}

//TABLAS DE LOS VUELOS
function vuelosIda(data){
    var html = ""
    if (Array.isArray(data)) {
        data.forEach(function (item){
            html +=
            `<tr>
                    <td>${item.route.name}</td>
                    <td>${item.route.name}</td>
                    <td>${item.date}</td>
                    <td>${item.time}</td>
                    <td>${item.flightNumber}</td>
                    <td>${item.economyPrice}</td>
            </tr>`;
        });
    } else {
        console.error("Error con la tabla de origen", data);
    }

    $("#tablaIda").html(html);

    $("#tablaIda tr").click(function () {
        $("#tablaIda tr").removeClass("selected");
        $(this).addClass("selected");
    });
}

function vuelosRegreso(data){
    var html = ""
    if (Array.isArray(data)) {
        data.forEach(function (item){
            html +=
            `<tr>
                    <td>${item.route.name}</td>
                    <td>${item.route.name}</td>
                    <td>${item.date}</td>
                    <td>${item.time}</td>
                    <td>${item.flightNumber}</td>
                    <td>${item.economyPrice}</td>
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

function loadData(){
    $.ajax({
        url: "http://localhost:7033/test/v1/api/schedules",
        method: "GET",
        dataType: "json",
        success: function (response) {
            vuelosIda(response.data);
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
        },
    });
}