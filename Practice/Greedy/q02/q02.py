s = input()
result = int(s[0])
for i in range(1, len(s)):
    digit = int(s[i])
    if result <= 1 or digit <= 1:
        result += digit
    else:
        result *= digit
print(result)