#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

long long sangguen[500000];
int n, m;

int get_upper_boundary(int start, int end, long long target){
    if(start > end){
        return -1;
    }
    int mid = (start+end)/2;
    if(sangguen[mid] == target){
        if(mid == n-1){
            return mid;
        }
        return get_upper_boundary(mid+1, end, target);
    }else if(sangguen[mid] > target){
        if(sangguen[mid-1] == target){
            return mid-1;
        }
        return get_upper_boundary(start, mid-1, target);
    }else{
        return get_upper_boundary(mid+1, end, target);
    }
}

int get_lower_boundary(int start, int end, long long target){
    if(start > end){
        return -1;
    }
    int mid = (start+end)/2;
    if(sangguen[mid] == target){
        if(mid == 0){
            return mid;
        }
        return get_lower_boundary(start, mid-1, target);
    }else if(sangguen[mid] < target){
        if(sangguen[mid+1] == target){
            return mid+1;
        }
        return get_lower_boundary(mid+1, end, target);
    }else{
        return get_lower_boundary(start, mid-1, target);
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> sangguen[i];
    }
    sort(sangguen, sangguen+n);
    cin >> m;
    string ans = "";
    for(int i = 0 ; i < m; i++){
        long long target;
        cin >> target;
        int upper_bound = get_upper_boundary(0, n-1, target);
        int lower_bound = get_lower_boundary(0, n-1, target);
        if(upper_bound != -1 && lower_bound != -1){
            ans += (to_string(upper_bound - lower_bound + 1) + " ");
        }else{
            ans += "0 ";
        }
    }
    cout << ans << "\n";
}