#include <iostream>
using namespace std;
int main() {

    short n,h;
    int total = 0;
    
    cin >>n>>h;
    
    int arr[n];
    for(int i = 0;i<n;i++)
        cin>>arr[i];
        
    for(int i = 0;i<n;i++)
        {
            total+= (arr[i] > h)?2 :1; 
        }
        
    cout<<total;
    

    return 0;
}