import Control.MainController;
import Model.Model;
import View.View;

public class Search_Algorithm_Analysis {
	public static void main (String[] args) {
		View view = new View ();
		Model model = new Model();
		MainController control = new MainController(view, model);
		
		view.setVisible(true);
	}
}
