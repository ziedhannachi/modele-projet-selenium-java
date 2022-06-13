@buzz
Feature: Post un message  dans le whats in your mind - OrangeHRM
  ETQ utilisateur connecter je souhaite de faire une post

  Background: 
    Given je me connecte sur l'application OrangeHRM
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le boutton LOGIN

  @post
  Scenario: post un msg dans what is in your mind
    #And je clique sur le menu buzz
    And je saisis le message "seleniumformation"
    And je clique sur le boutton post
    Then je verife que mon post est bien afficher "seleniumformation"

  @upload-image-buzz
  Scenario: Upload image
    #When je clique sur le menu buzz
    And Je clique sur le menu Uplaod images
    #And Je clique sur le boutton Upload images
   # And Je saisis un message "chart of result" dans le champ say something about these photos
   # And Je clique sur le boutton Post-picture
  #  Then Je verifie si le message "chart of result" et l'image sont bien parmis la liste des upload images
