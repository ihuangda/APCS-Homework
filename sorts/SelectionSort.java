// Ida Huang
// Period 8
// HW46
// 2013-12-19

/*======================================
class SelectionSort -- implements SelectionSort algorithm
======================================*/

import java.util.ArrayList;

public class SelectionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    // from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();
        while( size > 0 ) {
         // offset + rand int on interval [lo,hi]
         retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
         size--;
        }
        return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
         //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
         //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	// i is the passCtr, run loop below n-1 times 
	for (int i = 0; i < data.size() - 1; i++) {
	    int min = i; // index correalting to the passCtr
	    // j starts at the index i, and iterates through the data to find the smallest value
	    for (int j = i; j < data.size(); j ++){
		if (data.get(j).compareTo(data.get(min)) < 0) min = j;
	    }
	    data.set( i, data.set( min, data.get(i) ) );		
	} 
    }//end selectionSortV -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    // Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	ArrayList <Comparable> data = new ArrayList <Comparable>();
	for (Comparable o: input){
	    data.add(o);
	}

	selectionSortV(data);

	return data;
	
    }//end selectionSort, O(n^2)


    public static void main( String [] args ) {


        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        selectionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        selectionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );
        /*===============for VOID methods=============
         ============================================*/

       
        ArrayList glen2 = new ArrayList<Integer>();
        glen2.add(7);
        glen2.add(1);
        glen2.add(5);
        glen2.add(12);
        glen2.add(3);
        System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
        ArrayList glen2Sorted = selectionSort( glen2 );
        System.out.println( "sorted version of ArrayList glen2:\n"
                         + glen2Sorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco2 = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
        ArrayList coco2Sorted = selectionSort( coco2 );
        System.out.println( "sorted version of ArrayList coco2:\n"
                         + coco2Sorted );
        System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
        System.out.println( coco2 );
        /*==========for AL-returning methods==========
	============================================*/

    }//end main

}//end class SelectionSort
