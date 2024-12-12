//Function to reverse a string - I 
function reverseString(str: string): string {
    let reversedString = '';
    for (let i = str.length - 1; i >= 0; i--) {
        reversedString += str[i];
    }
    return reversedString;
}

// Function to reverse a string - II
function reverseStringII(str: string): string {
    return str.split('').reverse().join('');
}

//Function to reverse a string - III
function reverseStringIII(str: string): string {
    return [...str].reverse().join('');
}

//Function to reverse a string - IV
function reverseStringIV(str: string): string {
    let x = [...str];
    let start = 0, end = x.length - 1;
    while (start < end) {
        let temp = x[start];
        x[start] = x[end];
        x[end] = temp;
        start++;
        end--;
    }
    return x.join('');
}

//Function to find factorial of a number - Using Iteration 
function factorial(n: number): number {
    let x = 1;
    for (let i = 1; i <= n; i++) {
        x *= i;
    }
    return x;
}

//Function to find factorial of a number - Using Recursion
function factorialRecursion(n: number): number {
    if (n === 0) {
        return 0;
    }
    if (n == 1) return 1;
    return n * factorialRecursion(n - 1)
}

//Function to find the nth Fibonacci number - Using Iteration
function fibonacci(n: number): number {
    let a = 0, b = 1, c = 0;
    if (n == 0) return a;
    if (n == 1) return b;
    for (let i = 2; i <= n; i++) {
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
export function fibonacciRecursion(n: number): number {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
}


let str = 'racecar';
let reversedString = reverseStringIV(str);
console.log(factorial(5));
