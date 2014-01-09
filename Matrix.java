// Ida Huang
// Period 8
// HW49
// 2014-01-08

/*====================================
class Matrix -- models a square matrix

TASK: Implement methods below, categorize runtime of each.
Test in your main method.
====================================*/

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length; //this is the number of rows which is equal to number of cols
    }


    //return the item at the specified row & column
    private Object get( int r, int c ) {
	return matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return matrix[r-1][c-1].equals(null);
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object temp = get(r, c);
	matrix[r-1][c-1] = newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String ans = "";
	// for every array (row) i in matrix
	for (Object[] i : matrix){
	    // for every Object j in array i (row i)
	    for (Object j : i){
		ans += j + " ";
	    }	    
	    ans += "\n";
	}
	return ans;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals(Object rightSide){
	// if rightSide is-a Matrix and the dimensions of the matrices are identical, then..
	if ((rightSide instanceof Matrix) && (((Matrix)rightSide).size() == this.size())) {
		//check for corresponding values in corresponding slot
	    for (int r = 1; r <= matrix.length; r++ ){
		for (int c = 1; c <= matrix.length ; c++) {
		    // if elements are both null 
		    if (get(r,c) == null && ((Matrix)rightSide).get(r,c) == null ) {continue;}
		    // if this element does not corresponds to element in rightSide > return false
		    if (!((get(r,c)).equals(((Matrix)rightSide).get(r,c)))) {return false;}
		}	    	
	    }
		return true;
		}
	else {
	    return false;
	}	    					     
    }
  

    //return true if target is in this matrix; false otherwise
    public boolean isFound( Object target ) {
	for (Object[] i : matrix){
	    for (Object j : i){
		if (j.equals(target)){
		    return true; 
		}
	    }	    
		
	}
	return false;
    }



    //swap two columns of this matrix
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2 ) {
	for (int r = 1; r <= this.size(); r++) {
	    set (r, c1, set(r, c2, get(r, c1)));
	}
    }


    //swap two rows of this matrix
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2 ) {
	for (int c = 1; c <= this.size(); c++){
	      set (r1, c, set(r2, c, get(r1, c)));  
	}
    }


    //main method for testing
    public static void main( String[] args ) {
	Matrix m1 = new Matrix();
	Matrix m2 = new Matrix(2);
	Matrix m3 = new Matrix(3);

	System.out.println("Testing: same elements +  same size matrix");	
	System.out.println("m1: \n" + m1);
	System.out.println("m2: \n" + m2);
	System.out.println("Is m1 identical to m2? " + m1.equals(m2) + "\n"); // true - same size + elements
	
	System.out.println("Testing: different value, but same size matrix");
	m1.set(1, 1, "meep");
	System.out.println("m1: \n" + m1);
	System.out.println("m2: \n" + m2);
	System.out.println("Is m1 identical to m2? " + m1.equals(m2) + "\n"); // false - not identical values
	
	System.out.println("Testing: different dimension matrix");
	System.out.println("m2: \n" + m2);
	System.out.println("m3: \n" + m3);
	System.out.println("Is m2 identical to m3? " + m1.equals(m2) + "\n"); // false- diff dimensions

	m1.set(1,2, "matrix");
	m1.set(2,1, "m1");
	m1.set(2,2, "meow");
	System.out.println("original m1: \n" + m1); 
	
	System.out.println("Swap rows 1 & 2");
	m1.swapRows(1,2);
	System.out.println("m1 after swapping... \n" + m1);

	System.out.println("Swap columnss 1 & 2");
	m1.swapColumns(1,2);
	System.out.println("m1 after swapping... \n" + m1);
	
}

}//end class Matrix
