$(document).ready(function () {
    loadData();
    loadOrigen();
    loadDestino();
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
                        <td>${item.routeId.departure}</td>
                        <td>${item.routeId.arrival}</td>
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
//function filterData() {


//     $.ajax({
//         url: "http://localhost:7033/test/v1/api/schedules/findViajes",
//         method: "POST",
//         contentType: "application/json",
//         data: JSON.stringify(data),
//         dataType: "json",
//         success: function (response) {
//             var html = ""
//             var data = response.data;
//             if (Array.isArray(data)) {
//                 data.forEach(function (item) {
//                     html +=
//                         `<tr>
//                     <td>${item.routeId.departure}</td>
//                     <td>${item.reouteId.arrival}</td>
//                     <td>${item.date}</td>
//                     <td>${item.time}</td>
//                     <td>${item.flightNumber}</td>
//                     <td>${item.economyPrice}</td>
//             </tr>`;
//                 });
//             } else {
//                 console.error("Error con la tabla de origen", data);
//             }
//         },
//         error: function (error) {
//             console.error("ERROR CON LA FUNCION: " + error);
//         }
//     });
// }

//TABLAS DE LOS VUELOS
function vuelosIda() {
    var origen = parseInt($('#selected_departure_airports_id').val());
    var destino = parseInt($('#selected_arrival_airports_id').val());
    var fechaSalida = $('#fechaSalida').val();
    var fechaRegreso = $('#fechaRegreso').val();

    var data = {
        origenId: origen,
        destinoId: destino,
        fechaSalida: fechaSalida,
        fechaRegreso: fechaRegreso
    }

    console.log("vuelos ida  ", data);

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
                            <td>${item.routeId.departure}</td>
                            <td>${item.routeId.arrival}</td>
                            <td>${item.date}</td>
                            <td>${item.time}</td>
                            <td>${item.flightNumber}</td>
                            <td>${item.economyPrice}</td>
                        </tr>`;
                });
            } //else {
            $("#tablaIda").html(html);

            $("#tablaIda").show();
            $("#tablaRegreso").hide();
            //     console.error("Error con la tabla de destino", data);
            // }
            // $("#tablaRegreso").html(html);

            // $("#tablaRegreso tr").click(function () {
            //     $("#tablaRegreso tr").removeClass("selected");
            //     $(this).addClass("selected");
            // });
        },
        error: function (error) {
            console.error("Error en la solicitud", error);
        }
    });

    // $("#tablaIda").html(html);

    // $("#tablaIda tr").click(function () {
    //     $("#tablaIda tr").removeClass("selected");
    //     $(this).addClass("selected");
    // });
}

function vuelosRegreso() {



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

    console.log("vuelos regreso: ",data);
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
                            <td>${item.routeId.departure}</td>
                            <td>${item.routeId.arrival}</td>
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
}