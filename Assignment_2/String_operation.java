/**
 * @filename - String_operation.java
 * @Descripiton - This will perform most of the string operation : (e.g- uniquePalindromesCounter, getnthFibonacci, 
 *                                                                       convertSnakeToCamel, countConsonants, binaryToDecimal, 
 *                                                                       expandCharacter, getCharFrequency, isPrime, numberToWords,
 *                                                                       lengthOfLongestSubstring)
 * @author - Anish Saini
 */

public class String_operation {
    
    // Count Unique Palindromes 
    public int uniquePalindromesCounter(String intputString) {
    String[] uniquePalindromes = new String[intputString.length() * intputString.length()];
    int uniqueCount = 0;

    for (int center = 0; center < intputString.length(); center++) {
        uniqueCount = expandAndStore(intputString, center, center, uniquePalindromes, uniqueCount);

        uniqueCount = expandAndStore(intputString, center, center + 1, uniquePalindromes, uniqueCount);
    }

        return uniqueCount;
    }

    // Expand around center and add unique palindromes manually
    private int expandAndStore(String intputString, int left, int right, String[] uniqueList, int count) {
    while (left >= 0 && right < intputString.length() && intputString.charAt(left) == intputString.charAt(right)) {

        String current = "";
            for (int i = left; i <= right; i++) {
                current += intputString.charAt(i);
            }

            boolean alreadyExists = false;
            for (int i = 0; i < count; i++) {
                if (isSame(uniqueList[i], current)) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                uniqueList[count] = current;
                count++;
            }

            left--;
            right++;
        }
        return count;
    }
     // Compare two strings manually
    private boolean isSame(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    // Fibonacci Sequence – Nth Number
    public int fibonacci(int number){
        if(number <= 1)
        return number;

        int answer = -1;
        int number1 = 0,number2 = 1;
        for(int i = 2;i <= number;i++)
        {
            answer = number1 + number2;
            number1 = number2;
            number2 = answer;
        }
        return answer;      
    }

    // Snake Case to Camel Case Conversion
    public static String convertSnakeToCamel(String snakeCaseString) {
        String result = "";
        boolean toUpper = false;

        for (int i = 0; i < snakeCaseString.length(); i++) {
            char ch = snakeCaseString.charAt(i);

            if (ch == '_') {
                toUpper = true; 
            } else {
                if (toUpper) {
                    if (ch >= 'a' && ch <= 'z') {
                        ch = (char)(ch - 32);
                    }
                    toUpper = false;
                }
                result += ch;
            }
        }

        return result;
    }

    //Count Consonants in a String 

    public int countConsonants(String inputString){
        int count = 0;
        inputString = inputString.toLowerCase();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if ((ch >= 'a' && ch <= 'z') && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                count++;
            }
        }
        return count;
    }

    //Binary to Decimal Conversion
    public int binaryToDecimal(String binaryString){
        int decimalValue = 0;
        int base = 1; // 2^0

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char ch = binaryString.charAt(i);
            if (ch == '1') {
                decimalValue += base;
            }
            base *= 2; // Move to the next power of 2
        }

        return decimalValue;
    }

    //Characters in a String
    public static String expandCharacter(String intputString) {
        String result = "";
        int i = 0;
        while (i < intputString.length()) {
            char ch = intputString.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                i++;
                int count = 0;
                while (i < intputString.length() && intputString.charAt(i) >= '0' && intputString.charAt(i) <= '9') {
                    count = count * 10 + (intputString.charAt(i) - '0');
                    i++;
                }
                for (int j = 0; j < count; j++) {
                    result += ch;
                }
            } else {
                i++;
            }
        }
        return result;
    }

    //character Frequency
    public static String getCharFrequency(String inputString) {
        String result = "";
        int n = inputString.length();

        for (int i = 0; i < n; i++) {
            char ch = inputString.charAt(i);
            int count = 1;

            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (inputString.charAt(k) == ch) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (inputString.charAt(j) == ch) {
                    count++;
                }
            }

            result += ch;
            result += (char)(count + '0');
        }

        return result;
    }
    // Prime Number checker
    public boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i*i <= number ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Number to words Converter
    private static final String[] units = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", 
        "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static String numberToWords(int num) {
        if (num < 0) {
            return "minus " + numberToWords(-num);
        }

        if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            int tenPart = num / 10;
            int unitPart = num % 10;
            if (unitPart == 0) {
                return tens[tenPart];
            } else {
                return tens[tenPart] + " " + units[unitPart];
            }
        } else if (num < 1000) {
            int hundredPart = num / 100;
            int remainder = num % 100;
            if (remainder == 0) {
                return units[hundredPart] + " hundred";
            } else {
                return units[hundredPart] + " hundred " + numberToWords(remainder);
            }
        } else if (num < 10000) {
            int thousandPart = num / 1000;
            int remainder = num % 1000;
            if (remainder == 0) {
                return units[thousandPart] + " thousand";
            } else {
                return units[thousandPart] + " thousand " + numberToWords(remainder);
            }
        } else {
            return "Number too large";
        }
    }
    
    // Returns length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            if (lastIndex[currentChar] >= start) {
                start = lastIndex[currentChar] + 1;
            }

            lastIndex[currentChar] = end;

            int currentLength = end - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
