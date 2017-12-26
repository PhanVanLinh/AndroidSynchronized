package toong.vn.androidsynchronized;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * The result we can check at the synchronized static method demo
 *
 * Conclusion:
 * Synchronized block in static method: the function is locked base on class => at PingThread time, there are only 1
 * thread can execute this function per class
 */
public class SynchronizedBlockInsideNormalMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronized_block_inside_normal_method);
    }

    /**
     * Two method {@link #printTable1(String)} and {@link #printTable2(String)} when execute will
     * print similar result
     * We can think synchronized (class name) <=> synchronized static method
     */
    static class Table {
        static void printTable1(String name) {
            synchronized (Table.class) {
                for (int i = 1; i <= 5; i++) {
                    Log.i("TAG", name + ": " + i);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
            }
        }

        synchronized static void printTable2(String name) {
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
