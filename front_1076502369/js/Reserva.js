function saveUser(){
    var data = {
        'firstName' : $('#firstName').val(),
        'lastName' : $('#lastName').val(),
        'birthDate' : $('#birthDate').val(),
        'passportNumber' : $('#passportNumber').val(),
        'passportCountry' : { 'id': selectCountry },
        'phone' : $('#phone').val()
    }

    $.ajax({
        url: 'http://localhost:7033/test/v1/api/tickets/saveUsers',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data : JSON.stringify(data),
        success: function (response) {
            var id = response.data.id

            loadPasajeros();
        },
        error: function (error){
            console.error("ERROR AL AGREGAR PASAJERO. Tipo de error: ", error);
        }
    });
}

function loadPasajeros(){
    
}