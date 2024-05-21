import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 连天通
 * @since 2024/05/21
 * 基于滑动窗口实现的限流通用类
 */
public class RateLimiter {

    /**
     * 子窗口数量
     */
    private int windowCount;

    /**
     * 子窗口时间长度，单位毫秒
     */
    private int windowDuration;

    /**
     * 限流阈值
     */
    private int limit;

    private long prevTime;

    private final AtomicInteger[] counters;

    public RateLimiter(int limit, int windowCount) {
        this.limit = limit;
        this.windowCount = windowCount;
        this.windowDuration = 1000 / windowCount;
        this.prevTime = System.currentTimeMillis();
        this.counters = new AtomicInteger[windowCount];
        resetCounter();
    }

    /**
     * 重置计数器
     */
    private void resetCounter() {
        for (int i = 0;i < counters.length; i ++) {
            counters[i] = new AtomicInteger(0);
        }
    }

    /**
     * 验证是否限流，如果被限流返回 false
     * @return
     */
    public synchronized boolean tryRequire() {
        long currentTime = System.currentTimeMillis();
        int slideCount = (int) Math.floor((currentTime - prevTime) / windowDuration);
        slideWindow(slideCount);
        int sum = 0;
        for (AtomicInteger counter : counters) {
            sum += counter.get();
        }
        if (sum >= limit) {
            return false;
        } else {
            counters[windowCount - 1].incrementAndGet();
            return true;
        }
    }


    /**
     * 将数组元素向左滑动
     * @param num
     */
    private void slideWindow(int num) {
        if (num == 0) {
            return;
        }
        if (num >= windowCount) {
            resetCounter();
        } else {
            for (int i = num; i < windowCount; i ++) {
                int pos = i - num;
                counters[pos] = counters[i];
                counters[i].getAndSet(0);
            }
        }
        prevTime = prevTime + (long) num * windowDuration;

    }


    /**
     * 测试代码
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(5, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // 模拟测试结果：第一轮发起10个请求，休眠一秒，再发起10个请求
        for (int k = 0; k < 2; k ++) {
            for (int i = 0; i < 10; i ++) {
                if (limiter.tryRequire()) {
                    System.out.println(LocalDateTime.now().format(formatter) + ": Request success");
                } else {
                    System.out.println(LocalDateTime.now().format(formatter) + ": Request blocked!");
                }
            }
            Thread.sleep(1000);
        }
    }
}
