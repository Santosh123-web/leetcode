// Last updated: 8/12/2026, 11:18:14 AM
1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int sGas = 0, sCost = 0, res = 0, total = 0;
4        for (int i = 0; i < gas.length; i++) {
5            sGas += gas[i];
6            sCost += cost[i];
7        }
8        if (sGas < sCost) return -1;
9        for (int i = 0; i < gas.length; i++) {
10            total += gas[i] - cost[i];
11            if (total < 0) {
12                total = 0;
13                res = i + 1;
14            }
15        }
16        return res;
17    }
18}