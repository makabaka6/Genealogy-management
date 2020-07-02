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
	$("#Button1").click(function(){
					//获取到表单输入数据
	                var inputCode = document.getElementById("validCode").value;
					var acount =document.getElementById("acount").value;
					var pwd =document.getElementById("pwd").value;
					//进行验证码的验证
	                if (inputCode.length <= 0) {
	                    $('.introduction', window.parent.document).css('visibility', 'visible');
	                }
	                else if (inputCode.toUpperCase() != code) {
						$("#login_msg").css("visibility","visible")
	                	$("#login_msg").html("验证码错误");
	                    createCode(); //刷新验证码   
	                } 
					else if(inputCode.toUpperCase() == code){
						//验证成功进入登录验证
						$("#login_msg").css("visibility","hidden")
					$.ajax({
						url:"user/login",
						contentType:"application/json;charset=UTF-8",
						type:"post",
						data:'{"uid":"'+acount+'","upassword":"'+pwd+'"}',
						dataType: "json",
						success:function(data)
						{
							//登录成功进入主页面
							if(data.flag==true){
								//进入主页面
								location.href="src\main\webapp\main.html"
							}
							// 登录失败
							if(data.flag==false){
								$("#login_msg").css("visibility","visible")
								$("#login_msg").html(data.errorMsg);
							}
						}
					})
					}
				})
				
	$('.register').click(function(){
		var login=$('.login_frame');
		var register=$('.register_frame');
		login.css("visibility","hidden");
		register.css("visibility","visible");
	})

	$('.toinput').click(function() {
		var login = $('.login_frame');
		var register = $('.register_frame');
		login.css("visibility", "visible");
		register.css("visibility", "hidden");
	})

	$('#write_count').blur(function(){
		var name = $("#write_count").val();

		 $.post("user/findNameIsExist",{username:name},function (data) {
		   if(data.flag==false){
			   $("#msg").css("visibility","visible")
		   	$("#msg").html(data.errorMsg)
		   }
		   if(data.flag==true){
			   $("#msg").css("visibility","hidden")
		   }
		},"json")
	})

    $("#Button2").click(function () {
		
		var name_value=document.getElementById("write_count").value;
		var write_pwd = document.getElementById("write_pwd").value;
		var write_pwd2 = document.getElementById("write_pwd2").value;

		if(write_pwd != write_pwd2)
		{
			alert('两次输入的密码不一致!');
		}
		else{
			$.ajax({//提交用户密码
				url:"user/register",
				contentType:"application/json;charset=UTF-8",
				type:"post",
				data:'{"uid":"'+name_value+'","upassword":"'+write_pwd+'"}',
				dataType: "json",
				success:function(data)
				{
					if(data.flag==true)
						alert("注册成功!");
					else {
						alert("注册失败，请联系管理员")
					}
				}
			})
		}
	}
	)
})
