/**

错位映射：hashmap的巧用，可以把时间复杂度降到O(n)

*/


/**
Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
*/

class Solution {
    /** 
     * HashMap solution: O(n).
     */
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) return null;
        int len = A.length;
        int[] p = new int[len];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++)
            map.put(B[i], i);
        for (int i = 0; i < len; i++)
            p[i] = map.get(A[i]);
        return p;
    }
    
    /**
      * Naive Solution: O(n^2).
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) return null;
        
        int len = A.length;
        int[] p = new int[len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i] == B[j]) {
                    p[i] = j;
                    break;
                }
            }
        }
        return p;
    }
    */
}
