$(function(){
    //当前节点的所有信息
    var id1;var fid1=0;var name1; var fname1;var sex1;var birth1;var sex1; var spose1;
    var id2;var fid2;var name2; var fname2;var sex2;var birth2;var sex2; var spose2;
    
    var data=[//data是存储数据信息的json
        
    ];
   
    //ztree设置信息配置
    var setting={
        treeid:"tree",
        data: {
            simpleData: {
              enable: true,  //true 、 false 分别表示 使用 、 不使用 简单数据模式
              idKey: "id",  //节点数据中保存唯一标识的属性名称
              pIdKey: "fid",    //节点数据中保存其父节点唯一标识的属性名称 
              rootPId: 0  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
            }
        },
        check: {
            enable: false,
            chkStyle: "checkbox"//显示 checkbox 选择框，默认checkbox可选择值radio
        },
        callback:{
            onClick:zTreeOnClick
        }
    }
    

//初始化树
$.fn.zTree.init($("#tree"),setting,data);
//判断树是否拥有信息
if(data.length==0)//录入人数为0的时候
{
    $(".none").css("visibility","visible");
    document.getElementById("fname").value="您未选中任何成员";
}
else if(data.length!=0){
    $(".none").css("visibility","hidden");
}
//获取到节点函数，在右侧显示出节点信息
function zTreeOnClick(event, treeId, treeNode) {
    
    fid1=treeNode.id;
    document.getElementById("name").value=null;
    $("input[name='sex']:checked").val("");
    $("#birth").val("");
    $("#spose").val("");
    document.getElementById("fname").value=fid1;
    //选中后点击资料按钮时
    var len=data.length;
        for(var i=0;i<len;i++){
            if(data[i].id==fid1){
                name2=data[i].name;
                sex2=data[i].sex;
                birth2=data[i].birth;
                fid2=data[i].fid;
                spose2=data[i].spose;

                if(data[i].fid==0){
                fname2="无父辈记录";}
                else{
                    for(var i=0;i<len;i++){
                        if(data[i].id==fid2)
                        {
                            fname2=data[i].name;
                        }
                    }
                }
            }
        }
        
        

} 
 
//点击按钮 提交信息修改data.json
$("#button").click(function(){
    $(".none").css("visibility","hidden");
    //对data进行修改
    if(data.length==0)
    {
        id1=1;
        fid1=0;
        name1=document.getElementById("name").value;
        sex1=$("input[name='sex']:checked").val();
        birth1=$("#birth").val();
        spose1=$("#spose").val();
        if(name1.length==0 || birth1.length==0 || spose1.length==0)
        {
            $(".alert").css("visibility","visible");
        }
        else{
            $(".alert").css("visibility","hidden");
        }
        data.push({
            "fid":fid1,
            "id":id1,
            "name":name1,
            "sex":sex1,
            "birth":birth1,
            "spose":spose1,
            "open":true
        })
        $.fn.zTree.init($("#tree"),setting,data);
    }
    else{
        //获取到当前data的长度
        var len=data.length;
        
        var num=0;//统计该元素有几个一级子元素
        for(var i=0;i<len;i++){
            if(data[i].fid==fid1){
                num++;
            }
        }
        
        if(num==0)
        {
            id1=fid1*10+num+1;
        }
        id1=fid1*10+num+1;
        name1=document.getElementById("name").value;
        sex1=$("input[name='sex']:checked").val();
        birth1=$("#birth").val();
        spose1=$("#spose").val();
        data.push({
            "fid":fid1,
            "id":id1,
            "name":name1,
            "sex":sex1,
            "birth":birth1,
            "spose":spose1,
            "open":true
        })
        // $.fn.zTree.init($("#tree"),setting,data);
        console.log(data);
        $.fn.zTree.init($("#tree"),setting,data);
    }
    
})
$.fn.zTree.init($("#tree"),setting,data);

$(".button2").click(function(){
    document.getElementById("mess_name").innerText=name2;
    document.getElementById("mess_sex").innerText=sex2;
    document.getElementById("mess_birth").innerText=birth2;
    document.getElementById("mess_father").innerText=fname2;
    document.getElementById("mess_spose").innerText=spose2;
    $(".button2").css("background-color","rgba(245,245,245,0.4)");
    $(".button1").css("background-color","rgba(245,245,245,0)");
    $(".zp2").css("background-position","0px -67px");
    $(".zp1").css("background-position","0 -398.7px");
    $(".messagebox1").css("visibility","visible");
    $(".messagebox2").css("visibility","hidden")
})
$(".button1").click(function(){
    $(".button1").css("background-color","rgba(245,245,245,0.4)");
    $(".button2 ").css("background-color","rgba(245,245,245,0)");
    $(".zp2").css("background-position","0 -466.2px")
    $(".zp1").css("background-position","0 0px")
    $(".messagebox2").css("visibility","visible");
    $(".messagebox1").css("visibility","hidden")
}) 
});