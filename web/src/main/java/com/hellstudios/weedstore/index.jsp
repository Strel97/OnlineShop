<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/int/css/font-face.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/int/css/styles.main.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/ext/jsjquery.jcarousel.min.js"></script>
    <script src="<%=request.getContextPath()%>/int/js/script.main.js"></script>
</head>
<body>
<h1><%=request.getMethod()%></h1>
<div class="jimmyPage">

    <div class="wrapper-top">

        <div class="top">
            <header class="header">
                <div class="account">
                    <div class="account__cart">
                        <p class="account__price"> 0.00 </p>

                        <figure>
                            <img class="account__img" src="<%=request.getContextPath()%>/int/img/basket.png" alt="BASKET" title="basket">
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
                        <li><img src="<%=request.getContextPath()%>/int/img/slider/img1.jpg"></li>
                        <li><img src="<%=request.getContextPath()%>/int/img/slider/img2.jpg"></li>
                        <li><img src="<%=request.getContextPath()%>/int/img/slider/img3.jpg"></li>
                    </ul>
                </div>

                <p class="jcarousel-pagination"></p>
            </div>
        </div>

    </div>

    <div class="wrapper-main" id="main">

        <!-- PRODUCTS PAGE -->

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
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product2.jpg">

                            <figcaption class="products__name"> Product 1 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product3.jpg">

                            <figcaption class="products__name"> Product 2 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product4.jpg">

                            <figcaption class="products__name"> Product 3 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product1.jpg">

                            <figcaption class="products__name"> Product 4 </figcaption>
                        </figure>
                    </div>

                </div>

                <div class="products__content">
                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product4.jpg">

                            <figcaption class="products__name"> Product 5 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product1.jpg">

                            <figcaption class="products__name"> Product 6 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product3.jpg">

                            <figcaption class="products__name"> Product 7 </figcaption>
                        </figure>
                    </div>

                    <div class="products__item">
                        <figure>
                            <img class="products__img" src="<%=request.getContextPath()%>/int/img/products/product2.jpg">

                            <figcaption class="products__name"> Product 8 </figcaption>
                        </figure>
                    </div>

                </div>

                <div class="products__pagination"></div>
            </div>
        </main>

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
                        <img class="sellers__img" src="<%=request.getContextPath()%>/int/img/sellers/sashan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> OleXandr Snizzko </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="<%=request.getContextPath()%>/int/img/sellers/katyan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> eKATEryn Buггaiчyk </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="<%=request.getContextPath()%>/int/img/sellers/serogan.jpg" alt="">

                        <div class="sellers__personal">
                            <p class="sellers__name"> SerёgA Strelя </p>
                            <p class="sellers__description"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>

                        <input class="sellers__btn" type="button" value="Show weed">
                    </li>

                    <li class="sellers__item">
                        <img class="sellers__img" src="<%=request.getContextPath()%>/int/img/sellers/vovan.jpg" alt="">

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
