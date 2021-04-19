#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> a;
bool chk[10001];
int parent[10001];
int n, m, k;

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
    cin >> n >> m >> k;
    for(int i = 1; i <= n; i++){
        int money;
        cin >> money;
        a.push_back({money, i});
        parent[i] = i;
    }
    sort(a.begin(), a.end());
    for(int i = 0; i < m; i++){
        int v, w;
        cin >> v >> w;
        unite(v, w);
    }
    int tot_cost = 0;
    for(int i = 0; i < a.size(); i++){
        if(!chk[a[i][1]]){
            int min_cost = a[i][0];
            chk[a[i][1]] = true;
            for(int j = 0; j < a.size(); j++){
                if(!chk[a[j][1]] && (find_parent(a[i][1]) == find_parent(a[j][1]))){
                    min_cost = min(min_cost, a[j][0]);
                    chk[a[j][1]] = true;
                }
            }
            tot_cost += min_cost;
        }
    }
    tot_cost > k ? cout << "Oh no\n" : cout << tot_cost << "\n";
}