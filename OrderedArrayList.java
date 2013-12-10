// Ida Huang
// Period 8
// HW40
// 2013-12-09

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList <Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
        _data = new ArrayList <Comparable> ();
    }


    public String toString() { 
        return _data.toString();
    }

    //removes the item at index
    //shifts elements left to fill the newly-empted slot
    //returns removed value
    public Comparable remove( int index ) { 
	Comparable retComp = _data.get(index);
	_data.remove(index);
	return retComp;
    }


    public int size() { 
	return _data.size();
    }

    
    public Comparable get( int index ) { 
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear(Comparable newVal) { 
	if (_data.size() < 0) {
	    for (int i = 0 ; i <_data.size(); i++) {
		//compareTo returns: 0 if equal to newVal,< 0 if less than newVal, > 0 if greater than newVal  
		if (_data.get(i).compareTo(newVal) >= 0) { //when the element is greater than or equal to the newVal, insert the value at index
		    _data.add(i, newVal);
		    break;
		}
	    }
	}
        _data.add( newVal); //appends the argument to the end of this ArrayList   
    }


    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary(Comparable newVal) { 
        int lo = 0;
	int hi = _data.size() - 1;
	int m = (lo + hi)/2;

	while (lo <= hi) {
	    m = (lo + hi)/2;

	    //target found 
	    if (_data.get(m).compareTo(newVal) == 0){
		break;
	    }
	    //value at mid index is higher than target
	    else if (_data.get(m).compareTo(newVal)> 0)
		hi = m - 1; // update hi index to the element left of the mid
	    
	    //value at mid index is lower than target
	    else if (_data.get(m).compareTo(newVal)<0)
		lo = m + 1; //update lo index to the element right of the mid 	  
	}
	_data.add(m, newVal);
    }	


    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ ){
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	    }
	
	System.out.println( Franz );

	// testing binary search
	Franz = new OrderedArrayList();
	for( int i = 0; i < 15; i++ ) 
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	System.out.println( Franz );
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	 
    }

}//end class OrderedArrayList
