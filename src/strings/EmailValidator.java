package strings;

import java.util.*;

import javax.xml.crypto.dsig.Transform;

public class EmailValidator {
	
	public static String transformStr(String str) {
		String str2 = "";
		int i = 0;
		while(i<str.length()) {
			if(str.charAt(i)=='.') 
				i++;
			else if(str.charAt(i)== '+') {
				while(str.charAt(i)!= '@')
					i++;
			}
			if(str.charAt(i)=='@')
				break;
			str2+=String.valueOf(str.charAt(i));
			i++;
		}
		while(i<str.length()) {
			str2+=String.valueOf(str.charAt(i));
			i++;
		}
		return str2;
	}
	public static void main(String[] args) {
		String[] arr =  {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		Set<String> res = new HashSet<>();
		for(String s: arr) {
			String temp = transformStr(s);
			if(res.contains(temp) == false) {
				res.add(temp);
			}
		}
		
		System.out.println(res.size());
		
	}

}
