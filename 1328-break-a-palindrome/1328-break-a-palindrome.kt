class Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length == 1) return ""
        
        for (index in 0 until (palindrome.length / 2)) {
            if (palindrome[index] != 'a') {
                return palindrome.take(index) + "a" + palindrome.drop(index + 1)
            }            
        }
        
        return palindrome.take(palindrome.lastIndex) + "b"
    }
}