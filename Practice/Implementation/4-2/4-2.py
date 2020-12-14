n = int(input())

# sol 1
def getCount(hour):
    count = 0
    for i in range(hour+1):
        if "3" in str(i):
            count += 3600
        else:
            count += 1575
    return count

# sol 2
def bruteForceGetCount(hour):
    count = 0
    for i in range(hour+1):
        for j in range(60):
            for k in range(60):
                if "3" in str(i) + str(j) + str(k):
                    count += 1
    return count

print(getCount(n))
print(bruteForceGetCount(n))