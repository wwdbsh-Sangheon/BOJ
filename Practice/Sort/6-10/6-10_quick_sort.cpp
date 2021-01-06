#include <iostream>

using namespace std;

int n;
int seq[500];

void quick_sort(int s, int e){
    if(s >= e) return;
    int pivot = s;
    int left = s+1;
    int right = e;
    while(left <= right){
        while(left <= e && seq[left] >= seq[pivot]) left++;
        while(right > s && seq[right] <= seq[pivot]) right--;
        if(left > right){
            swap(seq[right], seq[pivot]);
            // int temp = seq[right];
            // seq[right] = seq[pivot];
            // seq[pivot] = temp;
        }else{
            swap(seq[right], seq[left]);
            // int temp = seq[left];
            // seq[left] = seq[right];
            // seq[right] = temp;
        }
    }
    quick_sort(s, right-1);
    quick_sort(right+1, e);
}

void print_seq(){
    for(int i = 0; i < n; i++){
        cout << seq[i] << " ";
    }
    cout << "\n";
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> seq[i];
    }
    quick_sort(0, n-1);
    print_seq();
}