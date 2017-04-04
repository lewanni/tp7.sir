'use strict';

/**
 * @ngdoc function
 * @name yoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the yoApp
 */
angular.module('lolChampsAppp')
  .controller('champsListCtrl', function ($scope, $http) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    var lsChamps = [];
    // Obtenir tous les infos des champions à partir d'un json dispo dans une uri
    $http({
        method: 'GET',
        url: "rest/champions"}).then(function successCallback(response) {
          // Le json n'est pas bien trié, donc on va stocker tous les données
          // dans un tableau pour filter les objets par le nom
          $scope.version = response.data.version;
          for (var key in response.data.data) {
            lsChamps.push(response.data.data[key]);
          }
    });
    // On défnie un scope pour le tableau trié par le nom
    $scope.lsChamps = lsChamps;
    console.log($scope.lsChamps);

    // Obtenir tous les commentaires postés sur le site
    $http({
        method: 'GET',
        url: "rest/msg/all"}).then(function successCallback(response) {
          $scope.lsMsgs = response.data;
          console.log($scope.lsMsgs);
    });

  });
