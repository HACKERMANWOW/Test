package calculatorrArabRumVer3_0;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class arab {
	static Scanner scanner = new Scanner(System.in);
	static int numb1, numb2;
	static char operation = 'c';
	static int result;
	public static void main (String[] args) throws IOException {
		
        String[] actions = {"+", "-", "/", "*"};
		 System.out.println("Введите выражение состоящее из арабских чисел от 1 до 10 (3*4) или два римских числа от I до X:(I-V) + Enter ");
		 System.out.println("Принимает 2 числа и один опернта, не больше не меньше");
		 String userInput = scanner.nextLine();
		 String[] blacks = userInput.split(" ");
		 int actionI=-1;
		 if (blacks.length == 3) {
		        for (int i = 0; i < actions.length; i++) {
		            if(userInput.contains(actions[i])){
		            	actionI = i;
		                String s = actions[i];
		                char[] operations = s.toCharArray();
		                operation = operations[0]; 
		                break;
		            }
		        }
		        if  (actionI==-1){
		        	 throw new IllegalArgumentException("Не верный знак операции"); 
		        }
		 }
		 else {
			 throw new IllegalArgumentException("В выражении должно быть два числа и один оперант"); 
		 }
		  String string02= blacks[0];
		  
	        String string03 = blacks[2]; 
	      
	        if(isNumeric(string02)==isNumeric(string03) ) 
	        {
	        	boolean itstrue = true;
	        	boolean itsfolse = false;
	        	if(isNumeric(string02) == itsfolse) {
	        	  numb1 = romanToNumber(string02);
	  	        numb2 = romanToNumber(string03);
	  	  	if( numb1 > 10 || numb2 > 10 || numb1 < 1 || numb2 < 1) {
 	        	System.out.println("калькулятор принимает араб. числа с 1 до 10");
 	           return;
 	        }
	  	            result = calculatr(numb1, numb2, operation);
	  	            System.out.println(".........Результат для римских цифр..........");
	  	            
	  	            String resultRoman = convertNumToRoman(result);
	  	            if(result > 0) {
	  	            System.out.println(string02 + " " + operation + " " + string03 + " = " + resultRoman);
	  	            }
	        	}
	        	if(isNumeric(string02) == itstrue) {
	        	  numb1 = Integer.parseInt(string02);
	  	        numb2 = Integer.parseInt(string03);
	  	        
	  	        result = calculatr(numb1, numb2, operation);
	  	        System.out.println("..........Результат для арабских цифр...........");
	  	        System.out.println(numb1 + " " + operation + " " + numb2 + " = " + result);
	        	}
	        }
	        else {
	        	throw new IllegalArgumentException("throws Exception //т.к. используются одновременно разные системы счисления");  
	        	
	        }    
	}
	
	 private static String convertNumToRoman (int numArabian) throws IOException {
    	 if(numArabian <= 0) {
    		 try {throw new IOException();
    			 } catch(IOException e) {
         	System.out.println("Exception //т.к. в римской системе нет отрицательных чисел, как и нуля");
    			 }
         }
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
       
        final String s = roman[numArabian];
        
        return s;
    }
   
    private static int romanToNumber (String roman) throws InputMismatchException {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return 'G';
    }

    public static int calculatr (int num1, int num2, char oper) {
        int result = 0;
      
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
            	result = num1 / num2;  //исключение не нужно так как вход не принимает цифру 0
                break;
           
        }
        return result;
    }
    public static boolean isNumeric(String string) {
        for (char c : string.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}