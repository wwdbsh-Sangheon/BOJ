#include <iostream>
#include <algorithm>

using namespace std;

int parent[501], cycle[501];
int n, m, v1, v2;

int find_parent(int x){
    if(parent[x] != x){
        return parent[x] = find_parent(parent[x]);
    }
    return parent[x];
}

void unite(int a, int b){
    a = find_parent(a);
    b = find_parent(b);
    if(b > a){
        if(cycle[b]){
            cycle[a] = 1;
        }
        parent[b] = a;
    }else{
        if(cycle[a]){
            cycle[b] = 1;
        }
        parent[a] = b;
    }
}

int main(void){
    int tc = 1;
    while(true){
        cin >> n >> m;
        if(n == 0 && m == 0){
            break;
        }
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            cin >> v1 >> v2;
            if(find_parent(v1) != find_parent(v2)){
                unite(v1, v2);
            }else{
                cycle[find_parent(v1)] = 1;
            }
        }
        int t = 0;
        for(int i = 1; i <= n; i++){
            int p = find_parent(i);
            if(!cycle[p]){
                t++;
                cycle[p] = 1;
            }
        }
        if(t > 1){
            cout << "Case " << tc << ": A forest of " << t << " trees.\n";
        }else if(t == 1){
            cout << "Case " << tc << ": There is one tree.\n";
        }else{
            cout << "Case " << tc << ": No trees.\n";
        }
        fill(cycle, cycle+501, 0);
        tc++;
    }
}