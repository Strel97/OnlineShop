var Rest = (function() {
    return {
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

        getData: function (url, callback) {
            $.ajax({
                type: 'GET',
                contentType: 'application/json; charset=utf-8',
                dataType: "json",        
                url: url,
                success: function (data, status, jqXHR) {
                    if (data.errors) {            
                        return;
                    }
        
                    callback && callback( data );
                },
                error: function (jqXHR, status) {            
                }
            });
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
        }
    }
})();