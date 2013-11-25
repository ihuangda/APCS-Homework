// Ida Huang
// Period 8
// HW31
// 2013-11-23

/*==================================================
  class Searching
  ==================================================*/

/*         -- Refresh on arrays --
  1. to declare an array of ints: int[] arrayName
  2. to allocate memory for n amount of integers: arrayName = new int[n]
  3. to initialize elements in an array: arrayName[x] = 100 (x is numerical index)
*/

public class Searching {

    /*==================================================
      int frequency(int[],int) -- uses FOR loop to search int array for target
      post: returns num of times target occurs in array
      ==================================================*/
    public static int frequency( int[] a, int target ) {

	int freq = 0; // counter variable

	for( int i : a ){ // for each int i in array a, run body 
	    if ( i == target )
		freq++;
	}
	return freq;
    }

    /*==================================================
      int linSearch(int[],int) -- searches an array of ints for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch( int[] a, int target ) {

	int tPos = -1;
	int i = 0; // counter 

	while ( i < a.length ) { 

	    if ( a[i] == target ) { 
		tPos = i; //set tPos to the index of the element 
		break;
	    }
	    i++;
	}
	return tPos;
    }

    /*==================================================
      int linSearch(String[],String) -- searches an array of Strings for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( String[] a, String target ) {
	int tPos = -1;
	int i = 0;
	while ( i < a.length ) {

	    if ( a[i].equals(target) ) { //.equals because each element is a String and compare strings using .equals
		tPos = i;
		break;
	    }
	    i++;
	}

	return tPos;
    }

    /*==================================================
      int linSearch(Binary[],Binary) -- searches an array of Binarys for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( Binary[] a, Binary target ) {
	int tPos = -1;
	int i = 0; 

	while ( i < a.length ) {

	    if ( a[i].equals(target) ) { //Binary has _binNum which are Strings so compare using .equals
		tPos = i;
		break;
	    }
	    i++;
	}
	return tPos;
    }

    /*==================================================
      int linSearch(Hexadecimal[],Hexadecimal) -- searches an array 
      of Hexadecimals for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( Hexadecimal[] a, Hexadecimal target ) {
	int tPos = -1;
	int i = 0; 

	while ( i < a.length ) {

	    if ( a[i].equals(target) ) {// _hexNum are Strings- use .equals
		tPos = i;
		break;
	    }
	    i++;
	}
	return tPos;
    }

    /*==================================================
      int linSearch(?,?) -- searches an array of Objects of same type for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch (Comparable[] a, Comparable target){
	int tPos = -1;
	int i = 0; 

	while ( i < a.length ) {

	    if ( a[i].equals(target) ) { 
		tPos = i;
		break;
	    }
	    i++;
	}
	return tPos;
    }

    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }
    private static void printArray( Object[] arr ) {
	String output = "[ "; 

	for( Object o : arr )
	    output += o + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }

    //main method for testing
    public static void main ( String[] args ) {

	//TIP: kill & yank the top comment bar down one section 
	//     at a time to test your methods as they develop.

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on int array...");

	//declare and initialize an array of ints
	int[] iArr = { 2, 4, 6, 8, 6, 42 };
	//	System.out.println(iArr.length); = 6

	printArray( iArr );

	//search for 6 in array 
	System.out.println( linSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( linSearch(iArr,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on String array...");

	//declare and initialize an array of Strings
	String[] y = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };
	printArray( y );

	//search for "watermelon" in array y
	System.out.println( linSearch(y,"watermelon") );

	//search for "lychee" in array y
	System.out.println( linSearch(y,"lychee") );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Binary array...");

	//declare Binary array
	Binary[] bArr = new Binary[10];

	printArray( bArr ); //should show array of nulls

	//initialize Binary array
	//Q: Why would a FOREACH loop not do the job here?
	for( int i = 0; i < bArr.length; i++ ) {
	    bArr[i] = new Binary( (int)(100 * Math.random()) );
	}

	printArray( bArr ); //should now show Binary numbers
	
	//search for the value in slot 3 in array
	System.out.println( "Searching for " + bArr[3] + "..." );
	System.out.println( linSearch(bArr, bArr[3] ) );

	//search for 101 in array
	System.out.println( linSearch(bArr, new Binary(5) ) );

	//search for 100000000 in array
	System.out.println( linSearch(bArr, new Binary(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Hexadecimal array...");

	//declare Hexadecimal array
	Hexadecimal[] hArr = new Hexadecimal[10];

	printArray( hArr ); //should show array of nulls

	//initialize Hexadecimal array
	//Q: Why would a FOREACH loop not do the job here?
	for( int i = 0; i < hArr.length; i++ ) {
	    hArr[i] = new Hexadecimal( (int)(100 * Math.random()) );
	}

	printArray( hArr ); //should now show Hexadecimal numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + hArr[3] + "..." );
	System.out.println( linSearch(hArr, hArr[3] ) );

	//search for 5 in array
	System.out.println( linSearch(hArr, new Hexadecimal(5) ) );

	//search for 100 in array
	System.out.println( linSearch(hArr, new Hexadecimal(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Comparable array...");
	
	//declare Comparable array
	Comparable[] cArr = new Comparable[4];

	printArray( cArr ); //should show array of nulls

	//initialize Comparable array- slot 0 is int, slot 1 is a String, slot 2 is Binary, slot 3 is Hexadecimal
	cArr[0] = 3; //autoboxing
	cArr[1] = "imagination";	
	cArr[2] = new Binary( (int)(100 * Math.random()) );
	cArr[3] = new Hexadecimal ((int) (100*Math.random()) );
	

	printArray( cArr ); //should now show Comparable numbers
	
	//search for the value in slot 3 in array
	System.out.println( "Searching for " + cArr[3] + "..." );
       	System.out.println( linSearch(cArr, cArr[3] ) );

	//search for 101 in array
	System.out.println ("Searching for " + 101+ "...");
	System.out.println( linSearch(cArr, new Binary(5) ) );

	//search for 100 in array
	System.out.println ("Searching for " + 100 + "...");
	System.out.println( linSearch(cArr, new Hexadecimal(256)) );
	
	//search for slot 2 in array
	System.out.println ("Searching for " + cArr[1] + "...");
	System.out.println( linSearch(cArr, cArr[1]) );

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
    }//end main()

}//end class Searching
