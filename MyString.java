/**
 * @filename - MyString.java
 * @description - This will perform most of the string operation
 * @author - Anish Saini 
 * 
 */
import java.util.*;

class MyString{
    private String curr="MyString"; 
    MyString(){}
    MyString(String s)
    {
        curr=s;
    }
    public String append(String newString)
    {
        
        curr+=" "+newString;
        return curr;
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

   public ArrayList<String> split(char element) {
    ArrayList<String> parts = new ArrayList<>();
    StringBuilder cur = new StringBuilder();

    for (int i = 0; i < curr.length(); i++) {
        char ch = curr.charAt(i);
        if (ch == element) {
            parts.add(cur.toString());
            cur.setLength(0); 
        } else {
            cur.append(ch);
        }
    }

    parts.add(cur.toString());

    return parts;
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
       
}