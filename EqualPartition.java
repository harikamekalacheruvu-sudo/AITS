public class EqualPartition {

    static boolean canPartition(int[] arr) {
        int sum = 0;

        for (int num : arr)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        if (canPartition(arr))
            System.out.println("Array can be partitioned into two equal subsets");
        else
            System.out.println("Array cannot be partitioned into two equal subsets");
    }
}
