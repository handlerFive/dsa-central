
public class App {

    //Function to reverse a string - I
    public static String reverseString(String str) {
        if (str.length() == 0) {
            return "";
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    //Function to reverse a string - II
    public static String reverseStringII(String str) {
        if (str.length() == 0) {
            return "";
        }
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

    //Function to find factorial of a number
    // factorial(4)
    // └── 4 * factorial(3)
    //         └── 3 * factorial(2)
    //                 └── 2 * factorial(1)
    //                         └── 1 * factorial(0)
    //                                 └── 1
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //Function to find the nth Fibonacci number - Using Iteration
    public static int fibIteration(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //Function to find the nth Fibonacci number - Using Recursion
    // fibonacciRecursion(5)
    //     ├── fibonacciRecursion(4)
    //     │   ├── fibonacciRecursion(3)
    //     │   │   ├── fibonacciRecursion(2)
    //     │   │   │   ├── fibonacciRecursion(1) -> 1
    //     │   │   │   └── fibonacciRecursion(0) -> 0
    //     │   │   └── fibonacciRecursion(1) -> 1
    //     │   └── fibonacciRecursion(2)
    //     │       ├── fibonacciRecursion(1) -> 1
    //     │       └── fibonacciRecursion(0) -> 0
    //     └── fibonacciRecursion(3)
    //         ├── fibonacciRecursion(2)
    //         │   ├── fibonacciRecursion(1) -> 1
    //         │   └── fibonacciRecursion(0) -> 0
    //         └── fibonacciRecursion(1) -> 1
    public static int fibRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    //Function to find duplicate in an array of N+1 Integers
    public static int findDuplicate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum - ((nums.length - 1) * nums.length) / 2;
    }

    public static void main(String[] args) throws Exception {
        String str = "racecar";
        System.out.println(reverseStringII(str));
        int[] arr = {1, 3, 4, 2, 2, 5};
        System.out.println(findDuplicate(arr));
    }
}
