/**
 * @filename - MyString.java
 * @description - This will perform most of the string operation
 * @author - Anish Saini 
 */
import java.util.Scanner;

class Main{
     public static void main(String[] args)
    {
        
        System.out.println("Enter the String :");
        Scanner sc=new Scanner(System.in);
      String input=sc.next();
       MyString a1=new MyString(input);
       
       System.out.println("Choose operation:");
       System.out.println("1. Append\n2. CountWords\n3. Replace\n4. isPalindrome\n5. Splice\n6. Split\n7. MaxRepeatingCharacter\n8. Sort\n9. Shift\n10.Reverse\n0.Exit");
   while(true){ int n;
    System.out.println("Enter your choice:");
    n=sc.nextInt();
    switch (n) {
        case 1 :
        System.out.println("Enter the append string:");
        String p=sc.next();
        System.out.println("The new String :" +a1.append(p));
            break;
        case 2 :
        System.out.println("The count word :"+a1.countWords());
            break;
        case 3 :
        System.out.println("The word is:");
         String a=sc.next();
         System.out.println("replaced by :");
         String k=sc.next();
        System.out.println(a1.replace(a,k));
            break;
        case 4 :
        System.out.println(a1.isPalindrome());
        break;
        case 5 :
        System.out.println("Enter starting index and length to splice");
        int start=sc.nextInt();
        int len=sc.nextInt();
        System.out.println(a1.splice(start,len));
            break;
        
        case 6 :
        System.out.println("Enter the string which you want to split:");
        String text=sc.nextLine();
        System.out.println(a1.split(text));
            break;
         case 7 :
        System.out.println(a1.maxReapet());
            break;
         case 8 :
        System.out.println(a1.sort());
            break;
         case 9 :
         System.out.println("Enter the no. of shift:");
         int b=sc.nextInt();
        System.out.println(a1.shift(b));
            break;
         case 10 :
        System.out.println(a1.reverse());
            break;
        case 0:
        System.out.println("Exit");
        return ;       
        default:
            break;
    }}
    }    
}