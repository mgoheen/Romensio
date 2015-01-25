OVERVIEW:
Romensio is a made up game in which the objective is to eliminate adjacent sequences of numbers in a matrix that add up to 10. Each move corresponds to eliminating one such sequence of numbers adding to 10 from within the matrix. After each move, any gaps that are left in the matrix are filled in with "falling" numbers from above. This continues until all possible combinations of 10 have been found from within the matrix. 

The matrices are squares but can be of any size n. The user can use a variety of different command line arguments as specified by the table below. The user can create random matrices with specified sizes or specific matrices from a given text file.

EXAMPLE OUTPUT ON A RANDOM 4x4 MATRIX:

Creating a random 4x4 matrix...

Initial Matrix:
2 5 8 7 
4 2 1 7 
5 4 4 1 
6 4 1 2 
Move 1:
  5 8 7 
  2 1 7 
5   4 1 
6 4 1 2 
After Numbers Fall on Move 1:
    8 7 
  5 1 7 
5 2 4 1 
6 4 1 2 
Move 2:
    8 7 
    1 7 
  2 4 1 
6 4 1 2 
After Numbers Fall on Move 2:
    8 7 
    1 7 
  2 4 1 
6 4 1 2 
Move 3:
      7 
      7 
  2 4   
6 4 1 2 
After Numbers Fall on Move 3:
        
      7 
  2 4 7 
6 4 1 2 
Move 4:
        
      7 
  2 4   
6 4     
After Numbers Fall on Move 4:
        
        
  2     
6 4 4 7 
Move 5:
        
        
  2     
    4 7 
After Numbers Fall on Move 5:
        
        
        
  2 4 7 

Solution Matrix:
        
        
        
  2 4 7 

Remaining Numbers: 3
Total Moves: 5

Argument: Details
[No Arguments]: Creates a random matrix between 3x3 and 11x11 with every move outputted
-v:	Creates a random matrix between 3x3 and 11x11 with no moves outputted
[Text File]: Creates a matrix from a text file with every move outputted
[Text File] –v: Creates a matrix from a text file with no moves outputted
r [number]: Creates a random matrix with dimensions specified by [number] and outputs every move
r [number] -v: Creates a random matrix with dimensions specified by [number] and outputs no in-between moves.

