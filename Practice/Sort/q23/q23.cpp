#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Student{
    public:
    string name;
    int korean;
    int english;
    int math;

    Student(string n, int k, int e, int m){
        this->name = n;
        this->korean = k;
        this->english = e;
        this->math = m;
    }
};

int n;
vector<Student> students;

string print_name(){
    string rt;
    for(int i = 0; i < n; i++){
        rt += students[i].name + "\n";
    }
    return rt;
}

int compare(Student s1, Student s2){
    if(s1.korean == s2.korean){
        if(s1.english == s2.english){
            if(s1.math == s2.math){
                return s1.name < s2.name;
            }else{
                return s1.math > s2.math;
            }
        }else{
            return s1.english < s2.english;
        }
    }else{
        return s1.korean > s2.korean;
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        string name;
        int k, e, m;
        cin >> name >> k >> e >> m;
        students.push_back(Student(name, k, e, m));
    }
    sort(students.begin(), students.end(), compare);
    cout << print_name();
}