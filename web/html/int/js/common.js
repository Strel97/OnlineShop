
function Application() {
}

Application.prototype.submitForm = function (url, params, successFunc) {
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
            successFunc && successFunc();
        },
        error: function (jqXHR, status) {
            self.onErrorSendUserForm(params);
        }
    });
};

Application.prototype.validateFields = function (fields) {
    var self = this;
    var validated = true;

    $.each(fields, function (index, field) {
        if (field.value === "") {
            self.showInputError($("#" + field.id), "Can't be empty!");
            validated = false;
        }
    });

    return validated;
};

Application.prototype.onSuccessSendUserForm = function(params) {
    $.each(params, function (field) {
        $('#' + field).val("");
    });
};

Application.prototype.onErrorSendUserForm = function(errors) {
    var self = this;

    $.each(errors, function (field, error) {
        self.showInputError($('#' + field), error);
    });

    return false;
};

/**
 * Shows error message in specified field.
 * @param inputField    Field where error should be printed.
 * @param errorMsg      Error message.
 */
Application.prototype.showInputError = function(inputField, errorMsg) {
    var wrongValue = inputField.val();
    var basePlaceholder = inputField.attr('placeholder') ? inputField.attr('placeholder') : '';

    inputField.val('').attr('placeholder', errorMsg);
    inputField.parent().addClass('has-error');
    inputField.focus(function() {
        inputField.val(wrongValue);
        inputField.attr('placeholder', basePlaceholder);
        inputField.parent().removeClass('has-error');
    })
};
