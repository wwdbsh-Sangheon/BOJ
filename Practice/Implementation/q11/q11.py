import sys
sys.setrecursionlimit(100000) # 재귀 제한을 풀어주는 요소

n = int(input())
board = [[0 for i in range(n)] for j in range(n)]

k = int(input())
for i in range(k):
    x, y = map(int, input().split())    
    board[x-1][y-1] = 1 # 사과 표시
    
plan = []
l = int(input())
for i in range(l):
    x, c = input().split()
    plan.append((int(x), c)) # 계획 저장

direction = [(0, 1), (1, 0), (0, -1), (-1, 0)] # east, south, west, north
snake = [(0, 0)] # 뱀의 처음 위치
head = 0 # index for east

def move(x, y, sec):
    # 뱀이 벽에 부딪히거나 뱀이 자기 자신과 충돌하면 재귀 종료
    if (x, y) in snake or x < 0 or x > n-1 or y < 0 or y > n-1: return sec
    
    snake.append((x, y))
    if board[x][y] == 1:
        board[x][y] = 0 # 먹은 사과 표시
    else:
        snake.pop(0) # 사과를 먹지 않았으면 꼬리 이동
    
    if len(plan) != 0 and sec == plan[0][0]:
        global head
        head = head-1 if plan[0][1] == 'L' else head+1 # 방향 결정
        if head == -1: head = 3
        if head == 4: head = 0
        plan.pop(0)
    
    return move(x+direction[head][0], y+direction[head][1], sec+1)

print(move(0, 1, 1))