import sys
sys.setrecursionlimit(10000)

def binary_search(start, end, q):
    if start > end:
        return q
    mid = (start+end)//2
    if mid*mid >= n:
        return binary_search(start, mid-1, min(mid, q))
    else:
        return binary_search(mid+1, end, q)

n = int(input())
print(binary_search(1, n, n))