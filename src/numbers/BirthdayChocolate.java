package numbers;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    // Complete the birthday function below.
	// m = consecutive entries in the list
	// d = sum expected from m consecutive entries
    static int birthday(List<Integer> s, int d, int m) {
    	int res, sum, i;
    	res = 0;
    	sum = 0;
    	for(i=0; i<m; i++ ) {
    		sum += s.get(i); 
    	}
		if(sum == d) res++;
    		
		for (i = m; i < s.size(); i++) {
			sum = sum + (s.get(i) - s.get(i - m)); 
			if(sum == d) res++;
		}
    	
    	return res;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("%HOMEPATH%\\java")));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

//        int result = birthday(s, d, m);
        int result = birthday(s, d, m);


//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println(result);

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
