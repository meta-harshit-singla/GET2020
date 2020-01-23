package main;
public class SparseMatrices 
{    
    private int []row;             //Used to store the row values where non zero element exists
    private int rowTranspose[];    //Used to store the row values of the non zero elements in transpose matrix
    private int []column;          //Used to store the column values where non zero element exists
    private int []columnTranspose; //Used to store the column values of the non zero elements in transpose matrix
    private int[] inputValues;     //Used to store the non zero elements of the matrix
    private int numberOfRows;      //Used to store the total number of rows in the matrix
    private int numberOfColumns;   //Used to store the total number of columns in the matrix
    int countNonZeroElements=0;    //Used to count the total number of non-zero elements
    int index=0;
    /**
     * Parameterized constructor used to initialize the values
     * @param array denotes the matrix which is to be stored
     */
    public SparseMatrices(int[][] array)
    {
        numberOfRows=array.length;
        numberOfColumns=array[0].length;
        inputAndValidate(array);
    }
    /**
     * This is used to store the non-zero elements only and also check whether it is a sparse matrix or not
     * @param array denotes the matrix which is to be stored and checked
     */
    private void inputAndValidate(int [][]array)
    {
        //Used to count the number of non-zero elements in the matrix
        for(int i=0;i<numberOfRows;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                if(array[i][j]!=0)
                {
                    countNonZeroElements++;
                }
            }
        }
        //Checks whether the number of non-zero elements are equal to or smaller than the number of zero elements
        if((countNonZeroElements/(numberOfRows*numberOfColumns))>=(numberOfRows*numberOfColumns-countNonZeroElements))
        {
            throw new AssertionError("Matrix contains more non-zero elements");
        }
        row=new int[countNonZeroElements];
        column=new int[countNonZeroElements];
        inputValues=new int[countNonZeroElements];
        //Used to store the non-zero elements
        for(int i=0;i<numberOfRows;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                if(array[i][j]!=0)
                {
                    inputValues[index]=array[i][j];
                    row[index]=i;
                    column[index]=j;
                    index++;
                }
            }
        }
    }
    /**
     * Used to transpose the Sparse matrix
     * @return the transposed matrix
     */
    public int[][] transpose()
    {
        int[][] transpose=new int[numberOfColumns][numberOfRows];
        rowTranspose=new int[countNonZeroElements];
        columnTranspose=new int[countNonZeroElements];
        //Swaps the index of row and column
        for(int i=0;i<index;i++)
        {
            rowTranspose[i]=column[i]+row[i];
            columnTranspose[i]=rowTranspose[i]-column[i];
            rowTranspose[i]=rowTranspose[i]-columnTranspose[i];
        }
        for(int i=0;i<index;i++)
        {
            transpose[rowTranspose[i]][columnTranspose[i]]=inputValues[i];
            
        }
        
        return transpose;
    }
    /**
     * Used to check whether the matrix is symmetric or not
     * @return true if the matrix is symmetric else return false
     */
    public boolean isSymmetric()
    {
        //Throws assertion error if the number of rows are not equal to the number of columns
        if(numberOfColumns!=numberOfRows)
        {
            throw new AssertionError("Number of rows is not equal to number of columns");
        }
        transpose();
        boolean flag=true;
        for(int i=0;i<index;i++)
        {
            for(int j=0;j<index;j++)
            {
                if(row[i]==rowTranspose[j] && column[i]==columnTranspose[j])
                {
                    if(inputValues[i]==inputValues[j])
                    {
                        flag=true;
                        break;
                    }
                    else
                        flag=false;
                }
            }
            if(!flag)
                break;
        }
        return flag;
    }
    /**
     * Used to add two matrices
     * @param instance denotes the second matrix which is to be added
     * @return the added matrix
     */
    public int[][] addMatrices(SparseMatrices instance) throws Exception
    {
        //Throws assertion error if the number of rows and columns of first matrix is not equal to the number of rows and columns respectively of the second matrix 
        if(this.numberOfRows!=instance.numberOfRows && this.numberOfColumns!=instance.numberOfColumns)
        {
            throw new AssertionError("In addition of matrices the dimensions of the two matrices are not equal");
        }
        int[][] addArray=new int[this.numberOfRows][this.numberOfColumns];
        int i=0;
        while(i<this.index)
        {   
            addArray[this.row[i]][this.column[i]]+=this.inputValues[i];
            i++;
        }
        i=0;
        while(i<this.index)
        {   
            addArray[instance.row[i]][instance.column[i]]+=instance.inputValues[i];
            i++;
        }
        return addArray;
    }
    /**
     *  Used to multiply two matrices
     * @param instance denotes the second matrix which is to be multiplied
     * @return the multiplied matrix
     */
    public int[][] multiplyMatrices(SparseMatrices instance) throws Exception
    {
        //Throws Assertion Error if the number of columns of first matrix is not equal to the number of rows of the second matrix
        if(this.numberOfColumns!=instance.numberOfRows)
        {
            throw new AssertionError("In Multiplication number of columns of first matrix should be equal to number of rows in the second Matrix");
        }
        int multiplyArray[][]=new int[this.numberOfRows][instance.numberOfColumns];
        SparseMatrices instance2=new SparseMatrices(instance.transpose());
        for(int i=0;i<this.index;i++)
        {
            for(int j=0;j<instance2.index;j++)
            {
                if(this.column[i]==instance2.column[j])
                {                
                    multiplyArray[row[i]][instance2.row[j]]+=this.inputValues[i]*instance2.inputValues[j];      
                }
            }
        }
        return multiplyArray;
    }
}