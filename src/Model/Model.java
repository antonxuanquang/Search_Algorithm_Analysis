package Model;

import java.util.ArrayList;

public class Model {
	
	/**
	 * This class is the place to hold all data, including missing keys table, present 
	 * 	keys table, random keys table, and the hash table after built
	 * Additionally, this class also stores information about current collision handling 
	 * 	method, hashing function, and table size
	 * This is the only place where counter is initiate; hence keeping the data clean and
	 * 	correct
	 */
	
	private String [] hashTable;
	private ArrayList<String> randomKeys, missingKeys, presentKeys;
	private int tableSize;
	private String collisionHandler, hashingFunction;
	private Counter count = new Counter();
	
	public Model() {}
	
	public String[] getHashTable() {
		return hashTable;
	}
	
	public void setHashTable (String [] table) {
		hashTable = table;
	}
	
	public ArrayList<String> getRandomKeysTable() {
		return randomKeys;
	}
	
	public void setRandomKeysTable(ArrayList<String> table) {
		randomKeys = table;
	}
	
	public ArrayList<String> getMissingKeysTable() {
		return missingKeys;
	}
	
	public void setMissingKeysTable(ArrayList<String> table) {
		missingKeys = table;
	}
	
	public ArrayList<String> getPresentKeysTable() {
		return presentKeys;
	}
	
	public void setPresentKeysTable(ArrayList<String> table) {
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
