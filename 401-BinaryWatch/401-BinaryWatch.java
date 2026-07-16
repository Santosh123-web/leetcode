// Last updated: 7/16/2026, 4:06:58 PM
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int hour = 0; hour < 12; hour++) {
            
            for (int minute = 0; minute < 60; minute++) {
                
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                if (totalBits == turnedOn) {
                    
                    String time = hour + ":" + 
                                  (minute < 10 ? "0" + minute : minute);
                    
                    result.add(time);
                }
            }
        }
        
        return result;
    }
}