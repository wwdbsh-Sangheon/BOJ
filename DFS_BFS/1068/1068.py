import sys
sys.setrecursionlimit(10000)

n = int(input())
graph = [[] for _ in range(n)]
parent = []
root = []
pp = list(map(int, input().split()))
for i in range(n):
    if pp[i] == -1:
        root.append(i)
        continue
    graph[pp[i]].append(i)
rm_node = int(input())

def dfs(p, prev):
    global temp
    if p == rm_node:
        if len(graph[prev]) == 1:
            temp += 1
        return
    if len(graph[p]) == 0:
        temp += 1
        return
    for child in graph[p]:
        dfs(child, p)

ans = 0
for r in root:
    temp = 0
    if r == rm_node:
        continue
    dfs(r, -1)
    if temp == 0: temp = 1
    ans += temp
print(ans)