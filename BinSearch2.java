// Ida Huang
// Period 8
// HW34
// 2013-11-27


/*==================================================
  class BinSearch2
  ==================================================*/
public class BinSearch2 {

    /*==================================================
      int binSearch(Comparable[], Comparable) -- searches an array of Comparables for target Comparable
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
	if (isSorted(a)){
		int mid = (lo + hi)/2; // init mid pos var
	
		if (lo > hi) {return -1;} // exit case: If lo & hi have crossed, target is not present

		if ( a[mid].compareTo(target) == 0) { 
		    //checks halfway between the range
		    return mid;
		}

		else if ( a[mid].compareTo(target) > 0 ) { 
		    // if halfway int is greater than target then set the new index to that point because anything beyond will definitely not be == to the target
		    return binSearchRec ( a, target, lo, mid - 1 );
		}
		// if halfway is less than target, then the target is above the halfway
		else if ( a[mid].compareTo(target) < 0) {
		    return binSearchRec (a, target, mid + 1, hi);
		}
	    }
        return -1; //if not sorted return -1, bad array
    }

    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
	if (isSorted(a)){
	    while (lo <= hi) {
		int m = (lo + hi)/2; // update mid pos var
		if ((a[m].compareTo(target)) == 0){ // target found
		    return m;
		}
		else if ((a[m].compareTo(target)) > 0) hi = m - 1; //value at mid index is higher than target
		else if ((a[m].compareTo(target)) < 0) lo = m + 1; // value at mid index if lower than target
	    }
	}
	return -1;
    }

    // tells whether a Comparable array is sorted in ascending order
     private static boolean isSorted (Comparable[] arr){
    	for (int i = 0; i < arr.length-1; i++){
    	    if (arr[i].compareTo(arr[i + 1] ) > 0) return false;
    	}
    	return true;
    }
	
    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Comparable[] arr ) {
        String output= "[ ";

        for( Comparable i : arr )
	    output += i + ", ";

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.println("\nNow testing binSearch on int array...");

        //Declare an array of Comparables and initialize it using ints 
        //   Each int will be autoboxed to class Integer, 
        //   which implements Comparable.

        Comparable[] iArr = { 2, 4, 6, 8, 12, 42 };
	System.out.println("iArr: ");
        printArray( iArr );
	System.out.println("is iArr sorted? " + isSorted(iArr));

        //search for 6 in array 
        System.out.println("Searching for 6 in iArr... " + binSearch(iArr,6) );//2

        //search for 43 in array 
        System.out.println("Searching for 43 in iArr... " + binSearch(iArr,43) );//-1

	Comparable[] iArr2 = { 2, 4, 6, 8, 6, 42 };
	System.out.println("iArr2: ");
	printArray(iArr2);
	System.out.println("is iArr2 sorted? " + isSorted(iArr2));
	
	//search for 6 in iArr2
	System.out.println("Searching for 6 in iArr2... " + binSearch(iArr2,6) );//-1

	//search for 43 in iArr2
	System.out.println("Searching for 43 in iArr2..." + binSearch(iArr2,43));//-1
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Rational array...");
	
	// Declare Rational array
	Rational[] rArr = new Rational[10];
	System.out.println("initial rArr: ");
	printArray( rArr ); // array of nulls
	
	// initialize Rational array: [1/10 -10/10] 
	for (int i = 0; i < rArr.length; i++){
	    rArr[i] = new Rational (i+1, 10);
	}
	System.out.println("current rArr: ");
	printArray( rArr );
	System.out.println("is rArr sorted? " + isSorted(rArr));
	
	//search for 1/10 in array 
        System.out.println("Searching for 1/10... " + binSearch(rArr, new Rational (1,10)) );

        //search for 0/10 in array 
        System.out.println("Searching for 0/10... " + binSearch(rArr, new Rational (0, 10)) );


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	System.out.println("\nNow testing binSearch on String array...");
	// compareTo(String): compares two Strings to see which is alphabetically greater. 
	// Declare String array
	String[] sArr = new String[10];
	System.out.println("initial sArr: ");
	printArray( sArr ); // array of nulls

	String letter = "a";
	// initialize String array
	for (int i = 0; i < sArr.length; i++){
	sArr[i]= letter;
	letter = letter + "a";
	}
	System.out.println("current sArr: ");
	printArray( sArr );
	System.out.println("is sArr sorted? " + isSorted(sArr)); //true
	
	//search for aaa in array 
        System.out.println("Searching for aaa... " + binSearch(sArr,"aaa") );

        //search for zzz in array 
        System.out.println("Searching for zzz... " + binSearch(sArr,"zzz") );



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Binary array...");

	// Declare Binary array
	Binary[] bArr = new Binary[10];
	System.out.println("initial bArr: ");
	printArray( bArr ); // array of nulls
       
	//Initialize Binary array 
	for (int i = 0; i < bArr.length; i++){
	bArr[i]= new Binary (i + 1);
	}
	System.out.println("current bArr: ");
	printArray( bArr );
	System.out.println("is bArr sorted? " + isSorted(bArr)); //true

	//search for 101 in array 
        System.out.println("Searching for 101... " + binSearch(bArr, new Binary(3)));

        //search for 100000000 in array 
        System.out.println("Searching for 100000000... " + binSearch(bArr, new Binary(256)));
		
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on Hexadecimal array...");

	// Declare array of Hexadecimals
	Hexadecimal[] hArr = new Hexadecimal[10];
	System.out.println("initial hArr: ");
	printArray( hArr ); // array of nulls
	   
	//Initialize Hexadecimal array 
	for (int i = 0; i < hArr.length; i++){
	hArr[i]= new Hexadecimal (i + 1);
	}
	System.out.println("current hArr: ");
	printArray( hArr );
	System.out.println("is hArr sorted? " + isSorted(hArr)); //true

	//search for 5 in array 
        System.out.println("Searching for 5... " + binSearch(hArr, new Hexadecimal(5)));

        //search for 100 in array 
        System.out.println("Searching for 100... " + binSearch(hArr, new Hexadecimal(256)));

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
    }//end main()

}//end class BinSearch
