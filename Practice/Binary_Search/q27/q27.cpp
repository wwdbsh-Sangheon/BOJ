#include <iostream>

using namespace std;

int arr[1000000];
int n, x;

int find_start_idx(int start, int end){
    if(start > end){
        return -1;
    }
    int mid = (start + end)/2;
    if((mid == 0 || arr[mid-1] < x) && arr[mid] == x){
        return mid;
    }else if(arr[mid] >= x){
        return find_start_idx(start, mid-1);
    }else{
        return find_start_idx(mid+1, end);
    }
}

int find_end_idx(int start, int end){
    if(start > end){
        return -1;
    }
    int mid = (start + end)/2;
    if((mid == n-1 || arr[mid+1] != x) && arr[mid] == x){
        return mid;
    }else if(arr[mid] > x){
        return find_end_idx(start, mid-1);
    }else{
        return find_end_idx(mid+1, end);
    }
}

int main(void){
    cin >> n >> x;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    int s_idx = find_start_idx(0, n-1);
    int e_idx = find_end_idx(0, n-1);
    s_idx == -1 ? cout << -1 << "\n" : cout << (e_idx - s_idx + 1) << "\n";
}