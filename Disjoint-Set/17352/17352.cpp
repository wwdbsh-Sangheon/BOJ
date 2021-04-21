#include <iostream>

using namespace std;

int parent[300001];
int n;

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
    cin >> n;
    for(int i = 1; i <= n; i++){
        parent[i] = i;
    }
    for(int i = 0; i < n-2; i++){
        int a, b;
        cin >> a >> b;
        unite(a, b);
    }
    for(int a = 1; a <= n; a++){
        for(int b = 1; b <= n; b++){
            if(find_parent(a) != find_parent(b)){
                cout << a << " " << b << "\n";
                return 0;
            }
        }
    }
}