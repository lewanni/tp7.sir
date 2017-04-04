'use strict';

/**
 * @ngdoc function
 * @name champsListCtrl
 * @description
 * Controller de la page Liste des champions
 * Tous les infos des champions proviennent du fichier json dans le dossier json
 */
angular.module('lolChampsApp')
  .controller('champsListCtrl', function ($scope, $http) {

    var lsChamps = [];
    // Obtenir tous les infos des champions à partir d'un json dispo dans une uri
    // L'uri est dispo grâce à la partie Java en faisant tourné le serveur Tomcat7
    $http({
        method: 'GET',
        url: "rest/champions"}).then(function successCallback(response) {
          $scope.version = response.data.version;
          // Le json n'est pas bien trié, donc on va stocker tous les données
          // dans un tableau pour filter les objets par le nom
          for (var key in response.data.data) {
            lsChamps.push(response.data.data[key]);
          }
    });
    // On défnie un scope pour le tableau trié par le nom
    $scope.lsChamps = lsChamps;
  });
