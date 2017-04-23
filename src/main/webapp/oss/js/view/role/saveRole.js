/**
 * Created by 踏月留香 on 2017/4/22.
 */
function addRole() {
    var n=$("#roleName").val();
    var d=$("#roleDescription").val();
    $.ajax({
        type: "POST",
        url: "/role/add",
        data: {
            name:n,
            description:d
        },
        success: function(data) {
            console.log(data);
            if(!data) {
                location.href = '/oss/role/role.htm'
            } else {
                alert("登录失败:" + data.msg);
            }
        }
    });
}

function showData() {
    var roleId=sessionStorage.getItem("id");
    $("#roleName").val(sessionStorage.getItem("name"));
    $("#roleDescription").val(sessionStorage.getItem("description"));
}

$(function () {
    showData();
});

function operaRole() {
    if(sessionStorage.getItem("id")){
        editRole(sessionStorage.getItem("id"));
    }else{
        addRole();
    }
}

function editRole(id) {
    var n=$("#roleName").val();
    var d=$("#roleDescription").val();
    $.ajax({
        type: "POST",
        url: "/role/edit",
        data: {
            id:id,
            name:n,
            description:d
        },
        success: function(data) {
            console.log(data);
            if(!data) {
                sessionStorage.removeItem("id");
                location.href = '/oss/role/role.htm'
            } else {
                alert("登录失败:" + data.msg);
            }
        }
    });
}