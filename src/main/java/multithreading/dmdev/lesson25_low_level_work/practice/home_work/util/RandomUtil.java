package multithreading.dmdev.lesson25_low_level_work.practice.home_work.util;

import java.util.Random;

public final class RandomUtil {

    public static final Random random = new Random(System.currentTimeMillis());
    public static final int DEFAULT_BOUND = 4;

    private RandomUtil() {
    }


    public static int getRandomInt() {
        return random.nextInt(DEFAULT_BOUND);
    }
    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }
    public static int getRandomIntStartingFromOne(int bound) {
        return random.nextInt(bound) + 1;
    }

}
