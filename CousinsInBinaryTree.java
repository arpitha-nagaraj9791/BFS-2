//Time Complexity: O(n)
//Space Complexity: O(n)   // queues for nodes and parents
//Did this code run in leetcode: Yes

//Approach:
// 1. Level-order BFS while tracking each node’s parent in parallel.
// 2. For each level, record when x and y are found and who their parents are.
// 3. If both found in the same level, return true iff parents differ.
// 4. If only one is found at a level, return false (they’re at different depths).


import java.util.LinkedList;
import java.util.Queue;


public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        q.add(root);
        parentQ.add(null);

        boolean x_found = false; boolean y_found = false;
        TreeNode x_parent = null; TreeNode y_parent = null;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode parent = parentQ.poll();

                if(curr.val == x){
                    x_found = true;
                    x_parent = parent;
                }

                if(curr.val == y){
                    y_found = true;
                    y_parent = parent;
                }

                if(curr.left != null){
                    q.add(curr.left);
                    parentQ.add(curr);
                }

                if(curr.right != null){
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }
            if(x_found && y_found) return x_parent != y_parent;
            if(x_found || y_found) return false;
        }
        return false;
    }
}
