// Last updated: 9/24/2026, 9:45:10 PM
1class LFUCache {
2  public LFUCache(int capacity) {
3    this.capacity = capacity;
4  }
5
6  public int get(int key) {
7    if (!keyToVal.containsKey(key))
8      return -1;
9
10    final int freq = keyToFreq.get(key);
11    freqToLRUKeys.get(freq).remove(key);
12    if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
13      freqToLRUKeys.remove(freq);
14      ++minFreq;
15    }
16
17    // Increase key's freq by 1
18    // Add this key to next freq's list
19    putFreq(key, freq + 1);
20    return keyToVal.get(key);
21  }
22
23  public void put(int key, int value) {
24    if (capacity == 0)
25      return;
26    if (keyToVal.containsKey(key)) {
27      keyToVal.put(key, value);
28      get(key); // Update key's count
29      return;
30    }
31
32    if (keyToVal.size() == capacity) {
33      // Evict LRU key from the minFreq list
34      final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
35      freqToLRUKeys.get(minFreq).remove(keyToEvict);
36      keyToVal.remove(keyToEvict);
37    }
38
39    minFreq = 1;
40    putFreq(key, minFreq);    // Add new key and freq
41    keyToVal.put(key, value); // Add new key and value
42  }
43
44  private int capacity;
45  private int minFreq = 0;
46  private Map<Integer, Integer> keyToVal = new HashMap<>();
47  private Map<Integer, Integer> keyToFreq = new HashMap<>();
48  private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();
49
50  private void putFreq(int key, int freq) {
51    keyToFreq.put(key, freq);
52    freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
53    freqToLRUKeys.get(freq).add(key);
54  }
55}