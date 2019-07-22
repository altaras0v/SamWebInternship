
<%@ page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
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
    <script type="text/javascript">
        //<![CDATA[
        var M = {};
        M.yui = {};
        M.pageloadstarttime = new Date();
        M.cfg = {
            "wwwroot": "http:\/\/moodle.lmsace.com",
            "sesskey": "fDP0tjLF0C",
            "themerev": "1560834156",
            "slasharguments": 1,
            "theme": "eguru",
            "iconsystemmodule": "core\/icon_system_fontawesome",
            "jsrev": -1,
            "admin": "admin",
            "svgicons": true,
            "usertimezone": "Europe\/London",
            "contextid": 2,
            "developerdebug": true
        };
        var yui1ConfigFn = function (me) {
            if (/-skin|reset|fonts|grids|base/.test(me.name)) {
                me.type = 'css';
                me.path = me.path.replace(/\.js/, '.css');
                me.path = me.path.replace(/\/yui2-skin/, '/assets/skins/sam/yui2-skin')
            }
        };
        var yui2ConfigFn = function (me) {
            var parts = me.name.replace(/^moodle-/, '').split('-'), component = parts.shift(), module = parts[0],
                min = '-min';
            if (/-(skin|core)$/.test(me.name)) {
                parts.pop();
                me.type = 'css';
                min = ''
            }
            if (module) {
                var filename = parts.join('-');
                me.path = component + '/' + module + '/' + filename + min + '.' + me.type
            } else {
                me.path = component + '/' + component + '.' + me.type
            }
        };
        YUI_config = {
            "debug": true,
            "base": "http:\/\/moodle.lmsace.com\/lib\/yuilib\/3.17.2\/",
            "comboBase": "http:\/\/moodle.lmsace.com\/theme\/yui_combo.php?",
            "combine": true,
            "filter": "RAW",
            "insertBefore": "firstthemesheet",
            "groups": {
                "yui2": {
                    "base": "http:\/\/moodle.lmsace.com\/lib\/yuilib\/2in3\/2.9.0\/build\/",
                    "comboBase": "http:\/\/moodle.lmsace.com\/theme\/yui_combo.php?",
                    "combine": true,
                    "ext": false,
                    "root": "2in3\/2.9.0\/build\/",
                    "patterns": {"yui2-": {"group": "yui2", "configFn": yui1ConfigFn}}
                },
                "moodle": {
                    "name": "moodle",
                    "base": "http:\/\/moodle.lmsace.com\/theme\/yui_combo.php?m\/-1\/",
                    "combine": true,
                    "comboBase": "http:\/\/moodle.lmsace.com\/theme\/yui_combo.php?",
                    "ext": false,
                    "root": "m\/-1\/",
                    "patterns": {"moodle-": {"group": "moodle", "configFn": yui2ConfigFn}},
                    "filter": "DEBUG",
                    "modules": {
                        "moodle-core-languninstallconfirm": {"requires": ["base", "node", "moodle-core-notification-confirm", "moodle-core-notification-alert"]},
                        "moodle-core-event": {"requires": ["event-custom"]},
                        "moodle-core-handlebars": {"condition": {"trigger": "handlebars", "when": "after"}},
                        "moodle-core-notification": {"requires": ["moodle-core-notification-dialogue", "moodle-core-notification-alert", "moodle-core-notification-confirm", "moodle-core-notification-exception", "moodle-core-notification-ajaxexception"]},
                        "moodle-core-notification-dialogue": {"requires": ["base", "node", "panel", "escape", "event-key", "dd-plugin", "moodle-core-widget-focusafterclose", "moodle-core-lockscroll"]},
                        "moodle-core-notification-alert": {"requires": ["moodle-core-notification-dialogue"]},
                        "moodle-core-notification-confirm": {"requires": ["moodle-core-notification-dialogue"]},
                        "moodle-core-notification-exception": {"requires": ["moodle-core-notification-dialogue"]},
                        "moodle-core-notification-ajaxexception": {"requires": ["moodle-core-notification-dialogue"]},
                        "moodle-core-dock": {"requires": ["base", "node", "event-custom", "event-mouseenter", "event-resize", "escape", "moodle-core-dock-loader", "moodle-core-event"]},
                        "moodle-core-dock-loader": {"requires": ["escape"]},
                        "moodle-core-formchangechecker": {"requires": ["base", "event-focus", "moodle-core-event"]},
                        "moodle-core-popuphelp": {"requires": ["moodle-core-tooltip"]},
                        "moodle-core-blocks": {"requires": ["base", "node", "io", "dom", "dd", "dd-scroll", "moodle-core-dragdrop", "moodle-core-notification"]},
                        "moodle-core-lockscroll": {"requires": ["plugin", "base-build"]},
                        "moodle-core-maintenancemodetimer": {"requires": ["base", "node"]},
                        "moodle-core-chooserdialogue": {"requires": ["base", "panel", "moodle-core-notification"]},
                        "moodle-core-actionmenu": {"requires": ["base", "event", "node-event-simulate"]},
                        "moodle-core-checknet": {"requires": ["base-base", "moodle-core-notification-alert", "io-base"]},
                        "moodle-core-dragdrop": {"requires": ["base", "node", "io", "dom", "dd", "event-key", "event-focus", "moodle-core-notification"]},
                        "moodle-core-tooltip": {"requires": ["base", "node", "io-base", "moodle-core-notification-dialogue", "json-parse", "widget-position", "widget-position-align", "event-outside", "cache-base"]},
                        "moodle-core_availability-form": {"requires": ["base", "node", "event", "event-delegate", "panel", "moodle-core-notification-dialogue", "json"]},
                        "moodle-backup-confirmcancel": {"requires": ["node", "node-event-simulate", "moodle-core-notification-confirm"]},
                        "moodle-backup-backupselectall": {"requires": ["node", "event", "node-event-simulate", "anim"]},
                        "moodle-course-formatchooser": {"requires": ["base", "node", "node-event-simulate"]},
                        "moodle-course-management": {"requires": ["base", "node", "io-base", "moodle-core-notification-exception", "json-parse", "dd-constrain", "dd-proxy", "dd-drop", "dd-delegate", "node-event-delegate"]},
                        "moodle-course-categoryexpander": {"requires": ["node", "event-key"]},
                        "moodle-course-util": {
                            "requires": ["node"],
                            "use": ["moodle-course-util-base"],
                            "submodules": {
                                "moodle-course-util-base": {},
                                "moodle-course-util-section": {"requires": ["node", "moodle-course-util-base"]},
                                "moodle-course-util-cm": {"requires": ["node", "moodle-course-util-base"]}
                            }
                        },
                        "moodle-course-modchooser": {"requires": ["moodle-core-chooserdialogue", "moodle-course-coursebase"]},
                        "moodle-course-dragdrop": {"requires": ["base", "node", "io", "dom", "dd", "dd-scroll", "moodle-core-dragdrop", "moodle-core-notification", "moodle-course-coursebase", "moodle-course-util"]},
                        "moodle-form-passwordunmask": {"requires": []},
                        "moodle-form-shortforms": {"requires": ["node", "base", "selector-css3", "moodle-core-event"]},
                        "moodle-form-showadvanced": {"requires": ["node", "base", "selector-css3"]},
                        "moodle-form-dateselector": {"requires": ["base", "node", "overlay", "calendar"]},
                        "moodle-question-qbankmanager": {"requires": ["node", "selector-css3"]},
                        "moodle-question-preview": {"requires": ["base", "dom", "event-delegate", "event-key", "core_question_engine"]},
                        "moodle-question-chooser": {"requires": ["moodle-core-chooserdialogue"]},
                        "moodle-question-searchform": {"requires": ["base", "node"]},
                        "moodle-availability_completion-form": {"requires": ["base", "node", "event", "moodle-core_availability-form"]},
                        "moodle-availability_date-form": {"requires": ["base", "node", "event", "io", "moodle-core_availability-form"]},
                        "moodle-availability_grade-form": {"requires": ["base", "node", "event", "moodle-core_availability-form"]},
                        "moodle-availability_group-form": {"requires": ["base", "node", "event", "moodle-core_availability-form"]},
                        "moodle-availability_grouping-form": {"requires": ["base", "node", "event", "moodle-core_availability-form"]},
                        "moodle-availability_profile-form": {"requires": ["base", "node", "event", "moodle-core_availability-form"]},
                        "moodle-qtype_ddimageortext-form": {"requires": ["moodle-qtype_ddimageortext-dd", "form_filepicker"]},
                        "moodle-qtype_ddimageortext-dd": {"requires": ["node", "dd", "dd-drop", "dd-constrain"]},
                        "moodle-qtype_ddmarker-form": {"requires": ["moodle-qtype_ddmarker-dd", "form_filepicker", "graphics", "escape"]},
                        "moodle-qtype_ddmarker-dd": {"requires": ["node", "event-resize", "dd", "dd-drop", "dd-constrain", "graphics"]},
                        "moodle-qtype_ddwtos-dd": {"requires": ["node", "dd", "dd-drop", "dd-constrain"]},
                        "moodle-mod_assign-history": {"requires": ["node", "transition"]},
                        "moodle-mod_forum-subscriptiontoggle": {"requires": ["base-base", "io-base"]},
                        "moodle-mod_quiz-toolboxes": {"requires": ["base", "node", "event", "event-key", "io", "moodle-mod_quiz-quizbase", "moodle-mod_quiz-util-slot", "moodle-core-notification-ajaxexception"]},
                        "moodle-mod_quiz-questionchooser": {"requires": ["moodle-core-chooserdialogue", "moodle-mod_quiz-util", "querystring-parse"]},
                        "moodle-mod_quiz-autosave": {"requires": ["base", "node", "event", "event-valuechange", "node-event-delegate", "io-form"]},
                        "moodle-mod_quiz-util": {
                            "requires": ["node", "moodle-core-actionmenu"],
                            "use": ["moodle-mod_quiz-util-base"],
                            "submodules": {
                                "moodle-mod_quiz-util-base": {},
                                "moodle-mod_quiz-util-slot": {"requires": ["node", "moodle-mod_quiz-util-base"]},
                                "moodle-mod_quiz-util-page": {"requires": ["node", "moodle-mod_quiz-util-base"]}
                            }
                        },
                        "moodle-mod_quiz-modform": {"requires": ["base", "node", "event"]},
                        "moodle-mod_quiz-quizbase": {"requires": ["base", "node"]},
                        "moodle-mod_quiz-dragdrop": {"requires": ["base", "node", "io", "dom", "dd", "dd-scroll", "moodle-core-dragdrop", "moodle-core-notification", "moodle-mod_quiz-quizbase", "moodle-mod_quiz-util-base", "moodle-mod_quiz-util-page", "moodle-mod_quiz-util-slot", "moodle-course-util"]},
                        "moodle-mod_quiz-repaginate": {"requires": ["base", "event", "node", "io", "moodle-core-notification-dialogue"]},
                        "moodle-message_airnotifier-toolboxes": {"requires": ["base", "node", "io"]},
                        "moodle-filter_glossary-autolinker": {"requires": ["base", "node", "io-base", "json-parse", "event-delegate", "overlay", "moodle-core-event", "moodle-core-notification-alert", "moodle-core-notification-exception", "moodle-core-notification-ajaxexception"]},
                        "moodle-filter_mathjaxloader-loader": {"requires": ["moodle-core-event"]},
                        "moodle-editor_atto-editor": {"requires": ["node", "transition", "io", "overlay", "escape", "event", "event-simulate", "event-custom", "node-event-html5", "node-event-simulate", "yui-throttle", "moodle-core-notification-dialogue", "moodle-core-notification-confirm", "moodle-editor_atto-rangy", "handlebars", "timers", "querystring-stringify"]},
                        "moodle-editor_atto-plugin": {"requires": ["node", "base", "escape", "event", "event-outside", "handlebars", "event-custom", "timers", "moodle-editor_atto-menu"]},
                        "moodle-editor_atto-menu": {"requires": ["moodle-core-notification-dialogue", "node", "event", "event-custom"]},
                        "moodle-editor_atto-rangy": {"requires": []},
                        "moodle-report_eventlist-eventfilter": {"requires": ["base", "event", "node", "node-event-delegate", "datatable", "autocomplete", "autocomplete-filters"]},
                        "moodle-report_loglive-fetchlogs": {"requires": ["base", "event", "node", "io", "node-event-delegate"]},
                        "moodle-gradereport_grader-gradereporttable": {"requires": ["base", "node", "event", "handlebars", "overlay", "event-hover"]},
                        "moodle-gradereport_history-userselector": {"requires": ["escape", "event-delegate", "event-key", "handlebars", "io-base", "json-parse", "moodle-core-notification-dialogue"]},
                        "moodle-tool_capability-search": {"requires": ["base", "node"]},
                        "moodle-tool_lp-dragdrop-reorder": {"requires": ["moodle-core-dragdrop"]},
                        "moodle-tool_monitor-dropdown": {"requires": ["base", "event", "node"]},
                        "moodle-assignfeedback_editpdf-editor": {"requires": ["base", "event", "node", "io", "graphics", "json", "event-move", "event-resize", "transition", "querystring-stringify-simple", "moodle-core-notification-dialog", "moodle-core-notification-alert", "moodle-core-notification-exception", "moodle-core-notification-ajaxexception"]},
                        "moodle-atto_accessibilitychecker-button": {"requires": ["color-base", "moodle-editor_atto-plugin"]},
                        "moodle-atto_accessibilityhelper-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_align-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_bold-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_charmap-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_clear-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_collapse-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_emoticon-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_equation-button": {"requires": ["moodle-editor_atto-plugin", "moodle-core-event", "io", "event-valuechange", "tabview", "array-extras"]},
                        "moodle-atto_html-button": {"requires": ["moodle-editor_atto-plugin", "event-valuechange"]},
                        "moodle-atto_image-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_indent-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_italic-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_link-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_managefiles-usedfiles": {"requires": ["node", "escape"]},
                        "moodle-atto_managefiles-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_media-button": {"requires": ["moodle-editor_atto-plugin", "moodle-form-shortforms"]},
                        "moodle-atto_noautolink-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_orderedlist-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_recordrtc-recording": {"requires": ["moodle-atto_recordrtc-button"]},
                        "moodle-atto_recordrtc-button": {"requires": ["moodle-editor_atto-plugin", "moodle-atto_recordrtc-recording"]},
                        "moodle-atto_rtl-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_strike-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_subscript-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_superscript-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_table-button": {"requires": ["moodle-editor_atto-plugin", "moodle-editor_atto-menu", "event", "event-valuechange"]},
                        "moodle-atto_title-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_underline-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_undo-button": {"requires": ["moodle-editor_atto-plugin"]},
                        "moodle-atto_unorderedlist-button": {"requires": ["moodle-editor_atto-plugin"]}
                    }
                },
                "gallery": {
                    "name": "gallery",
                    "base": "http:\/\/moodle.lmsace.com\/lib\/yuilib\/gallery\/",
                    "combine": true,
                    "comboBase": "http:\/\/moodle.lmsace.com\/theme\/yui_combo.php?",
                    "ext": false,
                    "root": "gallery\/-1\/",
                    "patterns": {"gallery-": {"group": "gallery"}}
                }
            },
            "modules": {
                "core_filepicker": {
                    "name": "core_filepicker",
                    "fullpath": "http:\/\/moodle.lmsace.com\/lib\/javascript.php\/-1\/repository\/filepicker.js",
                    "requires": ["base", "node", "node-event-simulate", "json", "async-queue", "io-base", "io-upload-iframe", "io-form", "yui2-treeview", "panel", "cookie", "datatable", "datatable-sort", "resize-plugin", "dd-plugin", "escape", "moodle-core_filepicker", "moodle-core-notification-dialogue"]
                },
                "core_comment": {
                    "name": "core_comment",
                    "fullpath": "http:\/\/moodle.lmsace.com\/lib\/javascript.php\/-1\/comment\/comment.js",
                    "requires": ["base", "io-base", "node", "json", "yui2-animation", "overlay", "escape"]
                },
                "mathjax": {
                    "name": "mathjax",
                    "fullpath": "https:\/\/cdnjs.cloudflare.com\/ajax\/libs\/mathjax\/2.7.2\/MathJax.js?delayStartupUntil=configured"
                }
            }
        };
        M.yui.loader = {modules: {}};

        //]]>
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body id="page-site-index"
      class="format-site course path-site safari dir-ltr lang-en yui-skin-sam yui3-skin-sam moodle-lmsace-com pagelayout-frontpage course-1 context-2 notloggedin ">

<div>
    <a class="sr-only sr-only-focusable" href="#maincontent">Skip to main content</a>
</div>
<script type="text/javascript"
        src="http://moodle.lmsace.com/theme/yui_combo.php?rollup/3.17.2/yui-moodlesimple.js"></script>
<script type="text/javascript" src="http://moodle.lmsace.com/theme/jquery.php/core/jquery-3.2.1.js"></script>
<script type="text/javascript" src="http://moodle.lmsace.com/lib/javascript.php/-1/lib/javascript-static.js"></script>
<script type="text/javascript">
    //<![CDATA[
    document.body.className += ' jsenabled';
    //]]>
</script>


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
                            <a class="dropdown-item" href="http://docs.moodle.org" title="Moodle Docs">Moodle Docs</a>
                            <a class="dropdown-item" href="https://moodle.org/development" title="Moodle development">Moodle
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
    </div>


</nav>


<div class="header-main">
    <div class="container">
        <nav class="navbar navbar-toggleable-md">
            <div class="header-logo">
                <a class="navbar-brand" href="http://moodle.lmsace.com/?redirect=0">
                    <img src="http://moodle.lmsace.com/theme/image.php/eguru/theme/1560834156/home/logo" width="183"
                         height="67" alt="Eguru">
                </a>
            </div>

            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="custom-menu">
                    <ul class="navbar-nav mr-auto">
                        <li class="dropdown nav-item">
                            <a class="dropdown-toggle nav-link" id="drop-down-5d13563a3639e5d13563a26a1e8"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                                Moodle community
                            </a>
                            <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a3639e5d13563a26a1e8">
                                <a class="dropdown-item" href="https://moodle.org/support" title="Moodle free support">Moodle
                                    free support</a>
                                <a class="dropdown-item" href="http://docs.moodle.org" title="Moodle Docs">Moodle
                                    Docs</a>
                                <a class="dropdown-item" href="https://moodle.org/development"
                                   title="Moodle development">Moodle development</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-item nav-link" href="http://moodle.com/" title="Moodle.com">Moodle.com</a>
                        </li>
                        <li class="dropdown nav-item">
                            <a class="dropdown-toggle nav-link" id="drop-down-5d13563a364575d13563a26a1e9"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
                                English ?(en)?
                            </a>
                            <div class="dropdown-menu" aria-labelledby="drop-down-5d13563a364575d13563a26a1e9">
                                <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=en"
                                   title="English ?(en)?">English ?(en)?</a>
                                <a class="dropdown-item" href="http://moodle.lmsace.com/?lang=ar" title="???? ?(ar)?">????
                                    ?(ar)?</a>
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </nav>
    </div>
</div>
<br><br><br><br>
<!--E.O.Header-->
<div id="page" class="container-fluid">
    <header id="page-header" class="row">
        <div class="col-12 pt-3 pb-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex">
                        <div class="mr-auto">
                            <div class="page-context-header">
                                <div class="page-header-headings"><h1>The Bug Files - Documenting the Itchy Side of
                                    Green School</h1></div>
                              </div>
                        </div>

                    </div>
                    <div class="d-flex flex-wrap">
                        <div id="page-navbar">
                            <nav role="navigation">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="http://moodle.lmsace.com/">Home</a></li>
                                    <li class="breadcrumb-item"><a href="http://moodle.lmsace.com/course/index.php">Courses</a>
                                    </li>
                                    <li class="breadcrumb-item"><a
                                            href="http://moodle.lmsace.com/course/index.php?categoryid=1">Miscellaneous</a>
                                    </li>
                                    <li class="breadcrumb-item"><a
                                            href="http://moodle.lmsace.com/course/view.php?id=6"
                                            title="The Bug Files - Documenting the Itchy Side of Green School">Entomology
                                        Database</a></li>
                                    <li class="breadcrumb-item">Enrolment options</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="ml-auto d-flex">

                        </div>
                        <div id="course-header">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div id="page-content" class="row">
        <div id="region-main-box" class="col-12">
            <section id="region-main">
                <div class="card">
                    <div class="card-body">
                        <span class="notifications" id="user-notifications"></span>
                        <div role="main"><span id="maincontent"></span>
                            <center> <h2>${lessonDTO.name}</h2></center>
                            <div class="box generalbox info py-3">
                                <div class="coursebox clearfix" data-courseid="6" data-type="1">

                                    <div class="content ">
                                        <div class="summary">
                                            <div class="no-overflow"><p><font style="color: #00008B">${lessonDTO.description}</font></p></div>
                                        </div>
                                        <div class="courseimage"><img src="/img/logo.png" width="210" height="500"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <td><form:form name="id"  action="../uploadRedirect" method="post">



                                        <div class="coursename"><button style="color: #4BA89C"  type="submit" name="id" value="${lessonDTO.id}" class="btn btn-link">Загрузить файл</button>
                                        </div>

                            </form:form></td>
                            <div class="info"><center><h2 class="coursename"> Files for lesson </h2></center>
                                <div class="moreinfo"></div>
                            </div>
                            <br>
                            <br>
                            <div class="coursebox clearfix odd first collapsed" data-courseid="6"
                                 data-type="1">
                            <c:forEach items="${listFiles}" var="files">

                                <td><form:form name="first" action="../download" method="get">

                                            <button   type="submit" name="id" value="${files.id}" style="text-transform: capitalize" class="btn btn-link"><a style="text-transform: capitalize"> ${files.name}</a></button>
                                        <div class="coursebox clearfix odd first collapsed" data-courseid="6"
                                             data-type="1"> <font style="color: #00008B">  &nbsp;&nbsp; ${files.description}</font> </div>

                                </form:form></td>
                                <style>
                                    :focus {outline:none !important;}
                                </style>
                            </c:forEach>
                            </div>
                            <td><form:form name="lessonId" action="../addTest" method="get">

                                <button  type="submit" name="lessonId" value="${lessonDTO.id}" style="text-transform: capitalize" class="btn btn-link"><a style="text-transform: capitalize"> Add test </a></button>

                            </form:form></td>
                            <br><br>
                            <div class="info"><center><h2 class="coursename"> Test:&nbsp;&nbsp; ${testDTO.name} </h2></center>
                                <div class="moreinfo"></div>
                            </div>
                            <br>
                            <div style="color: #00008B;font-size: 18px">
                                <center><span >${testDTO.description}</span></center>
                            </div>
                            <br>

                            <div class="coursebox clearfix odd first collapsed" data-courseid="6"
                                 data-type="1">

                                <form>
                                    <div class="form-group">
                                        <label style="color: #00008B" for="Textarea">Example textarea</label>
                                        <textarea  maxlength="1000" class="form-control" id="Textarea" rows="3"></textarea>

                                    </div>
                                    <br>
                                    <center><button type="submit"  class="btn btn-primary">Submit</button></center>
                                </form>


                            </div>

                            <form:form name="testId" action="../deleteTest" method="get">
                                <button style="color: #3c867c;font-size: 16px" type="submit" name="testId"
                                        value="${testDTO.id}" class="btn btn-link"><a
                                        style="text-transform:capitalize">Delete test</a></button>
                            </form:form>
                            <div id="notice" class="box generalbox py-3">Guests cannot access this course. Please
                                log in.
                            </div>
                            <div class="continuebutton">
                                <form method="get" action="http://moodle.lmsace.com/login/index.php">
                                    <button type="submit" hidden class="btn btn-primary"
                                            id="single_button5d1b3626211ec10"
                                            title=""
                                    >Continue
                                    </button>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

</div>

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
</body>
<footer>
    <a href="https://download.moodle.org/mobile?version=2018051700&amp;lang=en&amp;iosappid=633359593&amp;androidappid=com.moodle.moodlemobile">Get
        the mobile app</a>
    <div class="policiesfooter"><a href="http://moodle.lmsace.com/admin/tool/policy/viewall.php">Policies</a></div>


    <script type="text/javascript">
        //<![CDATA[
        var require = {
            baseUrl: 'http://moodle.lmsace.com/lib/requirejs.php/-1/',
            // We only support AMD modules with an explicit define() statement.
            enforceDefine: true,
            skipDataMain: true,
            waitSeconds: 0,

            paths: {
                jquery: 'http://moodle.lmsace.com/lib/javascript.php/-1/lib/jquery/jquery-3.2.1.min',
                jqueryui: 'http://moodle.lmsace.com/lib/javascript.php/-1/lib/jquery/ui-1.12.1/jquery-ui.min',
                jqueryprivate: 'http://moodle.lmsace.com/lib/javascript.php/-1/lib/requirejs/jquery-private'
            },

            // Custom jquery config map.
            map: {
                // '*' means all modules will get 'jqueryprivate'
                // for their 'jquery' dependency.
                '*': {jquery: 'jqueryprivate'},
                // Stub module for 'process'. This is a workaround for a bug in MathJax (see MDL-60458).
                '*': {process: 'core/first'},

                // 'jquery-private' wants the real jQuery module
                // though. If this line was not here, there would
                // be an unresolvable cyclic dependency.
                jqueryprivate: {jquery: 'jquery'}
            }
        };

        //]]>
    </script>
    <script type="text/javascript"
            src="http://moodle.lmsace.com/lib/javascript.php/-1/lib/requirejs/require.js"></script>
    <script type="text/javascript">
        //<![CDATA[
        require(['core/first'], function () {
            ;
            require(["media_videojs/loader"], function (loader) {
                loader.setUp(function (videojs) {
                    videojs.options.flash.swf = "http://moodle.lmsace.com/media/player/videojs/videojs/video-js.swf";
                    videojs.addLanguage("en", {
                        "Audio Player": "Audio Player",
                        "Video Player": "Video Player",
                        "Play": "Play",
                        "Pause": "Pause",
                        "Replay": "Replay",
                        "Current Time": "Current Time",
                        "Duration Time": "Duration Time",
                        "Remaining Time": "Remaining Time",
                        "Stream Type": "Stream Type",
                        "LIVE": "LIVE",
                        "Loaded": "Loaded",
                        "Progress": "Progress",
                        "Progress Bar": "Progress Bar",
                        "progress bar timing: currentTime={1} duration={2}": "{1} of {2}",
                        "Fullscreen": "Fullscreen",
                        "Non-Fullscreen": "Non-Fullscreen",
                        "Mute": "Mute",
                        "Unmute": "Unmute",
                        "Playback Rate": "Playback Rate",
                        "Subtitles": "Subtitles",
                        "subtitles off": "subtitles off",
                        "Captions": "Captions",
                        "captions off": "captions off",
                        "Chapters": "Chapters",
                        "Descriptions": "Descriptions",
                        "descriptions off": "descriptions off",
                        "Audio Track": "Audio Track",
                        "Volume Level": "Volume Level",
                        "You aborted the media playback": "You aborted the media playback",
                        "A network error caused the media download to fail part-way.": "A network error caused the media download to fail part-way.",
                        "The media could not be loaded, either because the server or network failed or because the format is not supported.": "The media could not be loaded, either because the server or network failed or because the format is not supported.",
                        "The media playback was aborted due to a corruption problem or because the media used features your browser did not support.": "The media playback was aborted due to a corruption problem or because the media used features your browser did not support.",
                        "No compatible source was found for this media.": "No compatible source was found for this media.",
                        "The media is encrypted and we do not have the keys to decrypt it.": "The media is encrypted and we do not have the keys to decrypt it.",
                        "Play Video": "Play Video",
                        "Close": "Close",
                        "Close Modal Dialog": "Close Modal Dialog",
                        "Modal Window": "Modal Window",
                        "This is a modal window": "This is a modal window",
                        "This modal can be closed by pressing the Escape key or activating the close button.": "This modal can be closed by pressing the Escape key or activating the close button.",
                        ", opens captions settings dialog": ", opens captions settings dialog",
                        ", opens subtitles settings dialog": ", opens subtitles settings dialog",
                        ", opens descriptions settings dialog": ", opens descriptions settings dialog",
                        ", selected": ", selected",
                        "captions settings": "captions settings",
                        "subtitles settings": "subititles settings",
                        "descriptions settings": "descriptions settings",
                        "Text": "Text",
                        "White": "White",
                        "Black": "Black",
                        "Red": "Red",
                        "Green": "Green",
                        "Blue": "Blue",
                        "Yellow": "Yellow",
                        "Magenta": "Magenta",
                        "Cyan": "Cyan",
                        "Background": "Background",
                        "Window": "Window",
                        "Transparent": "Transparent",
                        "Semi-Transparent": "Semi-Transparent",
                        "Opaque": "Opaque",
                        "Font Size": "Font Size",
                        "Text Edge Style": "Text Edge Style",
                        "None": "None",
                        "Raised": "Raised",
                        "Depressed": "Depressed",
                        "Uniform": "Uniform",
                        "Dropshadow": "Dropshadow",
                        "Font Family": "Font Family",
                        "Proportional Sans-Serif": "Proportional Sans-Serif",
                        "Monospace Sans-Serif": "Monospace Sans-Serif",
                        "Proportional Serif": "Proportional Serif",
                        "Monospace Serif": "Monospace Serif",
                        "Casual": "Casual",
                        "Script": "Script",
                        "Small Caps": "Small Caps",
                        "Reset": "Reset",
                        "restore all settings to the default values": "restore all settings to the default values",
                        "Done": "Done",
                        "Caption Settings Dialog": "Caption Settings Dialog",
                        "Beginning of dialog window. Escape will cancel and close the window.": "Beginning of dialog window. Escape will cancel and close the window.",
                        "End of dialog window.": "End of dialog window."
                    });

                });
            });
            ;

            require(['jquery'], function ($) {
                $('#single_select5d1b3626211ec3').change(function () {
                    var ignore = $(this).find(':selected').attr('data-ignore');
                    if (typeof ignore === typeof undefined) {
                        $('#single_select_f5d1b3626211ec2').submit();
                    }
                });
            });
            ;

            require(['jquery'], function ($) {
                $('#single_select5d1b3626211ec7').change(function () {
                    var ignore = $(this).find(':selected').attr('data-ignore');
                    if (typeof ignore === typeof undefined) {
                        $('#single_select_f5d1b3626211ec6').submit();
                    }
                });
            });
            ;

            require(['theme_boost/loader']);
            require(['theme_boost/drawer'], function (mod) {
                mod.init();
            });
            ;
            require(["core/notification"], function (amd) {
                amd.init(144, []);
            });
            ;
            require(["core/log"], function (amd) {
                amd.setConfig({"level": "trace"});
            });
        });
        //]]>
    </script>
    <script type="text/javascript"
            src="http://moodle.lmsace.com/lib/javascript.php/-1/theme/eguru/javascript/theme.js"></script>
    <script type="text/javascript"
            src="http://moodle.lmsace.com/lib/javascript.php/-1/local/vpt/javascript/videoplaytime.js"></script>
    <script type="text/javascript">
        //<![CDATA[
        M.str = {
            "moodle": {
                "lastmodified": "Last modified",
                "name": "Name",
                "error": "Error",
                "info": "Information",
                "yes": "Yes",
                "no": "No",
                "cancel": "Cancel",
                "confirm": "Confirm",
                "areyousure": "Are you sure?",
                "closebuttontitle": "Close",
                "unknownerror": "Unknown error"
            },
            "repository": {
                "type": "Type",
                "size": "Size",
                "invalidjson": "Invalid JSON string",
                "nofilesattached": "No files attached",
                "filepicker": "File picker",
                "logout": "Logout",
                "nofilesavailable": "No files available",
                "norepositoriesavailable": "Sorry, none of your current repositories can return files in the required format.",
                "fileexistsdialogheader": "File exists",
                "fileexistsdialog_editor": "A validator with that name has already been attached to the text you are editing.",
                "fileexistsdialog_filemanager": "A validator with that name has already been attached",
                "renameto": "Rename to \"{$a}\"",
                "referencesexist": "There are {$a} alias\/shortcut files that use this validator as their source",
                "select": "Select"
            },
            "admin": {
                "confirmdeletecomments": "You are about to delete comments, are you sure?",
                "confirmation": "Confirmation"
            }
        };
        //]]>
    </script>
    <script type="text/javascript">
        //<![CDATA[
        var video = {
            "cfg": {
                "dbtype": "mariadb",
                "dblibrary": "native",
                "dbhost": "localhost",
                "dbname": "lmsace_moodle",
                "dbuser": "lmsace_moodleDBU",
                "dbpass": "moodleDBU321#@!",
                "prefix": "mdl_",
                "dboptions": {"dbpersist": 0, "dbport": "", "dbsocket": "", "dbcollation": "utf8mb4_general_ci"},
                "wwwroot": "http:\/\/moodle.lmsace.com",
                "dataroot": "\/home\/lmsace\/moodledata",
                "admin": "admin",
                "directorypermissions": "511",
                "dirroot": "\/home\/lmsace\/moodle",
                "filepermissions": "438",
                "umaskpermissions": "0",
                "libdir": "\/home\/lmsace\/moodle\/lib",
                "tempdir": "\/home\/lmsace\/moodledata\/temp",
                "backuptempdir": "\/home\/lmsace\/moodledata\/temp\/backup",
                "cachedir": "\/home\/lmsace\/moodledata\/cache",
                "localcachedir": "\/home\/lmsace\/moodledata\/localcache",
                "langotherroot": "\/home\/lmsace\/moodledata\/lang",
                "langlocalroot": "\/home\/lmsace\/moodledata\/lang",
                "yui2version": "2.9.0",
                "yui3version": "3.17.2",
                "yuipatchlevel": "0",
                "yuipatchedmodules": [],
                "config_php_settings": {
                    "dbtype": "mariadb",
                    "dblibrary": "native",
                    "dbhost": "localhost",
                    "dbname": "lmsace_moodle",
                    "dbuser": "lmsace_moodleDBU",
                    "dbpass": "moodleDBU321#@!",
                    "prefix": "mdl_",
                    "dboptions": {"dbpersist": 0, "dbport": "", "dbsocket": "", "dbcollation": "utf8mb4_general_ci"},
                    "wwwroot": "http:\/\/moodle.lmsace.com",
                    "dataroot": "\/home\/lmsace\/moodledata",
                    "admin": "admin",
                    "directorypermissions": 511,
                    "dirroot": "\/home\/lmsace\/moodle",
                    "filepermissions": 438,
                    "umaskpermissions": 0,
                    "libdir": "\/home\/lmsace\/moodle\/lib",
                    "tempdir": "\/home\/lmsace\/moodledata\/temp",
                    "backuptempdir": "\/home\/lmsace\/moodledata\/temp\/backup",
                    "cachedir": "\/home\/lmsace\/moodledata\/cache",
                    "localcachedir": "\/home\/lmsace\/moodledata\/localcache",
                    "langotherroot": "\/home\/lmsace\/moodledata\/lang",
                    "langlocalroot": "\/home\/lmsace\/moodledata\/lang",
                    "yui2version": "2.9.0",
                    "yui3version": "3.17.2",
                    "yuipatchlevel": 0,
                    "yuipatchedmodules": []
                },
                "forced_plugin_settings": [],
                "debug": 32767,
                "debugdeveloper": true,
                "httpswwwroot": "http:\/\/moodle.lmsace.com",
                "dbfamily": "mysql",
                "rolesactive": "1",
                "auth": "email",
                "enrol_plugins_enabled": "manual,guest,self,cohort",
                "theme": "enlight",
                "filter_multilang_converted": "1",
                "siteidentifier": "xHBLlpzQ4578Tcn1vDycEfXoHh1FHciymoodle.lmsace.com",
                "backup_version": "2018051400",
                "backup_release": "3.5",
                "mnet_dispatcher_mode": "off",
                "sessiontimeout": "7200",
                "stringfilters": "",
                "filterall": "0",
                "texteditors": "atto,tinymce,textarea",
                "antiviruses": "",
                "media_plugins_sortorder": "videojs,youtube,swf",
                "upgrade_extracreditweightsstepignored": "1",
                "upgrade_calculatedgradeitemsignored": "1",
                "upgrade_letterboundarycourses": "1",
                "mnet_localhost_id": "1",
                "mnet_all_hosts_id": "2",
                "siteguest": "1",
                "siteadmins": "2",
                "themerev": "1560834156",
                "jsrev": "1560488670",
                "gdversion": "2",
                "licenses": "unknown,allrightsreserved,public,cc,cc-nd,cc-nc-nd,cc-nc,cc-nc-sa,cc-sa",
                "version": "2018051700",
                "enableoutcomes": "0",
                "usecomments": "1",
                "usetags": "1",
                "enablenotes": "1",
                "enableportfolios": "0",
                "enablewebservices": "1",
                "messaging": "1",
                "messaginghidereadnotifications": "0",
                "messagingdeletereadnotificationsdelay": "604800",
                "messagingallowemailoverride": "0",
                "enablestats": "1",
                "enablerssfeeds": "0",
                "enableblogs": "1",
                "enablecompletion": "1",
                "completiondefault": "1",
                "enableavailability": "1",
                "enableplagiarism": "0",
                "enablebadges": "1",
                "enableglobalsearch": "0",
                "allowstealth": "0",
                "defaultpreference_maildisplay": "2",
                "defaultpreference_mailformat": "1",
                "defaultpreference_maildigest": "0",
                "defaultpreference_autosubscribe": "1",
                "defaultpreference_trackforums": "0",
                "autologinguests": "1",
                "hiddenuserfields": "",
                "showuseridentity": "email",
                "fullnamedisplay": "language",
                "alternativefullnameformat": "language",
                "maxusersperpage": "100",
                "enablegravatar": "0",
                "gravatardefaulturl": "mm",
                "agedigitalconsentverification": "0",
                "agedigitalconsentmap": "*, 16\nAT, 14\nES, 14\nUS, 13",
                "sitepolicy": "https:\/\/moodle.lmsace.com\/readme.txt",
                "sitepolicyguest": "",
                "enablecourserequests": "0",
                "defaultrequestcategory": "1",
                "requestcategoryselection": "0",
                "courserequestnotify": "",
                "grade_profilereport": "user",
                "grade_aggregationposition": "1",
                "grade_includescalesinaggregation": "1",
                "grade_hiddenasdate": "0",
                "gradepublishing": "0",
                "grade_export_exportfeedback": "0",
                "grade_export_displaytype": "1",
                "grade_export_decimalpoints": "2",
                "grade_navmethod": "1",
                "grade_export_userprofilefields": "firstname,lastname,idnumber,institution,department,email",
                "grade_export_customprofilefields": "",
                "recovergradesdefault": "0",
                "gradeexport": "",
                "unlimitedgrades": "0",
                "grade_report_showmin": "1",
                "gradepointmax": "100",
                "gradepointdefault": "100",
                "grade_minmaxtouse": "1",
                "grade_mygrades_report": "overview",
                "gradereport_mygradeurl": "",
                "grade_hideforcedsettings": "1",
                "grade_aggregation": "13",
                "grade_aggregation_flag": "0",
                "grade_aggregations_visible": "13",
                "grade_aggregateonlygraded": "1",
                "grade_aggregateonlygraded_flag": "2",
                "grade_aggregateoutcomes": "0",
                "grade_aggregateoutcomes_flag": "2",
                "grade_keephigh": "0",
                "grade_keephigh_flag": "3",
                "grade_droplow": "0",
                "grade_droplow_flag": "2",
                "grade_overridecat": "1",
                "grade_displaytype": "1",
                "grade_decimalpoints": "2",
                "grade_item_advanced": "iteminfo,idnumber,gradepass,plusfactor,multfactor,display,decimals,hiddenuntil,locktime",
                "grade_report_studentsperpage": "100",
                "grade_report_showonlyactiveenrol": "1",
                "grade_report_quickgrading": "1",
                "grade_report_showquickfeedback": "0",
                "grade_report_meanselection": "1",
                "grade_report_enableajax": "0",
                "grade_report_showcalculations": "1",
                "grade_report_showeyecons": "0",
                "grade_report_showaverages": "1",
                "grade_report_showlocks": "0",
                "grade_report_showranges": "0",
                "grade_report_showanalysisicon": "1",
                "grade_report_showuserimage": "1",
                "grade_report_showactivityicons": "1",
                "grade_report_shownumberofgrades": "0",
                "grade_report_averagesdisplaytype": "inherit",
                "grade_report_rangesdisplaytype": "inherit",
                "grade_report_averagesdecimalpoints": "inherit",
                "grade_report_rangesdecimalpoints": "inherit",
                "grade_report_historyperpage": "50",
                "grade_report_overview_showrank": "0",
                "grade_report_overview_showtotalsifcontainhidden": "0",
                "grade_report_user_showrank": "0",
                "grade_report_user_showpercentage": "1",
                "grade_report_user_showgrade": "1",
                "grade_report_user_showfeedback": "1",
                "grade_report_user_showrange": "1",
                "grade_report_user_showweight": "1",
                "grade_report_user_showaverage": "0",
                "grade_report_user_showlettergrade": "0",
                "grade_report_user_rangedecimals": "0",
                "grade_report_user_showhiddenitems": "1",
                "grade_report_user_showtotalsifcontainhidden": "0",
                "grade_report_user_showcontributiontocoursetotal": "1",
                "badges_defaultissuername": "",
                "badges_defaultissuercontact": "",
                "badges_badgesalt": "badges1529681543",
                "badges_allowexternalbackpack": "1",
                "badges_allowcoursebadges": "1",
                "forcetimezone": "99",
                "country": "0",
                "defaultcity": "",
                "geoip2file": "\/home\/lmsace\/moodledata\/geoip\/GeoLite2-City.mmdb",
                "googlemapkey3": "",
                "allcountrycodes": "",
                "autolang": "1",
                "lang": "en",
                "langmenu": "1",
                "langlist": "",
                "langrev": "1560488670",
                "langcache": "1",
                "langstringcache": "1",
                "locale": "",
                "latinexcelexport": "0",
                "requiremodintro": "0",
                "authloginviaemail": "0",
                "allowaccountssameemail": "0",
                "authpreventaccountcreation": "0",
                "loginpageautofocus": "0",
                "guestloginbutton": "1",
                "limitconcurrentlogins": "0",
                "alternateloginurl": "",
                "forgottenpasswordurl": "",
                "auth_instructions": "",
                "allowemailaddresses": "",
                "denyemailaddresses": "",
                "verifychangedemail": "1",
                "recaptchapublickey": "",
                "recaptchaprivatekey": "",
                "filteruploadedfiles": "0",
                "filtermatchoneperpage": "0",
                "filtermatchonepertext": "0",
                "sitedefaultlicense": "allrightsreserved",
                "media_default_width": "400",
                "media_default_height": "300",
                "portfolio_moderate_filesize_threshold": "1048576",
                "portfolio_high_filesize_threshold": "5242880",
                "portfolio_moderate_db_threshold": "20",
                "portfolio_high_db_threshold": "50",
                "repositorycacheexpire": "120",
                "repositorygetfiletimeout": "30",
                "repositorysyncfiletimeout": "1",
                "repositorysyncimagetimeout": "3",
                "repositoryallowexternallinks": "1",
                "legacyfilesinnewcourses": "0",
                "legacyfilesaddallowed": "1",
                "searchengine": "simpledb",
                "searchindexwhendisabled": "0",
                "searchindextime": "600",
                "searchallavailablecourses": "0",
                "enablewsdocumentation": "0",
                "allowbeforeblock": "0",
                "allowedip": "",
                "blockedip": "",
                "protectusernames": "1",
                "forcelogin": "0",
                "forceloginforprofiles": "1",
                "forceloginforprofileimage": "0",
                "opentogoogle": "0",
                "allowindexing": "0",
                "maxbytes": "0",
                "userquota": "104857600",
                "allowobjectembed": "0",
                "enabletrusttext": "0",
                "maxeditingtime": "1800",
                "extendedusernamechars": "0",
                "keeptagnamecase": "1",
                "profilesforenrolledusersonly": "1",
                "cronclionly": "1",
                "cronremotepassword": "",
                "lockoutthreshold": "0",
                "lockoutwindow": "1800",
                "lockoutduration": "1800",
                "passwordpolicy": "1",
                "minpasswordlength": "8",
                "minpassworddigits": "1",
                "minpasswordlower": "1",
                "minpasswordupper": "1",
                "minpasswordnonalphanum": "1",
                "maxconsecutiveidentchars": "0",
                "passwordreuselimit": "0",
                "pwresettime": "1800",
                "passwordchangelogout": "0",
                "passwordchangetokendeletion": "0",
                "tokenduration": "7257600",
                "groupenrolmentkeypolicy": "1",
                "disableuserimages": "0",
                "emailchangeconfirmation": "1",
                "rememberusername": "2",
                "strictformsrequired": "0",
                "cookiesecure": "1",
                "cookiehttponly": "0",
                "allowframembedding": "0",
                "curlsecurityblockedhosts": "",
                "curlsecurityallowedport": "",
                "displayloginfailures": "0",
                "notifyloginfailures": "",
                "notifyloginthreshold": "10",
                "themelist": "",
                "themedesignermode": "0",
                "allowuserthemes": "0",
                "allowcoursethemes": "0",
                "allowcategorythemes": "0",
                "allowcohortthemes": "0",
                "allowthemechangeonurl": "1",
                "allowuserblockhiding": "1",
                "allowblockstodock": "1",
                "custommenuitems": "Moodle community|https:\/\/moodle.org\r\n-Moodle free support|https:\/\/moodle.org\/support\r\n-Moodle Docs|http:\/\/docs.moodle.org|Moodle Docs\r\n-German Moodle Docs|http:\/\/docs.moodle.org\/de|Documentation in German|de\r\n-Moodle development|https:\/\/moodle.org\/development\r\nMoodle.com|http:\/\/moodle.com\/",
                "customusermenuitems": "grades,grades|\/grade\/report\/mygrades.php|grades\r\nmessages,message|\/message\/index.php|message\r\npreferences,moodle|\/user\/preferences.php|preferences",
                "enabledevicedetection": "1",
                "devicedetectregex": "[]",
                "calendartype": "gregorian",
                "calendar_adminseesall": "0",
                "calendar_site_timeformat": "0",
                "calendar_startwday": "1",
                "calendar_weekend": "65",
                "calendar_lookahead": "21",
                "calendar_maxevents": "10",
                "enablecalendarexport": "1",
                "calendar_customexport": "1",
                "calendar_exportlookahead": "365",
                "calendar_exportlookback": "5",
                "calendar_exportsalt": "RMGpwCaHkLvmStLgB8P87Dlw2L2Aj4wJ6Mhj0KTxNDQDcSHu6rDcc5AvTDmz",
                "calendar_showicalsource": "1",
                "useblogassociations": "1",
                "bloglevel": "4",
                "useexternalblogs": "1",
                "externalblogcrontime": "86400",
                "maxexternalblogsperuser": "1",
                "blogusecomments": "1",
                "blogshowcommentscount": "1",
                "defaulthomepage": "1",
                "allowguestmymoodle": "1",
                "navshowfullcoursenames": "0",
                "navshowcategories": "1",
                "navshowmycoursecategories": "0",
                "navshowallcourses": "0",
                "navsortmycoursessort": "sortorder",
                "navcourselimit": "10",
                "usesitenameforsitepages": "0",
                "linkadmincategories": "1",
                "linkcoursesections": "1",
                "navshowfrontpagemods": "1",
                "navadduserpostslinks": "1",
                "formatstringstriptags": "1",
                "emoticons": "[{\"text\":\":-)\",\"imagename\":\"s\\\/smiley\",\"imagecomponent\":\"core\",\"altidentifier\":\"smiley\",\"altcomponent\":\"core_pix\"},{\"text\":\":)\",\"imagename\":\"s\\\/smiley\",\"imagecomponent\":\"core\",\"altidentifier\":\"smiley\",\"altcomponent\":\"core_pix\"},{\"text\":\":-D\",\"imagename\":\"s\\\/biggrin\",\"imagecomponent\":\"core\",\"altidentifier\":\"biggrin\",\"altcomponent\":\"core_pix\"},{\"text\":\";-)\",\"imagename\":\"s\\\/wink\",\"imagecomponent\":\"core\",\"altidentifier\":\"wink\",\"altcomponent\":\"core_pix\"},{\"text\":\":-\\\/\",\"imagename\":\"s\\\/mixed\",\"imagecomponent\":\"core\",\"altidentifier\":\"mixed\",\"altcomponent\":\"core_pix\"},{\"text\":\"V-.\",\"imagename\":\"s\\\/thoughtful\",\"imagecomponent\":\"core\",\"altidentifier\":\"thoughtful\",\"altcomponent\":\"core_pix\"},{\"text\":\":-P\",\"imagename\":\"s\\\/tongueout\",\"imagecomponent\":\"core\",\"altidentifier\":\"tongueout\",\"altcomponent\":\"core_pix\"},{\"text\":\":-p\",\"imagename\":\"s\\\/tongueout\",\"imagecomponent\":\"core\",\"altidentifier\":\"tongueout\",\"altcomponent\":\"core_pix\"},{\"text\":\"B-)\",\"imagename\":\"s\\\/cool\",\"imagecomponent\":\"core\",\"altidentifier\":\"cool\",\"altcomponent\":\"core_pix\"},{\"text\":\"^-)\",\"imagename\":\"s\\\/approve\",\"imagecomponent\":\"core\",\"altidentifier\":\"approve\",\"altcomponent\":\"core_pix\"},{\"text\":\"8-)\",\"imagename\":\"s\\\/wideeyes\",\"imagecomponent\":\"core\",\"altidentifier\":\"wideeyes\",\"altcomponent\":\"core_pix\"},{\"text\":\":o)\",\"imagename\":\"s\\\/clown\",\"imagecomponent\":\"core\",\"altidentifier\":\"clown\",\"altcomponent\":\"core_pix\"},{\"text\":\":-(\",\"imagename\":\"s\\\/sad\",\"imagecomponent\":\"core\",\"altidentifier\":\"sad\",\"altcomponent\":\"core_pix\"},{\"text\":\":(\",\"imagename\":\"s\\\/sad\",\"imagecomponent\":\"core\",\"altidentifier\":\"sad\",\"altcomponent\":\"core_pix\"},{\"text\":\"8-.\",\"imagename\":\"s\\\/shy\",\"imagecomponent\":\"core\",\"altidentifier\":\"shy\",\"altcomponent\":\"core_pix\"},{\"text\":\":-I\",\"imagename\":\"s\\\/blush\",\"imagecomponent\":\"core\",\"altidentifier\":\"blush\",\"altcomponent\":\"core_pix\"},{\"text\":\":-X\",\"imagename\":\"s\\\/kiss\",\"imagecomponent\":\"core\",\"altidentifier\":\"kiss\",\"altcomponent\":\"core_pix\"},{\"text\":\"8-o\",\"imagename\":\"s\\\/surprise\",\"imagecomponent\":\"core\",\"altidentifier\":\"surprise\",\"altcomponent\":\"core_pix\"},{\"text\":\"P-|\",\"imagename\":\"s\\\/blackeye\",\"imagecomponent\":\"core\",\"altidentifier\":\"blackeye\",\"altcomponent\":\"core_pix\"},{\"text\":\"8-[\",\"imagename\":\"s\\\/angry\",\"imagecomponent\":\"core\",\"altidentifier\":\"angry\",\"altcomponent\":\"core_pix\"},{\"text\":\"(grr)\",\"imagename\":\"s\\\/angry\",\"imagecomponent\":\"core\",\"altidentifier\":\"angry\",\"altcomponent\":\"core_pix\"},{\"text\":\"xx-P\",\"imagename\":\"s\\\/dead\",\"imagecomponent\":\"core\",\"altidentifier\":\"dead\",\"altcomponent\":\"core_pix\"},{\"text\":\"|-.\",\"imagename\":\"s\\\/sleepy\",\"imagecomponent\":\"core\",\"altidentifier\":\"sleepy\",\"altcomponent\":\"core_pix\"},{\"text\":\"}-]\",\"imagename\":\"s\\\/evil\",\"imagecomponent\":\"core\",\"altidentifier\":\"evil\",\"altcomponent\":\"core_pix\"},{\"text\":\"(h)\",\"imagename\":\"s\\\/heart\",\"imagecomponent\":\"core\",\"altidentifier\":\"heart\",\"altcomponent\":\"core_pix\"},{\"text\":\"(heart)\",\"imagename\":\"s\\\/heart\",\"imagecomponent\":\"core\",\"altidentifier\":\"heart\",\"altcomponent\":\"core_pix\"},{\"text\":\"(y)\",\"imagename\":\"s\\\/yes\",\"imagecomponent\":\"core\",\"altidentifier\":\"yes\",\"altcomponent\":\"core\"},{\"text\":\"(n)\",\"imagename\":\"s\\\/no\",\"imagecomponent\":\"core\",\"altidentifier\":\"no\",\"altcomponent\":\"core\"},{\"text\":\"(martin)\",\"imagename\":\"s\\\/martin\",\"imagecomponent\":\"core\",\"altidentifier\":\"martin\",\"altcomponent\":\"core_pix\"},{\"text\":\"( )\",\"imagename\":\"s\\\/egg\",\"imagecomponent\":\"core\",\"altidentifier\":\"egg\",\"altcomponent\":\"core_pix\"}]",
                "docroot": "https:\/\/docs.moodle.org",
                "doclang": "",
                "doctonewwindow": "0",
                "courselistshortnames": "0",
                "coursesperpage": "20",
                "courseswithsummarieslimit": "10",
                "courseoverviewfileslimit": "1",
                "courseoverviewfilesext": ".jpg,.gif,.png",
                "useexternalyui": "0",
                "yuicomboloading": "1",
                "cachejs": "0",
                "modchooserdefault": "1",
                "additionalhtmlhead": "",
                "additionalhtmltopofbody": "",
                "additionalhtmlfooter": "",
                "pathtodu": "",
                "aspellpath": "",
                "pathtodot": "",
                "pathtogs": "\/usr\/bin\/gs",
                "pathtopython": "",
                "supportname": "Admin User",
                "supportemail": "",
                "supportpage": "",
                "dbsessions": "0",
                "sessioncookie": "",
                "sessioncookiepath": "\/",
                "sessioncookiedomain": "",
                "statsfirstrun": "none",
                "statsmaxruntime": "0",
                "statsruntimedays": "31",
                "statsuserthreshold": "0",
                "slasharguments": "1",
                "getremoteaddrconf": "0",
                "proxyhost": "",
                "proxyport": "0",
                "proxytype": "HTTP",
                "proxyuser": "",
                "proxypassword": "",
                "proxybypass": "localhost, 127.0.0.1",
                "maintenance_enabled": "0",
                "maintenance_message": "",
                "deleteunconfirmed": "168",
                "deleteincompleteusers": "0",
                "disablegradehistory": "0",
                "gradehistorylifetime": "0",
                "tempdatafoldercleanup": "168",
                "extramemorylimit": "512M",
                "maxtimelimit": "0",
                "curlcache": "120",
                "curltimeoutkbitrate": "56",
                "smtphosts": "",
                "smtpsecure": "",
                "smtpauthtype": "LOGIN",
                "smtpuser": "",
                "smtppass": "",
                "smtpmaxbulk": "1",
                "noreplyaddress": "noreply@moodle.lmsace.com",
                "allowedemaildomains": "",
                "sitemailcharset": "0",
                "allowusermailcharset": "0",
                "allowattachments": "1",
                "mailnewline": "LF",
                "emailfromvia": "1",
                "updateautocheck": "1",
                "updateminmaturity": "200",
                "updatenotifybuilds": "0",
                "enablesafebrowserintegration": "0",
                "dndallowtextandlinks": "0",
                "pathtosassc": "",
                "forceclean": "0",
                "debugdisplay": "0",
                "debugsmtp": "0",
                "perfdebug": "7",
                "debugstringids": "0",
                "debugvalidators": "0",
                "debugpageinfo": "0",
                "profilingenabled": "0",
                "profilingincluded": "",
                "profilingexcluded": "",
                "profilingautofrec": "0",
                "profilingallowme": "0",
                "profilingallowall": "0",
                "profilinglifetime": "1440",
                "profilingimportprefix": "(I)",
                "release": "3.5 (Build: 20180517)",
                "branch": "35",
                "localcachedirpurged": "1560488670",
                "scheduledtaskreset": "1560488670",
                "allversionshash": "fae49be2a4aaf0be0ecaf7f73d283a64543d5e7b",
                "registrationpending": "0",
                "notloggedinroleid": "6",
                "guestroleid": "6",
                "defaultuserroleid": "7",
                "creatornewroleid": "3",
                "restorernewroleid": "3",
                "sitepolicyhandler": "tool_policy",
                "gradebookroles": "5",
                "chat_method": "ajax",
                "chat_refresh_userlist": "10",
                "chat_old_ping": "35",
                "chat_refresh_room": "5",
                "chat_normal_updatemode": "jsupdate",
                "chat_serverhost": "moodle.lmsace.com",
                "chat_serverip": "127.0.0.1",
                "chat_serverport": "9111",
                "chat_servermax": "100",
                "data_enablerssfeeds": "0",
                "feedback_allowfullanonymous": "0",
                "forum_displaymode": "3",
                "forum_shortpost": "5300",
                "forum_longpost": "5600",
                "forum_manydiscussions": "100",
                "forum_maxbytes": "512000",
                "forum_maxattachments": "9",
                "forum_subscription": "0",
                "forum_trackingtype": "1",
                "forum_trackreadposts": "1",
                "forum_allowforcedreadtracking": "0",
                "forum_oldpostdays": "14",
                "forum_usermarksread": "0",
                "forum_cleanreadtime": "2",
                "digestmailtime": "17",
                "forum_enablerssfeeds": "0",
                "forum_enabletimedposts": "1",
                "glossary_entbypage": "10",
                "glossary_dupentries": "0",
                "glossary_allowcomments": "0",
                "glossary_linkbydefault": "1",
                "glossary_defaultapproval": "1",
                "glossary_enablerssfeeds": "0",
                "glossary_linkentries": "0",
                "glossary_casesensitive": "0",
                "glossary_fullmatch": "0",
                "block_course_list_adminview": "all",
                "block_course_list_hideallcourseslink": "0",
                "block_html_allowcssclasses": "0",
                "block_online_users_timetosee": "5",
                "block_rss_client_num_entries": "5",
                "block_rss_client_timeout": "30",
                "pathtounoconv": "\/usr\/bin\/unoconv",
                "filter_multilang_force_old": "0",
                "filter_censor_badwords": "",
                "logguests": "1",
                "loglifetime": "0",
                "jabberhost": "",
                "jabberserver": "",
                "jabberusername": "",
                "jabberpassword": "",
                "jabberport": "5222",
                "airnotifierurl": "https:\/\/messages.moodle.net",
                "airnotifierport": "443",
                "airnotifiermobileappname": "com.moodle.moodlemobile",
                "airnotifierappname": "commoodlemoodlemobile",
                "airnotifieraccesskey": "",
                "profileroles": "5,4,3",
                "coursecontact": "3",
                "frontpage": "6,2,7,4,0",
                "frontpageloggedin": "6,2,5,7,4,0",
                "maxcategorydepth": "2",
                "frontpagecourselimit": "200",
                "commentsperpage": "15",
                "defaultfrontpageroleid": "8",
                "messageinbound_enabled": "0",
                "messageinbound_mailbox": "",
                "messageinbound_domain": "",
                "messageinbound_host": "",
                "messageinbound_hostssl": "ssl",
                "messageinbound_hostuser": "",
                "messageinbound_hostpass": "",
                "enablemobilewebservice": "1",
                "timezone": "Europe\/London",
                "registerauth": "email",
                "primarymenu": "\ncolors|\n-Blue | &color=blue\n-Green| &color=green\n-Lavendat|&color=lavendar\n-Red|&color=red\n-Purple|&color=purple\nHeaders |javascript:void(0)\n- Style 1|&headerStyle=1\n- Style 2|&headerStyle=2\nCourse lising| javascript:void(0)\n-Layout 1 | \/course\/index.php?courselayout=layout1\n-Layout 2 | \/course\/index.php?courselayout=layout2\n-Layout default | \/course\/index.php?courselayout=default\nFeatures|javascript:void(0)\n-Highly configurable slider\n-Testimonials | #testimonials\n-Our Team | #ourteam\n-Site promo1 | #sitepromo1\n-Site promo2 | #sitepromo2\n-Show Preloader | &preloader_status=1\n-Hide Preloader | &preloader_status=0\nLogin Page|javascript:void(0)\n-Moodle default style| \/login\/index.php?loginpageType=0\n-Theme based| \/login\/index.php?loginpageType=1\nFooter | javascript:void(0)\n-2 column | &footer=2\n-3 column | &footer=3\n-4 column | &footer=4\n",
                "webserviceprotocols": "rest",
                "mobilecssurl": "",
                "ostype": "UNIX",
                "os": "Linux",
                "wordlist": "\/home\/lmsace\/moodle\/lib\/wordlist.txt",
                "moddata": "moddata",
                "filelifetime": 21600
            }, "course": "6", "cm": ""
        };
        //]]>
    </script>
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