
$(function() {

    var app = new Application();
    var emailInput = $('#email');
    var nameInput = $('#nickname');
    var passInput = $('#password');


    $('.message a').on('click', function () {
        $('.toggle').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    $('#login-btn').on('click', function ( event ) {

        event.preventDefault();

        if (!app.validateFields([ emailInput, nameInput ])) {
            return;
        }

        var params = {
            "email": emailInput.val(),
            "password": passInput.val()
        };

        app.submitForm("/rest/auth/login", params, function () {
            // Refreshing page to get main page for logged in user
            location.reload();
        });
    });

    $('#register-btn').on('click', function () {

        event.preventDefault();

        if (!app.validateFields([ nameInput, emailInput, passInput ])) {
            return;
        }

        var params = {
            "name": nameInput.val(),
            "email": emailInput.val(),
            "password": passInput.val()
        };

        app.submitForm("/rest/registration/register", params, function () {
            app.onSuccessSendUserForm(params);
            $('.register-success').show();

            // Refreshing page to login user
            setTimeout(location.reload, 2000);
        });
    });
});