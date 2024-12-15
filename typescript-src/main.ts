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

//Function to find the nth Fibonacci number - Using Memoization
function fibonacciMemoization(n: number, memo: { [key: number]: number } = {}): number {
    if (n in memo) return memo[n];
    if (n == 0) return 0;
    if (n == 1) return 1;
    memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
    return memo[n];
}

//Functin to find the duplicate value in an array
function findDuplicate(arr: number[]): number {
    let n = arr.length;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        sum += arr[i];
    }
    //((n - 1) * (n - 2) / 2) is the sum of n natural numbers
    return sum - ((n - 1) * (n - 2) / 2);
}

//call, bind and apply 
function holler(this: any, greeting: string, punc: string): void {
    console.log(greeting + ', ' + this.name + punc);
}
const person = { name: 'Jeremy' };
holler.call(person, 'Hello', '!');
holler.apply(person, ['Heya', '?']);
const bindVal = holler.bind(person);
bindVal('hola', '!!');

let age: number = 5;
let myname: string = "raunak";

//Function to debounce 
function debounce(func: (arg0: any) => void, delay: number | undefined) {
    let timer: number | undefined;
    return (...args: any) => {
        clearTimeout(timer);
        timer = setTimeout(() => {
            func(args)
        }, delay);
    }
};

//Function to throttle
function throttle(func: (arg0: any) => void, limit: number | undefined) {
    let inThrottle: boolean;
    return function (...args: any) {
        if (!inThrottle) {
            func(args);
            inThrottle = true;
            setTimeout(() => inThrottle = false, limit);
        }
    }
}

//2593. Find Score of an Array After Marking All Elements - LeetCode
function findScore(arr: number[]): number {
    let ans = 0;
    let n = arr.length;
    let marked: boolean[] = new Array(n).fill(false);
    let sorted: [number, number][] = new Array(n);
    for (let i = 0; i < n; i++) {
        sorted[i] = [arr[i], i];
    }
    sorted.sort((a, b) => a[0] - b[0]);
    for (let i = 0; i < n; i++) {
        let num: number = sorted[i][0];
        let index: number = sorted[i][1];
        if (!marked[index]) {
            ans += num;
            marked[index] = true;
            if (index - 1 >= 0) marked[index - 1] = true;
            if (index + 1 < n) marked[index + 1] = true;
        }
    }
    return ans;
}

//Function to solve Leetcode 605 - Can Place Flowers
function canPlaceFlowers(flowerbed: number[], n: number): boolean {
    let count = 0;
    for (let i = 0; i < flowerbed.length; i++) {
        if (flowerbed[i] == 0) {
            let isEmptyLeft: boolean = i == 0 || flowerbed[i - 1] == 0;
            let isEmptyRight: boolean = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (isEmptyLeft && isEmptyRight) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) return true;
            }
        }
    }
    return count >= n;
}


const x = fibonacciMemoization(10);
console.log(x);
let arr = [0, 1, 2, 3, 2];
let duplicate = findDuplicate(arr);
console.log(duplicate);