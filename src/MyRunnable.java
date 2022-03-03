    import java.util.Scanner;

    public class MyRunnable {
        static int x;
        static int y;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Please input x: ");
                x = sc.nextInt();
                System.out.print("Please input y: ");
                y = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please insert an integer.");
            }
            while (x > y) {
                System.out.println("Y must bigger than X. Please insert again.");
                try {
                    System.out.print("Please input x: ");
                    x = sc.nextInt();
                    System.out.print("Please input y: ");
                    y = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please insert an integer.");
                }
            }

            OddRunnable oddRunnable = new OddRunnable(x, y);
            EvenRunnable evenRunnable = new EvenRunnable(x, y);

            Thread t1 = new Thread(oddRunnable);
            Thread t2 = new Thread(evenRunnable);
            t1.start();
            t2.start();

        }
    }


    class OddRunnable implements Runnable {
        int x, y;

        public OddRunnable(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void run() {
            for (int i = x; i <= y; i++) {
                if (i % 2 == 1) {
                    System.out.println(i);
                }
            }
        }
    }

    class EvenRunnable implements Runnable {
        int x, y;

        public EvenRunnable(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void run() {
            for (int i = x; i <= y; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }

            }
        }
    }