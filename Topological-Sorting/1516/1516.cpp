#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

vector<int> graph[501];
int time[501];
int result[501];
int indegree[501];
int n;

void topological_sort(){
    queue<int> q;
    for(int i = 1; i <= n; i++){
        if(!indegree[i]){
            q.push(i);
        }
    }
    while(!q.empty()){
        int now = q.front(); q.pop();
        for(int i = 0; i < graph[now].size(); i++){
            result[graph[now][i]] = max(result[graph[now][i]], result[now]+time[graph[now][i]]);
            indegree[graph[now][i]]--;
            if(!indegree[graph[now][i]]){
                q.push(graph[now][i]);
            }
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 1; i <= n; i++){
        int t, b;
        cin >> t;
        time[i] = t;
        result[i] = t;
        while(true){
            cin >> b;
            if(b == -1) break;
            graph[b].push_back(i);
            indegree[i]++;
        }
    }
    topological_sort();
    for(int i = 1; i <= n; i++){
        cout << result[i] << "\n";
    }
}