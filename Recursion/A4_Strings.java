package Recursion;

public class A4_Strings {
    static void reverseString(char[] s, int l, int r){
        if(l >= r) return;

        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        reverseString(s, l+1, r-1);
    }

    static boolean checkPalindrome(char[] s, int l, int r){
        if(l >= r) return true;

        if(s[l] != s[r]){
            return false; 
        }
        else {
            return checkPalindrome(s, l+1, r-1);
        }
    }

    static int pow(int a, int b){
        //base case
        if(b == 0){
            return 1;
        }
        
        if(b % 2 == 0){
            return pow(a, b/2) * pow(a, b/2);
        } else{
            return a * pow(a, b/2) * pow(a, b/2);
        }
    }

    public static void main(String[] args) {
        char[] s1 = "abcd".toCharArray();
        reverseString(s1, 0, s1.length-1);
        System.out.println(s1);

        char[] s2 = "abcdcba".toCharArray();
        System.out.println(checkPalindrome(s2, 0, s2.length-1));

        System.out.println(pow(2, 4));


    }
}
