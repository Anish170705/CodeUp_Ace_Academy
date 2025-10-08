/**
 * @filename - Main.java
 * @description - This will perform most of the string operation  : Append, CountWords, Replace, isPalindrome,
    Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse
 * @author - Anish Saini 
 */
import java.util.Scanner;
class Main{
    public static void main(String[] args){
        
        System.out.println("Enter the String :");
        Scanner userInput = new Scanner(System.in);
        String input=userInput.nextLine();
        MyString a1=new MyString(input);
       
        System.out.println("Choose operation:");
        System.out.println("""
                            1. Append
                            2. Count Words
                            3. Replace
                            4. isPalindrome
                            5. Splice
                            6. Split
                            7. Max Repeating Character
                            8. Sort
                            9. Shift
                            10. Reverse
                            0. Exit
                            """);

        while(true){
            int choice;
            System.out.println("Enter your choice:");
            choice=userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
            case 1 :
                System.out.println("Enter the append string:");
                String tempString=userInput.next();
                System.out.println("The new String :" +a1.append(tempString));
                break;
            case 2 :
                System.out.println("Total no. word :"+a1.countWords());
                break;
            case 3 :
                System.out.println("The word is:");
                String a=userInput.next();
                System.out.println("replaced by :");
                String k=userInput.next();
                System.out.println("Result:"+a1.replace(a,k));
                break;
            case 4 :
                System.out.println("Palindrome:"+a1.isPalindrome());
                break;
            case 5 :
                System.out.println("Enter starting index and length to splice");
                int start=userInput.nextInt();
                int len=userInput.nextInt();
                System.out.println("Result:"+a1.splice(start,len));
                break;
            case 6 :
                System.out.print("Enter character to split by: ");
                String delimInput = userInput.nextLine();
                char delim = delimInput.isEmpty() ? ' ' : delimInput.charAt(0);
                String[] result = a1.split(delim);        
                for (String part : result) {
                        System.out.println(part);
                    }
                break;
            case 7 :
                System.out.println("Max repeating Character:"+a1.maxReapetCharacter());
                break;
            case 8 :
                System.out.println("Sorted String:"+a1.sort());
                break;
            case 9 :
                System.out.println("Enter the no. of shift:");
                int b=userInput.nextInt();
                System.out.println("After Shift:"+a1.shift(b));
                break;
            case 10 :
                System.out.println("After reverse:"+a1.reverse());
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
