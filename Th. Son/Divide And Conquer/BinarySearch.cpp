#include <iostream>
using namespace std;

int BS(int arr[], int l, int r, int x) {
	while (l<=r) {
		int m = (l+r)/2;
		if(arr[m] == x) return m+1;
		if(arr[m] > x) r = m-1;
		else l = m+1;
	}
	return -1;
}

int main () {
	int t;
	int *a;
	int n,k,i;
	cin >> t;	
	while (t--) {
		cin >> n >> k;
		a = new int[n];
		for (i=0; i<n; i++) {
			cin >> a[i];
		}
		int tmp;
		tmp = BS(a,0,n-1,k);
		if(tmp==-1) cout << "NO\n";
		else cout << tmp << "\n";
		delete(a);
	}
}
	
