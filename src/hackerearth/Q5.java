package hackerearth;

import java.util.Set;
import java.util.TreeSet;

enum Name {
	Alice, Smith, Bob, Jones
}
public class Q5 {
	public static void main(String[] args) {
		Set<Name> obj = new TreeSet<>();
		obj.add(Name.Alice);
		obj.add(Name.Smith);
		obj.add(Name.Bob);
		obj.add(Name.Jones);
		
		for(Name d : obj) {
			System.out.println(d);
		}
	}
}
