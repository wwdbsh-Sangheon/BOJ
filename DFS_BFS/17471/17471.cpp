#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> graph[11];
vector<int> pp;
bool visited[11];
int population[11];
int parent[11];
int n, tot, b_sum, ans = 1e9;

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

void get_b(int start, int sum){
    b_sum = max(b_sum, sum);
    for(int i = 0; i < graph[start].size(); i++){
        int adj = graph[start][i];
        if(!visited[adj]){
            visited[adj] = true;
            get_b(adj, sum+population[adj]);
            visited[adj] = false;
        }
    }
}

void dfs(int start, int sum, int cnt){
    if(cnt == n){
        return;
    }
    for(int i = 1; i <= n; i++){
        if(!visited[i]){
            visited[i] = true;
            get_b(i, population[i]);
            visited[i] = false;
            if(sum+b_sum == tot){   
                ans = min(ans, abs(sum-(b_sum)));
                b_sum = 0;
            }
        }
    }
    for(int i = 0; i < graph[start].size(); i++){
        int adj = graph[start][i];
        if(!visited[adj]){
            visited[adj] = true;
            dfs(adj, sum+population[adj], cnt+1);
            visited[adj] = false;
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 1; i <= n; i++){
        parent[i] = i;
        cin >> population[i];
        tot += population[i];
    }
    for(int i = 1; i <= n; i++){
        int m;
        cin >> m;
        for(int j = 0; j < m; j++){
            int adj;
            cin >> adj;
            graph[i].push_back(adj);
            unite(i, adj);
        }
    }
    for(int i = 1; i <= n; i++){
        int p = parent[i];
        if(find(pp.begin(), pp.end(), p) == pp.end()){
            pp.push_back(p);
        }
    }
    if(pp.size() > 2){
        cout << "-1\n";
    }else if(pp.size() == 2){
        int p = pp[0];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(parent[i] == p){
                sum += population[i];
            }
        }
        cout << abs(sum-(tot-sum)) << "\n";
    }else{
        visited[1] = true;
        dfs(1, population[1], 1);
        cout << ans << "\n";
    }
}