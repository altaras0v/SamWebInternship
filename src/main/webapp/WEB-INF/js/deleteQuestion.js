
function deleteQuestion(id,size) {
    $.ajax({
            type:"DELETE",
            url: "../deleteQuestion/" + id,
            success: function () {
                console.log('easy');

                $('#' + id).remove();
                if (size==1)  $('#0012').remove();
            },
            error: function (e) {
                console.log('error')
            }
        }
    )
}
