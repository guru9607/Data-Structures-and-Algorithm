package Recursion;

public class A1_BasicQuestions {


    public static int factorial(int n){

        //base case
        if(n == 0) return 1;

        int smallerProblem = factorial(n-1);
        int biggerProbem = n * smallerProblem;

        return biggerProbem;
    }

    public static int pow(int n){
        if( n == 0) return 1;

        return n * pow(n-1);
    }

    static void print(int n){
        // base case
        if(n == 0) return;

        // Recursive Relation
        print(n-1);

        // Processing
        System.out.print(n + " ");
    }

    static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n== 2) return 2;

        int result = 0;
        int prev1 = 1;
        int prev2 = 2;

        for(int i = 3; i <= n; i++){
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5 is: " + factorial(5));
        System.out.println("Power of 2 is: " + pow(2));
        System.out.print("Print from 1 to 5: ");
        print(5);
        System.out.println();
        System.out.println("Cimb stairs: " + climbStairs(5));
    }
}