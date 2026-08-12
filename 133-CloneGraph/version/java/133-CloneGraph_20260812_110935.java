// Last updated: 8/12/2026, 11:09:35 AM
1class Solution {
2    Node[] visited;
3    public Node cloneGraph(Node node) {
4        if(node == null) return null;
5        visited = new Node[101];
6        return DFS(node);
7    }
8    public Node DFS(Node node){
9        if(visited[node.val] != null) return visited[node.val];
10        visited[node.val] = new Node(node.val);
11        for(Node n: node.neighbors) visited[node.val].neighbors.add(DFS(n));
12        return visited[node.val];
13    }
14}  