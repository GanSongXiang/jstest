/**
 * Created by ichoice on 2017/4/19.
 */
$(function () {
    //创建jqGrid组件
    jQuery("#roleTable").jqGrid({
            url : '/role/getAll',//组件创建完成之后请求数据的url
            datatype : "json",//请求数据返回的类型。可选json,xml,txt
            colNames : [ '编号','姓名','描述','操作'],//jqGrid的列显示名字
            width:1000,
            colModel : [
                {name : 'id',index : 'id',width : 200,align : 'center'},
                {name : 'name',index : 'name',width : 200,align : 'center'},
                {name : 'description',index : 'description',width : 200,align : 'center'},
                {name : 'privilege',index : 'privilege',width : 200,align : 'center',formatter:function () {
                    return '<a style="color: red" href="/oss/role/setPrivilege.htm">修改权限</a>';
                }},
            ],
            pager : '#rolePager',//表格页脚的占位符(一般是div)的id
            sortname : 'id',//初始化的时候排序的字段
            sortorder : "desc",//排序方式,可选desc,asc
            mtype : "post",//向后台请求数据的ajax的类型。可选post,get
            viewrecords : true,
            prmNames:{page:"page",rows:"limit",sort:"sidx",order: "sord", search:"_search", nd:"nd",npage:null},
            multiselect:false,
            sortable:true,
            recordtext:"显示从第{0}条数据到第{1}条数据，共{2}条数据",
            pgtext:"第{0}页共{1}页",
            emptyrecords:"未找到数据",
            rowNum:10,
            rowList: [10, 20, 50,100,200,500],
            jsonReader : {
                root:"data.items",
                page: "data.page",
                total: "data.pages",
                records: "data.totalCount",
                repeatitems: false
            },
        });

    /*可以控制界面上增删改查的按钮是否显示*/
    jQuery("#roleTable").jqGrid('navGrid', '#rolePager', {
        edit : true,
        add : true,
        del : true,
        view :true,
        addfunc:openAdd,
        editfunc:openEdit,
        delfunc:openDel
    });
})

function openAdd() {
   location.href='/oss/role/saveRole.htm';
}

function openEdit() {
    var id=$('#roleTable').jqGrid('getGridParam','selrow');
    var role=jQuery("#roleTable").jqGrid('getRowData', id);
    sessionStorage.setItem("id",role.id);
    sessionStorage.setItem("name",role.name);
    sessionStorage.setItem("description",role.description);
    location.href='/oss/role/saveRole.htm';
}

function openDel() {
    var id=$('#roleTable').jqGrid('getGridParam','selrow');
    $.ajax({
        type: "GET",
        url: "/role/delete",
        data: {
            "id":id
        },
        success: function(data) {
            console.log(data);
            if(!data) {
                $("#roleTable").jqGrid('setGridParam',{  // 重新加载数据
                    page:1
                }).trigger("reloadGrid");
            } else {
                alert("删除岗位失败:" + data.msg);
            }
        }
    })
}

function privilegeEdit() {

}