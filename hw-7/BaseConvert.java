/*========== BaseConvert.java ==========

  Contains 4 static methods to convert between bases

  decimalToBinary
       takes an integer and returns it as a binary (base 2) String

  binaryToDecimal
       takes a binary string and returns it as a decimal (base 10)
       int

  decimalToAnyBase
       takes an integer and returns it as a String in a specified
       base. If the base is > 10, the letters A-Z are used for 
       the extra digits

  anyBaseToDecimal
       takes a string representing a number in the specified base
       and returns it as a decimal (base 10) int
  
  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class BaseConvert 
{
    /*======== public static String decimalToBinary() ==========
      Inputs:  int d 
      Returns: Binary string representation of d
      
      Converts a decimal (base 10) number to a binary (base 2) String
      using the following algorithm:
           1. push the remainder of the number when divided by 
              2 onto a stack 
           2. divide the number by 2
	   3. repeat steps 1 and 2 until the number is 0
	   4. build a string by popping each entry off the stack
	   
      03/01/12 14:32:31
      jdyrlandweaver
      ====================*/
    public static String decimalToBinary(int d)
    {
	AStack<Integer> stack = new AStack<Integer>();
	String result = "";
	if(d < 0)
	{
	    d = 0 - d;
	    result = result + "-";
	}
	if(d == 0)
	{
	    return "0";
	}
	while(d > 0)
	{
	    stack.push(d % 2);
	    d = d / 2;
	}
	while(!stack.isEmpty())
	{
	    result = result + stack.pop();
	}
	return result;
    }

    /*======== public static int binaryToDecimal() ==========
      Inputs:   String n  
      Returns:  the decimal value of n

      A binary String can be converted to a decimal value using
      the following algorithm:
           1. go through the string one character at a time,
	      pushing each character onto a stack
	      Characters are not integers, so you should convert 
	      them to integer values when pushing them onto the stack. 
	      Remember that characters are primitives, which can be
	      used like ints (i.e. subtraction of characters works)	      
	   2. take a cumulative sum of the values of the stack by
	      popping each value off the stack and multiplying it
	      by successive powers of 2 (i.e. the first element
	      should be multiplied by 2^0, the second by 2^1 ...)
	   3. return that cumulative sum

	   4. profit

	   To use exponents, call Math.pow( base, power )

      03/01/12 14:36:52
      jdyrlandweaver
      ====================*/
    public static int binaryToDecimal(String n)
    {
	boolean negative = (n.charAt(0) == '-');
	AStack<Integer> stack = new AStack<Integer>();
	for(int i = negative ? 1 : 0; i < n .length(); i++)
	{
	    stack.push(n.charAt(i) - '0');
	}
	int result = 0;
	for(int m = 1; !stack.isEmpty(); m = m * 2)
	{
	    result = result + stack.pop() * m;
	}
	return negative ? 0 - result: result;
    }

    
    /*======== public static String decimalToAnyBase() ==========
      Inputs:  int d
               int b 
      Returns: A String representing d in base b

      The algorithm used in the decimalToBinary method can be
      generalized to work with any base with a few changes.

      * find the remainder of d with b, and divide by b instead
        of 2
      * if b <= 10, your remaiders (and resulting digits) will be
        in the range [0, 9]
      * when b > 10, you are going to need more digits, since the 
        remainders will be in the range [0, b-1] use capital 
        letters for these extra digits (i.e. in base 14, A = 10, 
	B = 11, C = 12 and D = 13)


      03/01/12 14:42:04
      jdyrlandweaver
      ====================*/
    public static String decimalToAnyBase(int d, int b)
    {
	AStack<Integer> stack = new AStack<Integer>();
	String result = "";
	if(d < 0)
	{
	    d = 0 - d;
	    result = result + "-";
	}
	if(d == 0)
	{
	    return "0";
	}
	while(d > 0)
	{
	    stack.push(d % b);
	    d = d / b;
	}
	while(!stack.isEmpty())
	{
	    int c = stack.pop();
	    if(c < 10)
	    {
		result = result + c;
	    }
	    else
	    {
		result = result + (char)(c - 10 + 'A');
	    }
	}
	return result;
    }

    /*======== public static int anyBaseToDecimal() ==========
      Inputs:   String n
                int base  
      Returns: The decimal value of n in base base
      
      The algorithm used in the anyBaseToDecimal method can be
      generalized to work with any base with a few changes.

      * instead of multiplying by powers of 2, multiply by 
        powers of base
      * If base > 10, the string may have non numeric digits. Make
        sure you convert those letters to numbers. (i.e. A => 10, 
	B => 11, C => 12...)

      03/01/12 14:56:08
      jdyrlandweaver
      ====================*/
    public static int anyBaseToDecimal( String n, int base )
    {
	boolean negative = (n.charAt(0) == '-');
	AStack<Integer> stack = new AStack<Integer>();
	for(int i = negative ? 1 : 0; i < n .length(); i++)
	{
	    char c = n.charAt(i);
	    if(c <= '9' && c >= '0')
	    {
		stack.push(c - '0');
	    }
	    else
	    {
		stack.push(c - 'A' + 10);
	    }
	}
	int result = 0;
	for(int m = 1; !stack.isEmpty(); m = m * base)
	{
	    result = result + stack.pop() * m;
	}
	return negative ? 0 - result: result;
    }
    

    /*======== public static void main() ==========
      Inputs:  String[] args 
      Returns: 

      The following main method will perform some basic tests using
      the binary mehtods as well as the any base methods, using base
      16 so as to test the extra digit functionality.

      Feel free to add more tests.

      03/01/12 15:10:26
      jdyrlandweaver
      ====================*/
    public static void main(String[] args) 
    {
	System.out.println( decimalToBinary(5) );
	System.out.println( decimalToBinary(15) );
	System.out.println( decimalToBinary(16) );
	System.out.println( binaryToDecimal(decimalToBinary(5)) );
	System.out.println( binaryToDecimal(decimalToBinary(15)) );
	System.out.println( binaryToDecimal(decimalToBinary(16)) );
	

	System.out.println( decimalToAnyBase(5,16) );
	System.out.println( decimalToAnyBase(16,16) );
	System.out.println( decimalToAnyBase(15,16) );
	System.out.println( anyBaseToDecimal(decimalToAnyBase(5,16), 16) );
	System.out.println( anyBaseToDecimal(decimalToAnyBase(16,16), 16) );
	System.out.println( anyBaseToDecimal(decimalToAnyBase(15,16), 16) );
    }
}