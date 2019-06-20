
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Custom File Inputs | Codrops</title>
    <meta name="description" content="Demo for the tutorial: Styling and Customizing File Inputs the Smart Way" />
    <meta name="keywords" content="cutom file input, styling, label, cross-browser, accessible, input type file" />
    <meta name="author" content="Osvaldas Valutis for Codrops" />
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- remove this if you use Modernizr -->
    <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</head>
<body>

HTML  JS Result
EDIT ON
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

<script src="myscript.js"></script>
<div class="container" style="margin-top: 20px;">
    <div class="row">

        <div class="col-lg-6 col-sm-6 col-12">
            <div class="jumbotron">
                <h1>Bootstrap File Input Demo</h1>
            </div>
        </div>

        <div class="col-lg-6 col-sm-6 col-12">
            <h4>Standard Button</h4>
            <label class="btn btn-primary">
                Browse&hellip; <input type="file" style="display: none;">
            </label>
        </div>
        <div class="col-lg-6 col-sm-6 col-12">
            <h4>Block-level Button</h4>
                <label class="btn btn-block btn-primary">
                    Browse&hellip; <input type="file" style="display: none;">
                </label>
        </div>

        <div class="col-lg-6 col-sm-6 col-12">
            <h4>Button Groups</h4>
            <div class="btn-group">
                <a href="#" class="btn btn-default">Action 1</a>
                <a href="#" class="btn btn-default">Action 2</a>
                <label class="btn btn-primary">
                    Browse&hellip; <input type="file" style="display: none;">
                </label>
            </div>
        </div>
        <div class="col-lg-6 col-sm-6 col-12">
            <h4>Input Groups</h4>
            <div class="input-group">
                <label class="input-group-btn" for="browse">

                        Browse&hellip; <input type="file" id="browse" onchange="$('#textfield').html(this.files[0].name)" style="display: none;" multiple>

                </label>
                <input type="text" id="textfield" class="form-control">
            </div>
            <span class="help-block">
                Try selecting one or more files and watch the feedback
            </span>
        </div>

    </div>
</div>
<div class="col-lg-6 col-sm-6 col-12">
    <label class="btn btn-primary" for="my-file-selector">
        <input id="my-file-selector" type="file" style="display:none"
               onchange="$('#upload-file-info').html(this.files[0].name)">
        Button Text Here
    </label>
    <span class='label label-info' id="upload-file-info"></span>
</div>
</body>
</html>
