/**
 * Created by ichoice on 2017/2/26.
 */
$(function () {
    $.ajax({
        type: "GET",
        url: "/department/getAll",
        data: {
        },
        success: function(data) {
           console.log(data);
        }
    });
})