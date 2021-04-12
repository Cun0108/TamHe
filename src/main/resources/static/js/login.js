$(document).ready(function() {

    $.validator.addMethod("format", function(value, element, regularExpression) {
        var re = new RegExp(regularExpression)
        return this.optional(element) || re.test(value);
    });

    $('#form-input').validate({
        rules: {
            Tendn: {
                required: true,
                format: "[A-Za-z0-9]{10,20}$",
            },
            Matkhau: {
                required: true,
            }
        },
        messages: {
            Tendn: {
                format: "Tên đăng nhập không chứa kí tự đặc biệt và dài từ 10 đến 20 kí tự!!!",
                required: "Tên đăng nhập không được để trống!!!"
            },
            Matkhau: {
                required: "Mật khẩu không được để trống!!!"
            }
        },
    })
});