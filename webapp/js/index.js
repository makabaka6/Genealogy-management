$(function(){
    let time = setInterval(function () {
  
        let ul = $(".container .swiper");
        ul.animate({
            marginLeft: "-100%"
        }, 1500, function () {
            ul.find("li").eq(0).appendTo(ul);
            // console.log(2);
            ul.css("marginLeft", 0);
        })
    }, 3000)
    $()
})