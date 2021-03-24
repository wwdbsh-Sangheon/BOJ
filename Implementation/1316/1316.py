import string
n = int(input())
ans = 0
while n > 0:
    word = input()
    alphabet = dict.fromkeys(string.ascii_lowercase, False)
    for i in range(len(word)):
        if i+1 == len(word) or (i+1 < len(word) and word[i] != word[i+1]):
            if alphabet[word[i]]:
                break
            else:
                alphabet[word[i]] = True
        if i+1 == len(word):
            ans += 1
    n -= 1
print(ans)