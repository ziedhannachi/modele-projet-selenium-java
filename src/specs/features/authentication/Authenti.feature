@authentification
Feature: Authentification - OrangeHRM
  ETQ utilisateur je souhaite m'authentifier

  @cnx-cas-passant
  Scenario: Tester l'interface de connexion
    Given je me connecte sur l'application OrangeHRM
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le boutton LOGIN
    Then je me redirige vers la page home "Welcome"
