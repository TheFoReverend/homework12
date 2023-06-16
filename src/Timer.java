public class Timer {

    public static void main(String[] args) {
        Thread elapsedThread = new Thread(new ElapsedTimeDisplay());
        elapsedThread.start();

        Thread messageThread = new Thread(new MessageDisplay());
        messageThread.start();
    }

    static class ElapsedTimeDisplay implements Runnable {
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            while (true) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Пройшло: " + (elapsedTime / 1000.0) + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MessageDisplay implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Минуло 5 секунд");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
