t = int(input())

def binary_search(start, end, target):
    if start > end:
        return 0
    mid = (start+end)//2
    if note1[mid] == target:
        return 1
    elif note1[mid] > target:
        return binary_search(start, mid-1, target)
    else:
        return binary_search(mid+1, end, target)

while t > 0:
    n = int(input())
    note1 = list(map(int, input().split()))
    m = int(input())
    note2 = list(map(int, input().split()))
    note1.sort()
    for num in note2:
        print(binary_search(0, n-1, num))
    t -= 1