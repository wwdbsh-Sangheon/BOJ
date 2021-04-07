k, n = map(int, input().split())
lans = []
for _ in range(k):
    lans.append(int(input()))

def binary_search(start, end, max_len):
    if start > end:
        return max_len
    mid = (start+end)//2
    count = 0
    for lan in lans:
        count += lan//mid
    if count >= n:
        return binary_search(mid+1, end, mid)
    else:
        return binary_search(start, mid-1, max_len)

lans.sort()
print(binary_search(1, lans[-1], 0))