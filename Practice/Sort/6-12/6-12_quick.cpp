#include <iostream>
#include <numeric>

using namespace std;

int n, k;
int a[100000];
int b[100000];

void quick_sort(int arr[100000], int start, int end, int type){
    if(start >= end) return;
    int pivot = start;
    int left = start+1;
    int right = end;
    while(left <= right){
        if(type == 0){
            while(left <= end && arr[pivot] <= arr[left]) left++;
            while(right > start && arr[pivot] >= arr[right]) right--;
        }else{
            while(left <= end && arr[pivot] >= arr[left]) left++;
            while(right > start && arr[pivot] <= arr[right]) right--;
        }
        if(left > right){
            swap(arr[pivot], arr[right]);
        }else{
            swap(arr[left], arr[right]);
        }
    }
    quick_sort(arr, start, right-1, type);
    quick_sort(arr, right+1, end, type);
}

int main(void){
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    for(int i = 0; i < n; i++){
        cin >> b[i];
    }
    quick_sort(a, 0, n-1, 1);
    quick_sort(b, 0, n-1, 0);
    for(int i = 0; i < k; i++){
        if(b[i] > a[i]){
            a[i] = b[i];
        }else{
            break;
        }
    }
    cout << accumulate(a, a+n, 0) << "\n";
}