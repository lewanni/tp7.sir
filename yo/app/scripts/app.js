'use strict';

/**
 * @ngdoc overview
 * @name yoApp
 * @description
 * # yoApp
 *
 * Main module of the application.
 */
angular
  .module('lolChampsAppp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  // Enlever le hash-bang :  passer de '#!' à '#' pour les href
  .config(['$locationProvider', function($locationProvider) {
        $locationProvider.hashPrefix('');
    }])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html'
      })
      .when('/champsList', {
        templateUrl: 'views/champsList.html',
        controller: 'champsListCtrl',
        controllerAs: 'champsList'
      })
      .when('/about', {
        templateUrl: 'views/about.html'
      })
      .when('/404', {
        templateUrl: 'views/404.html',
      })
      .otherwise({
        redirectTo: '/'
      });
  });
