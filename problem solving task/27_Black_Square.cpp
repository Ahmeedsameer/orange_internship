#include <iostream>
#include<cmath>
#include <cstdlib> 
using namespace std;
int main() {
    string str;
    int arr[4];
    int temp, cal = 0;
    
    for(int i =0;i<4;i++)
        cin>>arr[i];
    
    cin>>str;
    
    for(int i = 0; i<str.size();i++){
        temp =str[i] - '0';
        cal+=arr[temp-1];
    }
    
    
    cout<<cal;
   
    
    

    return 0;
}