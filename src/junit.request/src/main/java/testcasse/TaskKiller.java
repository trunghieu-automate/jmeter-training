package testcasse;

import org.junit.Test;
import page.driver.BaseTest;

public class TaskKiller extends BaseTest {

    @Test
    public synchronized void killTask() {
        if (Thread.activeCount() == 0) {
            killBrowserTask();
        } else {
            try {
                Thread.sleep(3000);
                killBrowserTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
