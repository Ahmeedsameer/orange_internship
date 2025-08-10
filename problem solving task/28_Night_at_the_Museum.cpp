// Online C++ compiler to run C++ program online
#include <iostream>
#include<cmath>
#include <cstdlib> 
using namespace std;
int main() {
    string str;
    int r = 0,cl,untic;
    
    cin>>str;
    cl = abs(str[0] - 'a');
    untic = 26 - cl;
    r+= min(cl,untic);
    for(int i = 0;i<str.size()-1;i++)
    {
        cl = abs(str[i+1] - str[i]);
        untic = 26 - cl;
        r+= min(cl,untic);
    }
    
    cout<<r;

    return 0;
}