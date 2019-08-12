#include <bits/stdc++.h>
using namespace std;

int main () {
	int i, n, m, tmp1, tmp2, j;
	cin >> n >> m;
	//bool v[n] = {0};
	int matrix[n][n];
	queue<int> q;
	
	for (i=0; i<n; i++) {
		for (j=0; j<n; j++) matrix[i][j] = 0;
	}	// init matrix with value 0
	
	for (i=0; i<m; i++) {
		cin >> tmp1 >> tmp2;
		matrix[tmp1-1][tmp2-1] = 1;
	} 	// input Graph
	//cout << "\n";
	// 1 co di den 5 hay khong ?
	
	int t;
	bool check = 0;
	cin >> t;
	while (t--) {
	check = 0;
	cin >> tmp1 >> tmp2;
	
	// init queue
	q.push(tmp1-1);
	bool v[n] = {0};
	v[tmp1-1] = 1;
	
	// processing
	while(!q.empty()) {
		tmp1 = q.front();
		
	//	cout << "\n" << tmp1+1 << "\t" << tmp2 << "\n";
		if(tmp1+1 == tmp2) {
			cout << "YES\n";
			check = 1;
			break;
		}
		
		q.pop();
		for(i=0; i<n; i++) {
			if(matrix[tmp1][i] == 1 && v[i] == 0) {
				q.push(i);
				v[i] = 1;
			}
		}
	}
	if(check == 0) cout << "NO\n";
	//cout << "\n\n";	
	}
	/* for (i=0; i<n; i++) {
		for (j=0; j<n; j++) cout << matrix[i][j] << " ";
		cout << "\n";
	}	// print matrix
	*/
	
	
}
