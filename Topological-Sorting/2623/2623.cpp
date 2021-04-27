#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

vector<int> ans;
vector<int> graph[1001];
int indegree[1001];
int n, m;

void topological_sort(){
    queue<int> q;
    for(int i = 1; i <= n; i++){
        if(!indegree[i]){
            q.push(i);
        }
    }
    while(!q.empty()){
        int now = q.front(); q.pop();
        ans.push_back(now);
        for(int i = 0; i < graph[now].size(); i++){
            indegree[graph[now][i]]--;
            if(!indegree[graph[now][i]]){
                q.push(graph[now][i]);
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int num, pre_singer, singer;
        cin >> num;
        if(num == 0) continue;
        cin >> pre_singer;
        for(int j = 1; j < num; j++){
            cin >> singer;
            graph[pre_singer].push_back(singer);
            indegree[singer]++;
            pre_singer = singer;
        }
    }
    topological_sort();
    for(int i = 1; i <= n; i++){
        if(indegree[i] != 0){
            cout << "0\n";
            return 0;
        }
    }
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << "\n";
    }
}