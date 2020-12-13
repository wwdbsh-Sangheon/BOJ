#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

priority_queue<pair<int,int>> food;

bool compare(pair<int,int> a, pair<int,int> b){
    return a.second < b.second;
}

int solution(vector<int> food_times, long long k) {
    
    long long sum_time = 0;
    for(int i = 0; i < food_times.size(); i++){
        sum_time += food_times[i];
    }
    if(sum_time <= k) return -1;
    
    for(int i = 0; i < food_times.size(); i++){
        food.push({-food_times[i], i+1});
    }

    sum_time = 0;
    long long prev_time = 0;
    long long left_food = food_times.size();
    while(sum_time+((-food.top().first-prev_time)*left_food) <= k){
        int now = -food.top().first;
        sum_time += (now-prev_time)*left_food;
        prev_time = now;
        left_food--;
        food.pop();
    }
    
    vector<pair<int,int>> result;
    while(!food.empty()){
        int t = -food.top().first;
        int n = food.top().second;
        result.push_back({t, n});
        food.pop();
    }
    sort(result.begin(), result.end(), compare);
    return result[(k-sum_time) % left_food].second;
}

int main(void){
    printf("%d\n",solution({3, 1, 2}, 5));
}