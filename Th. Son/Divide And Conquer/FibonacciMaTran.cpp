#include <iostream>
using namespace std;
const long long N = 1e9+7;
 
struct MaTran
{
    long long c[2][2];
    MaTran()
    {
        c[0][0]=0;
        c[0][1]=1;
        c[1][0]=1;
        c[1][1]=1;
    }
};
 
MaTran operator * (MaTran a, MaTran b)
{
    MaTran res;
    for (int i=0; i<=1; i++)
        for (int j=0; j<=1; j++)
        {
            res.c[i][j] = 0;
            for (int k=0; k<=1; k++)
                res.c[i][j] = (res.c[i][j]+a.c[i][k]*b.c[k][j])%N;
        }
    return res;
}
 
MaTran powermod (MaTran a, long long n)
{
    if (n==1)
        return a;
    MaTran tmp = powermod(a,n/2);
    if (n%2!=0) return tmp*tmp*a;
    return tmp*tmp;
}
 
int main()
{
	int t;
	cin >> t;
		while (t--) {
	    long long n;
	    cin >> n;
	    MaTran A;
	    A = powermod(A,n);
	    cout << A.c[0][1] << "\n";
    }
	return 0;
}
