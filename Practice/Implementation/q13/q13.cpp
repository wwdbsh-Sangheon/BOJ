#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m, min_dist = 1e9;
vector<vector<int>> homes;
vector<vector<int>> stores;

int get_dist(vector<int> h, vector<int> s){
    return abs(h[0] - s[0]) + abs(h[1] - s[1]);
}

int get_chicken_dist(){
    int tot_dist = 0;
    for(int i = 0; i < homes.size(); i++){
        int dist = 1e9;
        for(int j = 0; j < stores.size(); j++){
            if(stores[j][2] == 0){
                dist = min(dist, get_dist(homes[i], stores[j]));
            }
        }
        tot_dist += dist;
    }
    return tot_dist;
}

void close_store(int idx, int count){
    if(count == stores.size()-m){
        min_dist = min(min_dist, get_chicken_dist());
        return;
    }
    for(int i = idx; i < stores.size(); i++){
        stores[i][2] = 1;
        close_store(i+1, count+1);
        stores[i][2] = 0;
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int e;
            cin >> e;
            if(e == 1){
                homes.push_back({i, j});
            }else if(e == 2){
                stores.push_back({i, j, 0});
            }
        }
    }
    close_store(0, 0);
    cout << min_dist << "\n";
}