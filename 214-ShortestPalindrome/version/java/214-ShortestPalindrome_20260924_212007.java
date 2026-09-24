// Last updated: 9/24/2026, 9:20:07 PM
1import java.util.*;
2
3class AllOne {
4
5    private Map<String, Integer> count;
6    private TreeMap<Integer, HashSet<String>> keys;
7
8    public AllOne() {
9        count = new HashMap<>();
10        keys = new TreeMap<>();
11    }
12
13    public void inc(String key) {
14
15        count.put(key, count.getOrDefault(key, 0) + 1);
16        int cnt = count.get(key);
17
18        keys.putIfAbsent(cnt, new HashSet<>());
19        keys.get(cnt).add(key);
20
21        if (cnt != 1) {
22            keys.get(cnt - 1).remove(key);
23
24            if (keys.get(cnt - 1).isEmpty()) {
25                keys.remove(cnt - 1);
26            }
27        }
28    }
29
30    public void dec(String key) {
31
32        int prevCount = count.get(key);
33        count.put(key, prevCount - 1);
34
35        keys.get(prevCount).remove(key);
36
37        if (keys.get(prevCount).isEmpty()) {
38            keys.remove(prevCount);
39        }
40
41        if (count.get(key) == 0) {
42            count.remove(key);
43        } else {
44            keys.putIfAbsent(prevCount - 1, new HashSet<>());
45            keys.get(prevCount - 1).add(key);
46        }
47    }
48
49    public String getMaxKey() {
50
51        if (keys.isEmpty())
52            return "";
53
54        return keys.lastEntry().getValue().iterator().next();
55    }
56
57    public String getMinKey() {
58
59        if (keys.isEmpty())
60            return "";
61
62        return keys.firstEntry().getValue().iterator().next();
63    }
64}