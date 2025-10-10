import java.util.Scanner;
class Main{
    public static void main(String[] args){
        
        System.out.println("Enter the String :");
        Scanner userInput = new Scanner(System.in);
        String input=userInput.nextLine();
        MyString operation=new MyString(input);
       
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
                System.out.println("The new String :" +operation.append(tempString));
                break;
            case 2 :
                System.out.println("Total no. word :"+operation.countWords());
                break;
            case 3 :
                System.out.println("The word is:");
                String a=userInput.next();
                System.out.println("replaced by :");
                String k=userInput.next();
                System.out.println("Result:"+operation.replace(a,k));
                break;
            case 4 :
                System.out.println("Palindrome:"+operation.isPalindrome());
                break;
            case 5 :
                System.out.println("Enter starting index and length to splice");
                int start=userInput.nextInt();
                int len=userInput.nextInt();
                System.out.println("Result:"+operation.splice(start,len));
                break;
            case 6 :
                System.out.print("Enter character to split by: ");
                String delimInput = userInput.nextLine();
                char delim = delimInput.isEmpty() ? ' ' : delimInput.charAt(0);
                String[] result = operation.split(delim);        
                for (String part : result) {
                        System.out.println(part);
                    }
                break;
            case 7 :
                System.out.println("Max repeating Character:"+operation.maxRepeatCharacter());
                break;
            case 8 :
                System.out.println("Sorted String:"+operation.sort());
                break;
            case 9 :
                System.out.println("Enter the no. of shift:");
                int b=userInput.nextInt();
                System.out.println("After Shift:"+operation.shift(b));
                break;
            case 10 :
                System.out.println("After reverse:"+operation.reverse());
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
