# Word Guessing Game
## Context
The proposed project is a game that starts by defining two player names.

Once the names are defined, an arbitrary question is displayed. Each player takes their turn to answer the question by filling in the blank spaces. If the answer is correct, they earn +1 point; otherwise, they receive 0 points.

The characters proposed each time can be at the beginning of the word, in the middle, at the end, etc. It is arbitrary as well. If the number of characters exceeds 12, three characters will be proposed; if it's between 9 and 12, two characters will be proposed; otherwise, only one character.

The player who reaches 10 points first will be the winner.

Note: all questions and their associated answers can be saved in an XML file that the game administrator will update through their space. Please pay attention to the design of your game, with an automatic transition to the next character after input.

Example:
Question: A person dedicated to scientific research

                            C-------R
                            
The correct answer is "RESEARCHER."

## Features
The menu bar contains:
- A file menu that allows you to replay the game or exit.
- A rules menu.
- A menu for adding questions.
- Each added question will have a unique and automatically incremented ID.

When you open the game:
- You will find a splash screen.
- Then, the window for entering the player names opens with music.
- The OK button will not work if both name fields are empty (it displays a message to fill in the empty fields).

Next, the game window opens.
- Each player will play with a time limit of 15 seconds.
- If they exceed the time, a message will appear indicating this.
- The player can also choose to skip the question or give up.
- The score changes each time.
- If the score reaches 10, the winner is displayed.
- The cursor automatically advances.

## Result
![image](https://user-images.githubusercontent.com/96595695/208979925-cbf7700b-3e2a-4caf-9a5b-643da588a6f0.png)
![image](https://user-images.githubusercontent.com/96595695/208980047-38f65a3b-64b2-4277-a867-6c160b7055e7.png)
![image](https://user-images.githubusercontent.com/96595695/208980156-37a7a258-447b-432c-8d90-560da9e148e8.png)
- Message if a question is added

![image](https://user-images.githubusercontent.com/96595695/208980181-f66928d8-4247-40c4-bd59-69babe031c6e.png)
![image](https://user-images.githubusercontent.com/96595695/208980203-5dd57f73-4976-46ad-8b21-ed6b6865ad2b.png)
![image](https://user-images.githubusercontent.com/96595695/208980289-9d0afcac-e4c7-4017-a483-c1a0c2fec271.png)
![image](https://user-images.githubusercontent.com/96595695/208980323-d30bad5e-0884-444e-aede-34e35f887cc5.png)
![image](https://user-images.githubusercontent.com/96595695/208980346-07017e44-f8bc-4a21-89bd-f2e3ca8e8d6c.png)
- Message if the answer is correct:

![image](https://user-images.githubusercontent.com/96595695/208980491-905e44ab-3f40-4566-9617-ad2747daeaff.png)
- Message if the answer is wrong:

![image](https://user-images.githubusercontent.com/96595695/208980563-6c47eba3-46ab-4d2d-81fe-c57ce7b401e2.png)
- Message if the score reaches 10 or the player gives up:

![image](https://user-images.githubusercontent.com/96595695/208980674-d4774d36-4cf0-4ead-bb65-8d47e26d0312.png)
- Message if the 15-second time limit is reached:

![image](https://user-images.githubusercontent.com/96595695/208980726-b404d56f-75ce-408f-b84c-a21782493e0c.png)
