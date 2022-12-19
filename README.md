# word-guessing-game
Le projet proposé est un jeu qui permet de définir d’abord deux noms de joueurs.

Une fois définis, un affichage arbitraire d’une question est fait. Chaque joueur aura à son tour à répondre à cette question en remplissant les espaces vides. Si la réponse est correcte il aura +1, sinon un 0.

Les caractères proposés à chaque fois peuvent être au début du mot, au milieu, à la fin etc. arbitraire aussi. Si le nombre de caractères dépasse 12, trois caractères seront proposés, si entre 9 et 12 deux caractères proposés sinon un seul caractère.

Le joueur qui atteint 10 le premier sera gagnant.

NB : l’ensemble des questions et des réponses associées peuvent être enregistrées dans un fichier XML que l’administrateur du jeu va alimenter via son espace.
Prière de soigner le design de votre jeu, avec aussi passage automatique au caractère suivant automatique après saisie

Exemple :
Question : Personne qui se consacre à la recherche scientifique

                            C-------R
                            
La bonne réponse est CHERCHEUR
