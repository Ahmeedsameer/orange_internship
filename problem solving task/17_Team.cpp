#include <iostream>
using namespace std;
int main() {
   int n,s = 0;;
    
   cin>>n;
   
   
   
   for(int i = 0;i<n;i++){
       short temp = 0;
       for(int j = 0;j<3;j++){
           short x ;
           cin>>x;
           if(x)
           temp++;
           
       }
       if(temp > 1)
       s++;
   }
    
    cout<<s;
   
  
   
    

    return 0;
}