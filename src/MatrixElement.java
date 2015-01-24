// -------------------------------------------------------------------------
/**
 * Holds information about each element
 *
 * @author Michael Goheen
 * @version Feb 1, 2012
 */
public class MatrixElement
{
    private int row;
    private int col;
    private int data;


    // ----------------------------------------------------------
    /**
     * Create a new Element object.
     *
     * @param row
     * @param col
     * @param data
     */
    public MatrixElement(int row, int col, int data)
    {
        setRow(row);
        setCol(col);
        setData(data);
    }


    // ----------------------------------------------------------
    /**
     * @param row
     *            the row to set
     */
    public void setRow(int row)
    {
        this.row = row;
    }


    // ----------------------------------------------------------
    /**
     * @return the row
     */
    public int getRow()
    {
        return row;
    }


    // ----------------------------------------------------------
    /**
     * @param col
     *            the col to set
     */
    public void setCol(int col)
    {
        this.col = col;
    }


    // ----------------------------------------------------------
    /**
     * @return the col
     */
    public int getCol()
    {
        return col;
    }


    // ----------------------------------------------------------
    /**
     * @param data
     *            the data to set
     */
    public void setData(int data)
    {
        this.data = data;
    }


    // ----------------------------------------------------------
    /**
     * @return the data
     */
    public int getData()
    {
        return data;
    }


    public String toString()
    {
        String info = "";
        info += "row: " + row;
        info += "\ncol: " + col;
        info += "\ndata: " + data;
        info += "\n";
        return info;
    }

}
