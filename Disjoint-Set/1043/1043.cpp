#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> parties(50, vector<int>());
int parent[51];
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
    for(int i = 0; i <= n; i++){
        parent[i] = i;
    }
    
    int num;
    cin >> num;
    for(int i = 0; i < num; i++){
        int p;
        cin >> p;
        parent[p] = 0;
    }
    for(int i = 0; i < m; i++){
        int len, base_p;
        cin >> len >> base_p;
        parties[i].push_back(base_p);
        for(int j = 1; j < len; j++){
            int p;
            cin >> p;
            parties[i].push_back(p);
            unite(base_p, p);
            base_p = p;
        }
    }
    int ans = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < parties[i].size(); j++){
            int p = parties[i][j];
            if(find_parent(p) == 0) break;
            if(j == parties[i].size()-1) ans++;
        }
    }
    cout << ans << "\n";
}