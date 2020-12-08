e = input()
result = 0
minus = e.split("-")
for idx, plus in enumerate(minus):
    num = sum(list(map(int, plus.split("+")))) if "+" in plus else int(plus)    
    if idx == 0:
        result = num
    else:
        result -= num
print(result)