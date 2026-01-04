class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int n : nums) {
            int count = 0;
            int sum = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    count++;
                    sum += i;

                    if (i != n / i) {
                        count++;
                        sum += n / i;
                    }
                }

                if (count > 4) break; 
            }

            if (count == 4) {
                ans += sum;
            }
        }

        return ans;
    }
}
