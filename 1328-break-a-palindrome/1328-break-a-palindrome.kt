class Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length == 1) return ""
        
        for ((index, char) in palindrome.withIndex()) {
            if (char != 'a' && index != (palindrome.length / 2)) {
                return palindrome.take(index) + "a" + palindrome.drop(index + 1)
            }            
        }
        
        return palindrome.take(palindrome.lastIndex) + "b"
    }
}