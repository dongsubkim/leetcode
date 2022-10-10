class Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length == 1) return ""
        
        for ((index, char) in palindrome.withIndex()) {
            if (index == (palindrome.length / 2)) break
            
            if (char != 'a') {
                return palindrome.substring(0, index) + "a" + palindrome.substring(index + 1)
            }            
        }
        
        return palindrome.take(palindrome.lastIndex) + "b"
    }
}