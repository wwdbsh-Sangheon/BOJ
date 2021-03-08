#include <iostream>

using namespace std;

int parent[100001];
int n, m;

int find_parent(int x){
    if(parent[x] != x){
        return parent[x] = find_parent(parent[x]);
    }
    return parent[x];
}

void unite(int a, int b){
    a = find_parent(a);
    b = find_parent(b);
    b > a ? parent[b] = a : parent[a] = b;
}

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 100001; i++){
        parent[i] = i;
    }
    for(int i = 0; i < m; i++){
        int op, a, b;
        cin >> op >> a >> b;
        if(op == 0){
            unite(a, b);
        }else{
            find_parent(a) == find_parent(b) ? cout << "YES\n" : cout << "NO\n";
        }
    }
}