#include <iostream>
#include <algorithm>

using namespace std;

long long trees[1000000];
long long n, m;

long long get_tree(long long height){
    long long tot = 0;
    for(int i = 0; i < n; i++){
        if(height < trees[i]){
            tot += (trees[i]-height);
        }
    }
    return tot;
}
long long get_height(long long start, long long end, long long max_h){
    if(start > end){
        return max_h;
    }
    long long mid = (start+end)/2, len = get_tree(mid);
    if(len >= m){
        if(max_h < mid){
            return get_height(mid+1, end, mid);
        }
        return mid;
    }else{
        return get_height(start, mid-1, max_h);
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> trees[i];
    }
    sort(trees, trees+n);
    cout << get_height(1, trees[n-1], 0) << "\n";
}