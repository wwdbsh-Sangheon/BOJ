#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int t, n, m;
int indegree[501];
bool graph[501][501];

int main(void){
    cin >> t;
    while(t-- > 0){
        fill(indegree, indegree+501, 0);
        for(int i = 0; i < 501; i++){
            fill(graph[i], graph[i]+501, false);
        }
        cin >> n;
        vector<int> v;
        for(int i = 0; i < n; i++){
            int x;
            cin >> x;
            v.push_back(x);
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                graph[v[i]][v[j]] = true;
                indegree[v[j]] += 1;
            }
        }
        cin >> m;
        for(int i = 0; i < m; i++){
            int a, b;
            cin >> a >> b;
            if(graph[a][b]){
                graph[a][b] = false;
                graph[b][a] = true;
                indegree[a] += 1;
                indegree[b] -= 1;
            }else{
                graph[a][b] = true;
                graph[b][a] = false;
                indegree[a] -= 1;
                indegree[b] += 1;
            }
        }

        vector<int> result;
        queue<int> q;
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }
        
        bool certain = true;
        bool cycle = false;

        for(int i = 0; i < n; i++){
            if(q.size() == 0){
                cycle = true;
                break;
            }
            if(q.size() >= 2){
                certain = false;
                break;
            }
            int now = q.front();
            q.pop();
            result.push_back(now);
            for(int j = 1; j <= n; j++){
                if(graph[now][j]){
                    indegree[j] -= 1;
                    if(indegree[j] == 0){
                        q.push(j);
                    }
                }
            }
        }

        if(cycle){
            cout << "IMPOSSIBLE\n";
        }else if(!certain){
            cout << "?\n";
        }else{
            for(int i = 0; i < result.size(); i++){
                cout << result[i] << " ";
            }
            cout << "\n";
        }
    }
}