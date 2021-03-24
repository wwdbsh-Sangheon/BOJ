string = input()
chk1 = chk2 = chk3 = chk4 = False
for c in string:
    if ~chk1 and c == 'U':
        chk1 = True
    if chk1 and ~chk2 and c == 'C':
        chk2 = True
    if chk1 and chk2 and ~chk3 and c == 'P':
        chk3 = True
    if chk1 and chk2 and chk3 and ~chk4 and c == 'C':
        chk4 = True

if chk1 and chk2 and chk3 and chk4:
    print("I love UCPC")
else:
    print("I hate UCPC")
