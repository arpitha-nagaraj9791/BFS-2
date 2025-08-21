//Time Complexity: O(n)
//Space Complexity: O(n)   // queue for BFS; result list up to N
//Did this code run in leetcode: Yes

//Approach:
// 1. Level-order BFS. For each level, process 'size' nodes and
// 2. Append the value of the last node polled (rightmost at that level) to the result.
// 3. Enqueue left then right children for the next level.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(i == size - 1){
                    res.add(node.val);
                }

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}
