// Last updated: 9/24/2026, 9:08:32 PM
1//149ms
2
3class Solution {
4    public List<List<Integer>> palindromePairs(String[] words) {
5        HashMap<String,Integer> wordMap = new HashMap<>();
6        Set<Integer> set = new TreeSet<>();
7        int n = words.length;
8        
9        for(int i=0;i<n;i++){
10            wordMap.put(words[i],i);
11            set.add(words[i].length());
12        }
13        
14        List<List<Integer>> ans = new ArrayList<>();
15        
16        for(int i=0;i<n;i++){
17            int length = words[i].length();
18            
19            // if(length ==1){
20            //     if(wordMap.containsKey("")){
21            //         ans.add(Arrays.asList(i, wordMap.get("")));
22            //         ans.add(Arrays.asList(wordMap.get(""), i));
23            //     }
24            //     continue;
25            // }
26            String reverse= new StringBuilder(words[i]).reverse().toString();
27            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
28                ans.add(Arrays.asList(i,wordMap.get(reverse)));
29            
30            for(Integer k:set){
31                if(k==length)
32                    break;
33                if(isPalindrome(reverse,0,length-1-k)){
34                    String s1 = reverse.substring(length-k);
35                    if(wordMap.containsKey(s1))
36                        ans.add(Arrays.asList(i,wordMap.get(s1)));
37                }
38                
39                if(isPalindrome(reverse,k,length-1)){
40                    String s2 = reverse.substring(0,k);
41                    if(wordMap.containsKey(s2))
42                        ans.add(Arrays.asList(wordMap.get(s2),i));
43                }
44            }
45        }
46        return ans;
47    }
48    
49    private boolean isPalindrome(String s, int left, int right){
50        while(left<right)
51            if(s.charAt(left++)!=s.charAt(right--))
52                return false;
53        return true;
54    }
55}