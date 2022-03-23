import com.sun.source.tree.Tree;

public class BSTSearch {
    public static TreeNode searchBST(TreeNode root, int val) {
        //Complexity O(H)= O(log(N)), Worst - O(N)
        if(root.val==val){
            return root;
        }
        if(root!=null){
            return (root.val > val)?searchBST(root.left, val):searchBST(root.right, val);
        }
        return null;

    }
    public static void main(String[] args){
        TreeNode one = new TreeNode(1,null, null);
        TreeNode three = new TreeNode(3,null, null);
        TreeNode two = new TreeNode(2,one, three);
        TreeNode seven = new TreeNode(7,null, null);
        TreeNode four = new TreeNode(4,two, seven);
        TreeNode result =  searchBST(four, 2);
        //Do Pre Order DFS Traversal for getting copy of the tree as it is
        //In Order -> Non Decreasing
        //Post Order -> For Deleting tree
        printPreOrder(result);



    }

    private static void printPreOrder(TreeNode node) {
        //Simple pre order traversal
        if(node==null){
            return;
        }
        System.out.println(node.val);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
