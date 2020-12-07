s = input()
zero = 0
one = 0

if s[0] == "1":
    zero += 1
else:
    one += 1

for idx in range(len(s)-1):
    if s[idx] != s[idx+1]:
        if s[idx+1] == "1":
            zero += 1
        else:
            one += 1
print(min(zero, one))