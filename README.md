# word-guessing-game
## context
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

## Features
La barre de menu contient :
- un menu fichier qui permet de rejouer le jeu ou de quitter
- un menu pour les regles
- un menu pour ajouter des questions
- chaque question ajoutée aura un id unique et automatiquement incrementé.

lorsque on ouvre le jeu :
- on trouve un screenslpash
- puis, la fenetre pour saisir les noms des joueurs s’ouvre avec une musique.
- Le boutton ok ne va pas marcher si on remplie les deux cases des noms(il affiche un message pour remplir les cases vides)

Ensuite la fenetre du jeu s’ouvre.
- Chaque joueur va jouer mais avec un temps limittant 15 secondes.
- Si il depasse le temps un message apparait indiquant ceux-ci.
- Le joueur peut egalement de skip la question ou de give up.
- Le score se change chaque fois.
- Si le score egale a 10 il s’affiche le gagnant.
- Le curseur automatiquement s’avance.
## Résultat
![image](https://user-images.githubusercontent.com/96595695/208979925-cbf7700b-3e2a-4caf-9a5b-643da588a6f0.png)
![image](https://user-images.githubusercontent.com/96595695/208980047-38f65a3b-64b2-4277-a867-6c160b7055e7.png)
![image](https://user-images.githubusercontent.com/96595695/208980156-37a7a258-447b-432c-8d90-560da9e148e8.png)
- le message si la question est ajoutée

![image](https://user-images.githubusercontent.com/96595695/208980181-f66928d8-4247-40c4-bd59-69babe031c6e.png)
![image](https://user-images.githubusercontent.com/96595695/208980203-5dd57f73-4976-46ad-8b21-ed6b6865ad2b.png)
![image](https://user-images.githubusercontent.com/96595695/208980289-9d0afcac-e4c7-4017-a483-c1a0c2fec271.png)
![image](https://user-images.githubusercontent.com/96595695/208980323-d30bad5e-0884-444e-aede-34e35f887cc5.png)
![image](https://user-images.githubusercontent.com/96595695/208980346-07017e44-f8bc-4a21-89bd-f2e3ca8e8d6c.png)
- Le message si la réponse est vraie :

![image](https://user-images.githubusercontent.com/96595695/208980491-905e44ab-3f40-4566-9617-ad2747daeaff.png)
- Le message si la réponse est fausse :

![image](https://user-images.githubusercontent.com/96595695/208980563-6c47eba3-46ab-4d2d-81fe-c57ce7b401e2.png)
- Le message si le score atteint 10, ou le joueur give up :

![image](https://user-images.githubusercontent.com/96595695/208980674-d4774d36-4cf0-4ead-bb65-8d47e26d0312.png)
- Le message si le temps est atteint 15 secondes :

![image](https://user-images.githubusercontent.com/96595695/208980726-b404d56f-75ce-408f-b84c-a21782493e0c.png)



