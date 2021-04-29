n, k = map(int, input().split())
number = list(input())
stack = [number[0]]
for idx in range(1, n):
    if k:
        while k and len(stack) != 0 and number[idx] > stack[-1]:
            stack.pop()
            k -= 1
    stack.append(number[idx])
while k:
    stack.pop()
    k -= 1
print("".join(stack))