
$(function() {

    var app = Application;
    var user = app.getUser();

    var emailInput = $('#email');
    var nameInput = $('#nickname');
    var passInput = $('#password');

    
    function loginAndRedirect() {
        // Login user
        user.login(emailInput.val(), passInput.val(), function( loggedIn ) {        
            // If logged in go to main page
            loggedIn && app.goToMainPage();
        });
    }


    // Click handler for login / registration toogle button
    $('.message a').on('click', function () {
        $('.toggle').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    // Login button click handler
    $('#login-btn').on('click', function ( event ) {

        event.preventDefault();

        if (!app.validateFields([ emailInput, nameInput ])) {
            return;
        }
        
        loginAndRedirect();
    });

    // Registration button click handler
    $('#register-btn').on('click', function () {

        event.preventDefault();

        if (!app.validateFields([ nameInput, emailInput, passInput ])) {
            return;
        }

        var registered = user.register(emailInput.val(), passInput.val(), nameInput.val(), function( registered ) {
            // If user was successfully registered, show message and login him after few seconds.
            if (registered) {
                $('.register-success').show();

                // Login and redirect user to main page after 2 seconds
                setTimeout(loginAndRedirect, 2000);
            }
        });        
    });
});