let dataurl="";
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

    //
    $.post("findUserServlet",{},function (data) {
        //data格式:{uid:,username:}
        var msg="欢迎回来,"+data.username;
        $("#span_username").text(msg);
    })
    $("#fincreate").click(function(){
        var img = document.getElementById("write_image").value;
        var Sname =document.getElementById("write_sname").value;
        var name =document.getElementById("write_name").value;
        var jx =document.getElementById("write_jx").value;
        var big =document.getElementById("write_big").value;
        var intro =document.getElementById("write_intro").value;
        if(Sname.length==0)
        {
            alert("未输入家族姓名！");
        }
        else if(name.length==0)
        {
            alert("未输入族谱名称！");
        }
        else if(jx.length==0)
        {
            alert("未输入家训！");
        }
        else{
            // $.ajax({//提交族谱信息
			// 	url:"",
			// 	contentType:"application/json;charset=UTF-8",
			// 	type:"post",
			// 	data:'{}',
			// 	dataType: "json",
			// 	success:function(data)
			// 	{

			// 	}
			// })
        }

    })
    $("#write_big").on('input', function () {
        var inputedNum = $("#write_big").val().length;     
        var canInputNum = parseInt(500 - inputedNum);           //剩余可输入字数

        if (canInputNum > 0) {
            $(".error-desc1").html(canInputNum + "/500");
        } else {
            $(".error-desc1").html("0/500字");
            $('.error-desc1').val($('#input_textarea').val().substring(0, 500));    //当输入500字后 无法再输入
        }
    })
    $("#write_intro").on('input', function () {
        var inputedNum = $("#write_intro").val().length;   
        var canInputNum = parseInt(100 - inputedNum);           

        if (canInputNum > 0) {
            $(".error-desc2").html(canInputNum + "/100");
        } else {
            $(".error-desc2").html("0/100字");
            $('.error-desc2').val($('#input_textarea').val().substring(0, 100)); 
        }
    })
})
