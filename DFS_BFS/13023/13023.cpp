#include <iostream>
#include <vector>

using namespace std;

vector<int> rel[2000];
bool chk[2000];
int n, m;

void dfs(int p, int count){
    chk[p] = true;
    if(count == 4){
        cout << "1\n";
        exit(0);
    }
    for(int i = 0; i < rel[p].size(); i++){
        if(!chk[rel[p][i]]){
            dfs(rel[p][i], count+1);
        }
    }
    chk[p] = false;
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        rel[a].push_back(b);
        rel[b].push_back(a);
    }
    for(int i = 0; i < n; i++){
        dfs(i, 0);
    }
    cout << "0\n";
}