n, m = map(int, input().split(" "))
result = 0
a = []
b = []

def convert(i, j):
    for r in range(i, i+3):
        for c in range(j, j+3):
            if a[r][c] == '0':
                a[r][c] = '1'
            else:
                a[r][c] = '0'

def check():
    for r in range(n):
        for c in range(m):
            if a[r][c] != b[r][c]:
                return False
    return True

for i in range(n):
    a.append(list(input()))
for i in range(n):
    b.append(list(input()))

for i in range(n):
    for j in range(m):
        if i+2 < n and j+2 < m and a[i][j] != b[i][j]:
            convert(i, j)
            result += 1

print(result if check() else -1)