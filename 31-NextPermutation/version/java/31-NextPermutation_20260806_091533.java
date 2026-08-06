// Last updated: 8/6/2026, 9:15:33 AM
1class Solution {
2    public List<List<Integer>> levelOrder(TreeNode root) 
3    {
4        List<List<Integer>>al=new ArrayList<>();
5        pre(root,0,al);
6        return al;
7    }
8    public static void pre(TreeNode root,int l,List<List<Integer>>al)
9    {
10        if(root==null)
11            return;
12        if(al.size()==l)
13        {
14            List<Integer>li=new ArrayList<>();
15            li.add(root.val);
16            al.add(li);
17        }
18        else
19            al.get(l).add(root.val);
20        pre(root.left,l+1,al);
21        pre(root.right,l+1,al);
22    } 
23}