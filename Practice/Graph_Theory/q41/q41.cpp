#include <iostream>

using namespace std;

int parent[501];
int city[501];
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
    a < b ? parent[b] = a : parent[a] = b;
}

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 501; i++){
        parent[i] = i;
    }
    for(int a = 1; a <= n; a++){
        for(int b = 1; b <= n; b++){
            int chk;
            cin >> chk;
            if(chk == 1){
                unite(a, b);
            }
        }
    }
    for(int i = 1; i <= m; i++){ 
        cin >> city[i];
    }
    bool result = true;
    for(int i = 1; i <= m-1; i++){
        int a = city[i-1];
        int b = city[i];
        if(find_parent(a) != find_parent(b)){
            result = false;
        }
    }
    result ? cout << "YES\n" : cout << "NO\n";
}