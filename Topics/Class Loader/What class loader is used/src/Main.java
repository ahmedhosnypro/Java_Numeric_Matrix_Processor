import java.util.Scanner;

class Main {
    public static void main(String... args) {
        ClassLoader classLoader = A.class.getClassLoader();
        System.out.println(classLoader.getName());
    }
}

class A {
}