$(document).ready(function(){
      $("form[name='topicForm']").validate({
          rules:{
              name:{required:true},

          },
          messages:
              {
                  name:"Please Enter Topic"
              },

          submitHandler:function (form) {
              form.submit();
              
          }

      });

    });

