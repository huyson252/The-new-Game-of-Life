# The-new-Game-of-Life

# Introduction

	Welcome to the New Game Of Life Playground!
	Here you can play different versions of the famous Conway's game

## Four different themes are provided in our game: 
### Rainbow 
the color of one cell is directly and only determined by its “age”. There is a choice between three types of color effect: yellow to red, cyan to green and magenta to blue - from young to old cells. The colors are interesting as you can observe easily to what extent a cell survives and grows “older”. Most of the time, if a cell is old enough to reach the maximum age, it is part of a stable pattern.
### Corona
the living cell is characterized by its image and not its color. This version is quite different from the others while the principle is the same. The cells considered “alive” in this version are the cells infected, which will develop and spread in the board. The difference in this version is that you can set up other types of cells before launching the game (they are still considered dead cells in the main rules but they interact with infected cells). Human cells are targets for infected cells: if the infected cells get in the cells occupied by human, he dies. Confined cells are ignored in the game, infected cells cannot occupy those cells. The number of specific cells is limited, you can either win or lose if human cells remain. In this version the evolution of cells reminds us of the real biological evolution of bacteria culture. 
### Classic
the living cell is black color and the dead cell is white. It is the very classic version with no additional features than the others, we decided to do it at the end because we really enjoyed the aesthetic aspect and the minimalism of the game.
### Immigration
you can choose the color of each cell with no restriction thanks to a Colorchooser. The particular rule is that every new-born cell must be of the average color of its three “parents”. The blending of colors when launching the game is pretty interesting and could modelize the blending of genes intra species.

## Special functionality: there is a repository of special patterns ready to be initialized on the playground - each one of them can generate interesting shapes and behaviors!

# Content of the file
	
java class:	
- /Cell.java - define the cell (a JButton) and its state
- /Corona.java - IHM class for the corona mode, is linked to the Menu, can open frame Rules and pattern
- /Immigration -IHM class for the immigration mode, is linked to the Menu, can open frame Rule and Pattern
- /Menu.java - IHM class for the menu, is linked to the three modes, can also open frame Rule
- /Menutest.java - Main class to be executed, opens the frame Menu
- /Pattern - IHM class which can be opened in the three modes, linked to playground (is used to insert pattern in the grill)
- /Playground.java - use directly Cell to create a table of JButton Cell, form the grill on which the player will play, all three modes depend on it.
- /Rainbow - IHM class for the Rainbow mode, is linked to the Menu, can open frame Rules and pattern
- /Rules - IHm class which can be opened from the three modes and from Menu, describe the rules in the three modes

images used:
- /backgroundacceuil.jpg - background Image Panel for Menu
- /backgroundcorona.png - background Image Panel for Corona mode 
- /bgimmigration.jpg - background Image Panel for immigration mode
- /bgrainbow.jpg - background Image Panel for rainbow mode
- /bohommemort.png - image used for a certain time for the purpose of an animation in corona mode (original drawing)
- /bonhommevivant.png - image used in corona mode (JButton + color of a cell) original drawing
- /buttonclearcorona.png - used as a button in corona mode to clear playground 
- /buttonclearimm.png - used as a button in immigration mode to clear playground 
- /buttonclearrainbow.png - used as a button in rainbow mode to clear playground 
- /buttonhomecorona.png -used as a button in corona mode to return to Menu
- /buttonhomeimm.png -used as a button in immigration mode to return to Menu
- /buttonhomepurple.png -used as a button in rainbow mode to return to Menu
- /buttonpatternimm.jpg - used as a button in immigration mode to open pattern frame
- /buttonpausecorona.png - used as a button in corona mode to pause the ongoing game
- /buttonpauseimm.jpg -used as a button in immigration mode to pause the ongoing game
- /buttonpausered.png -used as a button in rainbow mode to pause the ongoing game
- /buttonplaycorona.png -used as a button in corona mode to start the game
- /buttonplayimm.png -used as a button in immigration mode to start the game
- /buttonplayorange.png -used as a button in rainbow mode to start the game
- /buttonrulesimm.jpg - used as a button in immigration mode to open rule frame
- /caseblockedcorona.png -image used in corona mode (JButton + color of a cell) original drawing
- /corona.png - image used in corona mode (JButton + color of a cell) and Menu to access corona mode (original drawing)
- /logoimmigration.png - used in Menu as a jbutton to access immigration mode (original drawing)
- /next.png -used as a button to access page 2 of rules
- /next1.png -used as a button to access page 2 of pattern
- /nextc.png -used as a button to access page 3 of rules
- /nextr.png -used as a button to access page 4 of rules
- /nexti.png -used as a button to access page 5 of rules
- /pannelcorona.png - background ImagePanel for pannelcommand corona
- /pannelslider.png - panel background for slider in rainbow 
- /patternsprincipal.JPG - background ImagePanel pattern frame 
- /previous1.png -used as a button to access page 1 of pattern
- /previousc.png -used as a button to access page 1 of rules
- /previousi.png -used as a button to access page 3 of rules
- /previousr.png -used as a button to access page 2 of rules
- /previousbw.png -used as a button to access page 4 of rules
- /rainbowlogo.png -used in Menu as a jbutton to access rainbow mode (original drawing)
- /rainbowpannel.jpg -background ImagePanel for pannelcommand rainbow
- /rulesacceuil.png - used as a button to access rule's frame from menu's frame
- /rulespage1.JPG - background JPanel in rule's frame
- /rulespage2.png -background JPanel in rule's frame
- /rulespage3.JPG -background JPanel in rule's frame
- /rulespage4.JPG -background JPanel in rule's frame
- /rulespage5.png -background JPanel in rule's frame
- /bluetomagenta.png -button mode 3 in Rainbow
- /buttonclearbw.png - button clear in Classic mode
- /buttonhomebw.png - button home in Classic mode
- /buttonpausebw.png - button pause in Classic mode
- /buttonplaybw.png -button play in Classic mode
- /buttonplaybw2.png -image used for blinking in Classic mode
- /buttonplaycorona2.png -image used for blinking in Corona
- /buttonplayimm2.png -image used for blinking in immigration
- /buttonplayorange2.png -image used for blinking in rainbow
- /colorchooser.png - button linked to a cooler chooser in immigration
- /greentocyan.png - button mode 2 in Rainbow
- /redtoyellow.png -button mode 1 in Rainbow
- /logobw.jpg - button in menu which leads to classic mode's frame
- /menumusic.wav - music files which is launched when menu is opened
- /white.png - image for dead cells in corona mode
- /asymetric.JPG -pattern
- /beacon.JPG -pattern
- /butterfly.JPG -pattern
- /expandingheart.JPG -pattern
- /exploder.JPG -pattern
- /glider.JPG -pattern
- /lightweightspaceship.JPG -pattern
- /loaf.JPG -pattern
- /original.JPG -pattern
- /R-pentomino.JPG -pattern
- /ship.JPG -pattern
- /smallexploder.JPG -pattern
- /toad.JPG -pattern
- /trafficlight.JPG -pattern
- /tumbler.JPG -pattern
	
## File Pattern
- /pattern1.txt -files.txt to describe and insert patterns
- /pattern2.txt -files.txt to describe and insert patterns
- /pattern3.txt -files.txt to describe and insert patterns
- /pattern4.txt -files.txt to describe and insert patterns
- /pattern5.txt -files.txt to describe and insert patterns
- /pattern6.txt -files.txt to describe and insert patterns
- /pattern7.txt -files.txt to describe and insert patterns
- /pattern8.txt -files.txt to describe and insert patterns
- /pattern9.txt -files.txt to describe and insert patterns
- /pattern10.txt -files.txt to describe and insert patterns
- /pattern11.txt -files.txt to describe and insert patterns
- /pattern12.txt -files.txt to describe and insert patterns
- /pattern13.txt -files.txt to describe and insert patterns
- /pattern14.txt -files.txt to describe and insert patterns
- /pattern15.txt -files.txt to describe and insert patterns

## Related Documents
- /ProjectreportGOLminiproject.pdf - report for the project
- /UMLdiagramGOL - UML diagram of GOL mini project (format png and STAR UML)
- /readme.text - this file

# Instruction 

-Compile all .java files 
-Execute the main class : Menutest.java

# About 

Algo mini-project, Scan 73, INSA Lyon, 2020
Authors: Huy Tran, Elise Piette, Ata Fidan

