/**
 * Main class for managing REST queries and application.
 * Written as Singleton to use only one particular instance
 * in any other class.
 *
 * @author strel
 */
var Application = (function () {
    // Private properties
    var user = new User();
    var productAPI = new ProductAPI();
    var sellerAPI = new SellerAPI();

    return {
        goToMainPage: function () {
            window.location = "index.html";
        },

        goToLoginPage: function () {
            window.location = "login.html";
        },

        getUser: function () {
            return user;
        },

        getProductAPI: function () {
            return productAPI;
        },

        getSellerAPI: function () {
            return sellerAPI;
        },

        submitForm: function (url, params, successFunc) {
            var self = this;

            $.ajax({
                type: 'POST',
                contentType: 'application/json; charset=utf-8',
                dataType: "json",
                data: JSON.stringify(params),
                url: url,
                success: function (data, status, jqXHR) {
                    if (data.errors) {
                        self.onErrorSendUserForm(data.errors);
                        return;
                    }

                    self.onSuccessSendUserForm();
                    successFunc && successFunc(data);
                },
                error: function (jqXHR, status) {
                    self.onErrorSendUserForm(params);
                }
            });
        },

        validateFields: function (fields) {
            var self = this;
            var validated = true;

            $.each(fields, function (index, field) {
                if (field.value === "") {
                    self.showInputError($("#" + field.id), "Can't be empty!");
                    validated = false;
                }
            });

            return validated;
        },

        onSuccessSendUserForm: function (params) {
            $.each(params, function (field) {
                $('#' + field).val("");
            });
        },

        onErrorSendUserForm: function (errors) {
            var self = this;

            $.each(errors, function (field, error) {
                self.showInputError($('#' + field), error);
            });

            return false;
        },

        /**
         * Shows error message in specified field.
         * @param inputField    Field where error should be printed.
         * @param errorMsg      Error message.
         */
        showInputError: function (inputField, errorMsg) {
            var wrongValue = inputField.val();
            var basePlaceholder = inputField.attr('placeholder') ? inputField.attr('placeholder') : '';

            inputField.val('').attr('placeholder', errorMsg);
            inputField.parent().addClass('has-error');
            inputField.focus(function () {
                inputField.val(wrongValue);
                inputField.attr('placeholder', basePlaceholder);
                inputField.parent().removeClass('has-error');
            })
        },


        /**
         * APPLICATION functions for cookies management.
         */

        setCookie: function (name, value, expires_days) {
            var d = new Date();
            d.setTime(d.getTime() + (expires_days * 24 * 60 * 60 * 1000));
            var expires = "expires=" + d.toUTCString();
            document.cookie = name + "=" + value + ";" + expires + ";path=/";
        },

        getCookie: function (cookie_name) {
            var name = cookie_name + "=";
            var decodedCookie = decodeURIComponent(document.cookie);
            var ca = decodedCookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
    };
})();
