// Last updated: 7/16/2026, 4:09:07 PM
import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1)); 
        }
        
        return result;
    }
}