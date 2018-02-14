//	Andrew Shao
//	APCS2 pd2
//	HW07 -- A Man, A Plan, A Canal: Panama!
//	2018-02-14W

public class Resrever {
	
	
	/***	
	Linear runtime method
	
	Algorithm:
	If the string is of length 1, return the string.
	Else concatenate the first letter of the string reversed to the rest of the string reversed and return it.
	***/
	public static String reverseLin( String str ) 
	{
		if(str.length() == 1)
			return str;
		return reverseLin(str.substring(1, str.length())) + reverseLin(str.substring(0, 1));
	}
	
	
	/***
	Logarithmic runtime method
	
	Algorithm:
	If the string is of length 1, return the string.
	Else concatenate the first half of the string reversed to the rest of the string reversed and return it.
	***/
	public static String reverseLog( String str ) 
	{
		if(str.length() == 1)
			return str;
		return reverseLog(str.substring(str.length()/2, str.length())) + reverseLog(str.substring(0, str.length()/2));
	}
	
	
	/***
	Random string generator
	
	Returns a string of random length with randomly generated letters.
	***/
	public static String randStr()
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String retStr = "";
		while(Math.random() > 0.02)
			retStr += alphabet.substring((int) (Math.random() * 26), 26).substring(0,1);
		return retStr;
	}
	
	
	public static void main( String args[] )
	{
		//	tests
		
		//System.out.println(randStr()); //random string generator test
		String str1 = randStr();
		String str2 = randStr();
		
		System.out.println("tests:");
		System.out.println("\nOriginal: a");
		System.out.println("Linear time method: " + reverseLin("a"));
		System.out.println("Logarithmic time method: " + reverseLog("a"));
		
		System.out.println("\nOriginal: at");
		System.out.println("Linear time method: " + reverseLin("at"));
		System.out.println("Logarithmic time method: " + reverseLog("at"));
		
		System.out.println("\nOriginal: stressed");
		System.out.println("Linear time method: " + reverseLin("stressed"));
		System.out.println("Logarithmic time method: " + reverseLog("stressed"));
		
		System.out.println("\nOriginal: " + str1);
		System.out.println("Linear time method: " + reverseLin(str1));
		System.out.println("Logarithmic time method: " + reverseLog(str1));
		
		System.out.println("\nOriginal: " + str2);
		System.out.println("Linear time method: " + reverseLin(str2));
		System.out.println("Logarithmic time method: " + reverseLog(str2));
	}
	
	
}