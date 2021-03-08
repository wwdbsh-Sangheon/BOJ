#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

vector<int> graph[501];
int indegree[501], time[501], result[501];
int n;

void topology_sort(){
    queue<int> q;
    for(int i = 1; i <= n; i++){
        result[i] = time[i];
        if(indegree[i] == 0){
            q.push(i);
        }
    }
    while(!q.empty()){
        int now = q.front(); q.pop();
        for(int i = 0; i < graph[now].size(); i++){
            int pre = graph[now][i];
            result[pre] = max(result[pre], result[now]+time[pre]);
            indegree[pre]--;
            if(indegree[pre] == 0){
                q.push(pre);
            }
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 1; i <= n; i++){
        int cost;
        cin >> cost;
        time[i] = cost;
        while(true){
            int pre;
            cin >> pre;
            if(pre == -1) break;
            graph[pre].push_back(i);
            indegree[i]++;
        }
    }
    topology_sort();
    for(int i = 1; i <= n; i++){
        cout << result[i] << "\n";
    }
}