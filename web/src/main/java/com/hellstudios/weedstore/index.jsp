<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" href="./int/css/font-face.css">
    <link rel="stylesheet" href="./int/css/styles.main.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="./ext/js/jquery.jcarousel.min.js"></script>
    <script src="./int/js/script.main.js"></script>
</head>
<body>
<div class="jimmyPage">

    <div class="wrapper-top">

        <div class="top">
            <header class="header">
                <div class="account">
                    <div class="account__cart">
                        <p class="account__price"> 0.00 </p>

                        <figure>
                            <img class="account__img" src="./int/img/basket.png" alt="BASKET" title="basket">
                        </figure>
                    </div>

                    <div class="logIn">
                        <a id="signInBtn" class="logIn__signIn" href="/Login.html"> Sign In </a>
                        <a class="logIn__register" href="#"> Register </a>
                    </div>
                </div>

                <nav class="nav">
                    <li class="nav__item">
                        <a class="nav__link" id="home" href="#"> Home </a>
                    </li>
                    <li class="nav__item">
                        <a class="nav__link" id="products" href="#main"> Products </a>
                    </li>
                    <li class="nav__item">
                        <a class="nav__link" id="sellers" href="#main"> Sellers </a>
                    </li>
                    <li class="nav__item">
                        <a class="nav__link" id="stores" href="#"> Stores </a>
                    </li>
                </nav>
            </header>

            <div class="j-wrapper">
                <div class="jcarousel">
                    <ul>
                        <li><img src="./int/img/slider/img1.jpg"></li>
                        <li><img src="./int/img/slider/img2.jpg"></li>
                        <li><img src="./int/img/slider/img3.jpg"></li>
                    </ul>
                </div>

                <p class="jcarousel-pagination"></p>
            </div>
        </div>

    </div>

    <div class="wrapper-main" id="main">

        <!-- PRODUCTS PAGE -->



        <!-- SELLERS PAGE -->

        <main class="main-sellers clearfix">
            <div class="sellers">
                <div class="sellers__top">

                    <div class="search">
                        <input class="search__input-text" type="text" placeholder="Search...">
                        <input class="search__button" type="button">
                    </div>

                    <span class="sellers__caption"> Sellers: </span>
                </div>

                <ul class="sellers__list">
                    <li class="sellers__item">
                        <img class="sellers__img" src="./int/img/sellers/sashan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> OleXandr Snizzko </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="./int/img/sellers/katyan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> eKATEryn Buггaiчyk </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="./int/img/sellers/serogan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> SerёgA Strelя </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="./int/img/sellers/vovan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> Eva Vovtukh </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>
                </ul>
            </div>
        </main>

        <!-- CART PAGE -->

    </div>

    <div class="wrapper-footer">
        <footer>
            <span class="copyright"> © Smoking weed can badly affect your health </span>
        </footer>
    </div>


</div>
</body>
</html>
