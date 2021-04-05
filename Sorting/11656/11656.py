from queue import PriorityQueue

s = input()
pq = PriorityQueue()
for idx in range(len(s)):
    pq.put(s[idx:])
while pq.empty() is False:
    print(pq.get())