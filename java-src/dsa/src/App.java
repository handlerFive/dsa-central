import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparingInt;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    // Function to reverse a string - I
    public static String reverseString(String str) {
        if (str.length() == 0) {
            return "";
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // Function to reverse a string - II
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

    // Function to find factorial of a number
    // factorial(4)
    // └── 4 * factorial(3)
    // └── 3 * factorial(2)
    // └── 2 * factorial(1)
    // └── 1 * factorial(0)
    // └── 1
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Function to find the nth Fibonacci number - Using Iteration
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

    // Function to find the nth Fibonacci number - Using Recursion
    // fibonacciRecursion(5)
    // ├── fibonacciRecursion(4)
    // │ ├── fibonacciRecursion(3)
    // │ │ ├── fibonacciRecursion(2)
    // │ │ │ ├── fibonacciRecursion(1) -> 1
    // │ │ │ └── fibonacciRecursion(0) -> 0
    // │ │ └── fibonacciRecursion(1) -> 1
    // │ └── fibonacciRecursion(2)
    // │ ├── fibonacciRecursion(1) -> 1
    // │ └── fibonacciRecursion(0) -> 0
    // └── fibonacciRecursion(3)
    // ├── fibonacciRecursion(2)
    // │ ├── fibonacciRecursion(1) -> 1
    // │ └── fibonacciRecursion(0) -> 0
    // └── fibonacciRecursion(1) -> 1
    public static int fibRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    // Function to find duplicate in an array of N+1 Integers
    public static int findDuplicate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum - ((nums.length - 1) * nums.length) / 2;
    }

    // 2558. Take Gifts From the Richest Pile - LeetCode
    public static long maxGifts(int[] piles, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]);
        }
        while (k-- > 0) {
            int max = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(max)));
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }

    // 2593. Find Score of an Array After Marking All Elements - LeetCode
    public static long arrayScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        List<SimpleEntry<Integer, Integer>> sorted = new ArrayList<>(nums.length);
        for (int i = 0; i < n; i++) {
            sorted.add(new SimpleEntry<>(nums[i], i));
        }
        boolean[] marked = new boolean[n];
        sorted.sort(comparingInt(SimpleEntry::getKey));
        for (int i = 0; i < n; i++) {
            int num = sorted.get(i).getKey();
            int index = sorted.get(i).getValue();
            if (!marked[index]) {
                ans += num;
                if (index - 1 >= 0)
                    marked[index - 1] = true;
                if (index + 1 < n)
                    marked[index + 1] = true;
            }
        }
        return ans;
    }

    public long findScore(int[] nums) {
        long ans = 0;
        boolean[] marked = new boolean[nums.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1.getKey() != arr2.getKey())
                return arr1.getKey() - arr2.getKey();
            return arr1.getValue() - arr2.getValue();
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int num = p.getKey();
            int index = p.getValue();
            if (!marked[index]) {
                ans += num;
                marked[index] = true;
                if (index - 1 >= 0)
                    marked[index - 1] = true;
                if (index + 1 < nums.length)
                    marked[index + 1] = true;
            }
        }
        return ans;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        while (i < word1.length())
            ans.append(word1.charAt(i++));
        while (j < word2.length())
            ans.append(word2.charAt(j++));
        return ans.toString();
    }

    // Find the GCD of two strings - LeetCode
    public static String gcdString(String str1, String str2) {
        List<Boolean> l = new ArrayList<>(str1.length());

        return "";
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && candies[i] + extraCandies < candies[j]) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }

    // Important ! Array Problem - Can Place Flowers - LeetCode 605 Acceptance Rate
    // 28.8%
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isEmptyLeft = i == 0 || flowerbed[i - 1] == 0;
                boolean isEmptyRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (isEmptyLeft && isEmptyRight) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) // Early Exit
                        return true;
                }
            }
        }
        return count >= n; // Final Check
    }

    public static String reverseVowels(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder(s);
        int i = 0, j = n - 1;
        while (i < j) {
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                res.setCharAt(i, s.charAt(j));
                res.setCharAt(j, s.charAt(i));
                i++;
                j--;
            }
            if (!isVowel(s.charAt(i)))
                i++;
            if (!isVowel(s.charAt(j)))
                j--;
        }
        return res.toString();
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // Fancy way to reverse words of a string
    public String reverseWords(String s) {
        s = s.trim();
        return Arrays.stream(s.split(" "))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l.stream();
                }))
                .collect(Collectors.joining(" "));
    }

    // Reverse Words in a String I - LeetCode 151
    public static String reverseWordsNoStream(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s, i + 1, end + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
        }
        return res.toString().trim();
    }

    // String Compression - LeetCode 443
    public static int stringCompression(char[] chars) {
        int n = chars.length;
        int i = 0, res = 0;
        while (i < n) {
            int groupLen = 1; // At least one character in the group
            while (i + groupLen < n && chars[i + groupLen] == chars[i]) {
                groupLen++;
            }
            chars[res++] = chars[i];
            if (groupLen > 1) { //
                for (char c : Integer.toString(groupLen).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLen; // Move to the next group
        }
        return res;
    }

    // 443. String Compression - LeetCode Hash Table //Not correct
    public static int stringCompressionII(char[] chars) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : chars) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();
            chars[res++] = c;
            if (count > 1) {
                for (char cx : Integer.toString(count).toCharArray()) {
                    chars[res++] = cx;
                }
            }
        }
        return res;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while (pos < n) {
            nums[pos++] = 0;
        }
    }

    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] != -1 && nums[j] != -1) {
                int sum = nums[i] + nums[j];
                if (sum == k) {
                    nums[i] = -1;
                    nums[j] = -1;
                    i++;
                    j--;
                    count++;
                } else {
                    i++;
                    j--;
                }
            } else {
                i++;
                j--;
            }
        }
        return count;
    }

    public int maxVowels(String s, int k) {
        int i = 0, j = k - 1;
        int sum = 0;
        for (int x = i; x <= j; x++) {
            if (isVowel(s.charAt(x))) {
                System.out.println("char : " + s.charAt(x));
                sum++;
            }
        }
        System.out.println("sum : " + sum);
        int maxCount = sum;
        j++;
        System.out.println("maxCount : " + sum);
        while (j < s.length() - 1) {
            if (isVowel(s.charAt(i)) || isVowel(s.charAt(j))) {
                i++;
                sum++;
            } else {
                sum--;
                j++;
            }
        }
        maxCount = Math.max(maxCount, sum);
        return maxCount;
    }

    // JP MORGAN SWE Cohort 2024
    // Problem statement - You are given two strings s and t, both of length n ,
    // consisting of lowercase English letters and integer K
    // The cost to change the i-th character of s to t is abs(s[i] - t[i]) the
    // absolute difference between the ASCII values of the characters
    // Find the maximum length of a subsequence of s such that the cost of changing
    // this subsequence to t is less than or equal to K
    // Pure sliding window problem
    public int equalSubstring(String s, String t, int K) {
        int n = s.length();
        int maxLen = 0;
        int currCost = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            currCost += Math.abs(s.charAt(right) - t.charAt(right));
            while (currCost > K) {
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // JP MORGAN SWE Cohort 2024
    // Problem statement - Researchers are conducting experiments with robot swarms
    // and need to ensure that all robots
    // in the swarm have same inital power level before deployement. Each robot's
    // power leven can be adjused using a charging device, which can either increase
    // or decrease the
    // power of a single robot by 1 unit per minute. Given the power levels of n
    // robots, determine the minium time (int minutes)
    // required to make all power levels equal
    // Brute Force Approach - TLE Hit in coding round
    public long minimumMinutes(List<Long> power) {
        long minPower = Collections.min(power);
        long maxPower = Collections.max(power);
        long minMinutes = Integer.MAX_VALUE;
        for (long i = minPower; i <= maxPower; i++) {
            long minutes = 0;
            for (long p : power) {
                minutes += Math.abs(p - i);
            }
            minMinutes = Math.min(minMinutes, minutes);
        }
        return minMinutes;
    }

    // JP MORGAN SWE Cohort 2024
    // Problem statement - Researchers are conducting experiments with robot swarms
    // and need to ensure that all robots
    // in the swarm have same inital power level before deployement. Each robot's
    // power leven can be adjused using a charging device, which can either increase
    // or decrease the
    // power of a single robot by 1 unit per minute. Given the power levels of n
    // robots, determine the minium time (int minutes)
    // required to make all power levels equal
    // Optimized - Median Approach
    public long minimumMinutesOptimized(List<Long> power) {
        long minMinutes = 0;
        Collections.sort(power);
        long median = power.get(power.size() / 2);
        for (long p : power) {
            minMinutes += Math.abs(p - median); // Calculate the difference between the median and the power level of
                                                // each robot
        }
        return minMinutes;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (st.contains(entry.getValue()))
                return false;
        }
        return true;
    }

    public static List<Integer> populateArrayList(List<Integer> list) {
        list = new ArrayList<>(Collections.nCopies(1000, 0));
        return list;
    }

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> mp = new HashMap<>(
                Map.ofEntries(
                        Map.entry(2, Arrays.asList('a', 'b', 'c')),
                        Map.entry(3, Arrays.asList('d', 'e', 'f')),
                        Map.entry(4, Arrays.asList('g', 'h', 'i')),
                        Map.entry(5, Arrays.asList('j', 'k', 'l')),
                        Map.entry(6, Arrays.asList('m', 'n', 'o')),
                        Map.entry(7, Arrays.asList('p', 'q', 'r', 's')),
                        Map.entry(8, Arrays.asList('t', 'u', 'v')),
                        Map.entry(9, Arrays.asList('w', 'x', 'y', 'z'))));

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, mp, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, Map<Integer, List<Character>> mp,
            int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(index));
        List<Character> letters = mp.get(digit);
        if (letters != null) {
            for (char letter : letters) {
                current.append(letter);
                backtrack(result, current, digits, mp, index + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    // LRUCache using LinkedHashMap
    private class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    // Explanation:
    // This class extends LinkedHashMap to implement an LRU (Least Recently Used)
    // cache.
    // - The constructor initializes the LinkedHashMap with access order set to
    // true.
    // - The `get` method retrieves the value for the given key, returning -1 if the
    // key is not present.
    // - The `put` method inserts a key-value pair into the cache.
    // - The `removeEldestEntry` method ensures that the cache size does not exceed
    // the specified capacity by removing the eldest entry when necessary.

    // LRUCacheII using HashMap and LinkedList
    private class LRUCacheII {
        private final int capacity;
        private final Map<Integer, Integer> map;
        private final LinkedList<Integer> list;

        public LRUCacheII(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
                list.addFirst(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
            } else if (list.size() == capacity) {
                int last = list.removeLast();
                map.remove(last);
            }
            map.put(key, value);
            list.addFirst(key);
        }
    }

    private class DynamicArray {
        int capacity;
        int size;
        int[] arr;

        public DynamicArray() {
            capacity = 1;
            size = 0;
            arr = new int[capacity];
        }

        public void pushback(int x) {
            if (size == capacity) {
                arr = new int[2 * capacity];
                capacity *= 2;
            }
            arr[size++] = x;
        }

        public void popback() {
            if (size == 0) {
                return;
            }
            size--;
        }

        public void set(int index, int x) {
            if (index < 0 || index >= size) {
                return;
            }
            arr[index] = x;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return arr[index];
        }
    }

    // Design a double ended queue

    private class Dequeue {
        private final LinkedList<Integer> list;

        public Dequeue() {
            list = new LinkedList<>();
        }

        public void insertFront(int x) {
            list.addFirst(x);
        }

        public void insertLast(int x) {
            list.addLast(x);
        }

        public int deleteFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeFirst();
        }

        public int deleteLast() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeLast();
        }

        public int getFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        public int getRear() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    // Design Binary Search Tree

    class BST {
        private class Node {
            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        private Node root;

        public BST() {
            root = null;
        }

        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }
            return root;
        }

        public void inorder() {
            inorderRec(root);
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        public void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node root, int key) {
            if (root == null) {
                return root;
            }
            if (key < root.key) {
                root.left = deleteRec(root.left, key);
            } else if (key > root.key) {
                root.right = deleteRec(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
            return root;
        }

        private int minValue(Node root) {
            int minv = root.key;
            while (root.left != null) {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }
    }

    // Design Hash Table
    class HT {
        private final int capacity;
        private final LinkedList<Entry>[] table;

        public HT(int capacity) {
            this.capacity = capacity;
            table = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                table[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int index = key % capacity;
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            table[index].add(new Entry(key, value));
        }

        public int get(int key) {
            int index = key % capacity;
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int index = key % capacity;
            Iterator<Entry> iterator = table[index].iterator();
            while (iterator.hasNext()) {
                Entry entry = iterator.next();
                if (entry.key == key) {
                    iterator.remove();
                    return;
                }
            }
        }

        private class Entry {
            int key;
            int value;

            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    private class Employee {
        public String name;
        public int age;
        public String department;
        public int salary;
        public Date joiningDate;

        public Employee(String name, int age, String department, int salary, Date joiningDate) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.joiningDate = joiningDate;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println(maxGifts(new int[]{25, 64, 9, 4, 100}, 4));
        // System.out.println(maxGifts(new int[]{25, 64, 9, 4, 100}, 4));
        // System.out.println(arrayScore(new int[] { 1, 2, 3, 4, 5 }));
        // System.out.println(reverseWordsNoStream("the sky is blue"));
        // To find the second highest number in an array using Java 8
        List<Integer> list = Arrays.asList(112, 23, 45, 65, 75, 34, 90, 34);
        // int max = list.stream().max(Integer::compare).get();
        // list.stream().filter(x -> x !=
        // max).max(Integer::compare).ifPresent(System.out::println);
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
        Map<Integer, List<Character>> mp = new HashMap<>(
                Map.ofEntries(
                        Map.entry(2, Arrays.asList('a', 'b', 'c')),
                        Map.entry(3, Arrays.asList('d', 'e', 'f')),
                        Map.entry(4, Arrays.asList('g', 'h', 'i')),
                        Map.entry(5, Arrays.asList('j', 'k', 'l')),
                        Map.entry(6, Arrays.asList('m', 'n', 'o')),
                        Map.entry(7, Arrays.asList('p', 'q', 'r', 's')),
                        Map.entry(8, Arrays.asList('t', 'u', 'v')),
                        Map.entry(9, Arrays.asList('w', 'x', 'y', 'z'))));

        LRUCacheII cacheII = new App().new LRUCacheII(2);
        cacheII.set(1, 1);
        cacheII.set(2, 2);
        System.out.println(cacheII.get(1));
        System.out.println(cacheII.get(2));
        cacheII.set(3, 3);
        System.out.println("---------");
        System.out.println(cacheII.get(1));
        System.out.println(cacheII.get(2));
        System.out.println(cacheII.get(3));

        List<Employee> employees = new ArrayList<>();
        employees.add(new App().new Employee("John", 25, "Engineering", 100000, new Date("01/01/2021")));
        employees.add(new App().new Employee("Jane", 30, "Marketing", 90000, new Date("01/01/2024")));
        employees.add(new App().new Employee("Alice", 35, "Finance", 120000, new Date("01/01/2023")));
        employees.add(new App().new Employee("Bob", 40, "Engineering", 110000, new Date("01/01/2022")));
        employees.add(new App().new Employee("Charlie", 45, "Marketing", 95000, new Date("01/01/2025")));
        employees.add(new App().new Employee("David", 50, "Finance", 130000, new Date("01/01/2020")));
        Map<String, Optional<Employee>> map = employees.stream().collect(
                Collectors.groupingBy(e -> e.department, Collectors.maxBy(Comparator.comparingInt(e -> e.salary))));
        for (Map.Entry<String, Optional<Employee>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().get().salary);
        }

        Date staticDate = new Date("01/01/2024");
        employees.stream().filter(e -> e.joiningDate.before(staticDate)).forEach(e -> System.out.println(e.name));
        //use partitioningBy to split the list of employees into two groups based on the department
        Map<Boolean, List<Employee>> partitioned = employees.stream().collect(Collectors.partitioningBy(e -> e.department.equals("Engineering")));
        System.out.println(partitioned.get(true).size());
        System.out.println(partitioned.get(false).size());
        int[][] xx = {{1, 2}, {3, 4}, {5, 6} , {7, 8}, {9, 10}};
        List<Integer> l = Arrays.asList(xx).stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
        System.out.println(l);
        String test = "Testing".toLowerCase();
        //first non repetative character
        Character t = test.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(t);
    }
}
