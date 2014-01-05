// Ida Huang
// Period 8
// HW47
// 2014-01-02

/*======================================
class InsertionSort -- implements insertionSort algorithm
======================================*/

/*   Include comments as appropriate, including a block comment just under your heading addressing these:
     Q1: Is more work done toward beginning or end of insertion sort? Why?
     I think more work is done toward the end of insertion sort because if the element we are looking at
     is less than the element to its right then we search from the beginning of the array to to the partition 
     (which is more elements than starting at the beginning) to find the right index to insert the element. 

     Q2: For n items, how many passes are necessary to sort?
     For n items, we need n-1 passes are necessary to sort because the first item is always taken to be sorted. 

     Q3: What is known after pass p, and how do you know it?
     After p passes, we know p+1 elements are sorted. 

     Q4: What is the runtime classification of this sort?
     A while loop (linear search) inside a for loop 
     n passes x n searches = O(n^2)
*/

import java.util.ArrayList;

public class InsertionSort {

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    // from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();

	for (int i = 0; i < size; i++){
	    int insert = (int) ((Math.random() * (hi - lo)) + lo);
	    retAL.add(insert);
	}

        return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
        ArrayList<Integer> copyAl = al;
	while (copyAl.size() > 0) {
	    int rand = (int) (Math.random() * (copyAl.size()));
	    al.remove(rand);
	    al.add(rand, copyAl.get(rand));
	    copyAl.remove(rand);
	}
    }


    // VOID version of insertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) { 
	// passes through arraysize - 1 times
	for (int p = 0; p < data.size()- 1; p++) {
	    // if the current element is less than the right element
	    if (data.get(p+1).compareTo(data.get(p)) < 0){
		//search through array from sorted to the pass mark to find the index where the 
		int i = 0;
		int tPos = -1;
		while (i < p+1){
		    if (data.get(i).compareTo(data.get(p+1)) >= 0){
			tPos = i;
			break;
		    }
		    i++;
		}
		data.add(tPos, data.get(p+1));
		// remove the element 
		data.remove(p+2);
	    }
	}
    }//end insertionSortV -- O(n^2) because of nested for loop


    // ArrayList-returning insertionSort
    // postcondition: order of data's elements unchanged
    // Returns sorted copy of data.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) {
        //declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();
	data = input; 
	
	insertionSortV(data);

        return data;
    }//end bubbleSort -- O(n^2) because of nested for loop in bubbleSortV


    public static void main(String [] args){
	/*===============for VOID methods=============           
	  ============================================*/
	System.out.println("TESTING insertionSortV........ \n");
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        insertionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        insertionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println("\n");

	/*==========for AL-returning methods==========
	  ============================================*/
	System.out.println("TESTING insertionSort() ............");
        ArrayList glen2 = new ArrayList<Integer>();
        glen2.add(7);
        glen2.add(1);
        glen2.add(5);
        glen2.add(12);
        glen2.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen2 );
        ArrayList glenSorted = insertionSort( glen2 );
        System.out.println( "sorted version of ArrayList glen:\n"
                         + glenSorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen2 );

        ArrayList coco2 = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco2 );
        ArrayList cocoSorted = insertionSort( coco2 );
        System.out.println( "sorted version of ArrayList coco:\n"
                         + cocoSorted );
        System.out.println( "ArrayList coco after sorting:\n" + coco2 );
        System.out.println( coco2 );
	System.out.println( "\n");
    }//end main

}//end class InsertionSort

