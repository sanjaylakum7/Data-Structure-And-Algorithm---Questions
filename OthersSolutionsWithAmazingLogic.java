public class OthersSolutionsWithAmazingLogic {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
            System.out.println(val);
        }
    }

    // Question Number: 116
    public Node connect(Node root) {
        Node node = root;
        while (node != null && node.left != null) {
            Node n = node;
            while (true) {
                n.left.next = n.right;
                if (n.next == null)
                    break;
                n.right.next = n.next.left;
                n = n.next;
            }
            node = node.left;
        }
        return root;
    }

    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;
        for (String s : bank) {
            int curr = 0;
            for (char ch : s.toCharArray())
                if (ch == '1')
                    curr++;
            if (prev != 0) {
                ans += curr * prev;
            }
            if (curr != 0)
                prev = curr;
        }
        return ans;
    }

    public static int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static int helper(int nums[], int i, int j) {

        if (i == j) {
            return nums[i];
        }

        int mid = (i + j) / 2;
        int sum = 0, leftMaxSUM = Integer.MIN_VALUE;

        for (int l = mid; l >= i; l--) {
            sum += nums[l];
            if (sum > leftMaxSUM) {
                leftMaxSUM = sum;
            }
        }

        int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0; 
        for (int l = mid + 1; l <= j; l++) {
            sum += nums[l];
            if (sum > rightMaxSUM) {
                rightMaxSUM = sum;
            }
        }

        int maxLeftRight = Math.max(helper(nums, i, mid), helper(nums, mid + 1, j));

        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM);
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
