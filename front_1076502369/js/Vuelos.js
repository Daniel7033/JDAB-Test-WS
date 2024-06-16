function salidas(){
    $.ajax({
        url: 'http://localhost:7033/test/v1/api/schedules/salidas' ,
        method: "GET",
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                    `<tr>
                    <td>${item.route.departure}</td>
                    <td>${item.route.arrival}</td>
                    <td>${item.date}</td>
                    <td>${item.time}</td>
                    <td>${item.flightNumber}</td>
                    <td>${item.economyPrice}</td>
                </tr>`
                });
            }
            $('#vuelosIda').html(html);
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}