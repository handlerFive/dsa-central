"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.fibonacciRecursion = fibonacciRecursion;
//Function to reverse a string - I 
function reverseString(str) {
    let reversedString = '';
    for (let i = str.length - 1; i >= 0; i--) {
        reversedString += str[i];
    }
    return reversedString;
}
// Function to reverse a string - II
function reverseStringII(str) {
    return str.split('').reverse().join('');
}
//Function to reverse a string - III
function reverseStringIII(str) {
    return [...str].reverse().join('');
}
//Function to reverse a string - IV
function reverseStringIV(str) {
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
function factorial(n) {
    let x = 1;
    for (let i = 1; i <= n; i++) {
        x *= i;
    }
    return x;
}
//Function to find factorial of a number - Using Recursion
function factorialRecursion(n) {
    if (n === 0) {
        return 0;
    }
    if (n == 1)
        return 1;
    return n * factorialRecursion(n - 1);
}
//Function to find the nth Fibonacci number - Using Iteration
function fibonacci(n) {
    let a = 0, b = 1, c = 0;
    if (n == 0)
        return a;
    if (n == 1)
        return b;
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
function fibonacciRecursion(n) {
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
}
//Function to find the nth Fibonacci number - Using Memoization
function fibonacciMemoization(n, memo = {}) {
    if (n in memo)
        return memo[n];
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
    return memo[n];
}
//Functin to find the duplicate value in an array
function findDuplicate(arr) {
    let n = arr.length;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        sum += arr[i];
    }
    return sum - ((n - 1) * (n - 2) / 2);
}
const x = fibonacciMemoization(10);
console.log(x);
let arr = [0, 1, 2, 3, 2];
let duplicate = findDuplicate(arr);
console.log(duplicate);
