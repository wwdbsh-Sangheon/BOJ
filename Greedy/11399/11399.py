n = int(input())
time = sorted(list(map(int, input().split())))
result = 0
wait_t = 0
for t in time:
    result += (wait_t + t)
    wait_t += t
print(result)