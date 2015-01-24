OVERVIEW:
Romensio is a made up game in which the objective is to eliminate adjacent sequences of numbers in a matrix that add up to 10. Each move corresponds to eliminating one such sequence of numbers adding to 10 from within the matrix. After each move, any gaps that are left in the matrix are filled in with "falling" numbers from above. This continues until all possible combinations of 10 have been found from within the matrix. 

The matrices are squares but can be of any size n. The user can use a variety of different command line arguments as specified by the table below. The user can create random matrices with specified sizes or specific matrices from a given text file.

EXAMPLE OUTPUT ON A RANDOM 3x3 MATRIX:

Creating a random 3x3 matrix...

Initial Matrix:
1 8 5 
7 5 6 
5 4 8 
Move 1:
1 8   
7   6 
5 4 8 
After Numbers Fall on Move 1:
1     
7 8 6 
5 4 8 
Move 2:
1     
7 8   
5   8 
After Numbers Fall on Move 2:
1     
7     
5 8 8 

Solution Matrix:
1     
7     
5 8 8 

Remaining Numbers: 5
Total Moves: 2

NumberOfArguments	Argument		Details
0   				[None]			Creates a random matrix between 3x3 and 11x11 with every move outputted
1					-v				Creates a random matrix between 3x3 and 11x11 with no moves outputted
1					[Text File]		Creates a matrix from a text file with every move outputted
2					[Text File] 	–v	Creates a matrix from a text file with no moves outputted
2					r [number] 		Creates a random matrix with dimensions specified by [number] and outputs every move
3					r [number] -v	Creates a random matrix with dimensions specified by [number] and outputs no in-between moves.

