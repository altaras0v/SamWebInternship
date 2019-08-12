
function deleteFile(id) {
    $.ajax({
            type:"DELETE",
            url: "../deleteFile/" + id,
            success: function () {
                console.log('easy');

                $('#' + id).remove();

            },
            error: function (e) {
                console.log('error')
            }
        }
    )
}
