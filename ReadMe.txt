*************
* Prérequis *
*************

Pour les tests, nous avons créé une méthode permettant d'insérer des données dans le datastore.
Afin de vider le datastore et recharger ces données de tests, il faut faire un appel à la méthode :
DatastoreManager.recreate()
Cela ajoutera 3 users, 2 villes et 2 vols, permettant ainsi de tester les fonction de login, recherche de vols, création de vols, etc...

Un appel automatique a cette méthode peut être fait automatiquement en appellant l'URL de l'application jbb-flight.appspot.com/datastore
Cette action redirigera vers la page de login.

Les utilisateurs / mots de passe disponibles dans les données de test sont :
ben / ben (seul utilisateur avec les droits administrateur)
ju / ju
baddou / baddou

*********************
* Membres du groupe *
*********************

  o Benjamin Chastanier
  o Baptiste Gaujal
  o Julien Rouvier


****************
* URL Déployée *
****************

    Notre projet est accessible à l'URL :
    jbb-flight.appspot.com

************************
* Ce qui a été réalisé *
************************

  Enregistrement d'un utilisateur
        Formulaire d'ajout                                                                         OK
        Envoi de mail de confirmation avec mdp auto                                                OK
        Messager d'erreur en cas d'echec                                                           OK

  Améliroation du login
        Affecter un mdp auto à un nouvel utilisateur                                               OK                                                
        A la premiere auth demander le changement de mdp                                           OK

  Console d'administration - Selection d'une tache
        Page d'admin permettant à un utilisateur particulier de choisir son activité               NOK
        Date et durée de la dernière connexion de l'utilisateur                                    NOK

  Console d'administration - Page de gestion des utilisateurs
        Lister les utilisateurs courants et possibilité des les supprimer                          OK
        et de les ajouter                                                                          NOK
        Délégation de l'ajout d'un utilisateur à une tache sur le serveur                          OK
        Afficher la date de la derniere connexion de l'utilisateur                                 NOK
        Afficher la durée de la derniere connexion de l'utilisateur                                NOK

  Gestion des vols
        Page d'administration permettant de visualiser tous les vols enregistrés                
        Suppression du vol courant                                                                
        Page/zone d'ajout de vol                                                                   OK               
        Délégation de l'ajout d'un vol à une tache sur le serveur                                  NOK (systeme en place)

  Recherche d'un vol
        Zone de recherche avec formulaire de recherche                                             OK
        Zone d'affichage des vols  concerné par la recherche                                       OK

  Historique de navigation
        Enregister toutes les recherches dans le Datastore                                         NOK
        Page d'historique affichant la liste des recherches effectuées avec leur date              NOK
        Tache de type CRON permettant de supprimer toutes les recherches > à 2 min                 OK

  Pages
        Header - Nombre d'utilisateur actuellement connectés                                       NOK
        Header - Login de l'utilisateur actuellement connecté                                      ?
        Header - Lien vers l'historique des requêtes                                               ?

  Resrvation de vol (Optionnel)


*************************
* Ce qui a été commencé *
*************************

  Style CSS 
        Les styles n'ont pas été appliquée sur toutes les pages par manque de temps
  
