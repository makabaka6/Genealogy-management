// 在页面加载完成之后
$(function () {
    $("#convert").click(function () {
        //获取输入框1的值
        var text_value = $("#password").val();

        ////获取输入框2的值
        var text1_value = $("#password1").val();
        if(text_value !=text1_value){
            //如果密码不一致
            alert("两次密码输入不一致，请重新输入");
            //清除密码框内容
            $("#password").val("");
            $("#password1").val("");
        }
        else {
            if(confirm("你确定要修改密码吗?")){
                alert("密码修改成功");
            }
        }
    })
})

