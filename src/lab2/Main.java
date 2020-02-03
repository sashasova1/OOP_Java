package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int Division(int a, int b) {
        int div = 0;
        try {
            if (b == 0) throw new ArithmeticException("Error, division by zero!");
            div = a / b;
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        return div;
    }

    public static int DivisionThrows(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Error, division by zero! using throws");
        int div = 0;
        div = a / b;
        return div;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a = ");
        int a = in.nextInt();
        System.out.print("Enter b = ");
        int b = in.nextInt();
        System.out.println(Division(a, b));

        try {
            System.out.println(DivisionThrows(a, b));
            try {
                System.out.println("Inside try");
            } catch (Exception e) {
                System.out.println("Error!");
            } finally {
                System.out.println("Inside finally");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Outside finally");
        }

        Sport sport = new Volleyball("Josh", 2);
        sport.printInfo();
        sport = new Basketball("Kobe", 5, "NBA");
        sport.printInfo();

        System.exit(1);
    }

    interface Sport {
        void printInfo();
    }

    static class Volleyball implements Sport {
        String name;
        int wins;

        Volleyball(String name, int wins) {
            this.name = name;
            this.wins = wins;
        }

        @Override
        public void printInfo() {
            System.out.println(name + " - Volleyball player, total wins = " + wins);
        }
    }

    static class Basketball implements Sport {
        String name;
        int wins;
        String league;

        Basketball(String name, int wins, String league) {
            this.name = name;
            this.wins = wins;
            this.league = league;
        }

        @Override
        public void printInfo() {
            System.out.println(name + " - Basketball player, " + league + " league, total wins = " + wins);
        }
    }

}
