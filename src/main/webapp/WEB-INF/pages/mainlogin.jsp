<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<head>
    <title>Moodle Demo Environment</title>
    <link rel="shortcut icon" href="http://moodle.lmsace.com/theme/image.php/eguru/theme/1560834156/favicon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251"/>
    <meta name="keywords" content="moodle, Moodle Demo Environment"/>
    <link rel="stylesheet" type="text/css"
          href="http://moodle.lmsace.com/theme/yui_combo.php?rollup/3.17.2/yui-moodlesimple.css"/>
    <script type="text/javascript"
            src="http://gc.kis.v2.scr.kaspersky-labs.com/98ACBE77-507D-0043-A315-2C405C0C8900/main.js"
            charset="UTF-8"></script>
    <script id="firstthemesheet"
            type="text/css">/** Required in order to fix style inclusion problems in IE with YUI **/</script>
    <link rel="stylesheet" type="text/css" href="http://moodle.lmsace.com/theme/styles.php/eguru/1560834156_1/all"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>


        <div class="container">
            <div class="navbar">
                <div class="navbar-inner">

                    <div data-region="drawer-toggle" class="d-inline-block mr-3">
                        <button aria-expanded="false" aria-controls="nav-drawer" type="button"
                                class="btn nav-link float-sm-left mr-1 btn-secondary" data-action="toggle-drawer"
                                data-side="left" data-preference="drawer-open-nav"><i class="icon fa fa-bars fa-fw "
                                                                                      aria-hidden="true"
                                                                                      aria-label=""></i><span
                                class="sr-only">Side panel</span>
                            <span></span>
                            <span></span>
                            <span></span>

                        </button>
                    </div>

                </div>

                <ul class="nav navbar-nav ml-auto">
                    <div class="d-none d-lg-block">

                    </div>
                    <!-- navbar_plugin_output -->
                    <li class="nav-item">

                    </li>
                    <!-- user_menu -->
                    <li class="nav-item d-flex align-items-center">
                        <div class="usermenu"><span class="login">You are not logged in. (<a
                                href="http://moodle.lmsace.com/login/index.php">Log in</a>)</span></div>
                    </li>
                </ul>
                <!-- search_box -->

                <div id="fMainmenu" class="nav-collapse collapse navbar-responsive-collapse">

                    <li class="dropdown nav-item">
                        <a class="dropdown-toggle nav-link" id="fdrop-down-5d13563a3610c5d13563a26a1e4"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                            Moodle community
                        </a>
                        <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a3610c5d13563a26a1e4">
                            <a class="dropdown-item" href="https://moodle.org/support" title="Moodle free support">Moodle
                                free support</a>
                            <a class="dropdown-item" href="http://docs.moodle.org" title="Moodle Docs">Moodle Docs</a>
                            <a class="dropdown-item" href="https://moodle.org/development" title="Moodle development">Moodle
                                development</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="http://moodle.com/" title="Moodle.com">Moodle.com</a>
                    </li>
                    <li class="dropdown nav-item">
                        <a class="dropdown-toggle nav-link" id="fdrop-down-5d13563a361e95d13563a26a1e5"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                            English ?(en)?
                        </a>
                        <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a361e95d13563a26a1e5">
                            <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=en" title="English ?(en)?">English
                                ?(en)?</a>
                            <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=ar" title="???? ?(ar)?">????
                                ?(ar)?</a>
                        </div>
                    </li>

                    <div class="custom-nav-search">

                        <form action="http://moodle.lmsace.com/course/search.php" method="get">
                            <div class="fields-wrap">
                                <input type="text" placeholder="<?php echo get_string('searchcourses'); ?>"
                                       name="search">
                                <div class="btn-search fa fa-search"><input type="submit" value="Search"></div>
                            </div>
                        </form>

                    </div>
                </div>

            </div>
        </div>


<body id="page-login-index"
      class="format-site  path-login safari dir-ltr lang-en yui-skin-sam yui3-skin-sam moodle-lmsace-com pagelayout-login course-1 context-1">


    <nav id="header" role="banner" class="fixed-top navbar navbar-light bg-white navbar-expand moodle-has-zindex">
        <!-- LMSACE S.o -->
        <div class="header-menubar">
            <div class="container">
                <div class="navbar">
                    <div class="navbar-inner">

                        <div data-region="drawer-toggle" class="d-inline-block mr-3">
                            <button aria-expanded="false" aria-controls="nav-drawer" type="button"
                                    class="btn nav-link float-sm-left mr-1 btn-secondary" data-action="toggle-drawer"
                                    data-side="left" data-preference="drawer-open-nav"><i class="icon fa fa-bars fa-fw "
                                                                                          aria-hidden="true"
                                                                                          aria-label=""></i><span
                                    class="sr-only">Side panel</span>
                                <span></span>
                                <span></span>
                                <span></span>

                            </button>
                        </div>

                    </div>

                    <ul class="nav navbar-nav ml-auto">
                        <div class="d-none d-lg-block">

                        </div>
                        <!-- navbar_plugin_output -->
                        <li class="nav-item">

                        </li>
                        <!-- user_menu -->
                        <li class="nav-item d-flex align-items-center">
                            <div class="usermenu"><span class="login">You are not logged in. (<a
                                    href="http://moodle.lmsace.com/login/index.php">Log in</a>)</span></div>
                        </li>
                    </ul>
                    <!-- search_box -->

                    <div id="Mainmenu" class="nav-collapse collapse navbar-responsive-collapse">

                        <li class="dropdown nav-item">
                            <a class="dropdown-toggle nav-link" id="drop-down-5d13563a3610c5d13563a26a1e4"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                                Moodle community
                            </a>
                            <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a3610c5d13563a26a1e4">
                                <a class="dropdown-item" href="https://moodle.org/support" title="Moodle free support">Moodle
                                    free support</a>
                                <a class="dropdown-item" href="http://docs.moodle.org" title="Moodle Docs">Moodle
                                    Docs</a>
                                <a class="dropdown-item" href="https://moodle.org/development"
                                   title="Moodle development">Moodle
                                    development</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-item nav-link" href="http://moodle.com/" title="Moodle.com">Moodle.com</a>
                        </li>
                        <li class="dropdown nav-item">
                            <a class="dropdown-toggle nav-link" id="drop-down-5d13563a361e95d13563a26a1e5"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                                English ?(en)?
                            </a>
                            <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a361e95d13563a26a1e5">
                                <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=en"
                                   title="English ?(en)?">English
                                    ?(en)?</a>
                                <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=ar" title="???? ?(ar)?">????
                                    ?(ar)?</a>
                            </div>
                        </li>

                        <div class="custom-nav-search">

                            <form action="http://moodle.lmsace.com/course/search.php" method="get">
                                <div class="fields-wrap">
                                    <input type="text" placeholder="<?php echo get_string('searchcourses'); ?>"
                                           name="search">
                                    <div class="btn-search fa fa-search"><input type="submit" value="Search"></div>
                                </div>
                            </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>


    </nav>

    <div id="page" class="container-fluid mt-0">
        <div id="page-content" class="row">
            <div id="region-main-box" class="col-12">
                <section id="region-main" class="col-12">
                    <span class="notifications" id="user-notifications"></span>
                    <div role="main"><span id="maincontent"></span>
                        <div class="m-y-3 hidden-sm-down"></div>

                        <div class="card">
                            <div class="card-block">
                                <div class="card-title text-xs-center hidden">
                                    <h2>Moodle Demo Environment</h2>

                                </div>

                                <div class="sr-only">
                                    <a href="http://moodle.lmsace.com/login/signup.php">Skip to create new account</a>
                                </div>


                                <div class="custom-login">

                                    <div class="">
                                        <br>
                                        <h2>Login into your account</h2>

                                        <form class="m-t-1" action="http://moodle.lmsace.com/login/index.php"
                                              method="post" id="login" autocomplete="off">
                                            <input id="anchor" type="hidden" name="anchor" value="">
                                            <script>document.getElementById('anchor').value = location.hash;</script>

                                            <div class="form-fields">
                                                <label for="username" class="">
                                                    Username
                                                </label>
                                                <div class="textbox-wrap">
                                                    <input type="text" name="username" id="username"
                                                           class="form-control"
                                                           value=""
                                                           placeholder="Username">
                                                    <i class="fa fa-user"></i>
                                                </div>
                                            </div>

                                            <div class="form-fields">
                                                <label for="password" class="">Password</label>

                                                <div class="textbox-wrap">
                                                    <input type="password" name="password" id="password" value=""
                                                           class="form-control"
                                                           placeholder="Password"
                                                           autocomplete="off">
                                                    <i class="fa fa-lock"></i>
                                                </div>
                                            </div>

                                            <button type="submit" class="btn btn-primary btn-block" id="loginbtn">Log
                                                in
                                            </button>

                                            <br>

                                            <div class="forgetpass m-t-1">
                                                <p><a href="http://moodle.lmsace.com/login/forgot_password.php">Forgotten
                                                    your username or password?</a></p>
                                            </div>

                                            <div class="rememberpass m-t-1">
                                                <input type="checkbox" name="rememberusername" id="rememberusername"
                                                       value="1"/>
                                                <label for="rememberusername">Remember username</label>
                                            </div>

                                        </form>
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>

<br><br><br>

    <footer id="footer" class="py-3 bg-dark text-light">
        <div class="footer-main">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="footer-desc">
                            <div class="logo-footer">
                                <a href="http://moodle.lmsace.com/?redirect=0">
                                    <img src="http://moodle.lmsace.com/theme/image.php/eguru/theme/1560834156/home/logo"
                                         width="183" height="67" alt="Eguru">
                                </a>
                            </div>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum
                                has been the industry&#039;s standard dummy text ever since the 1500s, when an unknown
                                printer took a galley of type and tronic typesetting, sheets taining Lorem Ipsum
                                passages.</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="footer-nav">
                            <h4>Quick Links</h4>
                            <ul>
                                <li><a href="http://www.example.com/about-us.php">About Us</a></li>
                                <li><a href="http://www.example.com/terms-of-use.php">Terms of use</a></li>
                                <li><a href="http://www.example.com/faq.php">FAQ</a></li>
                                <li><a href="http://www.example.com/support.php">Support</a></li>
                                <li><a href="http://www.example.com/contact.php">Contact</a></li>

                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="social-media">
                            <h4>Follow Us</h4>
                            <ul>
                                <li class="smedia-01">
                                    <a href="https://www.facebook.com/yourfacebookid" target="_blank">
                                    <span class="media-icon">
                                    <i class="fa fa-facebook-f"></i>
                                    </span>
                                        <span class="media-name">Facebook</span>
                                    </a>
                                </li>

                                <li class="smedia-02">
                                    <a href="https://twitter.com/yourtwittername" target="_blank">
                                    <span class="media-icon">
                                    <i class="fa fa-twitter"></i>
                                    </span>
                                        <span class="media-name">Twitter</span>
                                    </a>
                                </li>

                                <li class="smedia-03">
                                    <a href="https://www.google.com/+yourgoogleplusid" target="_blank">
                                    <span class="media-icon">
                                    <i class="fa fa-google-plus"></i>
                                    </span>
                                        <span class="media-name">Google Plus</span>
                                    </a>
                                </li>

                                <li class="smedia-04">
                                    <a href="https://in.pinterest.com/yourpinterestname/" target="_blank">
                                   <span class="media-icon">
                                   <i class="fa fa-pinterest-p"></i>
                                   </span>
                                        <span class="media-name">Pinterest</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="footer-contact">
                            <h4>Contact</h4>
                            <p>308 Negra Narrow Lane, Albeeze, New york, 87104</p>
                            <p><i class="fa fa-phone-square"></i>Phone: (000) 123-456</p>

                            <p><i class="fa fa-envelope"></i>
                                E-mail: <a class="mail-link" href="mailto:info@example.com">info@example.com</a>
                            </p>

                        </div>

                    </div>

                </div>

            </div>
        </div>
        <div class="footer-foot">
            <div class="container"><p class="text-center">Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
                <p>Contact: altaras0b@gmail.com</p>
            </div>
        </div>

    </footer>
    <!--E.O.Header-->


    </body>
    <footer>
        <a href="https://download.moodle.org/mobile?version=2018051700&amp;lang=en&amp;iosappid=633359593&amp;androidappid=com.moodle.moodlemobile">Get
            the mobile app</a>
        <div class="policiesfooter"><a href="http://moodle.lmsace.com/admin/tool/policy/viewall.php">Policies</a></div>


        <script type="text/javascript"
                src="http://moodle.lmsace.com/lib/javascript.php/-1/lib/requirejs/require.js"></script>

        <script type="text/javascript"
                src="http://moodle.lmsace.com/lib/javascript.php/-1/theme/eguru/javascript/theme.js"></script>
        <script type="text/javascript"
                src="http://moodle.lmsace.com/lib/javascript.php/-1/local/vpt/javascript/videoplaytime.js"></script>


        <script type="text/javascript">
            //<![CDATA[
            (function () {
                Y.use("moodle-filter_mathjaxloader-loader", function () {
                    M.filter_mathjaxloader.configure({
                        "mathjaxconfig": "\nMathJax.Hub.Config({\n    config: [\"Accessible.js\", \"Safe.js\"],\n    errorSettings: { message: [\"!\"] },\n    skipStartupTypeset: true,\n    messageStyle: \"none\"\n});\n",
                        "lang": "en"
                    });
                });
                M.util.help_popups.setup(Y);
                M.util.js_pending('random5d1b3626211ec11');
                Y.on('domready', function () {
                    M.util.js_complete("init");
                    M.util.js_complete('random5d1b3626211ec11');
                });
            })();

        </script>


    </footer>