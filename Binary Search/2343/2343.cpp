#include <iostream>

using namespace std;

int lessons[100000];
int n, m, tot;

bool is_possible(int size){
    int index = 0;
    for(int i = 0; i < m; i++){
        int temp = size;
        while(index < n){
            temp -= lessons[index];
            if(temp < 0) break;
            index++;
        }
        if(index == n) return true;
    }
    return false;
}

int b_search(int start, int end, int min_size){
    if(start > end){
        return min_size;
    }
    int mid = (start+end)/2;
    if(is_possible(mid)){
        if(mid < min_size){
            return b_search(start, mid-1, mid);
        }
        return b_search(start, mid-1, min_size);
    }else{
        return b_search(mid+1, end, min_size);
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> lessons[i];
        tot += lessons[i];
    }
    cout << b_search(tot/m, tot, 1e9) << "\n";
}