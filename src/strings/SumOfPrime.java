package strings;

public class SumOfPrime {
	final static double MAXArrayLength = 10000 ; 
    static boolean arrPrime[] = new boolean [(int) (MAXArrayLength + 1.0)] ;  
    static void setupPrimeBooleanArray()  
    {  
           
        for(int i = 0; i <= MAXArrayLength; i++) 
        {
            arrPrime[i] = true ; 
        } 
        
        arrPrime[1] = false;  
        
        for (int k = 2; k * k <= MAXArrayLength; k++) {  
        
            if (arrPrime[k] == true) {  
        
                for (int i = k * 2; i <= MAXArrayLength; i += k)  
                    arrPrime[i] = false;  
            }  
        }  
    }  
        
      
    static int solve(int n)  
    {  
          
        int count = 0, num = 1;  
        
          
        long sum = 0;  
        
        while (count < n) {  
        
              
            if (arrPrime[num]) {  
                sum += num;  
        
                count++;  
            }  
        
            num++;  
        }  
        return (int) sum;  
    }  
      
    public static void main(String args[]) 
    { 
        setupPrimeBooleanArray();  
        
        int n = 10;  
        
        System.out.println("N prime numbers Sum is :" + solve(n));  
            
    } 

}
