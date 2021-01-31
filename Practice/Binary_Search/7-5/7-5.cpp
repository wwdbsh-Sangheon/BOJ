#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> components;

bool b_search(int start, int end, int req){
    if(start > end){
        return false;
    }
    int mid = (start+end)/2;
    if(components[mid] == req){
        return true;
    }else if(components[mid] > req){
        return b_search(start, mid-1, req);
    }else{
        return b_search(mid+1, end, req);
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int component;
        cin >> component;
        components.push_back(component);
    }
    cin >> m;
    sort(components.begin(), components.end());
    for(int i = 0; i < m; i++){
        int req;
        cin >> req;
        if(b_search(0, n-1, req)){
            cout << "yes ";
        }else{
            cout << "no ";
        }
    }
}