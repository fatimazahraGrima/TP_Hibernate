Exercice 1 : Gestion des Produits
--------------------------------------
Dans cet exercice, nous avons créé une application Java pour la gestion des produits en utilisant Hibernate pour la persistance des données et MySQL comme base de données.

Étapes du projet :
Création du projet :

Un projet Java sous NetBeans nommé "H1" a été créé, avec les bibliothèques Hibernate-JPA et le pilote MySQL ajoutés pour la gestion de la persistance.
Entité Produit :

L'entité Produit a été définie dans le package ma.projet.entity avec les annotations Hibernate appropriées (@Entity, @Id, @GeneratedValue, @Column, @Table).
Base de données :

Une base de données MySQL nommée "H1" a été créée pour stocker les informations sur les produits.
Configuration Hibernate :

Le fichier de configuration Hibernate, hibernate.cfg.xml, a été placé dans le package ma.projet.config pour configurer la connexion à la base de données.
Classe HibernateUtil :

Une classe HibernateUtil a été créée dans le package ma.projet.util pour générer une instance de la classe SessionFactory, permettant d’interagir avec la base de données.
Interface IDao :

Une interface IDao a été définie dans le package ma.projet.dao, pour gérer les opérations CRUD de manière générique.
Service ProduitService :

La classe ProduitService, située dans le package ma.projet.service, implémente l'interface IDao et fournit des méthodes spécifiques pour gérer les produits (ajout, suppression, modification, etc.).
Classe de test :

Une classe de test a été créée pour effectuer les opérations suivantes :
Création de cinq produits.
Affichage de la liste des produits.
Recherche du produit avec id = 2.
Suppression du produit avec id = 3.
Modification des informations du produit avec id = 1.
Affichage des produits dont le prix est supérieur à 100 DH.
Affichage des produits commandés entre deux dates saisies au clavier.

Exercice 2 : Gestion de Stock pour un Magasin de Vente de Produits Informatiques
----------------------------------------------------------------------------------
Dans cet exercice, nous avons développé une application pour la gestion de stock d’un magasin informatique en utilisant Hibernate pour la persistance des données et MySQL comme base de données.

Étapes du projet :
A. Couche Persistance
Classes entités :
Les classes entités correspondant aux produits, catégories, commandes et lignes de commandes ont été développées dans le package ma.projet.classes.
Fichier de configuration Hibernate :
Le fichier de configuration Hibernate hibernate.cfg.xml a été placé dans le package ma.projet.config pour gérer la connexion à la base de données.
Classe HibernateUtil :
La classe HibernateUtil a été ajoutée dans le package ma.projet.util pour instancier la classe SessionFactory et gérer la session Hibernate.
B. Couche Service
Interface IDao :

Une interface générique IDao a été créée dans le package ma.projet.dao pour gérer les opérations CRUD sur les entités.
Classes Services :

Les classes ProduitService, CategorieService, CommandeService et LigneCommandeService implémentent l’interface IDao dans le package ma.projet.service.
Méthodes de gestion des produits et commandes :

Méthode pour afficher la liste des produits par catégorie.
Méthode pour afficher la liste des produits commandés entre deux dates.
Méthode pour afficher les produits commandés dans une commande spécifique.
Méthode pour afficher la liste des produits dont le prix est supérieur à 100 DH en utilisant une requête nommée.
Programmes de tests :

Des programmes de test ont été créés pour vérifier les fonctionnalités de l'application, comme l'affichage des produits par catégorie, les produits commandés entre deux dates, et les produits commandés dans une commande.

Exercice 3 : Application de Gestion de Projet
--------------------------------------------------

Cet exercice porte sur la création d’une application de gestion de projet permettant d’imputer le temps passé dans un projet à son coût global.

Étapes du projet :
A. Couche Persistance
Classes entités :

Les classes entités pour gérer les projets, les tâches, les employés et les relations entre employés et tâches ont été développées dans le package ma.projet.classes.
Fichier de configuration Hibernate :

Le fichier hibernate.cfg.xml est situé dans le package ma.projet.config pour configurer Hibernate avec la base de données.
Classe HibernateUtil :

Une classe HibernateUtil a été créée dans le package ma.projet.util pour initialiser la connexion à la base de données via Hibernate.
B. Couche Service
Interface IDao :

L’interface générique IDao a été définie dans le package ma.projet.dao pour effectuer les opérations CRUD sur les entités.
Classes Services :

Les classes ProjetService, TacheService, EmployeService et EmployeTacheService implémentent l’interface IDao et gèrent respectivement les projets, les tâches, les employés et les liens entre employés et tâches.
Méthodes de gestion des projets et tâches :

Méthode pour afficher la liste des tâches réalisées par un employé.
Méthode pour afficher la liste des projets gérés par un employé.
Méthode pour afficher les tâches planifiées pour un projet.
Méthode pour afficher la liste des tâches réalisées dans un projet.
Méthode pour afficher les tâches dont le prix est supérieur à 1000 DH en utilisant une requête nommée.
Méthode pour afficher la liste des tâches réalisées entre deux dates.
Programmes de tests :

Des programmes de test ont été développés pour valider les fonctionnalités du projet, comme l’affichage des tâches réalisées par un employé, les projets gérés, et les tâches réalisées dans un projet donné.
