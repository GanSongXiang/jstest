/**
 * Created by ichoice on 2017/4/18.
 */
var height = $(window).height() > 445 ? $(window).height() : 445;
$("#container").height(height);
var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
$('#bd').css('padding-top', bdheight);
$(window).resize(function(e) {
    var height = $(window).height() > 445 ? $(window).height() : 445;
    $("#container").height(height);
    var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
    $('#bd').css('padding-top', bdheight);
});
$('select').select();

$('.loginButton').click(function(e) {
    document.location.href = "main.htm";
});