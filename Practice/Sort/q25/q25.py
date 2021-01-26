def solution(N, stages):
    ans = [[0, stage] for stage in range(1, N+1)]
    stages.sort()
    idx = 0
    for stage in range(1, N+1):
        count = 0
        while idx < len(stages):
            if stages[idx] != stage: break
            count += 1
            idx += 1
        if len(stages)-idx+count == 0: continue
        ans[stage-1][0] = count / (len(stages)-idx+count)
    ans.sort(key=lambda x:(-x[0], x[1]))
    return [s[1] for s in ans]

# print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4,4,4,4,4]))