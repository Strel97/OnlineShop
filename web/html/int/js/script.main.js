"use strict";
$(function () {
    $("#sellers").on("click", function () {
        $(".wrapper-main").children().css("display", "none"), $(".main-sellers").css("display", "block")
    }), $("#products").on("click", function () {
        $(".wrapper-main").children().css("display", "none"), $(".main-products").css("display", "block")
    }), $(".account__img").on("click", function () {
    }), $(".jcarousel ul").width($("ul li img").width() * $("ul li img").length), $(".j-wrapper").on("mouseenter", function () {
        $(".jcarousel-pagination").addClass("jcarousel-pagination-visible")
    }), $(".j-wrapper").on("mouseleave", function () {
        $(".jcarousel-pagination").removeClass("jcarousel-pagination-visible")
    }), $(".jcarousel").jcarousel(), $(".jcarousel-pagination").on("jcarouselpagination:active", "a", function () {
        $(this).addClass("active")
    }).on("jcarouselpagination:inactive", "a", function () {
        $(this).removeClass("active")
    }).jcarouselPagination(), function (a) {
        var n = $(".products__pagination").children();
        if (a > 0)for (var i = n.length + 1, o = 0; o < a; o++)$(".products__pagination").append('<a class="products__page"> ' + (i + o) + " </a>"); else if ((a = -a) > 0 && a < n.length)for (var e = n.length - 1, s = 0; s < a; s++)$(n).eq(e - s).remove()
    }(3), $(".nav__link").click(function () {
        var a = $(this).attr("href"), n = $(a).offset().top;
        return $("body").animate({scrollTop: n}, 500), !1
    })
});