#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> graph[100001];
vector<vector<int>> ans;
bool chk[10001];
int n, m;

int compare(vector<int> a, vector<int> b){
    if(a[0] == b[0]){
        return a[1] < b[1];
    }else{
        return a[0] > b[0];
    }
}

void hack(int start, int computer){
    for(int i = 0; i < graph[computer].size(); i++){
        int c = graph[computer][i];
        if(!chk[c]){
            chk[c] = true;
            ans[start-1][0]++;
            hack(start, c);
        }
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[b].push_back(a);
    }
    for(int i = 1; i <= n; i++){
        chk[i] = true;
        ans.push_back({1, i});
        hack(i, i);
        fill(chk, chk+10001, false);
    }
    sort(ans.begin(), ans.end(), compare);
    for(int i = 0; i < n; i++){
        if(ans[0][0] == ans[i][0]){
            cout << ans[i][1] << " ";
        }else{
            break;
        }
    }
    cout << "\n";
}