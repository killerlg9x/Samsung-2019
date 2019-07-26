public class Test {
    
    //  main
    public static void main (String [] args) {
        Expression e = new Expression("((x+m*b!) + (a-(b*c/d)!)) - ((x+m*b!) + (a-(b*c/d)!))");
    }   // main


} // class Test

// Two phases: ( Xu li bieu thuc so hoc) - compier   - execution
class Expression {
    
    String polish = "";
    
    // Constructor
    Expression (String ex) {
        // Phase 1: 
        compiler(ex);
        //Phase 2:
        execution();
    }    // Constructor
    
    // phuong thuc
    
    // Phase 1: compiler ex -> polish
    // " a+ b * c" -> a b c * +
    void compiler (String ex) {
        char [] st = new char[ex.length()];     // stack chua phep toan
        int ist = 0;   // index of stack
        st[ist] = '@';    // 1 mieng dem trong bieu thuc
        char c;
        polish = "";
        for (int i=0; i<ex.length();i++) {
            c = ex.charAt(i);
            if (c>= 'a' && c <= 'z') {
                polish += c;
                continue;
            }
            if (c == '(') {
                st[++ist] = c;
                continue;
            }
            if (c == ')') {
                while (st[ist] != '(') {
                    if(ist<2) {
                        System.out.println("ERROR: thua )");
                        System.exit(3);
                    }
                    polish += st[ist];
                    ist--;
                }
                ist--;
                continue;
            }
            if (isOperator(c)) {
                //  Lay ra cac stack uu tien hon hoac bang c dua vao polish
                // sau do nap c
                while (degree(st[ist]) <= degree(c)) {
                    polish += st[ist];
                    ist--;
                }
                st[++ist] = c;
                continue;
            }
            
            
        }
        
        
        while (ist > 0) {
                polish += st[ist];
                ist--;
            }
            
        if (ist != 0) {
        System.out.println("SYNTAX ERROR");
        }
        
            
            System.out.println("input: " + ex);
            System.out.println("output: " + polish);
    }   // Phase 1
    
    
    // Phase 2: execution polish -> value
    // a + b * c = 0 + 1 * 2 = 2
    void execution(){ 
        int [] st = new int[polish.length()];
        int ist = -1;
        char c;
        for (int i=0; i<polish.length(); i++) {
            c = polish.charAt(i);
            if (c >= 'a' && c<= 'z') st[++ist] = c - 'a';
            else {
                switch(c) {
                case '+' : st[ist-1] += st[ist];
                ist--;
                break;
                case '-' : st[ist-1] -= st[ist];
                ist--;
                break;
                case '*' : st[ist-1] *= st[ist];
                ist--;
                break;
                case '/' : if (st[ist] == 0) {
                    System.out.println("ERROR: Devide by zero");
                    System.exit(0);
                }
                st[ist-1] /= st[ist];
                ist--;
                break;
                case '!' : 
                if (st[ist] <= 0) {
                    st[ist] = 1;
                    break;
                }
                //tmp = st[ist];
                for (int val=2; val< st[ist]; val++) {
                    st[ist] *= val;
                }
                //st[ist] = tmp;
                break;
                case '%' :  if (st[ist] == 0) {
                    System.out.println("ERROR: Devide by zero");
                    System.exit(0);
                }
                st[ist-1] %= st[ist];
                ist--;
                break;
                case '>' : st[ist]++;
                break;
                case '<' : st[ist]--;
                break;
                }
            }
        }
        System.out.println("RESULT: " + st[0]);
    } // Phase 2
    
    boolean isOperator(char op) {
        String OP = "+-*/%><!";
        for (int i=0; i<OP.length(); i++) if (OP.charAt(i) == op) return true;
        return false;
    }
    
    
    int degree (char op) {      // do uu tien cac phep toan: enum in C++
        switch(op) {
            case '!': return 100;
            case '>': return 100;
            case '<': return 100;
            case '*': return 200;
            case '/': return 200;
            case '%': return 200;
            case '+': return 300;
            case '-': return 300;
        default: return 1000;
        }
    }
    
}   // class Expression 
