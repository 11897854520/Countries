$(document).ready(function(){
var arr = [];
   $.get("api/get_rus", function(country) {
      $.each(country, function(index, value) {
          arr.push("<li>"+ "<a class= 'link' href= '#'>"
             + value + "</a></li>");
   })
   $(".countries").append(arr.join(""))
    $(".show_link").on('click', function() {
         $(".countries").css('display', 'block');
         $(".countries_title").css('display', 'block');
         $(".show_link").css('display', 'none');
         $(".instruction_one").css('display', 'none');
         $(".instruction_two").css('display', 'none');
     })
      $(".link").on('click', function(e) {
              $.get("api/get_rus/" + this.text, function(description) {
                $(".description_title").css('display', 'block');
                $(".description").empty();
                $(".description").append(description).css("display", "block");
            })
        })
    })

   $(".eng_button").on('click',function() {
      var eng = [];
      $("h1").html("Countries of the world");
      $(".instruction_one").html("Push on the globe...");
      $(".instruction_two").html("to see the countries list!!!");
      $(".description_title").html("Description:");
      $(".countries_title").html("Choose a country:");
      $(".show").html("push").css('margin-left', '50px')

      $.get("api/get", function(country) {
           $.each(country, function(index, value) {
               eng.push("<li>"+ "<a class= 'link' href= '#'>"
                 + value + "</a></li>");
      })
      $(".countries").html(eng.join(""));
      $(".show_link").on('click', function() {
                  $(".countries").css('display', 'block');
                  $(".countries_title").css('display', 'block');
                  $(".show_link").css('display', 'none');
                  $(".instruction_one").css('display', 'none');
                  $(".instruction_two").css('display', 'none');
      })
      $(".link").on('click', function(e) {
                    $.get("api/get/" + this.text, function(description) {
                      $(".description_title").css('display', 'block');
                      $(".description").empty();
                      $(".description").append(description).css("display", "block");
           })
        })
     })
   })

   $(".rus_button").on('click', function() {
     $("h1").html("Страны мира");
     $(".instruction_one").html("Нажми на шарик...");
     $(".instruction_two").html("чтобы увидеть список стран!!!");
     $(".description_title").html("Описание:");
     $(".countries_title").html("Выберите страну:");
     $(".show").html("нажми").css('margin-left', '30px')
     $(".countries").html(arr.join(""))

     $(".show_link").on('click', function() {
           $(".countries").css('display', 'block');
           $(".countries_title").css('display', 'block');
           $(".show_link").css('display', 'none');
           $(".instruction_one").css('display', 'none');
           $(".instruction_two").css('display', 'none');
        })
     $(".link").on('click', function(e) {
            $.get("api/get_rus/" + this.text, function(description) {
            $(".description_title").css('display', 'block');
            $(".description").empty();
            $(".description").append(description).css("display", "block");
         })
      })
   })
})






