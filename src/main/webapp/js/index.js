let dataurl = "";
$(function() {
	let time = setInterval(function() {

		let ul = $(".container .swiper");
		ul.animate({
			marginLeft: "-100%"
		}, 1500, function() {
			ul.find("li").eq(0).appendTo(ul);
			// console.log(2);
			ul.css("marginLeft", 0);
		})
	}, 3000)
	$('#Button1').click(function() {
		console.log("选中Button");
		//获取到表单输入数据
		var inputCode = document.getElementById("validCode").value;
		var acount = document.getElementById("acount").value;
		var pwd = document.getElementById("pwd").value;
		//进行验证码的验证
		console.log(inputCode);
		if (inputCode.length <= 0) {
			$('.introduction', window.parent.document).css('visibility', 'visible');
		} else if (inputCode.toUpperCase() != code) {
			alert("验证码输入错误！");
			createCode(); //刷新验证码   
		} else { //验证成功进入登录验证
			var text = {
				"data": {
					"id": account,
					"password": pwd
				}
			}
			$.ajax({
				type: "POST",
				url: "",
				data: JSON.stringify(text),
				async: false,
				dataType: "text",
				success: function(data) {
					//登录成功进入主页面 不成功进行报错
					alert("ok");
				},
				error: function(data) {
					//未z
					alert("emm");
					console.log(data);
				}
			});
		}
	})
	$('.register').click(function() {
		var login = $('.login_frame');
		var register = $('.register_frame');
		login.css("visibility", "hidden");
		register.css("visibility", "visible");
	})
	$('.toinput').click(function() {
		var login = $('.login_frame');
		var register = $('.register_frame');
		login.css("visibility", "visible");
		register.css("visibility", "hidden");
	})
	$('#write_count').blur(function() {
		var name = document.getElementById("write_count").value;
		var text = {
			"data": {
				"name": name
			}
		}; //获取到输入的名字
		$.ajax({ //异步请求验证用户名是否存在
			type: "POST",
			url: "",
			data: JSON.stringify(text),
			async: true,
			dataType: "json",
			success: function(data) {
				var writeid = $('.writeid');
				// if(获取到数据的值)//当重复的时候
				// {
				// writeid.css("visibility","visivle");
				// }
				// else{//不重复的时候
				// 	writeid.css("visibility","hidden");
				// }
			},
			error: function(data) {
				//未获取到数据
				alert("emm?");
				console.log(data);
			}
		})
	})
	$('#Button2').click(() => {
		var name = document.getElementById("write_count").value;
		var write_pwd = document.getElementById("write_pwd").value;
		var write_pwd2 = document.getElementById("write_pwd2").value;
		if (write_pwd != write_pwd2) {
			alert('密码输入错误!');
		} else {
			var text = {
				"data": {
					"id": name,
					"password": write_pwd
				}
			}
			$.ajax({ //提交用户密码
				type: "POST",
				url: '',
				data: JSON.stringify(text),
				async: false,
				dataType: "json",
				success: function(data) {
					alert("注册成功!");
				},
				error: function(data) {
					//未获取到数据
					alert("emm?");
					console.log(data);
				}
			})
		}
	})
})
