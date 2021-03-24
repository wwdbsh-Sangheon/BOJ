t = int(input())
quarter = 25; dime = 10; nickel = 5
while  t > 0 :
    change = int(input())
    q_cnt = 0; d_cnt = 0; n_cnt = 0; p_cnt = 0
    while change > 0:
        if change >= quarter:
            q_cnt = change // quarter
            change %= quarter
        elif change >= dime:
            d_cnt = change // dime
            change %= dime
        elif change >= nickel:
            n_cnt = change // nickel
            change %= nickel
        else:
            p_cnt = change
            change = 0
    print(str(q_cnt)+" "+str(d_cnt)+" "+str(n_cnt)+" "+str(p_cnt))
    t -= 1