<p align="center">
<img width="350" alt="y" src="https://user-images.githubusercontent.com/62071683/85179170-93982080-b280-11ea-8033-9afe7238c044.jpg">
</p>

# Selenium - Cucumber Automatisation de test
Selenium-Cucumber est une approche de développement piloté par le comportement (Behavior-Driven Development BDD) pour écrire un script de test d'automatisation pour tester une application Web. 
Il vous permet d'écrire et d'exécuter des tests d'acceptation / unitaires automatisés. Il est multiplateforme, open source et gratuit. Automatisez vos cas de test avec un codage minimal.

# Documentation
- [ Document technique ](https://www.linkedin.com/feed/)
     - Installation
     - Etapes prédéfinies

# Installation (pré-requis)
- JDK 1.8+ (assurez-vous que le chemin d'accès aux classes Java est défini)
- Maven (assurez-vous que le chemin de classe .m2 est défini)
- Eclipse
- Eclipse Plugins pour
    - Maven
    - Cucumber
- Driver du navigateur (assurez-vous que le driver de navigateur souhaité et le chemin de classe sont définis)

# Framework mis en place

La solution proposée est "frwTNRWebGherkin" basée sur Selenium webdriver, cucumber et Junit.

- frw = framework
- TNR = Tests de Non-Régression
- Web= Application web
- Selinuim= Nom application
- Gherkin= Syntaxe Behavior Driven Development (BDD)

# Technologies et Environments 

- Selenium WebDriver Version 2.50.1
- Cucumber Version 1.2.4
- Junit Version 4
- ExtentReport Version 3.1.3
- Eclipse 2019-12
- JDK Version 1.8

# Synthèse Framework de test auto en BDD
- Approche agile
  - Approche BDD 
- Technologies
  - Cucumber 
    - [Cucumber-JVM pour le BDD](https://cucumber.io/docs/installation/java/#maven)
  - Webdriver pour les UI 
    - [La lib officielle / Selenium (en Java)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
  - Assertion 
    - [Assert (JUnit API)](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)
  - Report 
    - [Extent report](https://extentreports.com/)
  - Runtime 
    - [JUnit](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)
  - Langage de Scripting
      - JAVA
- Architecture / Structure
  - POM (Page Object Model)
  - features
  - stepDefinitions
  - pageObjects
  - reports
  
#  Où sont écrits les tests ?

Les tests sont écrits dans le repertoire src/spec/feature avec le syntaxe Gherkin
- Gherkin utilise un ensemble de mots clés spéciaux pour donner une structure et un sens aux spécifications exécutables. Gherkin permet d’écrire des scénarios de test compréhensibles par des individus non techniques. Cette approche sert deux objectifs : documenter les fonctionnalités à développer d’une part, et permettre l’automatisation des tests d’autre part.La plupart des lignes d'un document Gherkin commencent par l'un des mots clés:
  - Le “Given” mot-clé précède le texte définissant le contexte; l'état connu du système (ou condition préalable).
  - Le “When” mot-clé précède le texte définissant une action.
  - Le “Then” mot-clé précède le texte définissant le résultat de l'action sur le contexte (ou résultat attendu).
  
# Exécution des scénarios 
- Pré-requises 
   -	Télécharger Apache Maven .rar
   -	Dézipper le fichier Apache maven
   -	Mettre le fichier apache dans Variable d’environnement  
- Exécutez la commande suivante dans l'invite de commandes 
   -	mvn test
   -	mvn -DTest "nom de la classe dans le projet"



# Reporting 
Les résultats de test s’affichent dans un rapport Extent nommé Dartagnan.html dans le dossier Target / Cucumber-reports





