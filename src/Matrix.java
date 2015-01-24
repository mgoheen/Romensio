import java.util.ArrayList;
import java.io.*;

// -------------------------------------------------------------------------
/**
 * Contains Matrix Data
 *
 * @author Michael Goheen
 * @version Jan 31, 2012
 */
public class Matrix
{
    // Matrix Information
    private int[][] matrix;
    private int     matrixSize;
    private int     moves   = 0;
    private boolean verbose = true;


    // ----------------------------------------------------------
    /**
     * Create a new random matrix object
     */
    public Matrix()
    {
        matrixSize = (int)(Math.random() * 9 + 3);
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++)
        {
            for (int j = 0; j < matrixSize; j++)
            {
                matrix[i][j] = (int)(Math.random() * 9 + 1);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Create a random Matrix with a defined size.
     *
     * @param matrixSize
     */
    public Matrix(int matrixSize)
    {
        setMatrixSize(matrixSize);
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++)
        {
            for (int j = 0; j < matrixSize; j++)
            {
                matrix[i][j] = (int)(Math.random() * 9 + 1);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Create a new Matrix object from a file.
     *
     * @param file
     */
    public Matrix(File file)
    {
        matrixSize = 0;
        try
        {
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            String[] splitLine = new String[4];
            int i = 0;
            int count = 0;
            while ((line = br.readLine()) != null)
            {
                if (count == 0)
                {
                    splitLine = line.split(" ");
                    matrixSize = Integer.parseInt(splitLine[0]);
                    matrix = new int[matrixSize][matrixSize];
                    count++;
                }
                else
                {
                    splitLine = line.split(" ");
                    for (int j = 0; j < matrixSize; j++)
                    {
                        matrix[i][j] = Integer.parseInt(splitLine[j]);
                    }
                    i++;
                }

            }
            in.close();
        }
        // Catch exception if any
        catch (Exception e)
        {
            System.err.println("Error Getting Input from File: "
                + e.getMessage());
            System.exit(0);
        }

    }


    // ----------------------------------------------------------
    /**
     * Create a new Matrix object with specified values.
     *
     * @param matrix
     * @param matrixSize
     */
    public Matrix(int[][] matrix, int matrixSize)
    {
        setMatrix(matrix);
        setMatrixSize(matrixSize);
    }


    // ----------------------------------------------------------
    /**
     * Find adjacent matrix elements
     *
     * @param i
     * @param j
     * @return ArrayList of matrix elements
     */
    public ArrayList<MatrixElement> getAdjacentElements(int i, int j)
    {
        ArrayList<MatrixElement> matrixElements =
            new ArrayList<MatrixElement>();
        // Look at elements not on the matrix boundaries
        if (i != 0 && j != 0 && i != matrix.length - 1
            && j != matrix.length - 1)
        {
            matrixElements.add(new MatrixElement(
                i - 1,
                j - 1,
                matrix[i - 1][j - 1]));
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(
                i - 1,
                j + 1,
                matrix[i - 1][j + 1]));
            matrixElements.add(new MatrixElement(i, j - 1, matrix[i][j - 1]));
            matrixElements.add(new MatrixElement(i, j + 1, matrix[i][j + 1]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j - 1,
                matrix[i + 1][j - 1]));
            matrixElements.add(new MatrixElement(i + 1, j, matrix[i + 1][j]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j + 1,
                matrix[i + 1][j + 1]));
        }
        // Look at elements on bottom boundary
        else if (i == matrix.length - 1 && j != 0 && j != matrix.length - 1)
        {
            matrixElements.add(new MatrixElement(
                i - 1,
                j - 1,
                matrix[i - 1][j - 1]));
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(
                i - 1,
                j + 1,
                matrix[i - 1][j + 1]));
            matrixElements.add(new MatrixElement(i, j - 1, matrix[i][j - 1]));
            matrixElements.add(new MatrixElement(i, j + 1, matrix[i][j + 1]));
        }
        // Look at elements on left boundary
        else if (i != 0 && i != matrix.length - 1 && j == 0)
        {
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(
                i - 1,
                j + 1,
                matrix[i - 1][j + 1]));
            matrixElements.add(new MatrixElement(i, j + 1, matrix[i][j + 1]));
            matrixElements.add(new MatrixElement(i + 1, j, matrix[i + 1][j]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j + 1,
                matrix[i + 1][j + 1]));
        }
        // Look at elements on right boundary
        else if (i != 0 && i != matrix.length - 1 && j == matrix.length - 1)
        {
            matrixElements.add(new MatrixElement(
                i - 1,
                j - 1,
                matrix[i - 1][j - 1]));
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(i, j - 1, matrix[i][j - 1]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j - 1,
                matrix[i + 1][j - 1]));
            matrixElements.add(new MatrixElement(i + 1, j, matrix[i + 1][j]));
        }
        // Look at elements on upper left corner
        else if (i == 0 && j == 0 && matrix.length > 1)
        {
            matrixElements.add(new MatrixElement(i, j + 1, matrix[i][j + 1]));
            matrixElements.add(new MatrixElement(i + 1, j, matrix[i + 1][j]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j + 1,
                matrix[i + 1][j + 1]));
        }
        // Look at elements on upper right corner
        else if (i == 0 && j == matrix.length - 1 && matrix.length > 1)
        {
            matrixElements.add(new MatrixElement(i, j - 1, matrix[i][j - 1]));
            matrixElements.add(new MatrixElement(
                i + 1,
                j - 1,
                matrix[i + 1][j - 1]));
            matrixElements.add(new MatrixElement(i + 1, j, matrix[i + 1][j]));
        }
        // Look at elements on bottom left corner
        else if (i == matrix.length - 1 && j == 0 && matrix.length > 1)
        {
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(
                i - 1,
                j + 1,
                matrix[i - 1][j + 1]));
            matrixElements.add(new MatrixElement(i, j + 1, matrix[i][j + 1]));
        }
        // Look at elements on bottom right corner
        else if (i == matrix.length - 1 && j == matrix.length - 1
            && matrix.length > 1)
        {
            matrixElements.add(new MatrixElement(
                i - 1,
                j - 1,
                matrix[i - 1][j - 1]));
            matrixElements.add(new MatrixElement(i - 1, j, matrix[i - 1][j]));
            matrixElements.add(new MatrixElement(i, j - 1, matrix[i][j - 1]));
        }
        return matrixElements;
    }


    // ----------------------------------------------------------
    /**
     * Remove solutions
     *
     * @param matrixElements
     */
    public void removeSolutions(ArrayList<MatrixElement> matrixElements)
    {
        for (int i = 0; i < matrixElements.size(); i++)
        {
            int row = matrixElements.get(i).getRow();
            int col = matrixElements.get(i).getCol();
            matrix[row][col] = 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Find Adjacent Solutions
     *
     * @param i
     * @param j
     */
    public void findAdjacentSolutions(int i, int j)
    {
        if (matrix[i][j] != 0)
        {
            ArrayList<MatrixElement> adjacentElements =
                new ArrayList<MatrixElement>();
            ArrayList<MatrixElement> solutions = new ArrayList<MatrixElement>();
            int sum = 0;
            int difference = 0;
            MatrixElement smallest = null;
            adjacentElements = getAdjacentElements(i, j);
            sum = matrix[i][j];
            solutions.add(new MatrixElement(i, j, matrix[i][j]));
            boolean solutionNotFound = true;
            while (solutionNotFound && sum < 10 && adjacentElements.size() != 0)
            {
                difference = 10 - sum;
                for (int x = 0; x < adjacentElements.size(); x++)
                {
                    if (adjacentElements.get(x).getData() == difference)
                    {
                        solutions.add(new MatrixElement(
                            adjacentElements.get(x).getRow(),
                            adjacentElements.get(x).getCol(),
                            adjacentElements.get(x).getData()));
                        removeSolutions(solutions);
                        adjacentElements.clear();
                        solutions.clear();
                        if (verbose)
                        {
                            System.out.println("Move " + (moves + 1) + ":\n"
                                + toString());
                        }
                        makeNumbersFall();
                        if (verbose)
                        {
                            System.out.println("After Numbers Fall on Move "
                                + moves + ":\n" + toString());
                        }
                        solutionNotFound = false;
                    }
                }


                if (solutionNotFound)
                {
                    smallest = findSmallest(adjacentElements);
                    sum += smallest.getData();
                    adjacentElements.remove(smallest);
                    solutions.add(new MatrixElement(smallest.getRow(), smallest
                        .getCol(), smallest.getData()));
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Determines if only ones are left in the matrix
     *
     * @return true if the only values left in the matrix are one
     */
    public boolean onlyOnesLeft()
    {
        boolean bool = false;
        int count = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                if (matrix[i][j] == 1)
                {
                    bool = true;
                    count++;
                }
                else if (matrix[i][j] == 0)
                {
                    bool = true;
                }
                else
                {
                    return false;
                }
            }
        }
        if (count < 10)
        {
            return false;
        }
        return bool;
    }


    // ----------------------------------------------------------
    /**
     * Handles the special case when there are only a bunch of ones left in the
     * matrix
     */
    public void removeElementsWhenOnlyOnesLeft()
    {
        int sum = 0;
        ArrayList<MatrixElement> solutionList = new ArrayList<MatrixElement>();
        for (int i = matrix.length - 1; i >= 0; i--)
        {
            for (int j = matrix.length - 1; j >= 0; j--)
            {
                sum = sum + matrix[i][j];
                solutionList.add(new MatrixElement(i, j, matrix[i][j]));
                if (sum == 10)
                {
                    removeSolutions(solutionList);
                    if (verbose)
                    {
                        System.out.println("Move " + (moves + 1) + ":\n"
                            + toString());
                    }
                    makeNumbersFall();
                    if (verbose)
                    {
                        System.out.println("After Numbers Fall on Move "
                            + moves + ":\n" + toString());
                    }
                    solutionList.clear();
                    sum = 0;
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Shift numbers down into empty spaces
     */
    public void makeNumbersFall()
    {
        moves++;
        int z = 0;
        // Check for gap
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                // Gap in matrix found
                if (matrix[i][j] == 0)
                {
                    z = i;
                    // Shift all numbers down one
                    for (int p = 0; z >= p; z--)
                    {
                        if (z == 0)
                        {
                            matrix[z][j] = 0;
                        }
                        // Set elements at top to 0 (Gap)
                        else
                        {
                            matrix[z][j] = matrix[z - 1][j];
                        }
                    }
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Find the smallest number in adjacent elements.
     *
     * @param adjacentElements
     * @return smallest number
     */
    public MatrixElement findSmallest(ArrayList<MatrixElement> adjacentElements)
    {
        MatrixElement m = adjacentElements.get(0);
        int smallest = adjacentElements.get(0).getData();
        for (int i = 0; i < adjacentElements.size(); i++)
        {
            if (adjacentElements.get(i).getData() < smallest)
            {
                smallest = adjacentElements.get(i).getData();
                m = adjacentElements.get(i);
            }
        }
        return m;
    }


    // ----------------------------------------------------------
    /**
     * Get remaining amount of numbers left in matrix
     *
     * @return Remaining Numbers
     */

    public int getRemainingNumbers()
    {
        int remainingNumbers = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                if (matrix[i][j] != 0)
                {
                    remainingNumbers++;
                }
            }
        }
        return remainingNumbers;
    }


    // ----------------------------------------------------------
    /**
     * @param matrix
     *            the matrix to set
     */
    public void setMatrix(int[][] matrix)
    {
        this.matrix = matrix;
    }


    // ----------------------------------------------------------
    /**
     * @return the matrix
     */
    public int[][] getMatrix()
    {
        return matrix;
    }


    // ----------------------------------------------------------
    /**
     * @param matrixSize
     *            the matrixSize to set
     */
    public void setMatrixSize(int matrixSize)
    {
        if (matrixSize < 0)
        {
            System.out.println("Matrix cannot be a negative number!");
            System.exit(0);
        }
        else
        {
            this.matrixSize = matrixSize;
        }
    }


    // ----------------------------------------------------------
    /**
     * @return the matrixSize
     */
    public int getMatrixSize()
    {
        return matrixSize;
    }


    // Print Matrix
    public String toString()
    {
        String info = "";
        if (matrix != null)
        {
            for (int i = 0; i < matrixSize; i++)
            {
                for (int j = 0; j < matrixSize; j++)
                {
                    if (matrix[i][j] == 0)
                    {
                        info = info + "  ";
                    }
                    else
                    {
                        info = info + matrix[i][j] + " ";
                    }
                }
                // Do not print new line after last line
                if (i == matrixSize - 1)
                {
                    // Do nothing
                }
                else
                {
                    info = info + "\n";
                }
            }
        }
        return info;
    }


    // ----------------------------------------------------------
    /**
     * @param moves
     *            the moves to set
     */
    public void setMoves(int moves)
    {
        this.moves = moves;
    }


    // ----------------------------------------------------------
    /**
     * @return the moves
     */
    public int getMoves()
    {
        return moves;
    }


    // ----------------------------------------------------------
    /**
     * @param verbose
     *            the verbose to set
     */
    public void setVerbose(boolean verbose)
    {
        this.verbose = verbose;
    }


    // ----------------------------------------------------------
    /**
     * @return the verbose
     */
    public boolean isVerbose()
    {
        return verbose;
    }
}
