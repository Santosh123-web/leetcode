// Last updated: 9/24/2026, 10:05:22 PM
1class Solution {
2    public String complexNumberMultiply(String num1, String num2) {
3        int[] complex1 = parseComplex(num1);
4        int real1 = complex1[0];    // Real part of first number
5        int img1 = complex1[1];     // Imaginary part of first number
6
7        int[] complex2 = parseComplex(num2);
8        int real2 = complex2[0];    // Real part of second number
9        int img2 = complex2[1];     // Imaginary part of second number
10
11        int realPart = (real1 * real2) - (img1 * img2);
12        int imgPart = (real1 * img2) + (real2 * img1);
13
14        return realPart + "+" + imgPart + "i";
15        
16    }
17    private static int[] parseComplex(String complex) {
18        // Remove the 'i' at the end
19        complex = complex.replace("i", "");
20        String[] parts = complex.split("\\+"); // Split by '+'
21        int real = Integer.parseInt(parts[0]); // Real part
22        int imaginary = Integer.parseInt(parts[1]); // Imaginary part
23        return new int[]{real, imaginary};
24    }
25}