function loadCountries() {
    // Realizar la solicitud AJAX
    $.ajax({
        url: 'http://localhost:7033/test/v1/api/countries',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Limpiar el selector antes de agregar nuevas opciones
            $('#passportCountryId').empty();

            // Crear opciones para el selector
            for (var i = 0; i < data.length; i++) {
                var option = document.createElement('option');
                option.value = data[i].id;
                option.text = data[i].name ;
                $('#passportCountryId').append(option);
            }
        },
        error: function (error) {
            console.error('Error al obtener los datos:', error);
        }
    });
}

function saveUser() {
    try {
        /* var selectCountry = parseInt($("#passportCountryId").val());
        if (isNaN(selectCountry) || selectCountry === null) {
            console.error("ID de ciudad no válido");
            return;
        } */

        var data = {
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'birthDate': $('#birthDate').val(),
            'passportNumber': $('#passportNumber').val(),
            'passportCountryId': { 'id' : parseInt($("#passportCountryId").val())},
            'phone': $('#phone').val()
        }

        var id = $('#id').val();

        $.ajax({
            url: 'http://localhost:7033/test/v1/api/tickets/saveUsers',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                var id = response.data.id

                loadPasajeros();
                alert("GUARDADO")
            },
            error: function (error) {
                console.error("ERROR AL AGREGAR PASAJERO. Tipo de error: ", error);
            }
        });
    } catch {

    }
}

function loadPasajeros() {
    $.ajax({
        url: 'http://localhost:7033/test/v1/api/users/',
        method: 'GET',
        dataType: 'json',
        contentType: 'application/json',

    })
}