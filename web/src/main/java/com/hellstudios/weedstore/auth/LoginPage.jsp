
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="./int/css/login.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="./int/js/login.js"></script>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form class="register-form">
                <input id="register_email" type="text" placeholder="email"/>
                <input id="register_password" type="password" placeholder="password"/>
                <button id="register">create</button>
                <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form>

            <form class="login-form" method="post" action="Login.action">
                <input id="login_email" type="text" placeholder="email"/>
                <input id="login_password" type="password" placeholder="password"/>
                <button id="login">login</button>
                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </div>
</body>
</html>
