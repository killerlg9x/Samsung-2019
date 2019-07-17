#include <stdio.h>
#include <stdlib.h>

int main () {
	int n;	// n points int Oxy
	int i;	// varible temp use to scan
	
	scanf("%d", &n);	// input number of point
	
	int *Ox = (int*)malloc(n*sizeof(int));
	int *Oy = (int*)malloc(n*sizeof(int));
	
	int max = 0;
	int tmp;
	int location = 0;

	for (i=0; i<n; i++) {
		tmp = 0;
		scanf("%d", &Ox[i]);
		scanf("%d", &Oy[i]);
		tmp = Ox[i]*Oy[i]*Ox[i]*Oy[i];
		if(tmp > max) {
			max = tmp;
			location = i;
		}
	}
	printf("%d",Ox[location]+Oy[location]);
		
	
}
