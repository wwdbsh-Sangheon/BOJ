#include <iostream>

using namespace std;

int teams[100001];
int n, m;

int find_parent(int x){
    if(teams[x] != x){
        return teams[x] = find_parent(teams[x]);
    }
    return teams[x];
}

void unite(int a, int b){
    a = find_parent(a);
    b = find_parent(b);
    if(b > a){
        teams[b] = a;
    }else{
        teams[a] = b;
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < 100001; i++){
        teams[i] = i;
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