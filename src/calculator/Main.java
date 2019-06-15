package calculator;
import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner plop = new Scanner(System.in);
        HashMap<String, Integer> popa =new HashMap<>();
        String owo[];
        String a1;
        String b1;
        char[]a1bis;
        char[] b1bis;
        int total;
        while (true){
            String lastop="+";
            String op=plop.nextLine();
            if (op.equals("")){
                continue;
            }
            else if (op.equals("/exit")){
                System.out.println("Bye!");
                break;
            }
            else if (op.contains("=")) {
                if (op.split("=").length>2) {
                    System.out.println("Invalid assignment");
                    continue;
                }
                Boolean astop=false;
                owo=op.split("=");
                a1=owo[0].trim();//add trim
                b1 = owo[1].trim();
                a1bis=a1.toCharArray();
                b1bis=b1.toCharArray();
                for (int i = 0; i < a1bis.length; i++) {
                    if (!(((int)a1bis[i]>= 65 && (int)a1bis[i]<=90) ||((int)a1bis[i]>= 97 && (int)a1bis[i]<=122))){
                        System.out.println("Invalid identifier");astop=true;break;}
                }
                if (astop) {
                    astop=false;
                    continue;
                }
                Boolean itsnum=false;
                Boolean itsalpha=false;
                for (int i = 0; i < b1bis.length; i++) {
                    if ((int)b1bis[i]>= 48 && (int)b1bis[i]<=57){
                        itsnum=true;}
                    if (((int)b1bis[i]>= 65 && (int)b1bis[i]<=90) ||((int)b1bis[i]>= 97 && (int)b1bis[i]<=122)){
                        itsalpha=true;}

                    if (itsnum && itsalpha){
                        System.out.println("Invalid assignment");
                        astop=true;
                        break;
                    }
                }
                if (astop) {
                    astop=false;
                    continue;
                }

                if (popa.containsKey(b1)){popa.put(a1,popa.get(b1));}
                else{
                    try {popa.put(a1,Integer.parseInt(b1));}catch (Exception e){
                        System.out.println("Unknown variable");
                    }
                }
            }
            else if (op.contains(" ")){
                total=0;
                String a[]=op.split(" ");
                int incr=0;
                for (String aa:a) {
                    incr+=1;
                    if (popa.containsKey(aa)){
                        aa=popa.get(aa).toString();
                    }
                    if (aa.equals(" ") || aa.equals("")){continue;}
                    else if (aa.contains("+")){lastop="+";continue;}
                    else if (aa.contains("-")){lastop="-";continue;}
                    else if (incr==1){total=Integer.parseInt(aa);continue;}
                    if (lastop.equals("+")){total += Integer.parseInt(aa);}
                    else if (lastop.equals("-")){total -= Integer.parseInt(aa);}
                    lastop="+";
                }
                System.out.println(String.valueOf(total));
            }else{
                if (popa.containsKey(op)){
                    System.out.println(popa.get(op).toString());
                }
                else{
                    System.out.println("Unknown variable");
                }
            }
        }
    }
}
