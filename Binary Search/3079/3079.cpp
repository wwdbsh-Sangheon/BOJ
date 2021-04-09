#include <iostream>
#include <algorithm>

using namespace std;

long long t[100000];
int n, m;

long long b_search(long long start, long long end, long long min_time){
    if(start > end){
        return min_time;
    }
    long long mid = (start+end)/2;
    long long sum = 0;
    for(int i = 0; i < n; i++){
        sum += mid/t[i];
    }
    if(sum >= m){
        return b_search(start, mid-1, min(min_time, mid));
    }else{
        return b_search(mid+1, end, min_time);
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> t[i];
    }
    sort(t, t+n);
    cout << b_search(0, m*t[n-1], m*t[n-1]) << "\n";
}