/**
 * Created by ichoice on 2017/2/25.
 */

$("#loginBtn").click(function () {
    $.ajax({
        type: "POST",
        url: "/login",
        data: {
            login_name:"admin",
            login_pwd: "123456"
        },
        success: function(data) {
            if(data.data) {
                location.href = '/oss/index.htm'
            } else {
                alert("登录失败:" + data.msg);
            }
        }
    });
})
