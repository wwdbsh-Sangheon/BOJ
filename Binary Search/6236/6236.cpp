#include <iostream>
#include <algorithm>

using namespace std;

long long days[100000];
int n, m;

long long b_search(long long start, long long end, long long min_amt){
    if(start > end){
        return min_amt;
    }
    long long mid = (start+end)/2;
    long long temp = mid;
    int cnt = 1;
    for(int i = 0; i < n; i++){
        if(mid < days[i]){
            return b_search(mid+1, end, min_amt);
        }
        if(temp < days[i]){
            temp = mid;
            cnt++;
        }
        temp -= days[i];
    }
    if(cnt <= m){
        return b_search(start, mid-1, min(min_amt, mid));
    }else{
        return b_search(mid+1, end, min_amt);
    }
}

int main(void){
    cin >> n >> m;
    long long sum = 0;
    for(int i = 0; i < n; i++){
        long long money;
        cin >> money;
        sum += money;
        days[i] = money;
    }
    cout << b_search(1, sum, sum) << "\n";
}