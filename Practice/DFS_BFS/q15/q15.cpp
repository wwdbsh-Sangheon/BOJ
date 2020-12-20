#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

vector<int> ans;
vector<int> cities[300001];
bool chk[300001];
int n, m, k, x;

void bfs(int x){
    chk[x] = true;
    queue<pair<int,int>> q;
    q.push(make_pair(x, 0));
    while(!q.empty()){
        vector<int> city = cities[q.front().first];
        int dist = q.front().second;
        if(dist == k) ans.push_back(q.front().first);
        q.pop();
        for(int i = 0; i < city.size(); i++){
            int to = city[i];
            if(!chk[to]){
                chk[to] = true;
                q.push(make_pair(to, dist+1));
            }
        }
    }
}

int main(void){
    cin >> n >> m >> k >> x;
    for(int i = 0; i < m; i++){
        int a;
        int b;
        cin >> a >> b;
        cities[a].push_back(b);
    }

    bfs(x);

    if(ans.size() != 0){
        sort(ans.begin(), ans.end());
        for(int i = 0; i < ans.size(); i++){
            cout << ans[i] << "\n";
        }
    }else{
        cout << -1 << "\n";
    }
}