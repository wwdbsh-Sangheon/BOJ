#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<int> graph[32001];
int indegree[32001];
int n, m;

void topological_sort(){
    priority_queue<int> pq;
    for(int i = 1; i <= n; i++){
        if(indegree[i] == 0){
            pq.push(-i);
        }
    }
    while(!pq.empty()){
        int now = -pq.top(); pq.pop();
        cout << now << " ";
        for(int i = 0; i < graph[now].size(); i++){
            indegree[graph[now][i]]--;
            if(!indegree[graph[now][i]]){
                pq.push(-graph[now][i]);
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        indegree[b]++;
    }
    topological_sort();
}