/*
Approach :
---------------------
1. Initialize an empty result list.
2. For every row i (0 to numRows-1):
    - Create new list.
    - For each element j (0 to i):
        - If j is first/last index → add 1.
        - Else → add sum of (i-1)th row’s j-1 and j.
    - Add built row to final list.

 TC:  O(numRows^2)
    - Two nested loops based on numRows.

 SC: O(numRows^2)
    - Output list stores each row with increasing length.
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
       // 🔽 Diamond operator <> lets Java 7 infer the full type from the left side
        //     Equivalent to: new ArrayList<List<Integer>>()
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements are always 1
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    int left = pascalTriangle.get(i - 1).get(j - 1);
                    int right = pascalTriangle.get(i - 1).get(j);
                    currRow.add(left + right);
                }
            }

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}


