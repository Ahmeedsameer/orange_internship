#include <iostream>
using namespace std;
int main() {
    short n,last = 0,steps = 0;
    
    cin>>n;
    
    char str[n];
    
    for(int i = 0;i<n;i++)
        cin>>str[i];
    
    
    
    
    for(int i = 1;i<n;i++){
        if(str[last] == str[i]){
            
            steps++;
        }else{
            last = i;
        }
    }
    
    
    std::cout << steps << std::endl;
    
    
    
    

    return 0;
}