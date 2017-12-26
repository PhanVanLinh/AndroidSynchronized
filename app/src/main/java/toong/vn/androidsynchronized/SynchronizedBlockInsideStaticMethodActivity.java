package toong.vn.androidsynchronized;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * The result we can check at the synchronized normal method demo
 *
 * Conclusion:
 * Synchronized block inside normal method: the function is locked base on object => at PingThread time, there are only 1
 * thread can execute this function per each object
 *
 * synchronized (this): this mean current object
 */
public class SynchronizedBlockInsideStaticMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronized_block_inside_static_method);
    }

    /**
     * Two method {@link #printTable1(String)} and {@link #printTable2(String)} when execute will
     * print similar result
     * We can think synchronized (this) <=> synchronized normal method
     */
    static class Table {

        void printTable1(String name) {
            synchronized (this) {
                for (int i = 1; i <= 5; i++) {
                    Log.i("TAG", name + ": " + i);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
            }
        }

        synchronized void printTable2(String name) {
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
