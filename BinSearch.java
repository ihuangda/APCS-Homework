// Ida Huang
// Period 8 
// HW33
// 2013-11-26

// partially pair programmed with Mika in class

/*==================================================
  class BinSearch
  ==================================================*/

public class BinSearch {

    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre: input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( int[] a, int target ) {
        //uncomment exactly 1 of the 2 stmts below:
        return binSearchIter( a, target, 0, a.length-1 );
	// return binSearchRec( a, target, 0, a.length-1 );
    }

    /*==================================================
      int binSearchRec/binSearchIter (int[] a, int target, int lo, int hi)
      lo: lower bound of range
      hi: upper bound of range

      efficiently search an array for target:
      max number of guesses necessary ceiling(log2n) where n is hi
      ==================================================*/

    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
	if (target > a[hi] || target < a[lo]) {return -1;}
	if (isSorted(a) && (lo + hi) >= lo ) { // continue if array is sorted and lo>hi
	    if  ( a[ (lo + hi) / 2 ] == target) { //checks halfway between the range
		return (lo + hi)/2; 
	    }
	    if ( a[(lo + hi)/2] > target) { // if halfway int is greater than target then set the new index to that point because anything beyond will definitely not be == to the target
		return binSearchRec ( a, target, lo,(lo + hi)/2);
	    }
	    // if halfway is less than target, then the target is above the halfway
	    else if ( a[(lo + hi)]/2 < target) {
		return binSearchRec (a, target, (lo + hi)/2, hi);
	    }
	}
	return -1; //if not sorted return -1, bad array
    }

    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	if (target > a[hi] || target < a[lo]) {return -1;}
        if (isSorted(a) && (hi >= lo)) { 
	    while ((lo + hi)/2 > 0) {
		if  (a[(lo + hi)/2] == target){
		    return (lo + hi)/2;
		}
		if (a[(lo + hi)/2] > target) hi = (lo + hi)/2;
		lo = (lo + hi)/2; // if halfway element is less than target
	    }
	}
	return -1; // if not sorted return -1, bad array
    }

    //tell whether an array is sorted in ascending order
    private static boolean isSorted( int[] arr ) {
        for (int i = 0; i < arr.length - 1; i++) {
	    if (arr[i] > arr[i + 1]) return false;
	}
        return true; 
    }

    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
        String output = "[ ";

        for( int i : arr )
	    output += i + ", ";

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {  

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
        System.out.println("\nNow testing binSearch on int array...");

        //Declare and initialize array of ints
        int[] iArr = { 2, 4, 6, 8, 6, 42 };
	System.out.println("iArr: ");
        printArray( iArr );
        System.out.println( "Is isArr sorted? -- " + isSorted(iArr) );//false

        int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	System.out.println("iArr2: ");
        printArray( iArr2 );
        System.out.println( "Is isArr2 sorted? -- " + isSorted(iArr2) ); //true
  
        //search for 6 in both arrays
        System.out.println("index of 6 in isArr: " + binSearch(iArr,6) ); // return -1
	System.out.println("index of 6 in isArr2: " + binSearch(iArr2,6) ); // return 2

        //search for 43 in both arrays
        System.out.println("index of 43 in isArr: " + binSearch(iArr,43) ); //return -1
	System.out.println("index of 43 in isArr2: " +  binSearch(iArr2,43) ); //return -1

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    }//end main()

}//end class BinSearch
