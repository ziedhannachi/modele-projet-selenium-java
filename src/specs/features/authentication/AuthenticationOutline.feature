@authentificationOutline
Feature: Authentification -OrangeHRM
   ETQ utilisateur je me souhaite m'authentifier avec un scenario outline

  @outline
  Scenario Outline: Authentification avec un scenario outline
    Given je me connecte sur l'application OrangeHRM
    When je saisis le username "<username>"
    And je saisis le password "<password>"
    And je clique sur le boutton LOGIN

    #Then je me redirige vers la page home "Welcome"
    Examples: 
      | username | password |
      | Admin    | admin123 |
      | med      | admin111 |
