n = int(input())
letter = {}
for i in range(n):
    word = list(input())
    length = len(word)
    for j in range(length):
        c = word[j]
        if c not in letter.keys():
            letter[c] = 0
        letter[c] += pow(10, length-j-1) # 해당 알파벳이 자리하는 자리수에 대한 10의 거듭제곱 값을 더해준다

letter = dict(sorted(letter.items(), key=lambda x:x[1], reverse=True)) # 미리 구해놓은 누적 합계 값에 따라 내림차순 정렬

result = 0
for idx, key in enumerate(letter):
    result += letter[key]*(9-idx) # 큰 값부터 작은 값까지 9부터 0을 차례대로 곱해준 후 결과값에 더해준다
print(result)