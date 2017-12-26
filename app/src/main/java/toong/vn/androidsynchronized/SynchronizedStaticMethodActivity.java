package toong.vn.androidsynchronized;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * == NO synchronized KEYWORD ===
 * TAG: Thread 1: 1
 * TAG: Thread 2: 1
 * TAG: Thread 1(2): 1
 * TAG: Thread 1: 2
 * TAG: Thread 2: 2
 * TAG: Thread 1(2): 2
 * TAG: Thread 1: 3
 * TAG: Thread 2: 3
 * TAG: Thread 1(2): 3
 * TAG: Thread 1: 4
 * TAG: Thread 2: 4
 * TAG: Thread 1(2): 4
 * TAG: Thread 2: 5
 * TAG: Thread 1: 5
 * TAG: Thread 1(2): 5
 *
 *
 * == HAVE synchronized KEYWORD ===
 * TAG: Thread 2: 1
 * TAG: Thread 2: 2
 * TAG: Thread 2: 3
 * TAG: Thread 2: 4
 * TAG: Thread 2: 5
 * TAG: Thread 1: 1
 * TAG: Thread 1: 2
 * TAG: Thread 1: 3
 * TAG: Thread 1: 4
 * TAG: Thread 1: 5
 * TAG: Thread 1(2): 1
 * TAG: Thread 1(2): 2
 * TAG: Thread 1(2): 3
 * TAG: Thread 1(2): 4
 * TAG: Thread 1(2): 5
 * Thread 2 are execute first even we start Thread 1 first :D
 *
 * Conclusion:
 * Synchronized static method: the function is locked base on class => at PingThread time, there are only 1
 * thread can execute this function per class
 */

public class SynchronizedStaticMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronized_static_method);

        MyThread1 t1 = new MyThread1("Thread 1");
        MyThread2 t2 = new MyThread2("Thread 2");
        MyThread1 t3 = new MyThread1("Thread 1(2)");
        t1.start();
        t2.start();
        t3.start();
    }

    class MyThread1 extends Thread {
        private String name;

        public MyThread1(String name) {
            this.name = name;
        }

        public void run() {
            Table.printTable(name);
        }
    }

    class MyThread2 extends Thread {
        private String name;

        public MyThread2(String name) {
            this.name = name;
        }

        public void run() {
            Table.printTable(name);
        }
    }

    static class Table {

        synchronized static void printTable(String name) {
            for (int i = 1; i <= 5; i++) {
                Log.i("TAG", name + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        }
    }
}

