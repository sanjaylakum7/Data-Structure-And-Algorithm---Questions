public class TreesQuestions {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
    }

    public static void preOrder(TreeNode root){
        if(root == null) return;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    } 

    public static void inOrder(TreeNode root){
        if(root == null) return;

        preOrder(root.left);
        System.out.print(root.value + " ");
        preOrder(root.right);
    } 

    public static void postOrder(TreeNode root){
        if(root == null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.value + " ");
    } 

    public static int sum(TreeNode root){
        if(root == null) return 0;      
        return sum(root.left) + sum(root.right) + root.value;
    }   

    public static int count(TreeNode root){
        if(root == null) return 0;  
        return count(root.left) + count(root.right) + 1;
    }   

    public static int height(TreeNode root){    
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }       

    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);

        System.out.println(height(root));
    }
}
