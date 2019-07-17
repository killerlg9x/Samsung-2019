#include <bits/stdc++.h>
using namespace std;
long long a[100] = {0};

int main () {
	a[0] = 0;
	a[1] = 1;

	int t,n,k;
	cin >> t;
	while(t--) {
	cin >> n >> k;
	for(int i=2; i<=n; i++) {
		if(a[i]==0) {
			a[i] = a[i-2] + a[i-1];
		}
		if(a[i]>=k) {
		cout << a[i] << "\n";	
		break;
		}
	
	}
	}
}
