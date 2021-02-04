n = int(input())
a = list(map(int, input().split()))

def b_search(start, end):
    if start > end: return -1
    mid = (start + end) // 2
    if mid == a[mid]: return mid
    elif mid > a[mid]: return b_search(mid+1, end)
    else: return b_search(start, mid-1)

print(b_search(0, n-1))