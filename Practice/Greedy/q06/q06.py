# 무지의 먹방 라이브 317p 513p
import heapq

def solution(food_times, k):
    if sum(food_times) <= k: return -1

    q = []
    for idx in range(len(food_times)):
        heapq.heappush(q, (food_times[idx], idx+1))

    used_time = 0
    prev_time = 0
    left_food = len(food_times)
    while used_time + ((q[0][0] - prev_time) * left_food) <= k:
        now = heapq.heappop(q)[0]
        used_time += (now - prev_time) * left_food
        prev_time = now
        left_food -= 1
    
    result = sorted(q, key=lambda x:x[1])
    return result[(k-used_time) % left_food][1]
