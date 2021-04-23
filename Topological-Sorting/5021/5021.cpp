#include <iostream>
#include <algorithm>
#include <queue>
#include <iterator>
#include <map>
#include <vector>

using namespace std;

map<string, map<string, double>> result;
map<string, vector<string>> graph;
map<string, double> blood;
map<string, int> indegree;
int n, m;

void topology_sort(string king){
    queue<pair<string,double>> q;
    q.push({king, blood[king]});
    while(!q.empty()){
        string parent = q.front().first;
        double c = q.front().second; q.pop();
        for(int i = 0; i < graph[parent].size(); i++){
            string partner = graph[parent][0];
            string child = graph[parent][1];
            if(blood[partner] == 0 && blood[parent] == 0){
                blood[child] = 0;
            }else if(blood[partner] != 0 && blood[parent] != 0){
                blood[child] = c;
            }else{
                blood[child] = c/2;
            }
            result[partner][child] = blood[child];
            indegree[child] -= 2;
            if(indegree[child] == 0){
                q.push({child, blood[child]});
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    string king;
    cin >> king;
    blood[king] = 1.0;
    for(int i = 0; i < n; i++){
        string child, mother, father;
        cin >> child >> mother >> father;
        if(mother == king){
            blood[father] = 0.0;
        }else if(father == king){
            blood[mother] = 0.0;
        }else{
            blood[father] = 0.0;
            blood[mother] = 0.0;
        }
        graph[mother] = {father, child};
        graph[father] = {mother, child};
        indegree[child] += 2;
        if(indegree.find(child) == indegree.end()){
            indegree[child] = 0;
        }
    }
    topology_sort(king);
    string future_king = "";
    double degree = 0.0;
    for(int i = 0; i < m; i++){
        string candidate;
        cin >> candidate;
        if(degree < result[king][candidate]){
            degree = result[king][candidate];
            future_king = candidate;
        }
    }
    cout << future_king << "\n";
}