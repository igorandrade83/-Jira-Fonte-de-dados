var cronappModules = [
    'ionic',
    'ui.router',
    'ngResource',
    'ngSanitize',
    'custom.controllers',
    'custom.services',
    'datasourcejs',
    'pascalprecht.translate',
    'tmh.dynamicLocale',
    'ui-notification',
    'ngFileUpload',
    'angularMoment'
]

if (window.customModules) {
    cronappModules = cronappModules.concat(window.customModules);
}


var app = (function() {

    return angular.module('MyApp', cronappModules)
        .constant('LOCALES', {
            'locales': {
                'pt_br': 'Portugues (Brasil)',
                'en_us': 'English'
            },
            'preferredLocale': 'pt_br'
        })
        .run(function($ionicPlatform) {
            $ionicPlatform.ready(function() {
                // Remove splash screen
                setTimeout(function() {
                    if (navigator.splashscreen) {
                        navigator.splashscreen.hide();
                    }
                }, 100);
                // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
                // for form inputs)
                if (window.cordova &&
                    window.cordova.plugins && window.cordova.plugins.Keyboard) {
                    cordova.plugins.Keyboard
                        .hideKeyboardAccessoryBar(true);
                    cordova.plugins.Keyboard.disableScroll(true);

                }
                if (window.StatusBar) {
                    // org.apache.cordova.statusbar required
                    StatusBar.styleDefault();
                }
            });
        })
        .config([
            '$httpProvider',
            function($httpProvider) {
                var interceptor = [
                    '$q',
                    '$rootScope',
                    function($q, $rootScope) {
                        var service = {
                            'request': function(config) {
                                var _u = JSON.parse(localStorage.getItem('_u'));
                                if (_u && _u.token) {
                                    config.headers['X-AUTH-TOKEN'] = _u.token;
                                    window.uToken = _u.token;
                                }
                                return config;
                            }
                        };
                        return service;
                    }
                ];
                $httpProvider.interceptors.push(interceptor);
            }
        ])
        .config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
            $ionicConfigProvider.navBar.alignTitle('center')
        })
        .config(function($stateProvider, $urlRouterProvider, NotificationProvider) {
            NotificationProvider.setOptions({
                delay: 5000,
                startTop: 20,
                startRight: 10,
                verticalSpacing: 20,
                horizontalSpacing: 20,
                positionX: 'right',
                positionY: 'top'
            });

            if (window.customStateProvider) {
                window.customStateProvider($stateProvider);
            }
            else {
                // Set up the states
                $stateProvider

                    .state('main', {
                        url: "",
                        cache: false,
                        controller: 'InitialController',
                        templateUrl: ''
                    })

                    .state('login', {
                        url: "/app/login",
                        cache: false,
                        controller: 'LoginController',
                        templateUrl: 'views/login.view.html'
                    })

                    .state('publicRoot', {
                        url: "/public/{name:.*}",
                        cache: false,
                        controller: 'PageController',
                        templateUrl: function (urlattr) {
                            return 'views/public/' + urlattr.name + '.view.html';
                        }
                    })

                    .state('public', {
                        url: "/app/public",
                        cache: false,
                        controller: 'PublicController',
                        templateUrl: 'plugins/cronapp-framework-mobile-js/dist/components/templates/publicMenu.template.html'
                    })

                    .state('public.home', {
                        url: "/home",
                        cache: false,
                        views: {
                            'menuContent': {
                                controller: 'PublicController',
                                templateUrl: 'views/public/home.view.html'
                            }
                        }
                    })
                    .state('public.pages', {
                        url: "/{name:.*}",
                        cache: false,
                        views: {
                            'menuContent': {
                                controller: 'PageController',
                                templateUrl: function (urlattr) {
                                    return 'views/public/' + urlattr.name + '.view.html';
                                }
                            }
                        }
                    })

                    .state('app', {
                        url: "/app/logged",
                        cache: false,
                        controller: 'HomeController',
                        templateUrl: 'plugins/cronapp-framework-mobile-js/dist/components/templates/menu.template.html'
                    })

                    .state('app.home', {
                        url: "/home",
                        cache: false,
                        views: {
                            'menuContent': {
                                controller: 'HomeController',
                                templateUrl: 'views/logged/home.view.html'
                            }
                        }
                    })

                    .state('app.pages', {
                        url: "/{name:.*}",
                        cache: false,
                        views: {
                            'menuContent': {
                                controller: 'PageController',
                                templateUrl: function (urlattr) {
                                    return 'views/logged/' + urlattr.name + '.view.html';
                                }
                            }
                        }
                    })

                    .state('404', {
                        url: "/error/404",
                        cache: false,
                        controller: 'PageController',
                        templateUrl: function (urlattr) {
                            return 'views/error/404.view.html';
                        }
                    })

                    .state('403', {
                        url: "/error/403",
                        cache: false,
                        controller: 'PageController',
                        templateUrl: function (urlattr) {
                            return 'views/error/403.view.html';
                        }
                    });
            }
            // For any unmatched url, redirect to /state1
            $urlRouterProvider.otherwise("/error/404");
        })

        .config(function($translateProvider, tmhDynamicLocaleProvider) {

            $translateProvider.useMissingTranslationHandlerLog();

            $translateProvider.useStaticFilesLoader({
                prefix: 'i18n/locale_',
                suffix: '.json'
            });

            $translateProvider.registerAvailableLanguageKeys(
                ['pt_br', 'en_us'], {
                    'en*': 'en_us',
                    'pt*': 'pt_br',
                    '*': 'pt_br'
                }
            );

            var locale = (window.navigator.userLanguage || window.navigator.language || 'pt_br').replace('-', '_');

            $translateProvider.use(locale.toLowerCase());
            $translateProvider.useSanitizeValueStrategy('escaped');

            tmhDynamicLocaleProvider.localeLocationPattern('plugins/angular-i18n/angular-locale_{{locale}}.js');
        })

        .directive('crnValue', ['$parse', function($parse) {
            return {
                restrict: 'A',
                require: '^ngModel',
                link: function(scope, element, attr, ngModelCtrl) {
                    var evaluatedValue;
                    if (attr.value) {
                        evaluatedValue = attr.value;
                    } else {
                        evaluatedValue = $parse(attr.crnValue)(scope);
                    }

                    element.attr("data-evaluated", JSON.stringify(evaluatedValue));
                    element.bind("click", function(event) {
                        scope.$apply(function() {
                            ngModelCtrl.$setViewValue(evaluatedValue);
                            $(element).data('changed', true);
                        }.bind(element));
                    });

                    scope.$watch(function(){return ngModelCtrl.$modelValue}, function(value, old){
                        if (value !== old) {
                            var dataEvaluated = element.attr("data-evaluated");
                            var changed = $(element).data('changed');
                            $(element).data('changed', false);
                            if (!changed) {
                                if (value && JSON.stringify(''+value) == dataEvaluated) {
                                    $(element)[0].children[0].checked = true
                                } else {
                                    $(element)[0].children[0].checked = false;
                                }
                            }
                        }
                    });
                }
            };
        }])

        .decorator("$xhrFactory", [
            "$delegate", "$injector",
            function($delegate, $injector) {
                return function(method, url) {
                    var xhr = $delegate(method, url);
                    var $http = $injector.get("$http");
                    var callConfig = $http.pendingRequests[$http.pendingRequests.length - 1];
                    if (angular.isFunction(callConfig.onProgress))
                        xhr.upload.addEventListener("progress",callConfig.onProgress);
                    return xhr;
                };
            }
        ])

        .run(function($rootScope, $state) {
            $rootScope.$on('$stateChangeError', function() {
                if (arguments.length >= 6) {
                    var requestObj = arguments[5];
                    if (requestObj.status === 404 || requestObj.status === 403) {
                        localStorage.removeItem('_u');
                        $state.go('login');
                    }
                } else {
                    $state.go('404');
                }
            });
            $rootScope.$on('$stateChangeSuccess', function() {
                setTimeout(function() {

                    $($('.icon.ion-plus-round').parent()).off('click');
                    $($('.icon.ion-plus-round').parent()).on('click',function() {
                        $('[required]').removeClass('input-validation-error');
                        $('input:invalid').removeClass('input-validation-error');
                    });

                    $($('.icon.ion-checkmark').parent()).off('click');
                    $($('.icon.ion-checkmark').parent()).on('click',function() {
                        $('[required].ng-invalid-required, [required].ng-invalid, [required].ng-empty').addClass('input-validation-error');
                        $('input:invalid').addClass('input-validation-error');
                    });

                    $('input').off('keydown')
                    $('input').on('keydown', function() {
                        $(this).removeClass('input-validation-error');
                    });

                }, 300);

            });
        });

}(window));

app.userEvents = {};

//Configuration
app.config = {};
app.config.datasourceApiVersion = 2;
app.config.defaultRoute = "/app";

app.bindScope = function($scope, obj) {
    var newObj = {};

    for (var x in obj) {
        // var name = parentName+'.'+x;
        // console.log(name);
        if (typeof obj[x] == 'string')
            newObj[x] = obj[x];
        else if (typeof obj[x] == 'function')
            newObj[x] = obj[x].bind($scope);
        else {
            newObj[x] = app.bindScope($scope, obj[x]);
        }
    }

    return newObj;
};

app.registerEventsCronapi = function($scope, $translate, $ionicModal, $ionicLoading) {
    for (var x in app.userEvents)
        $scope[x] = app.userEvents[x].bind($scope);

    $scope.vars = {};

    try {
        if (cronapi) {
            $scope['cronapi'] = app.bindScope($scope, cronapi);
            $scope['cronapi'].$scope = $scope;
            $scope['cronapi'].$scope.$ionicModal = $ionicModal;
            $scope['cronapi'].$scope.$ionicLoading = $ionicLoading;

            $scope.safeApply = safeApply;
            if ($translate) {
                $scope['cronapi'].$translate = $translate;
            }
        }
    } catch (e) {
        console.info('Not loaded cronapi functions');
        console.info(e);
    }
    try {
        if (blockly)
            $scope['blockly'] = app.bindScope($scope, blockly);
    } catch (e) {
        console.info('Not loaded blockly functions');
        console.info(e);
    }
};

window.safeApply = function(fn) {
    var phase = this.$root.$$phase;
    if (phase == '$apply' || phase == '$digest') {
        if (fn && (typeof(fn) === 'function')) {
            fn();
        }
    } else {
        this.$apply(fn);
    }
};