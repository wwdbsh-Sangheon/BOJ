n = [int(d) for d in input()]
print("LUCKY" if sum(n[:int(len(n)/2)]) == sum(n[int(len(n)/2):]) else "READY")