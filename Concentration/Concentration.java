// Ida Huang
// Period 8
// HW44
// 2013-12-16

/*========================================
class Concentration
Facilitates playing game of Concentration,
aka Memory.
========================================*/

import java.util.ArrayList;
import cs1.Keyboard;

public class Concentration {

    //instance variables
    //storage for 4x4 grid of Tiles. _board.size() == 16        
    private ArrayList<Tile> _board; 

    //count of Tiles with faces visible
    private int _numberFaceUp;  

    //list of Strings used for Tile vals
    private WordList _list;

    private static int _numRows = 4;

    //Constructor
    public Concentration () {
	//_face of each tile
	ArrayList<String> animalia = new ArrayList<String>();
	//_face values 
	String[] ANIMALS = { "cat", "cat", "mouse", "mouse", 
			     "pig", "pig", "frog", "frog", 
			     "dog", "dog", "squirrel", "squirrel",
			     "fox", "fox", "hamster", "hamster"};
	//put the Strings into ArrayList
	for (int i = 0; i < 16; i++){
	    animalia.add(ANIMALS[i]);
	}
	_list = new WordList (animalia);
	_board = new ArrayList<Tile>();
	
	//randomly fill each slot
	for (int i = 0; i < animalia.size(); i++){
	    int rand = (int)(Math.random() * (animalia.size()-1));
	    Tile newtile = new Tile ((animalia.get(rand)));
	    _board.add(newtile);
	    animalia.remove(rand);
	}
    }

    //display board with toString method
    public String toString() {
	String retStr = "Current Board: \n";
      	int perRow =(int) ( _board.size() / _numRows);
	for (int i = 0; i < _board.size(); i++){
	    for (int j = 0; j < perRow; j++) {
		retStr = retStr + _board.get(i + j) + " ";
	    }
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    //DO NOT MODIFY main()
    public static void main( String[] args ) {
        Concentration game = new Concentration();
	System.out.println(game);
        //game.play();
    }

}//end class Concentration
