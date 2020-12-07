n = int(input()) # 설탕의 양
result = 0
while n >= 3:
    if n % 5 == 0: # 남은 설탕의 양이 5로 나누어 떨어지면 5킬로그램 봉지 사용.
        result += n // 5
        n -= n // 5 * 5
        break
    n -= 3 # 3킬로그램 봉지 사용
    result += 1
print(result if n == 0 else -1)
