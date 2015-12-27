package Model;

public class Counter {
	
	/**
	 * The main purpose of this class is a placeholder for counter
	 * Collision handling classes will extends this class to inherit all the methods.
	 * Thus, when these class perform algorithms, the counter is automatically increased.
	 */
	
	private static int comparison = 0;
	private static int collision = 0;
	
	public int getComparisons() {
		return comparison;
	}
	
	public static void incrementComparison() {
		comparison++;
	}
	
	public void setComparison(int number) {
		comparison = number;
	}
	
	public int getCollisions() {
		return collision;
	}
	
	public static void incrementCollisions() {
		collision++;
	}
	
	public void setCollisions(int number) {
		collision = number;
	}
}
