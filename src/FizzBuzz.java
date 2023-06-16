import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread threadA = new Thread(new FizzThread(queue));
        Thread threadB = new Thread(new BuzzThread(queue));
        Thread threadC = new Thread(new FizzBuzzThread(queue));
        Thread threadD = new Thread(new NumberThread(queue));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    static class FizzThread implements Runnable {
        private final BlockingQueue<String> queue;

        public FizzThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    try {
                        queue.put("fizz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class BuzzThread implements Runnable {
        private final BlockingQueue<String> queue;

        public BuzzThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 5 == 0 && i % 3 != 0) {
                    try {
                        queue.put("buzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class FizzBuzzThread implements Runnable {
        private final BlockingQueue<String> queue;

        public FizzBuzzThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    try {
                        queue.put("fizzbuzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class NumberThread implements Runnable {
        private final BlockingQueue<String> queue;

        public NumberThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                try {
                    String output = queue.take();
                    if (output != null) {
                        System.out.println(output);
                    } else {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
