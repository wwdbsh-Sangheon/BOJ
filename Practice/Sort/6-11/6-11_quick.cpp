#include <iostream>
#include <vector>

using namespace std;

int n;
vector<pair<string,int>> s;

void print_s(){
    for(int i = 0; i < s.size(); i++){
        cout << s[i].first << " ";
    }
    cout << "\n";
}

void quick_sort(int start, int end){
    if(start >= end) return;
    int pivot = start;
    int left = start+1;
    int right = end;
    while(left <= right){
        while(left <= end && s[left].second <= s[pivot].second) left++;
        while(right > start && s[right].second >= s[pivot].second) right++;
        if(left > right){
            swap(s[right], s[pivot]);
        }else{
            swap(s[right], s[left]);
        }
    }
    quick_sort(start, right-1);
    quick_sort(right+1, end);
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        string name;
        int score;
        cin >> name >> score;
        s.push_back(make_pair(name, score));
    }
    quick_sort(0, n-1);
    print_s();
}