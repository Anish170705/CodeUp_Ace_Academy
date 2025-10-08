import java.util.*;

class Strings{
    String curr=""; 
    public String append(String newString)
    {
        
        String ans=curr+" "+ newString;
        return ans;
    }
    public int countWords()
    {
       if(curr==null || curr.trim().isEmpty())
       return 0;

       String[] word=curr.trim().split("\\s+");
       return word.length;
    }
    public String replace(String a,String b)
    {
        String s="";
        int flag=0;
       int i=0;
       while(i<curr.length())
       {
        if(curr.charAt(i)==a.charAt(0))
        {flag=0;
            String p="";
            for(int k=0;k<a.length();k++)
            {
                if(i<curr.length() && curr.charAt(i)==a.charAt(k))
                {
                    
                    p+=curr.charAt(i);
                    i++;
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                s+=p;
            }
            else
            s+=b;
        }
        else
        {
            s+=curr.charAt(i);
            i++;
        }
       }
       return s;
    }
    public boolean isPalindrome()
    {
        int i=0;
        int j=curr.length()-1;
        while(i<j)
        {
            if(curr.charAt(i)!=curr.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }

    public String splice(int start,int len)
    {
        int i=0;
    String ans="";
    while(i<curr.length())
    {
        if(i>=start&&i<start+len)
        {i++;
            continue;}
        ans+=curr.charAt(i);
        i++;

    }
    return ans;
    }

    public String[] split(String pattern)
    {
           String[] word=curr.trim().split("\\s+");
           return word;
    }

    public String maxReapet()
{
    int[]freq=new int[256];
    int max=0;
    char maxchar=' ';
    for(int i=0;i<curr.length();i++)
    {
        char ch=curr.charAt(i);
        if(ch!=' '){
            freq[ch]++;
            if(freq[ch]>max)
            {
                max=freq[ch];
                maxchar=ch;
            }
        }
    }
    return "Max Repeated character is : "+maxchar+" count is: "+max;

}
    public String sort()
    {
        char[] c=curr.toCharArray();
        for(int i=0;i< c.length-1;i++)
        {
            for(int j=0;i<c.length-i-1;j++)
            {
                if(c[j]>c[j+1])
                {
                    char temp=c[j];
                    c[j]=c[j+1];
                    c[j+1]=temp;
                }
            }
        }
        return new String(c);
    }
    public String shift(int n)
    {
        String ans="";
        n=n%curr.length();
        if(n==0)
        return curr;
        int n1=curr.length();
        for(int i=n1-n;i<n1;i++)
        {
            ans+=curr.charAt(i);
        }
        for(int i=0;i<(n1-n);i++)
        ans+=curr.charAt(i);
        return ans;
    }
    public String reverse()
    {
        String newstr="";
        for(int i=curr.length()-1;i>=0;i--)     
        {
            newstr+=curr.charAt(i);
        }
        return newstr;
    }
        public static void main(String[] args)
    {
       Strings a1=new Strings();
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the String :");
       a1.curr=sc.next();
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