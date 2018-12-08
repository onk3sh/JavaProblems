package stackoverflow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {
	
	public static void main(String[] args) {
	    String filename= "C:\\Users\\onkesh.bansal\\eclipse-workspace\\Problems\\src\\stackoverflow\\brock.txt";
	    String line; 
	    String [] cities = new String[10];
	    int x = 0;
	    try {

	    BufferedReader eshread = new BufferedReader( new FileReader (filename));
	        line = "";

	        while ((line = eshread.readLine()) != null ) {
	        String[] store = line.split(",");
	        System.out.println(store[0]);
	        System.out.println(store[1]);
	        System.out.println(store[2]);
	        cities[x] = store[2];            //< keep getting an error here
	        x++;
	        }//end while loop
	        eshread.close();
	        }//end try
	    catch(IOException iox) {
	    System.out.println("failiure");
	    }//end catch

	}
}
