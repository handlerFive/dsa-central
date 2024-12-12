"use strict";
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
//Function to find factorial of a number 
function factorial(n) {
    let x = 1;
    for (let i = 1; i <= n; i++) {
        x *= i;
    }
    return x;
}
let str = 'racecar';
let reversedString = reverseStringIV(str);
console.log(factorial(5));
