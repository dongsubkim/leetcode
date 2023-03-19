class WordDictionary:
    def __init__(self):
        self.children = [None] * 26
        self.isEndOfWord = False

    def addWord(self, word: str) -> None:
        curr = self
        for c in word:
            ind = ord(c) - ord('a')
            if curr.children[ind] == None:
                curr.children[ind] = WordDictionary()
            curr = curr.children[ind]
        
        curr.isEndOfWord = True
    
    def search(self, word: str) -> bool:
        curr = self
        for i in range(len(word)):
            c = word[i]
            if c == '.':
                for child in curr.children:
                    if child != None and child.search(word[i+1:]):
                        return True
                return False
            if curr.children[ord(c) - ord('a')] == None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr != None and curr.isEndOfWord

