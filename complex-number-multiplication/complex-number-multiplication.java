class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int plusIdx1 = num1.indexOf('+');
        int plusIdx2 = num2.indexOf('+');
        
        int a = Integer.parseInt(num1.substring(0, plusIdx1));
        int b = Integer.parseInt(num1.substring(plusIdx1+1, num1.length()-1));
        int c = Integer.parseInt(num2.substring(0, plusIdx2));
        int d = Integer.parseInt(num2.substring(plusIdx2+1, num2.length()-1));
        return String.format("%d+%di",a*c-b*d, b*c+a*d);
    }
}