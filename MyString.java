/**
 * @filename - MyString.java
 * @description - This will perform most of the string operation : Append, CountWords, Replace, isPalindrome,
    Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse
 * @author - Anish Saini 
 */

 class MyString{
    private String inputString = "MyString"; 

    MyString(String userInput)
    {
        this.inputString = userInput;
    }
    @Override
    public String toString(){
        return this.inputString;
    }
    public String append(String newString){
        this.inputString += " " + newString;
        return this.inputString;
    }
    public int countWords(){
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < this.inputString.length(); i++) {
            char ch = this.inputString.charAt(i);
            if (ch != ' ' && ch != '\t') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return count;
    }
    public String replace(String a,String b)
    {
        String newString = "";
        int flag = 0;
        int i = 0;
        while(i < this.inputString.length())
        {
        if(this.inputString.charAt(i) ==  a.charAt(0)){
            flag = 0;
            String tempString = "";
            for(int k = 0; k < a.length(); k++){
                if(i < this.inputString.length() && inputString.charAt(i) == a.charAt(k)){ 
                    tempString += this.inputString.charAt(i);
                    i++;
                } else {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                newString += tempString;
            } else{
                newString +=  b; }
        }  else{
           newString += this.inputString.charAt(i);
           i++; 
        }
       }
       return newString;
    }
    public boolean isPalindrome()
    {
        int i = 0;
        int j = this.inputString.length() - 1;
        while(i < j){
            if(this.inputString.charAt(i) != this.inputString.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }

    public String splice(int start,int len)
    {
        int i = 0;
        String ans = "";
        while(i < this.inputString.length())
        {
        if(i >= start && i < start + len){   
            i++;
            continue;
        }
        ans += this.inputString.charAt(i);
        i++;
        }
        return ans;
    }

   public String[] split(char element) {
        int parts = 1;
        for (int i = 0; i < this.inputString.length(); i++) {
            if (this.inputString.charAt(i) == element)
                parts++;
        }

        String[] result = new String[parts];
        for (int i = 0; i < parts; i++) 
            result[i] = "";

        int idx = 0;
        for (int i = 0; i < this.inputString.length(); i++) {
            if (this.inputString.charAt(i) == element)
                idx++;
            else 
                result[idx] += this.inputString.charAt(i);
        }
        return result;
    }
    public char maxReapetCharacter()
    {
    int[]freq = new int[256];
    int max = 0;
    char maxchar = ' ';
    for(int i = 0;i < this.inputString.length();i++)
    {
        char ch = this.inputString.charAt(i);
        if(ch != ' '){
            freq[ch]++;
            if(freq[ch] > max)
            {
                max = freq[ch];
                maxchar = ch;
            }
        }
    }
    return maxchar;

}
    public String sort()
    {
        char[] c=this.inputString.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = 0; j < c.length - i - 1; j++) { 
                if (c[j] > c[j + 1]) {
                char temp = c[j];
                c[j] = c[j + 1];
                c[j + 1] = temp;
                }
            }   
        }
        return new String(c);
    }
    public String shift(int choice)
    {
        String ans = "";
        choice = choice % this.inputString.length();
        if(choice == 0)
        return this.inputString;
        int n1 = this.inputString.length();
        for(int i = n1-choice;i < n1;i++){
            ans += this.inputString.charAt(i);
        }
        for(int i = 0;i < (n1-choice);i++)
        ans+=this.inputString.charAt(i);
        return ans;
    }
    public String reverse()
    {
        String newString = "";
        for(int i = this.inputString.length() - 1;i >= 0;i--){
            newString += this.inputString.charAt(i);
        }
        return newString;
    }
}