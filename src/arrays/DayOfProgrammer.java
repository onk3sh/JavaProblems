/**
 * 
 */
package arrays;

/**
 * @author onkesh.bansal
 *
 *         link: https://www.hackerrank.com/challenges/day-of-the-programmer/
 */
public class DayOfProgrammer {

	// Complete the dayOfProgrammer function below.
	// Find the 256th day of the year as per Russian calendar

	static boolean isLeapYear(int year) {
		boolean flag = false;
		if (year > 1918) {
			if (year % 400 == 0)
				flag = true;
			if (year % 4 == 0 && year % 100 != 0)
				flag = true;
		} else {
			if (year % 4 == 0)
				flag = true;
		}

		return flag;
	}

	/*
	 * sum of all days from January till August is 244 in leap year and 243
	 * otherwise in leap year, February = 29 else 28 For 256th date, well subtract
	 * the sum from 256
	 */
	static String dayOfProgrammer(int year) {

		int dd = 13;
		if (year == 1918)
			dd = 26; // Special case due to 14 days shift

		if (isLeapYear(year))
			dd = 12;

		return dd + ".09." + year;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int year = 1800;
		System.out.println(dayOfProgrammer(year));

//		for(int i = year; i<2017; i++) {
//			System.out.println(dayOfProgrammer(i));
//		}

	}

}
