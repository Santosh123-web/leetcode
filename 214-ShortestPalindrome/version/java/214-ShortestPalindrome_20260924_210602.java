// Last updated: 9/24/2026, 9:06:02 PM
1public class Solution {
2    public boolean isSelfCrossing(int[] x) {
3        if (x.length <= 3) {
4            return false;
5        }
6        int i = 2;
7        // keep spiraling outward
8        while (i < x.length && x[i] > x[i - 2]) {
9            i++;
10        }
11        if (i >= x.length) {
12            return false;
13        }
14        // transition from spiraling outward to spiraling inward
15        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) ||
16                (i == 3 && x[i] == x[i - 2])) {
17            x[i - 1] -= x[i - 3];
18        }
19        i++;
20        // keep spiraling inward
21        while (i < x.length) {
22            if (x[i] >= x[i - 2]) {
23                return true;
24            }
25            i++;
26        }
27        return false;
28    }
29}