#include <iostream>

using namespace std;

int parent[100001];
int g, p;

int find_parent(int x){
    if(parent[x] != x){
        return parent[x] = find_parent(parent[x]);
    }
    return parent[x];
}

void unite(int a, int b){
    a = find_parent(a);
    b = find_parent(b);
    a < b ? parent[b] = a : parent[a] = b;
}

int main(void){
    cin >> g >> p;
    for(int i = 1; i < 100001; i++){
        parent[i] = i;
    }
    int ans = 0;
    for(int i = 0; i < p; i++){
        int data;
        cin >> data;
        data = find_parent(data);
        if(data == 0) break;
        unite(data, data-1);
        ans++;
    }
    cout << ans << "\n";
}