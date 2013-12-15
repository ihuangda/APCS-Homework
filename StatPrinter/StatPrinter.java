// Ida Huang
// Period 8
// HW43
// 2013-12-13

/*===========================================
An AP-style question, for practice:
Write the StatPrinter class below. The StatPrinter Object receives an
ArrayList of nonnegative integers, then builds a frequency ArrayList in which
the index values are the data and the entry at the index is the frequency.
For example, if the received data is 2,3,2,5,1,3 then the frequency
list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
the maximum value of the data.

A capability of the class is to calculate local modes from the frequency
list. A local mode is a value that is greater than the value at index-1
and greater than the value at index+1. A local mode is never at the end
points of the list. For example, if the frequency list is [1,2,1,4,2,3,5]
then the local modes are 2 and 4.

This class is also capable of printing a histogram of the frequencies, using
‘*’s to indicate a frequency amount. To print a histogram, the user specifies
the longest sequence of ‘*’s used and then all other values are printed in
proportion to this value. For example, if longest bar is 10 and the frequency
list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

0 : **
1 : ****
2 : **
3 : ********
4 : ****
5 : ******
6 : **********

For each method, state run time efficiency using Big O notation.

Tips for Awesome:
* Look over all fxns, think a bit, decide which to tackle first.
        ( Simplest? Prerequisites? . . . )
* Develop 1 fxn at a time, test it, then move to next.
* For coding today, what extra code do you need to get past Mr. Compiler?
===========================================*/


/* RUN TIME EFFICIENCY OF EACH METHOD HERE:
   1. Constructor: StatPrinter(data) is  O(n) because the performance will grow linearly and in direct proportion to the size of data (input param). 
   2. max(data) is O(n) number of iterations is directly proportional to data
   2. isLocalMode(i) is O(1) because the run-time is constant -> no matter how large the data size is, we are only looking at 3 elements of the data
   3. getLocalModes() is O(n)because for loops group directly proportional to size, we call isLocalMode(i) but the runtime is constant
   4. printHistogram() is O(n^2) because there is a nested iteration. 

   EXTRA CODE? I'm not sure what extra code was needed to get past Mr.Compiler but I did need (import java.util.ArrayList;) at the beginning of StatDriver 
   
*/

import java.util.ArrayList;

public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;

    //*************** QUESTION __ **************************
    //precond: data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data)+1
    // _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    // _frequency would be [0,0,3,2,0,1]
    
    //THIS IS THE CONSTRUCTOR
    public StatPrinter( ArrayList <Integer> data ) {
	_frequency = new ArrayList<Integer> ();
	// find the max
	Integer themax = max(data);
	// fill the elements ArrayList _frequency and increase its size to max(data) + 1
	for (int i = 0; i < themax + 1; i++){
	    _frequency.add(0);
	}
	// iterate through data and update frequency 
	for (int p = 0; p < data.size(); p++) {
	    _frequency.set(data.get(p) , _frequency.get(data.get(p)) + 1 );
	}
    }

    // for testing purposes to make sure _frequency looked correct after getting initializing a StatPrinter
    // public ArrayList <Integer> getFreq(){
    // 	return _frequency;
    // }

    //*************** QUESTION __ **************************
    //precond: data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) {
	Integer max = 0;
	for (int i = 0; i < data.size(); i++) {
	    if (data.get(i) > max) {
		max = data.get(i);
	    }
	}
	return max;
    }


    //*************** QUESTION __ **************************
    //postcond: returns true if i>0 and i<_frequency.size()-1
    // and _frequency.get(i-1) < _frequency.get(i)
    // and _frequency.get(i+1) < _frequency.get(i)
    // Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    // 2 and 8 are local modes, so
    // isLocalMode(0) -> false
    // isLocalMode(1) -> true
    // isLocalMode(5) -> true
    public boolean isLocalMode( int i ) {
	if ( i > 0 && i < _frequency.size()-1)
	    return ((_frequency.get(i) > _frequency.get(i - 1)) && (_frequency.get(i) > _frequency.get(i+1)));
	return false;
    }


    //*************** QUESTION __ **************************
    //postcond: returns list of modes in _frequency
    public ArrayList <Integer> getLocalModes() {
	ArrayList <Integer> localModes = new ArrayList <Integer> ();
	for (int i = 1; i < _frequency.size() ; i++){
	    if (isLocalMode(i)) localModes.add(i); 
	}
	return localModes;
    }

    /*  This class is also capable of printing a histogram of the frequencies, using
	‘*’s to indicate a frequency amount. To print a histogram, the user specifies
	the longest sequence of ‘*’s used and then all other values are printed in
	proportion to this value. For example, if longest bar is 10 and the frequency
	list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

	0 : **
	1 : ****
	2 : **
	3 : ********
	4 : ****
	5 : ******
	6 : **********
    */
    //*************** QUESTION __ **************************
    //precond: longestBar > 0
    public void printHistogram( int longestBar ){
	// max = longest frequency amount
	Integer max = max(_frequency); 
	// histogram string
	String histo = "Histogram  for : " + _frequency + " when longestBar = " + longestBar + "\n";
	// proportion constant based on the longestBar
	int ratio;
	if  (longestBar < max) ratio = 1;
	else ratio = ( longestBar / max);


	/* iterate through the _frequency array
	   for each value, calculate the proportional freq value
	 */
	for (int i = 0; i < _frequency.size() ; i++){
	    histo = histo + "\n" + i + " : ";
	    int freq = _frequency.get(i);
	    int pfreq = freq * ratio;
	    
	    while (pfreq > 0) {
		histo = histo + "*";
		pfreq--;
	    }
	}
	System.out.println(histo);
    }
 
}//end class StatPrinter
