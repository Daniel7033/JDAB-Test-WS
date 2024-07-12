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
            'passportCountry': 1,
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