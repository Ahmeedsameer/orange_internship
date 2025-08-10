// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;
int main() {
    // Write C++ code here
   short n,diff;
   cin>>n; 
   short arr[n];
   
   
   
   for(int i = 0;i<n;i++){
     cin>>arr[i];
   }
   
  for(int i = n-1;i>=0;i--){
      for(int j = i-1; j>=0;j--){
         
          if(arr[j] > arr[i]){
          
            diff = arr[j]-arr[i];
            arr[i]+= diff;
            arr[j]-= diff;
          
            cout<<endl;
          }
      }
  }
  
   for(int i = 0;i<n;i++){
     cout<<arr[i]<<" ";
   }
    

    return 0;
}