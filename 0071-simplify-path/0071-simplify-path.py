class Solution:
    def simplifyPath(self, path: str) -> str:
        folders = []
        ps = path.split("/")
        for p in ps:
            if p == "":
                continue
            elif p == "..":
                if len(folders) > 0:
                    folders.pop()
            elif p == ".":
                continue
            else:
                folders.append(p)
        
        return "/" + "/".join(folders)