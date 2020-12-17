def check(answer): # 새로운 프레임을 추가하거나 제거할때마다 모든 프레임들을 점검 해야한다.
    for x, y, t in answer:
        if t == 0:
            if y == 0 or [x, y-1, 0] in answer or [x-1, y, 1] in answer or [x, y, 1] in answer: continue
        else:
            if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer): continue
        return True
    return False

def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x, y, t, op = frame
        if op == 1:
            answer.append([x, y, t])
            if check(answer):
                answer.remove([x, y, t])
        else:
            answer.remove([x, y, t])
            if check(answer):
                answer.append([x, y, t])
    return sorted(answer)