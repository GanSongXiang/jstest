/**
 * Created by 踏月留香 on 2017/4/23.
 */
// 选择所有
function selectAll(checkedValue){
    $("input[type=checkbox][name=resourceIdList]").attr("checked", checkedValue);
}

function doChecked( liID, checkedValue ){
    // 当前点击的checkbox元素所在的li元素
    var jLi = $("#" + liID);

    // 选中所有的直属下级。（children()方法是筛选下一级，find()是筛选所有后代）
    jLi.children("ul").find("input[type=checkbox]").attr("checked", checkedValue);

    // 选中或取消选中直属上级
    if( checkedValue ){ // checkedValue是boolean型，表示是否选中了当前复选框
        // 如果当前是选中，则选中所有的直属上级
        jLi.parents("li").children("input[type=checkbox]").attr("checked", checkedValue);
    }else{
        // 如果当前是取消选中，并且同级中没有被选中的项，则也取消上级的选中状态
        var jCheckedSibingCB = jLi.siblings("li").children("input[type=checkbox]:checked");
        if(jCheckedSibingCB.size() == 0){
            var jCheckboxInput = jLi.parent("ul").prev("label").prev("input[type=checkbox]");
            jCheckboxInput.attr("checked", checkedValue);

            // 递归操作每一层直属上级
            var jParentLi = jCheckboxInput.parent("li");
            if(jParentLi.size() > 0){
                doChecked(jParentLi.attr("id"), checkedValue);
            }
        }
    }
}

$(function(){
    $("#tree").treeview();
});