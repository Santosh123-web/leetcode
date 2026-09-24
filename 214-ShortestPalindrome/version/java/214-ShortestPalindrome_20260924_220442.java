// Last updated: 9/24/2026, 10:04:42 PM
1import java.util.HashMap;
2import java.util.Map;
3
4public class Codec {
5    // Stores the mapping from the short URL suffix to the original long URL
6    private final Map<String, String> urlMap = new HashMap<>();
7    // A counter to generate unique IDs for each new URL
8    private int id = 0;
9    // The base domain required for the short URL structure
10    private static final String BASE_URL = "http://tinyurl.com/";
11
12    // Encodes a URL to a shortened URL.
13    public String encode(String longUrl) {
14        id++;
15        String shortKey = Integer.toString(id);
16        urlMap.put(shortKey, longUrl);
17        return BASE_URL + shortKey;
18    }
19
20    // Decodes a shortened URL to its original URL.
21    public String decode(String shortUrl) {
22        // Extract the unique key by removing the base URL prefix
23        String shortKey = shortUrl.replace(BASE_URL, "");
24        return urlMap.get(shortKey);
25    }
26}
27
28// Your Codec object will be instantiated and called as such:
29// Codec codec = new Codec();
30// codec.decode(codec.encode(url));