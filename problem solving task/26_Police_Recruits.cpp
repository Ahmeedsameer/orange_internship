#include <iostream>
#include<cmath>
#include <cstdlib> 
using namespace std;
int main() {
    int n,off = 0,temp,c=0;
    
    cin>>n;
    
   
    
    for(int i = 0;i<n;i++){
        cin>>temp;
         
        if(temp > 0){
            off+=temp;
           
        }else{
          
            if(off+temp >= 0){
               
                
                off+= temp;
               
            }else{
               
                c+= abs(off+temp);
                off = 0;
               
            }
        }
        
    }
    
   
    
    
    
   
    
    
    std::cout << c << std::endl;
    
    
    
    

    return 0;
}