package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Model;
import Model.SearchSimulation;
import Model.Generator.DataTableGenerator;
import Model.Generator.HashTableGenerator;
import Model.HashingFunctions.DivisionHashFunction;
import View.View;

public class MainController implements ActionListener{
	private View view;
	private Model model;
	
	public MainController (View view, Model model) {
		this.view = view;
		this.model = model;
		
		this.view.addListeners(this);
	}
	
	
	public void actionPerformed (ActionEvent ae) {
		Object source = ae.getSource();
		if (source == view.getSelectMissingBtn()) buildMissingKeysTable();
		else if (source == view.getSelectPresentBtn()) buildPresentKeysTable();
		else if (source == view.getSelectRandomBtn()) buildRandomKeysTable();
		else if (source == view.getSearchBtn()) doSearchSimulation();
		else if (source == view.getBuildHashTableBtn()) buildHashTable();
	}


	private void doSearchSimulation() {
		model.getCounterObject().setComparison(0);
		String dataFile = view.getSelectedValueOfGroupDataFile();
		if (dataFile.equals("Missing Keys Table")) {
			for (String key: model.getMissingKeysTable()) {
				int initialHashAddress = DivisionHashFunction.divisionHash(key, model.getTableSize());
				int index = SearchSimulation.findKeyInHashTable(key, initialHashAddress,
						model.getCollisionHandler(), model.getHashTable());
			}
		} else {
			for (String key: model.getPresentKeysTable()) {
				int initialHashAddress = DivisionHashFunction.divisionHash(key, model.getTableSize());
				int index = SearchSimulation.findKeyInHashTable(key, initialHashAddress,
						model.getCollisionHandler(), model.getHashTable());
			}
		}
		view.setNumberOfComparison(model.getCounterObject().getComparisons());
		view.setAverageComparison((double)model.getCounterObject().getComparisons()/500);
	}

	
	private void buildHashTable() {
		model.setCollisionHandler(view.getSelectedValueOfGroupCollision());
		model.setHashingFunction(view.getSelectedValueOfGroupHash());
		model.setTableSize(view.getTableSize());
		model.getCounterObject().setComparison(0);
		model.setHashTable(HashTableGenerator.createHashTable(
				model.getHashingFunction(), 
				model.getCollisionHandler(), 
				model.getTableSize(), 
				model.getRandomKeysTable())
		);
		view.setNumberOfComparison(model.getCounterObject().getComparisons());
		view.setAverageComparison((double)model.getCounterObject().getComparisons()/5000);
	}
	
	

	private void buildRandomKeysTable() {
		DataTableGenerator fileReader = new DataTableGenerator();
		model.setRandomKeysTable(fileReader.readAFile());
		view.setRandomFileName(fileReader.getFileName());
	}


	private void buildPresentKeysTable() {
		DataTableGenerator fileReader = new DataTableGenerator();
		model.setPresentKeysTable(fileReader.readAFile());
		view.setPresentFileName(fileReader.getFileName());
	}


	private void buildMissingKeysTable() {
		DataTableGenerator fileReader = new DataTableGenerator();
		model.setMissingKeysTable(fileReader.readAFile());
		view.setMissingFileName(fileReader.getFileName());
	}
	
}
