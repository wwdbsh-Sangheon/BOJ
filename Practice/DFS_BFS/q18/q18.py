import sys
sys.setrecursionlimit(10000)

def check_correct_s(parentheses):
    stack = []
    for p in parentheses:
        if p == "(":
            stack.append(p)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    return True

def reorganize_u(u):
    reorg_u = ""
    for p in u:
        if p == "(":
            reorg_u += ")"
        else:
            reorg_u += "("
    return reorg_u

def reorganize_parentheses(parentheses):
    if parentheses == "":
        return parentheses
    l_count = 0
    r_count = 0
    s_point = None
    for idx, p in enumerate(parentheses):
        if p == "(":
            l_count += 1
        else:
            r_count += 1
        if l_count == r_count:
            s_point = idx+1
            break
    u = parentheses[:s_point]
    v = parentheses[s_point:] if s_point != len(parentheses) else ""
    if check_correct_s(u):
        return u + reorganize_parentheses(v)
    return "(" + reorganize_parentheses(v) + ")" + reorganize_u(u[1:-1])

def solution(p):
    return reorganize_parentheses(p)