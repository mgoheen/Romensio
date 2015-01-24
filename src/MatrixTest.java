import java.util.ArrayList;
import java.io.File;

// -------------------------------------------------------------------------
/**
 * Test the matrix class
 *
 * @author Michael Goheen
 * @version Jan 31, 2012
 */
public class MatrixTest
{
    // ----------------------------------------------------------
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args)
    {
        // Test creating a random matrix
        System.out.println("Creating a random matrix:");
        Matrix m1 = new Matrix();
        System.out.println(m1);

        // Test creating a matrix from a file
        System.out.println("Creating a matrix from a file:");
        File file = new File("input.txt");
        Matrix m2 = new Matrix(file);
        System.out.println(m2);

        // Test getAdjacentElements
        ArrayList<MatrixElement> matrixElements =
            new ArrayList<MatrixElement>();
        matrixElements = m2.getAdjacentElements(2, 2);
        for (int i = 0; i < matrixElements.size(); i++)
        {
            System.out.println(matrixElements.get(i));
        }

        // Test removeSolutions
        ArrayList<MatrixElement> solutions = new ArrayList<MatrixElement>();
        solutions.add(new MatrixElement(1, 1, 5));
        solutions.add(new MatrixElement(2, 1, 5));
        solutions.add(new MatrixElement(2, 2, 5));
        m2.removeSolutions(solutions);
        System.out.println("After Removing Solutions: \n" + m2);

        // Test make numbers fall
        m2.makeNumbersFall();
        System.out.println("After Numbers Fall: \n" + m2);

        // Test findSmallest
        System.out.println("Creating a matrix from a file:");
        Matrix m3 = new Matrix(file);
        System.out.println(m3);
        // Test findAdjacentSolutions
        System.out.println("START\n" + m3);
        m3.findAdjacentSolutions(1, 1);
        System.out.println("After Find Adjacent Solutions \n" + m3);
    }
}
