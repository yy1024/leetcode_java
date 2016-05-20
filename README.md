###leetcode的Java解决方式
###author:littleapple

# 1.Two Sum
##Subject
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Subscribe to see which companies asked this question

##Answer
###
		public class Solution {
		    public int[] twoSum(int[] nums, int target) {
		        int[] result = {0,0};
				if(nums == null || nums.length < 2)
		        {
		        	//
					return result;
		        }
		        int length = nums.length;
		        for(int i = 0; i < length; i++)
		        {
		        	for(int j = i + 1 ; j < length ; j++)
		        	{
		        		if(nums[i] + nums[j] == target)
		        		{
		        			result[0] = i + 1;
		        			result[1] = j + 1;
		        			return result;
		        		}
		        	}
		        }
		        return result;
		    }
		}

# 2.Add Two Numbers
##Subject
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems
##Answer
###
		/**
		 * Definition for singly-linked list.
		 * public class ListNode {
		 *     int val;
		 *     ListNode next;
		 *     ListNode(int x) { val = x; }
		 * }
		 */
		public class Solution {
		    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		        int carry =0;
				 
		        ListNode newHead = new ListNode(0);
		        ListNode p1 = l1, p2 = l2, p3=newHead;
		 
		        while(p1 != null || p2 != null){
		            if(p1 != null){
		                carry += p1.val;
		                p1 = p1.next;
		            }
		 
		            if(p2 != null){
		                carry += p2.val;
		                p2 = p2.next;
		            }
		 
		            p3.next = new ListNode(carry%10);
		            p3 = p3.next;
		            carry /= 10;
		        }
		 
		        if(carry==1) 
		            p3.next=new ListNode(1);
		 
		        return newHead.next;
		    }
		}

# 3.Longest Substring Without Repeating Characters
##Subject
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

Subscribe to see which companies asked this question
##Answer
###
		public class Solution {
		    public int lengthOfLongestSubstring(String s) {
		 	if(s == null || s.equals(""))
		            return 0;
		        Map<String,Integer> sets = new HashMap<String,Integer>();
		        byte[] bytes =  s.getBytes();
		        int result = 0;
		        int now = 0;
		        int remove = 0;
		        for(int i = 0; i < bytes.length ; i++)
		        {
		            if(sets.containsKey(""+bytes[i]))
		            {
		                int temp = sets.get(""+bytes[i]);
		                for(int j = remove ; j < temp; j++)
		                {
		                	sets.remove(""+bytes[j]);
		                }
		                sets.put(""+bytes[i], i);
		                now = i - temp;
		                remove = temp + 1;
		            }
		            else
		            {
		                now++;
		                if(result < now)
		                	result = now;
		                sets.put(""+bytes[i], new Integer(i));
		            }
		        }
		        return result;
		    }
		}

# 4.Median of Two Sorted Arrays
##Subject
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

##Answer

```
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
		
		int n = A.length;
	    int m = B.length;
	    // the following call is to make sure len(A) <= len(B).
	    // yes, it calls itself, but at most once, shouldn't be
	    // consider a recursive solution
	    if (n > m)
	        return findMedianSortedArrays(B, A);

	    // now, do binary search
	    int k = (n + m - 1) / 2;
	    int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
	    while (l < r) {
	        int midA = (l + r) / 2;
	        int midB = k - midA;
	        if (A[midA] < B[midB])
	            l = midA + 1;
	        else
	            r = midA;
	    }

	    // after binary search, we almost get the median because it must be between
	    // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

	    // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
	    // and there are some corner cases we need to take care of.
	    int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
	    if (((n + m) & 1) == 1)
	        return (double) a;

	    // if (n+m) is even, the median can be calculated by 
	    //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
	    // also, there are some corner cases to take care of.
	    int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
	    return (a + b) / 2.0;

    }
}

```

# 5.Longest Palindromic Substring
##Subject
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
##Answer
```
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
	    if (s.length() == 1) return s;
	    int min_start = 0, max_len = 1;
	    for (int i = 0; i < s.length(); ) {
	        if (s.length() - i <= max_len / 2) break;
	        int j = i, k = i;
	        while (k < s.length() - 1 && s.charAt(k + 1) == s.charAt(k)) ++k; // Skip duplicate characters.
	        i = k + 1;
	        while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
	            ++k;
	            --j;
	        } // Expand.
	        int new_len = k - j + 1;
	        if (new_len > max_len) {
	            min_start = j;
	            max_len = new_len;
	        }
	    }
	    return s.substring(min_start, min_start + max_len);
    }
}

```

# x.Model Tile
##Subject
##Answer
```

```
