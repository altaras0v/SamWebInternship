$(document).ready(
    function () {
        $('#sub').click(function (event) {
            event.preventDefault();
            validatePassword();
        });
    });


function validatePassword() {
    var validator = $("#registrationForm").validate( {
        rules: {
            confirm_password: {
                equalTo: "#password"
            }
        },
        messages: {
            confirm_password: "Enter Confirm Password Same As Password"
        },
        errorElement: 'span'
    });
    if(validator.form()){
        $("#registrationForm").submit();
    }
}
