$(document).ready(function () {

    $("[name='registrationUser']").validate({
        rules: {
            firstName: {
                required: true
            },
            lastName:
                {
                    required:true
                },

            email: {
                required: true,
                email: true
            },
            regisusername:
                {
                    required:true
                },
            regispassword:
                {
                    required:true
                },
            confirmpassword:
                {
                    required:true
                }

        },
        messages: {
            firstName:"First Name Can't be empty",
            lastName:"Last Name Can't be empty",
            regisusername:"Username Can`t be empty",
            regispassword:"Password Cnat be empty",
            confirmpassword:"Confirm Password cant be empty",

            email: {
                required: "Email Can't be empty",
                email: "Invalid Email.Please use proper email format"

            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });

    $("[name='loginform']").validate({
     rules: {
         username:
             {
                 required:true
             },
         password:
             {
                 required:true
             }


     },
        messages:
            {
                username:"Please Enter UserName",
                password:"Please Enter Password"
            },
        submitHandler: function (form) {
            form.submit();
        }

    });


});
