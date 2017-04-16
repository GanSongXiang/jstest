require.config({
    paths: {
        "jquery": "jquery/jquery-3.1.1.min",
        // angular
        "angular": "http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js",

        // angular-ui
        "angular-ui-router": "angular-ui-router/release/angular-ui-router",
    },
    shim: {
        // angular
        "angular": {
            exports: "angular"
        },
    }
})

// bootstrap
define(["angular"], function(angular) {
    var stateProvider = null;
    var registerRoutes = function($stateProvider, $urlRouterProvider) {
        stateProvider = $stateProvider;
        registerNoJsPage("building");
        //注册状态 registerPage(状态名称，html中的监视地址，要替换的ui-view视图名 默认为""，视图地址,controller js的位置)

    };

    //注册未知页面
    function registerNoJsPage(stateName) {
        registerPage(stateName, "/" + stateName + ".html", null, "/oss/" + stateName + ".htm", "/oss/js/view/none.js");
    }

    //注册状态 registerPage(状态名称，html中的监视地址，要替换的ui-view视图名 默认为""，视图地址,controller js的位置)
    function registerPage(stateName, watchUrl, uiViewName, viewUrl, controllerJs) {
        if(uiViewName == null) {
            uiViewName = "";
        }
        var viewSetting = {
            templateUrl: viewUrl
        };
        var viewsObject = {};
        viewsObject[uiViewName] = viewSetting;
        try {
            stateProvider.state(stateName, angularAMD.route({
                url: watchUrl,
                controllerUrl: controllerJs,
                views: viewsObject

            }));
        } catch(e) {
            console.log(e.message);
        }
    }

});