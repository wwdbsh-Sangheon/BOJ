import sys
sys.setrecursionlimit(10000)

n = int(input())
requests = list(map(int, input().split()))
budget = int(input())

requests.sort()

def is_possible(upper_limit):
    tot = 0
    for r in requests:
        if r < upper_limit:
            tot += r
        else:
            tot += upper_limit
    return True if tot <= budget else False

def binary_search(start, end, max_limit):
    if start > end:
        return max_limit
    mid = (start+end)//2
    if is_possible(mid):
        if mid > max_limit:
            return binary_search(mid+1, end, mid)
        else:
            return max_limit
    else:
        return binary_search(start, mid-1, max_limit)

print(binary_search(1, requests[-1], 0))