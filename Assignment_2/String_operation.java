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
        public int uniquePalindromesCounter(String inputString) {
        String[] uniquePalindromes = new String[inputString.length() * inputString.length()];
        int uniqueCount = 0;

        for (int center = 0; center < inputString.length(); center++) {
            // Odd-length palindromes
            uniqueCount = expandAndStore(inputString, center, center, uniquePalindromes, uniqueCount);

            // Even-length palindromes
            uniqueCount = expandAndStore(inputString, center, center + 1, uniquePalindromes, uniqueCount);
        }

        System.out.println("\nTotal unique palindromes: " + uniqueCount);
        return uniqueCount;
         }

    // Expand around center and add unique palindromes manually
        private int expandAndStore(String inputString, int left, int right, String[] uniqueList, int count) {
            while (left >= 0 && right < inputString.length() && inputString.charAt(left) == inputString.charAt(right)) {

                // Build current substring
                String current = "";
                for (int i = left; i <= right; i++) {
                    current += inputString.charAt(i);
                }

                // Check if already exists
                boolean alreadyExists = false;
                for (int i = 0; i < count; i++) {
                    if (isSame(uniqueList[i], current)) {
                        alreadyExists = true;
                        break;
                    }
                }

                // If unique, store and print
                if (!alreadyExists) {
                    uniqueList[count] = current;
                    System.out.println(current);
                    count++;
                }

                left--;
                right++;
            }
        return count;
    }

    // Compare two strings manually (without using equals)
    private boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
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
    int start = 0;     // start of current window
    int maxStart = 0;  // start index of longest substring

    int[] lastIndex = new int[256];
    for (int i = 0; i < 256; i++) {
        lastIndex[i] = -1;
    }

    for (int end = 0; end < n; end++) {
        char currentChar = s.charAt(end);

        // If character was seen and inside the current window, move start
        if (lastIndex[currentChar] >= start) {
            start = lastIndex[currentChar] + 1;
        }

        // Update last seen index
        lastIndex[currentChar] = end;

        int currentLength = end - start + 1;

        // If we found a longer substring, record its start and length
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStart = start;
        }
    }

    // Print the longest substring
    String longestSubstring = s.substring(maxStart, maxStart + maxLength);
    System.out.println("Longest substring without repeating characters: " + longestSubstring);
    System.out.println("Length: " + maxLength);

    return maxLength;
}

}
