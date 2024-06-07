package ex12inheritance;

public class E08VariableArgument {
    static int getTotal (int param) {
        int total = 0;
        total += param;
        return total;
    }
    static int getTotal(int param1, int param2) {
        int total = 0;
        total += (param1 + param2);
        return total;
    }
    static int getTotal(int param1, int param2, int param3) {
        int total = 0;
        total += (param1 + param2 + param3);
        return total;
    }
//    static int getTotal(int ... param) {
//        int total = 0;
//        for(int i = 0; i < param.length; i++) {
//            total += param[i];
//        }
//        return total;
//    }
public static void main(String[] args) {
    System.out.println("getTotal(args1) call" + getTotal(10));
    System.out.println("getTotal(args1,args2) call" + getTotal(10,20));
    System.out.println("getTotal(args1,args2,args3) call" + getTotal(10,20,30));
//    System.out.println("getTotal(param6개) call" + getTotal(10,20,30,40,50,60));
//    System.out.println("getTotal(args1, args2) call" + getTotal(10,20.3));
    }
}
