# TP7 SIR : Interface Web

## Objectif
  Le but de ce TP est de construire une interface Web pour notre application développée en Java côté serveur.

## Description/Organisation du projet
* Le projet est composé de deux parties.
* En Back-End : 
	- Il y a tout ce qui est géré par Java, JPA et JaxRS pour récupérer les données depuis une base données hsqldb et les affichées dans des URI, tournés sur un serveur local Tomcat7
	- Il y a 2 services de lecture, qui seront utilisés par les services $httpget AngularJs :
		* 1 pour importer un fichier json local et le rendre disponible dans une URI
		* 1 pour afficher en json dans une URI les données présentes dans la base de données hsqldb.
	- Il y a 1 service d'écriture pour récupérer les informations saisies depuis le site et les stockées en tant qu'entité persistante dans JPA
* En Front-End : 
	- Il y a 2 frameworks : AngularJs et Bootstrap
	- On a 2 controllers AngularJs : 
		* 1 controller pour afficher sur le site les données du json importé localement disponibles dans une URI
		* 1 controller pour afficher sur le site les données du json qui correspondent aux données de hsqldb disponibles dans une URI
 
## Informations complémentaires
- Ayant mal compris au départ le sujet du tp7, où il fallait normalement réutiliser les classes persistantes du tp2 de opower, nous sommes conscient que ce projet est moins lourd avec un modèle simple par rapport à ce qui est prévu, vu qu'on est parti de zéro et de notre imagination.
 - Le fichier json présent dans le projet vient du site [Riot Developer Portal](https://developer.riotgames.com/) (il faut être joueur dans le jeu League of Legends pour avoir accès au site api de développement)
	
## Technologies utilisées
* Java
* JPA
* Jersey : framework JaxRS RESTful Web Services (pas besoin de servlet c'est pratiquement la même chose mais en mieux)
* HTML5
* AngularJs v1.6.4 : framework JavaScript
* Bootstrap : framework CSS

## Outils de dévelopment
* [Eclipse Java](https://eclipse.org/)
* [Maven](https://maven.apache.org)
* [Tomcat7](http://tomcat.apache.org/)
* [HSQLDB](http://hsqldb.org/)
* [Atom](https://atom.io/)
* [NodeJS v7.7.1](https://nodejs.org/en/)
* [Npm v4.1.2](https://www.npmjs.com/)
* [Yeoman](http://yeoman.io/) 

## Tuturiel sous Windows 7 pour lancer l'application Web
- Pré-requis : avoir installé tous les outils de dévelopment cités ci-dessus
- Télécharger ou cloner ce dépôt git :

      git clone https://github.com/lewanni/tp7.sir
                       
- Back-End : 
  * Sur Eclipse ou autres IDE Java, importer ce dépôt git en tant que projet Maven
  * Une fois importer, faite un clean install, un update et un refresh du projet Maven
  * Ouvrer un cmd et exécuter le fichier "run-hsqldb-server.bat" qui se trouve à la racine du projet maven
  * Retour sur votre IDE, lancer votre application en tant que que maven build... : "tomcat7:run"
- Front-End :
  * Il manque 2 dossiers dans ce dépôt git et qui sont indispensables pour faire fonctionner le site en local "bower_components" et "node_modules". Nous allons donc devoir les regénérer en suivant ces étapes suivantes.
  * Créer un dossier au hasard sur votre disque dur et positionner vous dans ce dossier depuis un cmd
  * Dans ce dossier et depuis un cmd, exécuter les commandes suivantes :
    * npm install -g yo grunt-cli bower (si c'est la 1ère fois que vous utilisez npm)
    * npm install -g generator-angular (si c'est la 1ère fois que vous utilisez npm)
		* yo angular :
      - Réponder No concernant Gulp au lieu de Grunt
        - Réponder No concernant l'utilisation de Sass
        - Réponder Yes concernant l'utilisation de Bootstrap
        - Cocher toutes les cases concernant les modules angular
    * npm install grunt-connect-proxy --save-dev
  * Une fois que toute les commandes sont exécutées, copier 2 dossiers "bower_components" et node_modules et coller les dans le dossier "yo" qui se trouve à la racine du projet maven.
  * Lancer un cmd depuis le dossier yo et exécuter la commande : grunt serve
  * L'application web devrait se lancer sur votre navigateur à l'adresse : http://localhost:9000/
