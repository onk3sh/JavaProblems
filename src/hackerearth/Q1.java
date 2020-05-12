/**
 * 
 */
package hackerearth;

/**
 * @author onkesh.bansal
 *
 */

class HackerEarth {
	
	public void print() {
		System.out.println("In HackerEarth");
	}

}

class Hacker extends HackerEarth {
	public void print() {
		System.out.println("In Hacker");
	}
}

public class Q1 {
	public static void main(String[] args) {
		HackerEarth obj1 = new HackerEarth();
		Hacker obj2 = new Hacker();

		((HackerEarth) obj2).print();
		
		obj1 = obj2;
		
		obj1.print();
		
		
				
	}
}

