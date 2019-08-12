#include <iostream>
#include <fstream>
using namespace std;

/*	So TPLT	*/

const int MN = 100;

typedef struct Edge {

	int x;
	int y;
	int type;
};

const int NOR = 0;
const int SPAN = 1;
const int BRIDGE = 2;

Edge e[MN+1];

	int n;	//	So diem
	int m;	//	So canh : diem - diem

void Read () {
	ifstream fn;
	fn.open("tplt.txt");
	fn >> n;
	int i = 1;
	while (true) {
		fn >> e[i].x >> e[i].y;
		if(e[i].x == 0 && e[i].y == 0)
		break;	
		e[i].type = NOR;
	//	cout << "\n " << e[i].x << "\t|\t" << e[i].y;
		i++;
		m++;
	}
	cout << "\n Reading...";
	cout << "\n Total " << n << " point(s) " << m << " edge(s) ";
	fn.close();
}

int d[MN];

void Init() {
	int i = 1;
	while (i<=n) {
		d[i] = i;
		i++;
	}
}

int Find (int x) {
	while (d[x] != x) {
		x = d[x];
	}
	return d[x];
}

int Union (int x, int y) {
	
	
	if (Find(x) == Find(y))
	return 0;
	if (Find(x) < Find(y))
	d[y] = x;
	else
	d[x] = y;
	return 1;
}

int SoTPLT (int k = 0) {
		Init();
	int TPLT = n;
	int i;
	for (i = 1; i < k; ++i)
		TPLT -= Union(e[i].x, e[i].y);
	for (i = k+1; i <= m; ++i)
		TPLT -= Union(e[i].x, e[i].y);
	//	cout << "\n So TPLT: " << TPLT; 
	return TPLT;
}

int Connect () {
	int c = SoTPLT();
	if (c > 1) {
		int i = 2;
		while (i<=m) {
		if (d[i] == i)
			cout << "\n Can noi them: * 1 - " << i;
		i++;
		}
	}
	else
		cout << "\n Khong can noi them. ";
	return c-1;
} 

int SpanTree () {
	Init();
	int i = 1;
	int c = 0;
	while (i<=m) {
		 if (Union(e[i].x, e[i].y) == 1)
		 {
			 e[i].type = SPAN;
			c++;
		 }
		 i++;
	 }
	 cout << "\n Total " << c << " Span Edge(s)";
	 i = 1;
	 while (i<=m) {
		 if (e[i].type == SPAN)
		 {
			 	cout << "\n * " << e[i].x << "\t|\t" << e[i].y;
		 }
		 i++;
	 }
	 return c; 
}
	
int ImBridges () {
	int i = 1;
	int count = 0;
	SpanTree();
		while (i<=m) {
				if (e[i].type == SPAN)
				//	cout << "\n " << e[i].x << " | " << e[i].y << " : " << SoTPLT(i);
				if(SoTPLT(i) > 1) {
				e[i].type = BRIDGE;
				count++;
				}
		i++;
	}
	cout << "\n Total " << count << " Important bridge(s) ";
	i = 1;
	while (i<=m)
	{
		if (e[i].type == BRIDGE)
		cout << "\n " << e[i].x << "\t|\t" << e[i].y;
		i++;
	}
	return count;
}	

int main () {
	Read();
	//	SoTPLT();
		Connect();
	//	SpanTree();
		ImBridges();
}
