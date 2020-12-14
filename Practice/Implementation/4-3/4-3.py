# def getY(col):
#     if col == "a": return 1
#     elif col == "b": return 2
#     elif col == "c": return 3
#     elif col == "d": return 4
#     elif col == "e": return 5
#     elif col == "f": return 6
#     elif col == "g": return 7
#     else: return 8

y, x = list(input())
x, y = int(x), int(ord(y)) - int(ord("a")) + 1 # ord => ascii return

dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]

result = 0
for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx >= 1 and nx <= 8 and ny >= 1 and ny <= 8:
        result += 1
print(result)