#include<iostream>
#include<deque>
#include<vector>

using namespace std;

vector<deque<int>> wheel(5, deque<int>(8));
int k;

void rotate(int w, int r,int dir){
    if(r == 1){
        if (w + 1 <= 4 && (dir==0 || dir==1)){
            if(wheel[w][2] != wheel[w + 1][6]){
                rotate(w + 1, -r,1);
            }
        }
        if(w - 1 >= 1 && (dir==0 || dir==2)){
            if(wheel[w][6] != wheel[w - 1][2]){
                rotate(w - 1, -r, 2);
            }
        }
        int tmp = wheel[w].back();
        wheel[w].pop_back();
        wheel[w].push_front(tmp);
    }
    
    if(r == -1){
        if (w + 1 <= 4 && (dir == 0 || dir == 1)){
            if (wheel[w][2] != wheel[w + 1][6]){
                rotate(w + 1, -r, 1);
            }
        }
        if(w - 1 >= 1 && (dir == 0 || dir == 2)){
            if(wheel[w][6] != wheel[w - 1][2]){
                rotate(w - 1, -r, 2);
            }
        }
        int tmp = wheel[w].front();
        wheel[w].pop_front();
        wheel[w].push_back(tmp);
    }
}

int main(void){
    for (int i = 1; i <= 4; i++){
        string tmp;
        cin >> tmp;
        for (int j = 0; j < 8; j++){
            wheel[i][j] = tmp[j] - '0';
        }
    }
    int a[101][2];
    cin >> k;
    for (int i = 0; i < k; i++){
        cin >> a[i][0] >> a[i][1];
    }
    for(int i = 0; i < k; i++){
        rotate(a[i][0], a[i][1], 0);
    }
    int sum = 0;
    for (int i = 1; i <= 4; i++){
        if(wheel[i][0] == 0){
            sum += 0;
        }else{
            sum += (1 << (i-1));
        }
    }
    cout << sum << "\n";
}
