#include <iostream>

using namespace std;

int parent[500000];
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
    for(int i = 0; i < n; i++){
        parent[i] = i;
    }
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
        }else{
            cout << i+1 << "\n";
            return 0;
        }
    }
    cout << "0\n";
}