$(function(){
    var setting={
        data: {
            simpleData: {
              enable: true,  //true 、 false 分别表示 使用 、 不使用 简单数据模式
              idKey: "id",  //节点数据中保存唯一标识的属性名称
              pIdKey: "parentId",    //节点数据中保存其父节点唯一标识的属性名称 
              rootPId: -1  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
            //             },
            //   key: {
            //       name: "menuName"  //zTree 节点数据保存节点名称的属性名称  默认值："name"
            //        }
            }
        },
        check: {
            enable: false,
            chkStyle: "checkbox"//显示 checkbox 选择框，默认checkbox可选择值radio
        }
    }
    
var zTreeNodes=[
{"name":"一代01","open":true,children:[
    {"name":"二代01"},
    {"name":"二代02","open":true,children:[
        {"name":"三代01"},
        {"name":"三代02"},
        {"name":"三代03"}
    ]},
    {"name":"二代03"},
    {"name":"二代04","open":true,children:[
        {"name":"三代04"},
        {"name":"二代05"}
    ]}
]}
];
var city = $.fn.zTree.init($("#tree"), setting, zTreeNodes);    
//第一个参数为zTree的DOM容器，第二个为zTree设置详情可见官网api,第三个为zTree的节点数据 
});