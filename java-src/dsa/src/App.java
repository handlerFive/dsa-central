import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparingInt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
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
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while(pos < n) {
            nums[pos++] = 0;
        }
    }

    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = n - 1; 
        int count = 0;
        while(i < j) {
            if(nums[i] != -1 && nums[j] != -1) {
                int sum = nums[i] + nums[j];
                if(sum == k) {
                    nums[i] = -1; nums[j] = -1;
                    i++; j--;
                    count++;
                } else {
                    i++;j--;
                }
            } else {
                i++; j--;
            }
        }
        return count;
    }

    public int maxVowels(String s, int k) {
        int i = 0, j = k - 1;
        int sum = 0;
        for(int x = i; x <= j; x++){
            if(isVowel(s.charAt(x))) {
                System.out.println("char : " + s.charAt(x));
                sum++;
            }
        }
        System.out.println("sum : " + sum);
        int maxCount = sum;
        j++;
        System.out.println("maxCount : " + sum);
        while(j < s.length() - 1) {
            if(isVowel(s.charAt(i)) || isVowel(s.charAt(j))) {
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

    //JP MORGAN SWE Cohort 2024 
    //Problem statement - You are given two strings s and t, both of length n , consisting of lowercase English letters and integer K
    //The cost to change the i-th character of s to t is abs(s[i] - t[i]) the absolute difference between the ASCII values of the characters
    //Find the maximum length of a subsequence of s such that the cost of changing this subsequence to t is less than or equal to K
    //Pure sliding window problem
    public int equalSubstring(String s, String t, int K) {
        int n = s.length();
        int maxLen = 0;
        int currCost = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            currCost += Math.abs(s.charAt(right) - t.charAt(right));
            while(currCost > K) {
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    } 

    //JP MORGAN SWE Cohort 2024
    //Problem statement - Researchers are conducting experiments with robot swarms and need to ensure that all robots 
    //in the swarm have same inital power level before deployement. Each robot's power leven can be adjused using a charging device, which can either increase or decrease the 
    //power of a single robot by 1 unit per minute. Given the power levels of n robots, determine the minium time (int minutes) 
    //required to make all power levels equal
    //Brute Force Approach - TLE Hit in coding round
    public long minimumMinutes(List<Long> power) {
        long minPower = Collections.min(power);
        long maxPower = Collections.max(power);
        long minMinutes = Integer.MAX_VALUE;
        for(long i = minPower; i <= maxPower; i++) {
            long minutes = 0;
            for(long p : power) {
                minutes += Math.abs(p - i);
            }
            minMinutes = Math.min(minMinutes, minutes);
        }
        return minMinutes;
    }

    //JP MORGAN SWE Cohort 2024
    //Problem statement - Researchers are conducting experiments with robot swarms and need to ensure that all robots 
    //in the swarm have same inital power level before deployement. Each robot's power leven can be adjused using a charging device, which can either increase or decrease the 
    //power of a single robot by 1 unit per minute. Given the power levels of n robots, determine the minium time (int minutes) 
    //required to make all power levels equal
    //Optimized - Median Approach
    public long minimumMinutesOptimized(List<Long> power) {
        long minMinutes = 0;
        Collections.sort(power);
        long median = power.get(power.size() / 2);
        for(long p : power) {
            minMinutes += Math.abs(p - median); //Calculate the difference between the median and the power level of each robot
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
            if(st.contains(entry.getValue())) return false;
        }
        return true;
    }
    
    public static List<Integer> populateArrayList(List<Integer> list) {
        list = new ArrayList<>(Collections.nCopies(1000, 0));
        return list;
    }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(arr.isEmpty() || arr.get(arr.size() - 1) < 0 || asteroids[i] > 0) {
                arr.add(asteroids[i]);
            } else {
                if(arr.get(arr.size() - 1) == Math.abs(asteroids[i])) {
                    arr.remove(arr.size() - 1);
                } else if(arr.get(arr.size() - 1) < Math.abs(asteroids[i])) {
                    arr.remove(arr.size() - 1);
                    i--;
                }       
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] convertListToIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws Exception {
        // System.out.println(maxGifts(new int[]{25, 64, 9, 4, 100}, 4));
        // System.out.println(maxGifts(new int[]{25, 64, 9, 4, 100}, 4));
        // System.out.println(arrayScore(new int[] { 1, 2, 3, 4, 5 }));
        // System.out.println(reverseWordsNoStream("the sky is blue"));
        //To find the second highest number in an array using Java 8
        List<Integer> list = Arrays.asList(112,23,45,65,75,34,90,34);
        //int max = list.stream().max(Integer::compare).get();
        //list.stream().filter(x -> x != max).max(Integer::compare).ifPresent(System.out::println);
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);


    }
}
