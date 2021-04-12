$(document).ready(function () {

    $.validator.addMethod("format", function (value, element, regularExpression) {
        var re = new RegExp(regularExpression)
        return this.optional(element) || re.test(value);
    });

    $('#form-dsbnnt').validate({
        rules: {
            timkiem: {
                required: true,
                format: "[A-Za-z]$",
            },

        },
        messages: {
            timkiem: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },

        },


    })

    $('#form-dtnt').validate({
        rules: {
            timkiem: {
                required: true,
                format: "[A-Za-z]$",
            },

        },
        messages: {
            timkiem: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },

        },



    })

    $('#form-qlhsba').validate({
        rules: {
            timkiem: {
                required: true,
                format: "[A-Za-z]$",
            },

        },
        messages: {
            timkiem: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },

        },


    })

    $('#form-qlns').validate({
        rules: {
            timkiem: {
                required: true,
                format: "[A-Za-z]$",
            },

        },
        messages: {
            timkiem: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },

        },


    })

    $('#form-qltl').validate({
        rules: {
            timkiem: {
                required: true,
                format: "[A-Za-z]$",
            },

        },
        messages: {
            timkiem: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },

        },


    })

    $('#form-qlttbn').validate({
        rules: {
            hoten: {
                required: true,
                format: "[A-Za-z]$",
            },
            sdthoai: {
                required: true,
                format: "[0-9]{10}",
            },
            diachi: {
                required: true,
                format: "[a-zA-Z0-9]",
            },
            kham: {
                required: true,
                format: "[a-zA-Z0-9]",
            },
            phongkham: {
                required: true,
                format: "[a-zA-Z0-9]",
            },
        },
        messages: {
            hoten: {
                format: "Không chứa số và kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },
            sdthoai: {
                format: "Không chứa chữ và kí tự đặc biệt!!!",
                required: "Không được để trống và đủ 10 số!!!"
            },
            diachi: {
                format: "Không chứa kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },
            kham: {
                format: "Không chứa kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },
            phongkham: {
                format: "Không chứa kí tự đặc biệt!!!",
                required: "Không được để trống!!!"
            },
        },



    })
});