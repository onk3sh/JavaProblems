/**
 * 
 */
package hackerRankJavaTest;

/**
 * @author onkesh.bansal
 *
 */

interface BaseI { void method(); }

class BaseC {
	public void method() {
		System.out.println("Inside BaseC::method");
	}
}

public class ImplC extends BaseC implements BaseI{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new ImplC()).method();
	}

}
