// Ida Huang
// Period 8
// HW35
// 2013-11-29

/*
  Summary of findings:
  1. Remove isSorted(a) at the top of from binSearchRec method because if you require binSearch2 to sort and then 
     look for the numbers, it will sort of be like going through the array twice so it binSearchRec can take longer than linSearch.
  
  * Tested on an array with 10,000 elements
  2. When looking for a target value near first quarter of the array[0 - 2500), 
     LinSearch is sometimes faster. I think this is because it is successively searching from the beginning of the array
     and sometimes the target is closer to index zero such as when the target is 66, it will find it before BinSearch which gradually closes in
     on the target value by reducing the range of the array it will search by half each time. 
     Sometimes BinSearch is faster when the target is farther away from the 0 index and closer to 2500. 
  3. When the target number is in the second quarter [2500-5000), BinSearch is faster.
     I think BinSearch is faster because the first value that BinSearch will look at is the mid-value of the range,
     which is closer to the target value than where LinSearch begins at index 0. 
  4. When the target number is in the third quarter [5000-7500), BinSearch is faster.
     The same argument as the one above would apply. The target value is closer to the mid-index value than the 0 index. 
  5. When the target number is in the fourth quarter[7500-10000), BinSearch is faster than in the other three conditions above.

  *Since all of these the results are displayed in nanoseconds if you multiply by 10^-9, you will notice that there is not a huge difference
  in efficiency between BinSearch and LinSearch. At most BinSearch is faster than LinSearch x * 10^ -3 seconds where 0 < x < 9. 

     
 */

public class SearchTrials{

    /*===========================================================
      makeArr(int):
      function to make an integer array of length n
      each element is filled according to corresponding index
      this guarantees that the array will be sorted.
      ============================================================*/
    public static Comparable[] makeArr(int n){
	Comparable[] newArr = new Comparable[n];
	for (int i = 0; i < n; i++){
	    newArr[i] = i;
	}
	return newArr;
    }//end makeArr

    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Comparable[] arr ) {
        String output= "[ ";

        for( Comparable i : arr )
	    output += i + ", ";

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println( output );
    }
 
    public static void main (String[] args){
	int length = 10000;
	Comparable[] iArr = makeArr(length);
	//uncomment the two lines below if you want to see the array printed out
	//System.out.println("iArr: ");
	//printArray(iArr); //private so can't call BinSearch2 or LinSearch
	System.out.println("isArr contains " + length + " elements from 0 - " + (length-1));
	
	String results = "\nResults: "; //will display results of the run after
	long tdiff;

	// Search for any element within the first quarter [0 -2500)
	int target =(int) ((length/4) * Math.random());
	results = results + "\n\nWhen the target was " + target + "..."; //update results with target
	System.out.println("\nNow testing LinSearch vs BinSearch2 to find " + target);

	long tstart = System.nanoTime();
	System.out.println("LinSearch for " + target + " :" + LinSearch.linSearch(iArr, target));
	long tlin = (System.nanoTime()-tstart); //time it took for LinSearch
	System.out.println("LinSearch took " + tlin + " nanoseconds.");
	results = results + "\nLinSearch took " + tlin + " nanoseconds to find " + target;

        tstart = System.nanoTime();
	System.out.println("BinSearch for " + target + " :" + BinSearch2.binSearch(iArr, target));
	long tbin = (System.nanoTime()-tstart);	// time it took for BinSearch
	System.out.println("BinSearch took " + tbin + " nanoseconds.");
        results = results + "\nBinSearch took " + tbin + " nanoseconds to find " + target;

	if (tlin < tbin) {//if LinSearch time is less than BinSearch time than LinSearch is faster
	    tdiff = tbin - tlin; // subtract for how much fastser
	    results = results + "\nLinSearch was faster than BinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}
	else if (tbin < tlin) { //if BinSearch time is less than LinSearch time than BinSearch is faster
	    tdiff = tlin - tbin;
	    results = results + "\nBinSearch was faster than LinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}				       
	else if (tbin == tlin) {
	    results = results + "\nLinSearch and BinSearch work equally fast to find" + target;
	}
	
	// Search for any element within the first quarter (2500 -5000)
	target =(int) ((length/4) * Math.random()) + 2500;
	results = results + "\n\nWhen the target was " + target + " ..."; //update results with target
	System.out.println("\nNow testing LinSearch vs BinSearch2 to find " + target);

	tstart = System.nanoTime();
	System.out.println("LinSearch for " + target + " :" + LinSearch.linSearch(iArr, target));
	tlin = (System.nanoTime()-tstart);
	System.out.println("LinSearch took " + tlin + " nanoseconds.");
	results = results + "\nLinSearch took " + tlin + " nanoseconds to find " + target;

        tstart = System.nanoTime();
	System.out.println("BinSearch for " + target + " :" + BinSearch2.binSearch(iArr, target));
	tbin = (System.nanoTime()-tstart);	
	System.out.println("BinSearch took " + tbin + " nanoseconds.");
        results = results + "\nBinSearch took " + tbin + " nanoseconds to find " + target;

	if (tlin < tbin) {
	    tdiff = tbin - tlin;
	    results = results + "\nLinSearch was faster than BinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}
	else if (tbin < tlin) {
	    tdiff = tlin - tbin;
	    results = results + "\nBinSearch was faster than LinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}				       
	else if (tbin == tlin) {
	    results = results + "\nLinSearch and BinSearch work equally fast to find" + target;
	}


	// Search for any element within the first quarter (5000 -7500)
	target =(int) ((length/4) * Math.random()) + 5000;
	results = results + "\n\nWhen the target was " + target + " ..."; //update results with target
	System.out.println("\nNow testing LinSearch vs BinSearch2 to find " + target);

	tstart = System.nanoTime();
	System.out.println("LinSearch for " + target + " :" + LinSearch.linSearch(iArr, target));
	tlin = (System.nanoTime()-tstart);
	System.out.println("LinSearch took " + tlin + " nanoseconds.");
	results = results + "\nLinSearch took " + tlin + " nanoseconds to find " + target;

        tstart = System.nanoTime();
	System.out.println("BinSearch for " + target + " :" + BinSearch2.binSearch(iArr, target));
	tbin = (System.nanoTime()-tstart);	
	System.out.println("BinSearch took " + tbin + " nanoseconds.");
        results = results + "\nBinSearch took " + tbin + " nanoseconds to find " + target;

	if (tlin < tbin) {
	    tdiff = tbin - tlin;
	    results = results + "\nLinSearch was faster than BinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}
	else if (tbin < tlin) {
	    tdiff = tlin - tbin;
	    results = results + "\nBinSearch was faster than LinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}				       
	else if (tbin == tlin) {
	    results = results + "\nLinSearch and BinSearch work equally fast to find" + target;
	}

	// Search for any element within the first quarter [7500 -10000)
	target =(int) ((length / 4) * Math.random()) + 7500;
	results = results + "\n\nWhen the target was " + target + " ..."; //update results with target
	System.out.println("\nNow testing LinSearch vs BinSearch2 to find " + target);

	tstart = System.nanoTime();
	System.out.println("LinSearch for " + target + " :" + LinSearch.linSearch(iArr, target));
	tlin = (System.nanoTime()-tstart);
	System.out.println("LinSearch took " + tlin + " nanoseconds.");
	results = results + "\nLinSearch took " + tlin + " nanoseconds to find " + target;

        tstart = System.nanoTime();
	System.out.println("BinSearch for " + target + " :" + BinSearch2.binSearch(iArr, target));
	tbin = (System.nanoTime()-tstart);	
	System.out.println("BinSearch took " + tbin + " nanoseconds.");
        results = results + "\nBinSearch took " + tbin + " nanoseconds to find " + target;

	if (tlin < tbin) {
	    tdiff = tbin - tlin;
	    results = results + "\nLinSearch was faster than BinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}
	else if (tbin < tlin) {
	    tdiff = tlin - tbin;
	    results = results + "\nBinSearch was faster than LinSearch by " + tdiff + " nanoseconds when looking for " + target; 
	}				       
	else if (tbin == tlin) {
	    results = results + "\nLinSearch and BinSearch work equally fast to find" + target;
	}

	System.out.print(results); //prints out results for user to analyze
    }
    
}//end SearchTrials
