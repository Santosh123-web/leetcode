// Last updated: 9/24/2026, 9:07:47 PM
1class Solution {
2    public boolean isSelfCrossing(int[] distance) {
3        int len = distance.length;
4        // Base Case
5        if(len <= 3){
6            return false;
7        }
8
9        for(int i=3; i<len; i++){
10            //Fourth line crosses first line and onward
11            if(distance[i]>=distance[i-2] && distance[i-1]<=distance[i-3]){
12                return true;
13            }
14            // Fifth line meets first line and onward
15            if(i>=4){
16                if(distance[i-1]==distance[i-3] && distance[i]+distance[i-4]>=distance[i-2]){
17                    return true;
18                }
19            }
20            // Sixth line crosses first line and onward
21            if(i>=5){
22                if(distance[i-2]-distance[i-4]>=0 && distance[i]>=distance[i-2]-distance[i-4] && distance[i-1]>=distance[i-3]-distance[i-5] && distance[i-1]<=distance[i-3]){
23                    return true;
24                }
25            }
26        }
27        return false;
28    }
29}