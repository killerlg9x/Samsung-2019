
/***********************************************
 * Equation: (a+b)*c+a*(b+c) 
 * Solve the equation with a = 0, b = 1, c = 2,...
 * @author: tuananh
 * @version: 9/7/2019 Samsunglab
 ***********************************************/
 
 class Expression {
     
     String ex = "a b + c * a b c + * + ";
     int [] stk = new int [500];    // stack
     int ctrl = -1;                 // controller
     
        // Constructor method
     Expression (String ex) {
        compiler(ex);
        execution();
        }   // Constructor
     
        // Compiler method
     void compiler (String ex) {
        }   // Compiler
        
        // Execution method
     void execution () {
         char ch;
         int i;
     for (i=0; i<ex.length();i++) {
            ch = ex.charAt(i);
            if (ch>= 'a' && ch <= 'z') {
                ctrl++;
                stk[ctrl] = ch - 'a';
            } else {
                switch(ch) {
                    case '+' :
                    stk[ctrl-1] += stk[ctrl];
                    ctrl--;
                    break;
                    
                    case '-' :
                    stk[ctrl-1] -= stk[ctrl];
                    ctrl--;
                    break;
                    
                    case '*' :
                    stk[ctrl-1] *= stk[ctrl];
                    ctrl--;
                    break;
                    
                    case '/' :
                    stk[ctrl-1] /= stk[ctrl];
                    ctrl--;
                    break;
                }
            }
        }   // for
        System.out.println("\n RESULT: " + stk[0]);
     }  // Execution
}
public class Test
{
    public static void main (String [] args) {
        Expression ex = new Expression("test");
        // Constructor is not setup, data is String in Expression
    }   // main
}
