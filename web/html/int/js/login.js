$(function() {

    $('.message a').on('click', function () {
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    $('#auth').on('click', function () {

        var email = $('#login_email').val();
        var password = $('#login_password').val();

        $.post(
            "/rest/auth/login",
            {
                "email": email,
                "password": password
            },
            function (data) {
                if (data['error']) {
                    alert(data['error']);
                }
            }
        );
    });
});