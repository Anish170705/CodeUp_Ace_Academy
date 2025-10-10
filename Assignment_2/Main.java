/**
 * @filename - Main.java
 * @Descripiton - This will perform most of the string operation 
 * @author - Anish Saini
 */

import java.util.Scanner;
class Main{
    public static void main(String[] args){
        
        System.out.println("Enter the String :");
        Scanner userInput = new Scanner(System.in);
        String_operation operation=new String_operation();
       
        System.out.println("Choose operation:");
        System.out.println("""
                            1. Count Unique Palindromes substring
                            2. Nth Fibonacci Sequence
                            3. Convert snake_case to camelCase
                            4. Count consonants in a string
                            5. Binary to Decimal conversion
                            6. Expand characters based on digits
                            7. Character frequency in a string
                            8. Check if a number is prime
                            9. Convert number to words
                            10.Length of longest substring without repeating characters
                            0. Exit
                            """);

        while(true){
            int choice;
            System.out.println("Enter your choice:");
            choice=userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
            case 1 :
                System.out.print("Enter a string: ");
                String inpuString=userInput.nextLine();
                System.out.println("Total unique palindromic substrings: " + operation.uniquePalindromesCounter(inpuString));
                break;
            case 2 :
                System.out.print("Enter N: ");
                int n = userInput.nextInt();
                System.out.println("Total no. word :"+operation.fibonacci(n));
                break;
            case 3 :
                System.out.print("Enter snake_case string: ");
                String snake = userInput.nextLine();
                System.out.println("CamelCase: " + operation.convertSnakeToCamel(snake));
                break;
            case 4 :
                System.out.print("Enter a string: ");
                String inpuString1=userInput.nextLine();
                System.out.println("Number of consonants: " + operation.countConsonants(inpuString1));
                break;
            case 5 :
                System.out.print("Enter binary string: ");
                String binary = userInput.nextLine();
                int decimal = operation.binaryToDecimal(binary);
                System.out.println("Decimal: " + decimal);
                break;
            case 6 :
                System.out.print("Enter string with characters followed by numbers: ");
                String expand = userInput.nextLine();
                System.out.println("Expanded string: " + operation.expandCharacter(expand));
                break;
            case 7 :
                System.out.print("Enter a string: ");
                String freqStr = userInput.nextLine();
                System.out.println("Character frequency: " + operation.getCharFrequency(freqStr));
                break;
            case 8 :
                System.out.print("Enter a number: ");
                int num = userInput.nextInt();
                boolean prime = operation.isPrime(num);
                System.out.println((prime ? "The given number is PRIME" : "The given number is NOT prime"));
                break;
            case 9 :
                System.out.print("Enter a number: ");
                int numWords = userInput.nextInt();
                System.out.println("Number in words: " + operation.numberToWords(numWords));
                break;
            case 10 :
                System.out.print("Enter a string: ");
                String str3 = userInput.nextLine();
                int maxLength = operation.lengthOfLongestSubstring(str3);
                System.out.println("Length of longest substring without repeating characters: " + maxLength);
                break;
            case 0:
                System.out.println("Exit");
                return ;       
            default:  
                System.out.println("Invalid choice");
            }       
        }
    }    
}
