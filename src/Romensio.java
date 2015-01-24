import java.io.*;

// -------------------------------------------------------------------------
/**
 * Computer plays a game of Romensio
 *
 * @author Michael Goheen
 * @version Jan 31, 2012
 */
public class Romensio
{
    // ----------------------------------------------------------
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args)
    {
        File f;
        Matrix matrix = null;
        // Command Line Argument for File
        if (args.length == 0)
        {
            matrix = new Matrix();
            System.out
            .println("No file or other arguments specified. " +
            		"\nCreating random matrix...");
        }
        else if (args.length == 1)
        {
            if (args[0].equals("verbose") || args[0].equals("Verbose")
                || args[0].equals("v") || args[0].equals("V")
                || args[0].equals("-v") || args[0].equals("-V"))
            {
                System.out
                    .println("No File Specified. " +
                    		"\nCreating Random Matrix...");
                System.out
                    .println("Verbose turned off. Printing only initial " +
                    		"matrix and solution matrix without all of the " +
                    		"inbetween steps.");
                matrix = new Matrix();
                matrix.setVerbose(false);
            }
            else
            {
                System.out.println("Creating Matrix from File " + args[0] + "...");
                f = new File(args[0]);
                matrix = new Matrix(f);
            }
        }
        else if (args.length == 2)
        {
            if (args[1].equals("verbose") || args[1].equals("Verbose")
                || args[1].equals("v") || args[1].equals("V")
                || args[1].equals("-v") || args[1].equals("-V"))
            {
                System.out.println("Creating Matrix from File " + args[0] + "...");
                System.out
                    .println("Verbose turned off. Printing only initial " +
                            "matrix and solution matrix without all of the " +
                            "inbetween steps.");
                f = new File(args[0]);
                matrix = new Matrix(f);
                matrix.setVerbose(false);
            }
            else if (args[0].equals("random") || args[0].equals("Random")
                || args[0].equals("r") || args[0].equals("R")
                || args[0].equals("-r") || args[0].equals("-R"))
            {
                Integer dimensions = Integer.parseInt(args[1]);
                System.out.println("Creating a random " + dimensions + "x" + dimensions
                    +" matrix...");
                matrix = new Matrix(dimensions);
            }
            else
            {
                System.out.println("Incorrect Arguments!");
                System.exit(0);
            }
        }
        else if (args.length == 3)
        {
            Integer dimensions = Integer.parseInt(args[1]);
            System.out.println("Creating a random " + dimensions + "x" + dimensions
                +" matrix...");
            System.out
            .println("Verbose turned off. Printing only initial " +
                    "matrix and solution matrix without all of the " +
                    "inbetween steps.");
            matrix = new Matrix(dimensions);
            matrix.setVerbose(false);
        }
        else
        {
            System.out.println("Incorrect Number of Arguments!");
        }
        // Print initial matrix
        System.out.println("\nInitial Matrix:\n" + matrix);
        // Search through matrix for solutions
        for (int i = 0; i < matrix.getMatrixSize(); i++)
        {
            for (int j = 0; j < matrix.getMatrixSize(); j++)
            {
                matrix.findAdjacentSolutions(i, j);
            }
        }
        // Special case to handle a bunch of ones left in the matrix
        while (matrix.onlyOnesLeft())
        {
            matrix.removeElementsWhenOnlyOnesLeft();
        }
        // Output solution matrix
        System.out.println("\nSolution Matrix:");
        System.out.println(matrix);
        System.out.println("\nRemaining Numbers: " + matrix.getRemainingNumbers());
        System.out.println("Total Moves: " + matrix.getMoves());
    }
}
