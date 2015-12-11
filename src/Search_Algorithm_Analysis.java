import Control.MainController;
import Model.Model;
import View.View;

public class Search_Algorithm_Analysis {
	
	/**
	 * 
	 * This program is to count the number of collisions occuring during
	 * 		the construction of a hashed table, which is created by using
	 * 		different collision handling methods: linear probing, quadratic
	 * 		probing, and linear quotient probing.
	 * 
	 * @author Quang Nguyen
	 * @param args
	 */
	
	public static void main (String[] args) {
		View view = new View ();
		Model model = new Model();
		MainController control = new MainController(view, model);
		
		view.setVisible(true);
	}
}
