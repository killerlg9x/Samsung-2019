#include <bits/stdc++.h>
using namespace std;

int main () {
	int t,n,k;
	int S0 = 0;
	int S1 = 1;
	int tmp;
	cin >> t;
	while(t--) {
	cin >> n >> k;
	while(S1<k) {
		tmp = S0+S1;
		S0 = S1;
		S1 = tmp;
	}
	cout << S1<< "\n";
	}
}
