package processor;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        Matrix B = new Matrix();
        System.out.println();
        Matrix sum = A.add(B);
        if (Objects.nonNull(sum.matrix)){
            System.out.println(sum);
        }
        else{
            System.out.println("ERROR");
        }
    }
}
