<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<html>
<head>
    <title>Upload File Request Page</title>

    <script>
        var totalFileLength, totalUploaded, fileCount, fileUploaded;

        //Will be called when upload is completed
        function onUploadComplete(e) {
            totalUploaded += document.getElementById('file').file.size;
            fileUploaded++;
                uploadNext();
                var bar = document.getElementById('bar');
                bar.style.width = '100%';
                bar.innerHTML = '100% complete';
        }

        //Will be called when user select the files in file control
        function onFileSelect(e) {
           var files = e.target.files; // FileList object
            var output = [];
                var file = files[0];
                output.push(file.name, ' (', file.size, ' bytes, ', file.lastModifiedDate.toLocaleDateString(), ')');
                output.push('<br/>');
                totalFileLength = file.size;

            document.getElementById('selectedFiles').innerHTML = output.join('');
        }

        //This will continueously update the progress bar
        function onUploadProgress(e) {
            if (e.lengthComputable) {
                var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
                var bar = document.getElementById('bar');
                bar.style.width = percentComplete + '%';
                bar.innerHTML = percentComplete + ' % complete';
            }
        }

        //the Ouchhh !! moments will be captured here
        function onUploadFailed(e) {
            alert("Error uploading file");
        }

        //Pick the next file in queue and upload it to remote server
        function uploadNext() {
            var xhr = new XMLHttpRequest();
            var fd = new FormData();
            var file = document.getElementById('file').files[fileUploaded];
            fd.append("multipartFile", file);
            xhr.upload.addEventListener("progress", onUploadProgress, false);
            xhr.addEventListener("load", onUploadComplete, false);
            xhr.addEventListener("error", onUploadFailed, false);
            xhr.open("POST", "upload");
            xhr.send(fd);
        }

        //Let's begin the upload process
        function startUpload() {
            totalUploaded = fileUploaded = 0;
            uploadNext();
        }

        //Event listeners for button clicks
        window.onload = function () {
            document.getElementById('file').addEventListener('change', onFileSelect, false);
            document.getElementById('uploadButton').addEventListener('click', startUpload, false);
        }
    </script>

</head>

<body>

<br><br><br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 well">
            <h3 class="text-center">Add files</h3>

            <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="../upload">

            <div class="col-xs-12">
                <div class="form-group">
                    <div class="text-center col-xs-12">
                        <div class="input-group">
                             <span class="input-group-btn">
                                <span class="btn btn-primary"
                                      onclick="$(this).parent().find('input[type=file]').click();">Browse</span>
                                    <input name="file" id="file"
                                           onchange="$(this).parent().parent().find('.form-control').html($(this).val().split(/[\\|/]/).pop());"
                                           style="display: none;" type="file">

                                </span>
                            <span class="form-control"></span>
                        </div>
                        <br>
                        <div class="col-xs-12">
                            <div class="text-center col-xs-12">
                                <div class="form-group">
                                    <input type="text" placeholder="Description" name="description"
                                           id="description"/>
                                </div>
                            </div>
                        </div>

                        <h3 style="color: red; font-style: italic" ;><form:errors path="file"/></h3>
                        <div class="text-center col-xs-12">
                            <input id="uploadButton" type="submit" value="Upload">
                        </div>
                            <br><br><br><br>
                        <div id='progressBar' style='height: 20px; border: 2px steelblue; margin-bottom: 20px'>
                            <div id='bar' style='height: 100%; background: steelblue; width: 0%'>
                            </div>
                        </div>
                    </div>


                </div>

                </form:form>
                <td><form:form name="id" action="/" method="get">
                    <div class="coursename">
                        <button style="color: steelblue" type="submit" class="btn btn-link">На главную</button>
                    </div>
                </form:form></td>
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

<style>

    input[type=text],
    input[type=email],
    input[type=password] {
        -webkit-transition: color 0.2s ease, background 0.3s ease;
        -moz-transition: color 0.2s ease, background 0.3s ease;
        -o-transition: color 0.2s ease, background 0.3s ease;
        transition: color 0.2s ease, background 0.3s ease;
        -webkit-border-radius: 0;
        -webkit-background-clip: padding-box;
        -moz-border-radius: 0;
        -moz-background-clip: padding;
        border-radius: 0;
        background-clip: padding-box;
        -webkit-box-shadow: none;
        -moz-box-shadow: none;
        box-shadow: none;
        margin: 0;
        vertical-align: top;
        display: inline-block;
        width: 100%;
        font-size: 22px;
        color: #8d8d8d;
        background-color: #ffffff;
        border-style: solid;
        border-width: 1px 1px 1px 3px;
        border-top-color: #d7d7d7;
        border-right-color: #d7d7d7;
        border-bottom-color: #d7d7d7;
        outline: none;
    }


    input[type=text]:hover,
    input[type=email]:hover,
    input[type=password]:hover {
        color: #000000;
    }

    body {
        background-color: lightblue; /* Цвет фона веб-страницы */
    }

    input[type="button"]:not(.default), input[type="submit"]:not(.default) {
        -webkit-border-radius: 3px;
        -webkit-background-clip: padding-box;
        -moz-border-radius: 3px;
        -moz-background-clip: padding;
        border-radius: 3px;
        background-clip: padding-box;
        -webkit-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, -webkit-box-shadow 0.2s ease;
        -moz-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, -moz-box-shadow 0.2s ease;
        -o-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, box-shadow 0.2s ease;
        transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, box-shadow 0.2s ease;
        position: relative;
        margin: 0 7px;
        display: inline-block;
        min-width: 144px;
        max-width: 100%;
        padding: 15px 25px;
        font-family: "Arial", "Helvetica Neue", Arial, Helvetica, sans-serif;
        font-size: 14px;
        font-weight: 600;
        text-transform: uppercase;
        line-height: 1;
        border-width: 1px;
        border-style: solid;
        background-color: steelblue;
        color: #ddd;
    }

    .well h3 {
        text-shadow: -1px -1px #FFF, -2px -2px #FFF, -1px 1px #FFF, -2px 2px #FFF, 1px 1px #FFF, 2px 2px #FFF, 1px -1px #FFF, 2px -2px #FFF, -3px -3px 2px #BBB, -3px 3px 2px #BBB, 3px 3px 2px #BBB, 3px -3px 2px #BBB;
        color: steelblue;
        transition: all 1s;
    }

</style>
<%--<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>--%>
</body>
</html>
