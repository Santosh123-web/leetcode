// Last updated: 9/21/2026, 10:11:14 PM
1public class Codec {
2    public String serialize(TreeNode root) {
3        if (root == null) return "#";
4        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
5    }
6
7    public TreeNode deserialize(String data) {
8        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
9        return helper(queue);
10    }
11    
12    private TreeNode helper(Queue<String> queue) {
13        String s = queue.poll();
14        if (s.equals("#")) return null;
15        TreeNode root = new TreeNode(Integer.valueOf(s));
16        root.left = helper(queue);
17        root.right = helper(queue);
18        return root;
19    }
20}