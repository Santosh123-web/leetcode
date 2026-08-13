// Last updated: 8/13/2026, 9:43:23 PM
1class LRUCache {
2    class Node {
3        int key;
4        int val;
5        Node prev;
6        Node next;
7
8        Node(int key, int val) {
9            this.key = key;
10            this.val = val;
11        }
12    }
13
14    Node head = new Node(-1, -1);
15    Node tail = new Node(-1, -1);
16    int cap;
17    HashMap<Integer, Node> m = new HashMap<>();
18
19    public LRUCache(int capacity) {
20        cap = capacity;
21        head.next = tail;
22        tail.prev = head;
23    }
24
25    private void addNode(Node newnode) {
26        Node temp = head.next;
27
28        newnode.next = temp;
29        newnode.prev = head;
30
31        head.next = newnode;
32        temp.prev = newnode;
33    }
34
35    private void deleteNode(Node delnode) {
36        Node prevv = delnode.prev;
37        Node nextt = delnode.next;
38
39        prevv.next = nextt;
40        nextt.prev = prevv;
41    }
42
43    public int get(int key) {
44        if (m.containsKey(key)) {
45            Node resNode = m.get(key);
46            int ans = resNode.val;
47
48            m.remove(key);
49            deleteNode(resNode);
50            addNode(resNode);
51
52            m.put(key, head.next);
53            return ans;
54        }
55        return -1;
56    }
57
58    public void put(int key, int value) {
59        if (m.containsKey(key)) {
60            Node curr = m.get(key);
61            m.remove(key);
62            deleteNode(curr);
63        }
64
65        if (m.size() == cap) {
66            m.remove(tail.prev.key);
67            deleteNode(tail.prev);
68        }
69
70        addNode(new Node(key, value));
71        m.put(key, head.next);
72    }
73}