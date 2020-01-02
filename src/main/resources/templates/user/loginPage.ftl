<!DOCTYPE html>
<!--[if lt IE 7 ]>
<html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>
<html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>
<html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>
<html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js"> <!--<![endif]-->
<head>

    <meta charset="UTF-8"/>
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>卖家管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3"/>
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class"/>
    <meta name="author" content="Codrops"/>
    <link rel="shortcut icon" href="/sell/favicon.ico">
    <link rel="stylesheet" type="text/css" href="/sell/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/sell/css/style3.css"/>
    <link rel="stylesheet" type="text/css" href="/sell/css/animate-custom.css"/>
</head>
<script>
    var re = /^[0-9a-zA-Z]*$/g;

    function submitTest() {
        var name = document.getElementById("registerUserName").value;
        var password = document.getElementById("registerUsePassword").value;
        var confirm_password = document.getElementById("password_confirm").value;
        if (!re.test(name)) {
            alert("请输入英文或数字");
            return false;
        }
        if (name.length < 6 || name.length > 16) {
            alert("请输入6-16位的账号");
            return false;
        }
        if (password.length < 6 || password.length > 16) {
            alert("请输入6-16位的密码");
            return false;
        }
        if (password !== confirm_password) {
            alert("两次密码输入不一致！");
            return false;
        }
    }
</script>
<body>
<div class="container">
    <!-- Codrops top bar -->
    <header>
        <h1>卖家后台管理系统</h1>
    </header>
    <section>
        <div id="container_demo">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="/sell/user/login" method="post" autocomplete="on">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u"> Your account </label>
                            <input id="username" name="username" required="required" type="text" placeholder="请输入账号"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password"
                                   placeholder="请输入密码"/>
                        </p>
                        <p class="login button">
                            <input type="submit" value="登录"/>
                        </p>
                        <p class="change_link">
                            没有账号 ?
                            <a href="#toregister" class="to_register">去注册一个</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form action="/sell/user/register" method="post" onsubmit="return submitTest()" autocomplete="on">
                        <h1> Sign up </h1>
                        <p>
                            <label for="registerUserName" class="uname" data-icon="u">Your account</label>
                            <input id="registerUserName" name="registerUserName" required="required" type="text"
                                   placeholder="请输入6-16位的英文或数字"/>
                        </p>
                        <p>
                            <label for="registerUsePassword" class="youpasswd" data-icon="p">Your password </label>
                            <input id="registerUsePassword" name="registerUsePassword" required="required" type="password"
                                   placeholder="密码限制5-16位"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your
                                password </label>
                            <input id="password_confirm" name="passwordsignup_confirm" required="required"
                                   type="password" placeholder="重复输入密码"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="注册"/>
                        </p>
                        <p class="change_link">
                            已有账号 ?
                            <a href="#tologin" class="to_register"> 直接登录 </a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <a href="http://www.beian.miit.gov.cn/" target="_blank">沪ICP备18047321号</a>
</div>
</body>
</html>