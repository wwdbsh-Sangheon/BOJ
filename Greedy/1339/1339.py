n = int(input())
letter = {}
for i in range(n):
    word = list(input())
    length = len(word)
    for j in range(length):
        c = word[j]
        if c not in letter.keys():
            letter[c] = 0
        letter[c] += pow(10, length-j-1)

letter = dict(sorted(letter.items(), key=lambda x:x[1], reverse=True))

result = 0
for idx, key in enumerate(letter):
    result += letter[key]*(9-idx)
print(result)