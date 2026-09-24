// Last updated: 9/24/2026, 9:15:55 PM
1/**
2 * Using ArrayList & HashMap.
3 *
4 * Time Complexity: All function have average O(1)
5 *
6 * Space Complexity: O(N)
7 *
8 * N = Number of values currently stored in the data structure.
9 */
10class RandomizedCollection {
11
12    List<Integer> nums;
13    Map<Integer, Set<Integer>> idxMap;
14    Random random;
15
16    public RandomizedCollection() {
17        nums = new ArrayList<>();
18        idxMap = new HashMap<>();
19        random = new Random();
20    }
21
22    public boolean insert(int val) {
23        boolean response = !idxMap.containsKey(val);
24
25        if (response) {
26            idxMap.put(val, new HashSet<>());
27        }
28        idxMap.get(val).add(nums.size());
29        nums.add(val);
30
31        return response;
32    }
33
34    public boolean remove(int val) {
35        if (!idxMap.containsKey(val)) {
36            return false;
37        }
38
39        Set<Integer> idxSet = idxMap.get(val);
40        int idxToBeRemoved = idxSet.iterator().next();
41        if (idxSet.size() == 1) {
42            idxMap.remove(val);
43        } else {
44            idxSet.remove(idxToBeRemoved);
45        }
46
47        int lastIdx = nums.size() - 1;
48        if (idxToBeRemoved != lastIdx) {
49            int lastVal = nums.get(lastIdx);
50            Set<Integer> lastIdxSet = idxMap.get(lastVal);
51            lastIdxSet.add(idxToBeRemoved);
52            lastIdxSet.remove(lastIdx);
53            nums.set(idxToBeRemoved, lastVal);
54        }
55
56        nums.remove(lastIdx);
57
58        return true;
59    }
60
61    public int getRandom() {
62        return nums.get(random.nextInt(nums.size()));
63    }
64}