$(document).ready(function () {
    if ($(".myAlert-top").find('span').text() == "")
        $(".myAlert-top").addClass("hide");
    $(".subscribeLink").on("click", function (e) {
        e.preventDefault();
        $(".myAlert-top").removeClass("hide");
        var topicId = $(this).attr('value');
        if ($(this).text() == "Subscribe") {
            $.post("/subscription/save", {
                "topic.topic_id": topicId,
                "seriousness": $("[name='seriousness" + topicId + "']").val()
            }, function (response) {
                if (response.status) {
                    $(".myAlert-top").addClass("alert-success").removeClass("alert-danger");
                    $(".myAlert-top").find('span').text(response.message);

                }
                else {
                    $(".myAlert-top").find('span').text(response.message);

                }
                $(window).scrollTop(0);
            })
        } else {
            $.ajax({
                    url: "/subscription/delete/" + topicId, type: "delete", success: function (response) {
                        if (response.status) {
                            $(".myAlert-top").addClass("alert-success").removeClass("alert-danger");
                            $(".myAlert-top").find('span').text(response.message);
                        }
                        else
                            $(".myAlert-top").find('span').text(response.message);
                        $(window).scrollTop(0);
                    }
                }
            )
        }
        $(".myAlert-top").addClass("show")
        setTimeout(function () {
            $(".navbar-brand")[0].click();
        }, 1000);
    })

    $("form[name='topicForm']").validate({
        rules: {
            name: {required: true},

        },
        messages:
            {
                name: "Please Enter Topic"
            },

        submitHandler: function (form) {
            form.submit();

        }

    });

});

