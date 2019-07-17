#include<iostream>
using namespace std;
long long N = 1e9+7;
int n, k;

long long LT (int n, int k) {
		if(k==0) return 1;
		long long tmp = LT(n,k/2);
		if(k%2!=0) return (tmp*tmp%N)*n%N;
	return tmp*tmp%N;
}

int main () {
	int t;
	cin >> t;
	while(t--) {
	
	cin >> n >> k;
	cout << LT(n,k) << "\n";
}
}
