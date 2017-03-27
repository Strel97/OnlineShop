<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
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
                        <a class="logIn__signIn" href="#"> Sign In </a>
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

        <main class="main-products clearfix">
            <div class="filters">

                <div class="filter">
                    <span class="filter__caption"> Categories filter: </span>

                    <ul class="filter__menu">
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 1 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 2 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 3 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 4 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 5 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Category 6 </label>
                        </li>
                    </ul>
                </div>

                <div class="filter">
                    <span class="filter__caption"> Sellers filter: </span>

                    <ul class="filter__menu">
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Seller 1 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Seller 2 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Seller 3 </label>
                        </li>
                        <li class="filter__item">
                            <label><input class="filter__input" type="checkbox"> Seller 4 </label>
                        </li>
                    </ul>
                </div>

            </div>

            <div class="products">
                <div class="search">
                    <input class="search__input-text" type="text" placeholder="Search...">
                    <input class="search__button" type="button">
                </div>

                <span class="products__caption"> Products: </span>

                <div class="products__content">
                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product2.jpg">

                            <figcaption class="products__name"> Product 1</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product3.jpg">

                            <figcaption class="products__name"> Product 2</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product4.jpg">

                            <figcaption class="products__name"> Product 3</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product1.jpg">

                            <figcaption class="products__name"> Product 4</figcaption>
                        </figure>
                    </div>

                </div>

                <div class="products__content">
                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product4.jpg">

                            <figcaption class="products__name"> Product 5</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product1.jpg">

                            <figcaption class="products__name"> Product 6</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product3.jpg">

                            <figcaption class="products__name"> Product 7</figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="./int/img/products/product2.jpg">

                            <figcaption class="products__name"> Product 8</figcaption>
                        </figure>
                    </div>

                </div>

                <div class="products__pagination"></div>
            </div>
        </main>

    </div>

    <div class="wrapper-footer">
        <footer>
            <span class="copyright"> © Smoking weed can badly affect your health </span>
        </footer>
    </div>
</div>
</body>
</html>