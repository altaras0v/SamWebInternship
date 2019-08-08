$(document).ready(function () {

    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
            if (input.files[0].type.trim() != "image/png" && input.files[0].type.trim() != "image/jpeg"  ) {
                alert('Bad file format')
            } else if (input.files[0].size>16567500){
                alert('Max photo size 16 MB')
            }

            else {
                reader.readAsDataURL(input.files[0]);
            }
        }
    }

    $(".file-upload").on('change', function () {
        readURL(this);
    });

    $(".upload-button").on('click', function () {
        $(".file-upload").click();
    });
});

