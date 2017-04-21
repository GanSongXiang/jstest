/**
 * Created by ichoice on 2017/4/19.
 */
//获取所有岗位
function getAllRole(){
    $.ajax({
        type: "POST",
        url: "/role/getAll",
        data: {
        },
        success: function(data) {
            console.log(data);
            if(data.data) {

            } else {
                alert("岗位获取失败:" + data.msg);
            }
        }
    });
}

$(function () {
    //创建jqGrid组件
    jQuery("#roleTable").jqGrid(
        {
            url : '/role/getAll',//组件创建完成之后请求数据的url
            datatype : "json",//请求数据返回的类型。可选json,xml,txt
            colNames : [ '编号','姓名','描述' ],//jqGrid的列显示名字
            width:1000,
            colModel : [
                {name : 'id',index : 'id',width : 200,align : 'center'},
                {name : 'name',index : 'name',width : 200,align : 'center'},
                {name : 'description',index : 'description',width : 200,align : 'center'}
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
            pagerpos:"left",
            rowNum:10,
            rowList: [10, 20, 50,100,200,500],
            jsonReader : {
                root:"data.items",
                page: "data.page",
                total: "data.pages",
                records: "data.totalCount",
                repeatitems: false
            }
        });

})