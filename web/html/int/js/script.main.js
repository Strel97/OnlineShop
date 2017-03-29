$(function() {

   $('#sellers').on('click', function() {
      $('.wrapper-main').children().css('display', 'none');
      $('.main-sellers').css('display', 'block');
   });

   $('#products').on('click', function() {
      $('.wrapper-main').children().css('display', 'none');
      $('.main-products').css('display', 'block');
   });

   $('.account__img').on('click', function() {
      // $('.wrapper-main').children().css('display', 'none');
      // $('.main-products').css('display', 'block');
   });

   //    SLIDER

   $('.jcarousel ul').width( $('ul li img').width() * $('ul li img').length );

   $('.j-wrapper').on('mouseenter', function() {
      $('.jcarousel-pagination').addClass('jcarousel-pagination-visible');
   });

   $('.j-wrapper').on('mouseleave', function() {
      $('.jcarousel-pagination').removeClass('jcarousel-pagination-visible');
   });

   $('.jcarousel').jcarousel();

   /*           Slider pagination          */

   $('.jcarousel-pagination')
   .on('jcarouselpagination:active', 'a', function() {
      $(this).addClass('active');
   })
   .on('jcarouselpagination:inactive', 'a', function() {
      $(this).removeClass('active');
   })
   .jcarouselPagination();


   //      PRODUCTS PAGINATION

   // positive - add 'num', negative - remove 'num'
   function productsPage(num) {
      var paginationObj = $('.products__pagination').children();

      if (num > 0) {
         var pageNum = paginationObj.length + 1;

         for (var i = 0; i < num; i++) {
            $('.products__pagination').append(`<a class="products__page"> ${pageNum + i} </a>`);
         }
      } else {
         num = -num;

         if ( num > 0 && num < paginationObj.length ) {
            var lastIndex = paginationObj.length - 1;

            for (var i = 0; i < num; i++) {
               $(paginationObj).eq(lastIndex - i).remove();
            }
         }
      }
   }
   productsPage(3);

   /*       SCROLL         */

   $('.nav__link').click(function () {
      var elementClick = $(this).attr("href");
      var destination = $(elementClick).offset().top;

      $('body').animate({ scrollTop: destination }, 500);

      return false;
   });

});
