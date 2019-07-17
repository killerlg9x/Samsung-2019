
/***********************************************
 * Equation: (a+b)*c+a*(b+c)
 * Polish Form: a b + c * a b c + * + 
 * Result: (0+1)*2+0(1+2) = 2
 * Solve the equation with a = 0, b = 1, c = 2,...
 * @author: ptavt05
 * @version: 9/7/2019 Samsunglab
 ***********************************************/


class Expression {
    
    String polish = "";  // = "a b + c * a b c + * +";
    
    Expression(String ex) {
            compiler(ex);
            execution();
       }

    void compiler(String ex) {
            polish = "";
            char [] st = new char[ex.length()];
            st[0] = '@';
            int ctrl = 0;
            int i;
            char c;
            for(i=0; i<ex.length(); i++) {
                c = ex.charAt(i);
                if((c>='a'&&c<='z')) {
                    polish += c;
                    continue;
                }
                
                if(c=='(') {
                    st[++ctrl] = c;
                    continue;
                }
                
                if(c == ')') {
                    while ( st[ctrl] != '(') {
                        if(ctrl<2) {
                            System.out.println("SYNTAX ERROR");
                            System.exit(0);
                        }
                        polish += st[ctrl];
                        ctrl--;
                    }
                    ctrl--;
                    continue;
                }   
                
                if(isOperator(c)) {
                    while(degree(st[ctrl])<=degree(c)) {
                        polish += st[ctrl];
                        ctrl--;
                    }
                    st[++ctrl] += c;
                    continue;
                }
            }   // for scan ex
            
            while (ctrl>0) {
                polish+=st[ctrl];
                ctrl--;
            }
            System.out.println(polish);
    } // compiler
    
    void execution()
    {
        int [] st = new int [polish.length()];
        int ctrl = -1;
        int i;
        char c;
        for (i=0;i<polish.length(); i++) {
            c = polish.charAt(i);
            if(c>='a'&&c<='z') {
                st[++ctrl] = c-'a';
                continue;
            }
            
            
            switch(c) 
            {
                    case '+':
                        if(ctrl>0)
                        {   
                            st[ctrl-1] += st[ctrl];
                            ctrl--;
                            break;
                        }
                        else {
                            System.out.println("SYSTAX ERROR");
                            System.exit(1);
                        }
                        
                    case '-':
                        if(ctrl>0)
                        {   
                            st[ctrl-1] -= st[ctrl];
                            ctrl--;
                            break;
                        }
                        else {
                            System.out.println("SYSTAX ERROR");
                            System.exit(1);
                        }
                    case '*':
                        if(ctrl>0)
                        {   
                            st[ctrl-1] *= st[ctrl];
                            ctrl--;
                            break;
                        }
                        else {
                            System.out.println("SYSTAX ERROR");
                            System.exit(1);
                        }
                    
                    case '/':
                        if(ctrl>0)
                        {
                             if(st[ctrl]== 0) {
                                  System.out.println("DIVIDE BY 0");
                                  System.exit(0);
                             }
                             st[ctrl-1] /= st[ctrl];
                             ctrl--;
                             break;
                        }
                        else {
                            System.out.println("SYSTAX ERROR");
                            System.exit(1);
                        }  
                               
                    case '%':
                        if(ctrl>0)
                        {
                             if(st[ctrl]== 0) {
                                  System.out.println("DIVIDE BY 0");
                                  System.exit(0);
                             }
                             st[ctrl-1] %= st[ctrl];
                             ctrl--;
                             break;
                        }
                        else {
                            System.out.println("SYSTAX ERROR");
                            System.exit(1);
                        }
                    
                    case '!':
                        for(i=2;i<=st[ctrl-1];i++)
                        st[ctrl]*=i;
                        break;
                    
                    case '>':
                        st[ctrl]++;
                        break;
                    
                    case '<':
                        st[ctrl]--;
                        break;
            }   // switch(c)
        }   // for polish
        System.out.println(st[0]);
    }   // execution
    
    boolean isOperator(char c) { 
        String Op = "+-*/%!><";
        int i;
        char ch;
        for (i=0; i<Op.length(); i++) {
            ch = Op.charAt(i);
            if(c ==  ch) return true;
        }
        return false;
    }   // isOperator
    
    int degree(char c) {
        switch(c) {
            case '!': return 10;
            case '>': return 10;
            case '<': return 10;
            case '*': return 20;
            case '/': return 20;
            case '%': return 20;
            case '+': return 30;
            case '-': return 30;
            default: return 100;
        }
    }   // degree
}   // class Expression

public class Test {
public static void main (String [] args) {
    Expression a = new Expression("(a+b)*c+a*(b+c)");
}   // main funtion
}   // class Test