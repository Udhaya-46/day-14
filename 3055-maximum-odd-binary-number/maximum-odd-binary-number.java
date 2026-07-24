class Solution {
    public String maximumOddBinaryNumber(String s) {
        
        int ones = 0;
        int zeros = 0;

        // Count 1s and 0s
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
            else
                zeros++;
        }

        StringBuilder ans = new StringBuilder();

        // Put all extra ones in front
        for (int i = 0; i < ones - 1; i++) {
            ans.append('1');
        }

        // Put zeros in middle
        for (int i = 0; i < zeros; i++) {
            ans.append('0');
        }

        // Last digit must be 1 for odd number
        ans.append('1');

        return ans.toString();
    }
}