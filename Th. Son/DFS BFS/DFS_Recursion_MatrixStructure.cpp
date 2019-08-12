#include <bits/stdc++.h>
using namespace std;
int n;
int a[100][100];

void DFS (int index, bool *visited) {
	visited[index] = 1;
	cout << index+1 << " ";
	for(int i=0; i<n; i++) {
		if(a[index][i] == 1 && visited[i] == 0) {
			DFS(i,visited);
		} 
	}
}

int main () {
	int m, i, j, t1, t2;
	cin >> n >> m;
	
	// input matrix
	for(i=0; i<n; i++)
	for (j=0; j<n; j++) a[i][j] = 0;
	for(i=0; i<m; i++) {
		cin >> t1 >> t2;
		a[t1-1][t2-1] = 1;
	}	// end input matrix
	
	bool *visited = new bool[n];
	for(int i=0; i<n; i++) visited[i] = 0;
	
	DFS(1-1,visited);
}
