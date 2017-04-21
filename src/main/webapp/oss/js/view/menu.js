/**
 * Created by ichoice on 2017/3/22.
 */
var alreadyOpenTableId = null;
var hrefBaseValue = null;

var basePath = "";
var SubImg = basePath + '/images/MenuIcon/menu_arrow_close.gif';
var SubImgOpen = basePath + '/images/MenuIcon/menu_arrow_open.gif';

function closeMenu() {
    if (alreadyOpenTableId == null) return;
    alreadyOpenTable = document.getElementById(alreadyOpenTableId); // document.all(alreadyOpenTableId);
    targetTableId = alreadyOpenTableId + "d";
    targetTable = document.getElementById(targetTableId); // document.all(targetTableId);
    targetTable.style.display = "none";
    alreadyOpenTableId = null;
}

function menuClick(topMenuDiv){
    $(".MenuLevel2").not( $(topMenuDiv).siblings("ul") ).hide();
    $(topMenuDiv).siblings("ul").toggle();
}

function subMenuClick(tableSrc) {
    subTableId = tableSrc.id+"d";
    subTable = document.getElementById(subTableId); // document.all(subTableId);
    var tableSrcImgId = tableSrc.id + "_img";
    var tableSrcImg = document.getElementById(tableSrcImgId); // document.all(tableSrcImgId);
    if (subTable != null) {
        if (subTable.style.display == "none") {
            subTable.style.display = '';
            tableSrcImg.src = SubImgOpen;
        } else {
            subTable.style.display = "none";
            tableSrcImg.src = SubImg;
        }
    }
}

function openPage(urlName) {
    var cfg =urlConfigList[urlName];
    if(cfg == null ) return;

    if("_blank" == cfg.target){
        // 第二个参数中不能有特殊字符，如"/"，否则会出错："参数无效"。
        var newWin = window.open(cfg.url, urlName);
        newWin.focus();
    }
    else if("desktop" == cfg.target){
        parent.desktop.location = cfg.url;
        parent.document.title = "Itcast OA - " + urlName;
    }
}

function st_onload() {
    return;
}

$(".level2Style").click(function () {
    var r=window.parent.document.getElementById('right');
    var jumpUrl=$(this).attr("jumpUrl");
    r.setAttribute("src",jumpUrl);
});

