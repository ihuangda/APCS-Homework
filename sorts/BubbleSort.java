// Ida Huang
// Period 8
// HW45
// 2013-12-18

/*======================================
class BubbleSort -- implements bubblesort algorithm
======================================*/

import java.util.ArrayList;

public class BubbleSort {

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


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	// passes through arraysize - 1 times
	for (int i = 0; i < data.size() - 1; i++){
	    // iterates through all elements of data
	    for (int p = 0; p < data.size() - 1; p++){
		if (data.get(p).compareTo(data.get(p+1)) > 0) {
		    Comparable temp = data.get(p);
		    data.set(p, data.get(p+1));
		    data.set(p+1, temp);
		}
	    }
	}
    }//end bubbleSortV -- O(n^2) because of nested for loop


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    // Returns sorted copy of data.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
        //declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();
	data = input; 
	
	bubbleSortV(data);

        return data;
    }//end bubbleSort -- O(n^2) because of nested for loop in bubbleSortV


    public static void main(String [] args){
	/*===============for VOID methods=============           
	  ============================================*/
	System.out.println("TESTING bubbleSortV........ \n");
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        bubbleSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        bubbleSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println("\n");

	/*==========for AL-returning methods==========
	  ============================================*/
	System.out.println("TESTING bubbleSort() ............");
        ArrayList glen2 = new ArrayList<Integer>();
        glen2.add(7);
        glen2.add(1);
        glen2.add(5);
        glen2.add(12);
        glen2.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen2 );
        ArrayList glenSorted = bubbleSort( glen2 );
        System.out.println( "sorted version of ArrayList glen:\n"
                         + glenSorted );
        System.out.println( "ArrayList glen after sorting:\n" + glen2 );

        ArrayList coco2 = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco2 );
        ArrayList cocoSorted = bubbleSort( coco2 );
        System.out.println( "sorted version of ArrayList coco:\n"
                         + cocoSorted );
        System.out.println( "ArrayList coco after sorting:\n" + coco2 );
        System.out.println( coco2 );
	System.out.println( "\n");
    }//end main

}//end class BubbleSort
