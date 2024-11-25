// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		System.out.println(sqrt(263169));
		//System.out.println(minus(0,2));
	    /*System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));*/
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1 < 0 && x2 < 0){
			for(int i = 0; i > x2; i--) x1 -= 1;
			return x1;
		}
		for(int i = 0; i < x2; i++) x1 += 1;
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if ((x1 <= 0 && x2 < 0) || (x1 >= 0 && x2 < 0)){
			for(int i = 0; i > x2; i--) x1 += 1;
			return x1;
		}
		
		for(int i = 0; i < x2; i++) x1 -= 1;
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) return 0;
		int x = x1;
		if (x1 < 0 && x2 < 0){
			x1 = 0;
			for(int i = 0; i > x2; i--) x1 = minus(x1, x);
			return x1;
		}
		
		for(int i = 1; i < x2; i++) x1 = plus(x1, x);
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) return 1;
		int x1 = x;
		if(x1 < 0) x1 = minus(0, x1);
		//x1 = x;
		for(int i = 1; i < n; i++) x = times(x, x1);
		
		if(x1 < 0) return minus(0, x);
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0) return 0;

		int x = x1;
		int y = x2;
		if (x < 0) x1 = minus(0, x1);
		if (y < 0) x2 = minus(0, x2);

		if (x1 > x2) {
			int divisor = 0;
			while (x1 >= 0){ 
				x1 = minus(x1, x2);
				divisor += 1;

				if (x < 0 && y > 0){
					if (x1 == 0) return minus(0, divisor);
					if (x1 < 0) return minus(0,(minus(divisor, 1)));
				}

				if (x1 == 0) return divisor;
				if (x1 < 0) return minus(divisor, 1);
				
				}
			}

		if(x1 < x2) return 0;
		return 1; //for the case of equality between the integers
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divisor = 0;
		if(x1 < x2) return x1;
		if (x1 == 0 || x1 == x2) return 0;

		int t = 0;
		int i = 1;
		while(true){
			t = times(x2, i);
			i += 1;
			if (t == x1) return 0;
			if (plus(t, x2) > x1) return minus(x1, t);
		}

	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		while(true){
			if (times(i, i) == x) return i;
			if (times(i, i) > x) return minus(i, 1);
			i += 1;
		}
	}	  	  
}