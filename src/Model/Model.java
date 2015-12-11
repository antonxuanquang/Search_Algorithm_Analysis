package Model;

import java.util.ArrayList;

public class Model {
	private int [] hashTable;
	private ArrayList<Integer> randomKeys, missingKeys, presentKeys;
	private int tableSize;
	private String collisionHandler, hashingFunction;
	private Counter count = new Counter();
	
	public Model() {}
	
	public int[] getHashTable() {
		return hashTable;
	}
	
	public void setHashTable (int [] table) {
		hashTable = table;
	}
	
	public ArrayList<Integer> getRandomKeysTable() {
		return randomKeys;
	}
	
	public void setRandomKeysTable(ArrayList<Integer> table) {
		randomKeys = table;
	}
	
	public ArrayList<Integer> getMissingKeysTable() {
		return missingKeys;
	}
	
	public void setMissingKeysTable(ArrayList<Integer> table) {
		missingKeys = table;
	}
	
	public ArrayList<Integer> getPresentKeysTable() {
		return presentKeys;
	}
	
	public void setPresentKeysTable(ArrayList<Integer> table) {
		presentKeys = table;
	}
	
	public String getCollisionHandler () {
		return collisionHandler;
	}
	
	public void setCollisionHandler(String handler) {
		collisionHandler = handler;
	}
	
	public String getHashingFunction() {
		return hashingFunction;
	}
	
	public void setHashingFunction(String function) {
		hashingFunction = function;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
	public void setTableSize(int size) {
		tableSize = size;
	}
	
	public Counter getCounterObject() {
		return count;
	}
}
