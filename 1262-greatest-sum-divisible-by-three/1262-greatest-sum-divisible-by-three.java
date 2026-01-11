import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();

        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) rem1.add(n);
            else if (n % 3 == 2) rem2.add(n);
        }

        if (sum % 3 == 0) return sum;

        Collections.sort(rem1);
        Collections.sort(rem2);

        int remove = Integer.MAX_VALUE;

        if (sum % 3 == 1) {
            if (rem1.size() >= 1)
                remove = rem1.get(0);
            if (rem2.size() >= 2)
                remove = Math.min(remove, rem2.get(0) + rem2.get(1));
        } else { // sum % 3 == 2
            if (rem2.size() >= 1)
                remove = rem2.get(0);
            if (rem1.size() >= 2)
                remove = Math.min(remove, rem1.get(0) + rem1.get(1));
        }

        return remove == Integer.MAX_VALUE ? 0 : sum - remove;
    }
}
