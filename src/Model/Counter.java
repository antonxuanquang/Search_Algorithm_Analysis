package Model;

public class Counter {
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
