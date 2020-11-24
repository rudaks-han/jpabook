package jpabook.start.dispatch;

/**
 * Static Dispatch
 * compile time 시점
 */
public class StaticDispatch {
    static class Service {
        void run(int number) {
            System.out.println("run(" + number + ")");
        }

        void run(String msg) {
            System.out.println("run(" + msg + ")");
        }
    }

    public static void main(String[] args) {
        new Service().run(1);
        new Service().run("Dispatch");
    }
}
