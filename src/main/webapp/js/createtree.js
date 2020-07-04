$(function(){
    var setting={
        treeid:"tree",
        data: {
            simpleData: {
              enable: true,  //true 、 false 分别表示 使用 、 不使用 简单数据模式
              idKey: "id",  //节点数据中保存唯一标识的属性名称
              pIdKey: "pid",    //节点数据中保存其父节点唯一标识的属性名称 
              rootPId: 0  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
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
var data=[
    {
        "id":1,
        "pid":0,
        "name":"一代01",
        "open":true
    },
    {
        "id":11,
        "pid":1,
        "name":"二代01"
    },
    {
        "id":12,
        "pid":1,
        "name":"二代02",
        "open":true
    },
    {
        "id":13,
        "pid":1,
        "name":"二代03"
    },
    {
        "id":14,
        "pid":1,
        "name":"二代04",
        "open":true
    },
    {
        "id":121,
        "pid":12,
        "name":"三代01"
    },
    {
        "id":122,
        "pid":12,
        "name":"三代02"
    },
    {
        "id":123,
        "pid":12,
        "name":"三代03"
    },
    {
        "id":141,
        "pid":14,
        "name":"三代04"
    },
    {
        "id":142,
        "pid":14,
        "name":"三代05"
    },
]

//初始化第一个树
$.fn.zTree.init($("#tree"),setting,data)


});