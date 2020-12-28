import sys
sys.setrecursionlimit(10000)

def calculate(n1, n2, op):
    if op == 0: # +
        return n1+n2
    if op == 1: # -
        return n1-n2
    if op == 2: # *
        return n1*n2
    if op == 3: # //
        return ((n1)*-1//n2)*-1 if n1 < 0 else n1//n2

def dfs(cal_v, idx, count):
    if count == n-1:
        global max_ans, min_ans
        max_ans = max(max_ans, cal_v)
        min_ans = min(min_ans, cal_v)
        return

    for i in range(idx, len(numbers)):
        for op in range(4):
            if operations[op] != 0:
                operations[op] -= 1
                dfs(calculate(cal_v, numbers[i], op), i+1, count+1)
                operations[op] += 1

n = int(input())
numbers = list(map(int, input().split()))
operations = list(map(int, input().split()))
max_ans, min_ans = -1e9, 1e9
dfs(numbers[0], 1, 0)
print(max_ans)
print(min_ans)