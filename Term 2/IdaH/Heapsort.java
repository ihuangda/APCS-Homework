// Ida Huang
// APCS2 Period 9
// HW41
// 2014-05-18

//class Heapsort

public class Heapsort {

    //instance vars
    private static ALHeap heap = new ALHeap();
    
    public static Integer[] sort (Integer[] data){
	//create the heap 
	for (Integer i: data){
	    heap.add(i);
	}

	//return array of sorted heap
	int len = data.length;
	Integer[] sorted = new Integer[len];
	for (int i= 0; i < sorted.length; i++){
	    sorted[i] = heap.removeMin();
	}
	
	return sorted;
    }

    public static void main (String[] args){
	Integer[] herro = {2, 33, 41, 9, 87, 30, 12};
	for (int i = 0; i < herro.length; i++){
	    System.out.println(herro[i] + ",");
	}

	Integer[] sorted = sort(herro);
	System.out.println("SORT ABOVE");
	for (int i = 0; i < sorted.length; i++){
	    System.out.println(sorted[i] + ",");
	}
    }

}
