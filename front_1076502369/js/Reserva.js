$(document).ready(function () {
    // loadCountries()
    loadPasajeros()
});

/*  function loadCountries() {
//    Realizar la solicitud AJAX
    $.ajax({
        url: 'http://localhost:7033/test/v1/api/office',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
  //          Limpiar el selector antes de agregar nuevas opciones
            $('#passportCountryId').empty();

    //        Crear opciones para el selector
            for (var i = 0; i < data.length; i++) {
                var option = document.createElement('option');
                option.value = data[i].id;
                option.text = data[i].name + " - " + data[i].countryId.name;
                $('#passportCountryId').append(option);
            }
        },
        error: function (error) {
            console.error('Error al obtener los datos:', error);
        }
    });
}  */

function save() {
    return saveUser(), saveTicket();
}

function saveTicket() {
    try{
        var data = {
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'passportNumber': $('#passportNumber').val(),
            'passportCountryId':  1 ,
            'phone': $('#phone').val(),
            'passportPhoto': $('#passportPhoto').val()
        }
        
        var id = $('#id').val();

        $.ajax({
            url: 'http://localhost:7033/test/v1/api/tickets/save',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
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
        url: 'http://localhost:7033/test/v1/api/tickets',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = ""
            if (Array.isArray(data)) {
                data.forEach(function (item){
                    html +=
                    `<tr>
                        <td>${item.firstName}</td>
                        <td>${item.lastName}</td>
                        <td>${item.userId.birthDate}</td>
                        <td>${item.passportNumber}</td>
                        <td>${item.officeId.countryId.name}</td>
                        <td>${item.phone}</td>
                    </tr>`;
                })
            }
        }

    })
}