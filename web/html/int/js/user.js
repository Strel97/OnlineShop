
function User() {
    this.email = "";
    this.nickname = "";
    this.token = "";
}

User.prototype.isLoggedIn = function(callback) {
    var self = this;

    // If no token, then user is not authenticated
    if (!self.token) {
        self.token = Cookie.getCookie('token');
        callback( self.token && self.token.length > 0 );
        return;
    }

    Rest.submitForm('rest/auth/authenticated', self.token, function(response) {
        callback( response.results['authenticated'] );
    });
};

User.prototype.login = function(email, password, callback) {
    var self = this;
    
    if (!email || !password) {
        callback( false );
        return;
    }

    var params = {
        "email": email,
        "password": password
    };

    Rest.submitForm('rest/auth/login', params, function( response ) {
        Cookie.setCookie("token", response.results['token']);

        self.token = response.results['token'];
        self.email = email;
        self.password = password;
    
        callback( true );
    });
};

User.prototype.register = function(email, password, nickname, callback) {
    var self = this;

    if (!email || !password || !nickname) {
        callback( false );
        return;
    }

    var params = {
        "name": nickname,
        "email": email,
        "password": password
    };

    Rest.submitForm("rest/registration/register", params, function () {
        self.nickname = nickname;
        self.email = email;
        self.password = password;

        callback( true );
    });
};

User.prototype.logout = function() {
    var self = this;

    var params = {
        "email": self.email,
        "password": self.password
    };

    Rest.submitForm('rest/auth/logout', params, function() {
        self.email = "";
        self.password = "";
        self.token = "";

        window.location = "/login.html";
    });
};