// Ida Huang
// Period 8
// HW34
// 2013-11-27

/*==================================================
  class BinSearch2
  ==================================================*/

public class BinSearch2 {

    /*==================================================
      int binSearch(int[],int) -- searches an array of Comparables for target Comparable
      pre: Comparable array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( Comparable[] a, Comparable target ) {
        //uncomment exactly 1 of the 2 stmts below:
	// return binSearchIter( a, target, 0, a.length-1 );
        return binSearchRec( a, target, 0, a.length-1 );
    }

    /*==================================================
      int binSearchRec/binSearchIter (Comparable[] a, Comparable target, int lo, int hi)
      lo: lower bound of range
      hi: upper bound of range

      efficiently search an array for target:
      max number of guesses necessary ceiling(log2n) where n is hi
      ==================================================*/
    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
	if (target instanceof String) {
	    String Target = (String) target;
	}
	if (target instanceof Rational) {
	     Rational Target = (Rational) target;
	}
	if (target instanceof Binary){
	     Binary Target = (Binary) target;
	}
	if (target instanceof Hexadecimal){
	     Hexadecimal Target = (Hexadecimal) target;
	}
	
	int m = (lo + hi)/2; // init mid pos var

        if (isSorted(a)) { // continue if array is sorted 
	    if (lo > hi) {return -1;} // exit case: If lo & hi have crossed, target is not present
	    if ( a[m].compareToa(Target) == 0) { 
		//checks halfway between the range
                return (lo + hi)/2;
	    }
	    if ( a[m].compareTo(Target) > 0 ) { 
		// if halfway int is greater than target then set the new index to that point because anything beyond will definitely not be == to the target
                return binSearchRec ( a, Target, lo,(lo + hi)/2 - 1 );
	    }
	    // if halfway is less than target, then the target is above the halfway
	    else if ( a[m].compareTo(Target) < 0) {
                return binSearchRec (a, Target, (lo + hi)/2 + 1, hi);
	    }
        }
        return -1; //if not sorted return -1, bad array
    }

    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
	if (target instanceof String) {
	    String Target = (String) target;
	}
	if (target instanceof Rational) {
	     Rational Target = (Rational) target;
	}
	if (target instanceof Binary){
	     Binary Target = (Binary) target;
	}
	if (target instanceof Hexadecimal){
	     Hexadecimal Target = (Hexadecimal) target;
	}

        if (isSorted(a)) {
	    while (lo <= hi) {
		int m = (lo + hi)/2; // update mid pos var
                if ((a[m].compareTo(Target)) == 0){ // target found
		    return m;
                }
                if ((a[m].compareTo(Target)) > 0) hi = m - 1; //value at mid index is higher than target
                lo = m + 1; // value at mid index if lower than target
	    }
        }
        return -1; // if not sorted return -1, bad array
    }

    // tells whether a Comparable array is sorted in ascending order
     private static boolean isSorted (Comparable[] array){
    	for (int i = 0; i < array.length-1; i++){
    	    if (array[i].compareTo(array[i + 1] ) > 0) return false;
    	}
    	return true;
    }
	
    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Object[] arr ) {
        String output = arr + ": [ ";

        for( Object i : arr )
	    output += i + ", ";

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Rational array...");
	
	// Declare Rational array
	Rational[] rArr = new Rational[10];
	printArray( rArr ); // array of null;
	
	// initialize Rational array
	for (int i = 0; i < rArr.length; i++){
	    rArr[i] = new Rational (i, 10);
	}

	printArray( rArr );

	/*
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	System.out.println("\nNow testing binSearch on String array...");
	// compareTo(String): compares two Strings to see which si alphabetically greater. 
	// Declare and initialize array of Rationals
	String[] sArr = new String[10];
	printArray( sArr ); // array of nulls

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Binary array...");

	// Declare and initialize array of Rationals
	Binary[] bArr = new Binary[10];
	printArray( bArr ); // array of nulls

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Hexadecimal array...");

	// Declare and initialize array of Hexadecimals
	Hexadecimal[] hArr = new Hexadecimal[10];
	printArray( hArr ); // array of nulls

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
    }//end main()

}//end class BinSearch
