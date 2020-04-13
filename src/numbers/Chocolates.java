package numbers;
/*
 * Programs
There is one shop, where for 3 chocolate wrappers, we get one new chocolate. 
1 chocolate is for 1 Rs. We have 15 Rs. How many total chologate we can get?

Write code and create a function, that takes Amount as input and returns total number of chocolate we can get. Assume 1 chocolate is for 1 Rs  
15c -> 15 w ->  5 c -> 5 w -> 1c , 2w -> 3w, -> 1c
20c -> 20w -> 6c, 2w -> 8w -> 2c, 2w -> 4w -> 1c, 1w
*/

class Chocolates{
	public static int getChocolates(int money) {
		int count=0, rem=0;
		int price = 1;
		
		count+= money/price;
		
		while(money >=3) {
			count += money/3;
			money = money/3;
			if(money/3 > 1) {
				count+=money/3;
			}
			rem+= money%3;
		}
		if(rem>=3) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getChocolates(15));
		System.out.println(getChocolates(20));
		System.out.println(getChocolates(11));
		System.out.println(getChocolates(3));

	}
}