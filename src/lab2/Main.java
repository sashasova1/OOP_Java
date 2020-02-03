package lab2;

import java.io.IOException;
import java.util.*;

public class Main {

    public static int Division(int a, int b) {
        int div = 0;
        try {
            if (b == 0) throw new ArithmeticException("Division exception (b == 0)");
            div = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return div;
    }

    public static int DivisionThrows(int a, int b) throws ArithmeticException, IOException {
        if (a == 0) throw new IOException("why would you even try to divide zero by a number");
        if (b == 0) throw new ArithmeticException("DivisionThrows exception (b == 0)");
        int div = a / b;
        return div;
    }

    public static void main(String args[]) {
        int tries = 0;
        int maxTries = 2;

        while (tries < maxTries) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a = ");
            int a = in.nextInt();
            System.out.print("Enter b = ");
            int b = in.nextInt();
            System.out.println(Division(a, b));

            try {
                System.out.println(DivisionThrows(a, b));
                tries = maxTries;
                try {
                    System.out.println("Inside try"+5/0);
                } finally {
                    System.out.println("Inside finally");
                }
            } catch (ArithmeticException | IOException e) {
                tries++;
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Outside finally");
            }
        }

        Sport sport = new Volleyball("Josh", 2);
        sport.printInfo();
        sport = new Basketball("Kobe", 5, "NBA");
        sport.printInfo();

        System.exit(1);
    }

    interface Sport {
        void setMedals(int medals);
        void printInfo();
    }

    static class Volleyball implements Sport {
        String name;
        int wins;
        int medals;
        String ball;

        Volleyball(String name, int wins) {
            this.name = name;
            this.wins = wins;
        }

        @Override
        public void printInfo() {
            System.out.println(name + " - Volleyball player, total wins = " + wins);
        }
        public void setMedals(int medals) {this.medals = 3;}
    }

    static class Basketball implements Sport {
        String name;
        int wins;
        int medals;
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

        public void setMedals(int medals) {this.medals = medals;}
    }

}
