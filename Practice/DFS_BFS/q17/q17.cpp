#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<queue<pair<int,int>>> virus(10001);
vector<pair<int,int>> temp;
int board[201][201];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n, k, s, x, y;

int main(void){
    cin >> n >> k;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            int v;
            cin >> v;
            board[i][j] = v;
            if(v != 0){
                virus[v].push(make_pair(i, j));
            }
        }
    }
    cin >> s >> x >> y;

    int time = 0;
    
    while(time < s){
        for(int i = 1; i <= k; i++){
            while(!virus[i].empty()){
                int a = virus[i].front().first;
                int b = virus[i].front().second;
                virus[i].pop();
                for(int index = 0; index < 4; index++){
                    int nx = a + dx[index];
                    int ny = b + dy[index];
                    if(nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[nx][ny] == 0){
                        board[nx][ny] = i;
                        temp.push_back(make_pair(nx, ny));
                    }
                }
            }
            for(int j = 0; j < temp.size(); j++){
                virus[i].push(temp[j]);
            }
            temp.clear();
        }
        time++;
    }
    cout << board[x][y] << "\n";
}