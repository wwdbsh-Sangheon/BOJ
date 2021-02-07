#include <iostream>
#include <algorithm>

using namespace std;

int homes[200000];
int n, c, dist;

void get_dist(int start, int end){
    if(start > end){
        return;
    }
    int mid = (start + end) / 2;
    int value = homes[0];
    int count = 1;
    for(int i = 1; i < n; i++){
        if(homes[i] >= value + mid){
            value = homes[i];
            count++;
        }
    }
    if(count >= c){
        dist = mid;
        get_dist(mid+1, end);
    }else{
        get_dist(start, mid-1);
    }
}

int main(void){
    cin >> n >> c;
    for(int i = 0; i < n; i++){
        cin >> homes[i];
    }
    sort(homes, homes+n);
    int start = 1;
    int end = homes[n-1] - homes[0];
    get_dist(start, end);
    cout << dist << "\n";
}