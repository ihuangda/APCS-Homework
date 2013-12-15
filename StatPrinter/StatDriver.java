// Ida Huang
// Period 8
// HW43
// 2013-12-13

import java.util.ArrayList;

public class StatDriver {
    
    public static void main (String[] args){
	
	//declare ArrayList data
	ArrayList<Integer> data = new ArrayList<Integer> ();
	// populate the ArrayList with 10 elements 
	for (int i = 10; i > 0; i--){
	    data.add(i);
	}
	
	System.out.println(data.size());
	System.out.println(data);
    
	StatPrinter list = new StatPrinter(data);
	System.out.println(list.getFreq());
	System.out.println(list.max(data));
	System.out.println(list.isLocalMode(0));
	System.out.println(list.isLocalMode(10));
	System.out.println(list.isLocalMode(9));
	System.out.println(list.getLocalModes());

	//declare ArrayList data
	ArrayList<Integer> data2 = new ArrayList<Integer> ();
	// populate the ArrayList 
	data2.add(1);
	data2.add(2);
	data2.add(1);
	data2.add(1);
	data2.add(0);
	
	System.out.println(data2.size());
	System.out.println(data2);
    
	StatPrinter list2 = new StatPrinter(data2);
	System.out.println(list2.getFreq());
	System.out.println(list2.max(data2));
	
	System.out.println(list2.isLocalMode(0));
	System.out.println(list2.isLocalMode(3));
	System.out.println(list2.isLocalMode(1));
	System.out.println(list2.getLocalModes());
	list2.printHistogram(1);
	
    }
}
