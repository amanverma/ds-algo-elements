/*Given a nary tree, return level order traversal of its nodes*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class nary_level_order_traversal {
    static List<List<Integer>> resultList = new ArrayList<>();
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelNodes.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }

            result.add(levelNodes);
        }

        return result;
    }

    public static void recursiveLevelOrder(Node root){
        if(root!=null){
            traverseNode(root, 0);
        }
    }

    private static void traverseNode(Node root, int level) {
        if(resultList.size()<=level) {
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(root.val);
        for(Node n: root.children){
            traverseNode(n,level+1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root.children = new ArrayList<>();
        root.children.add(node2);
        root.children.add(node3);

        List<List<Integer>> levelOrderTraversal = levelOrder(root);
        for (List<Integer> level : levelOrderTraversal) {
            System.out.println(level);
        }
    }
}

