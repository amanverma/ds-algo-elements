import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UniqueBST {
    static HashMap<Integer, LinkedList<Integer>> cache = new HashMap<>();
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        else{
            return constructTrees(1,n);
        }
    }

    private static LinkedList<TreeNode> constructTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start; i<=end; i++){
            //choose each i as root

            //all left trees
            LinkedList<TreeNode> leftTrees = constructTrees(start, i-1);
            //all right trees
            LinkedList<TreeNode> rightTrees = constructTrees(i+1, end);

            //connect left and right trees to the root
            for(TreeNode l: leftTrees){
                for(TreeNode r: rightTrees){
                    TreeNode currentTreeNode = new TreeNode(i);
                    currentTreeNode.left = l;
                    currentTreeNode.right = r;
                    allTrees.add(currentTreeNode);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args){
        List<TreeNode> treeNodes = generateTrees(3);
        treeNodes.stream().forEach(tn->{
            printPreOrderDFS(tn);
            System.out.println("\n");
        });
        System.out.println();
    }

    private static void printPreOrderDFS(TreeNode node) {
        //Simple pre order traversal
        if(node==null){
            return;
        }
        System.out.println(node.val);
        printPreOrderDFS(node.left);
        printPreOrderDFS(node.right);
    }
}

