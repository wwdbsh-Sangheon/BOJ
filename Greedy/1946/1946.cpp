#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int t, n;
vector<pair<int,int>> applicants;

int main(void){
    
    cin >> t;
    
    while(t-- > 0){
        cin >> n;
        for(int i = 0; i < n; i++){
            int a, b;
            cin >> a >> b;
            applicants.push_back(make_pair(a, b));
        }

        sort(applicants.begin(), applicants.end()); // 서류 순위로 오름차순 정렬

        int result = n;
        int inerview_rank = applicants[0].second; // 탈락자를 결정시킬 인터뷰 순위 변수

        for(int i = 1; i < n; i++){
            // 자신 보다 서류 순위가 높은 사람들 보다 인터뷰 순위가 낮다면 탈락 아니면 인터뷰 순위 변수 갱신
            applicants[i].second > inerview_rank ? result-- : inerview_rank = applicants[i].second;
        }
        printf("%d\n", result);
        applicants.clear();
    }
}