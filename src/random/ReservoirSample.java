package random;

import org.junit.Test;

import java.util.Random;

public class ReservoirSample {
    /*
     * 实现在n个元素中抽取k个元素，每个元素被抽中的概率相等，都是k/n。
     *
     * 先把前k个数放入蓄水池，对第k+1，我们以k/(k+1)概率决定是否要把它换入蓄水池，换入时随机的选取一个作为替换项，
     * 这样一直做下去，对于任意的样本空间n，对每个数的选取概率都为k/n。也就是说对每个数选取概率相等。
     *
     * 假设第i个元素，i<K：
     *      K步之前，被选中的概率为1；
     *      当走到第K+1步时，被替换的概率为K/(K+1) * 1/K = 1/(K+1)，被保留的概率为1 - 1/(K+1) = K/(K+1)；当走到第K+2步时，被保留的概率为K+1/K+2.....，第n步被保留的概率为N-1/N；
     * 假设第j个元素，j>K:
     *      在第j步被选中的概率为K/j；
     *      当走到j+1步时，被替换的概率为K/(j+1) * 1/K,被保留的概率为1 - 1/(j+1) = j/(j+1)；
     * 运行到第 n 步时，被保留的概率 = 被选中的概率 * 之前每一步都不被替换的概率。
     * 因此对于每一个元素，被保留的概率都为K/N.
     */
    private static int[] pool;
    private static final int N = 10000;
    private static Random random = new Random();

    public static void setUp() {
        pool = new int[N];
        for (int i=0; i<N; i++) {
            pool[i] = i;
        }
    }

    private static int[] sampling(int k) {
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = i;
        }

        for (int j=k; j<N; j++) {
            int r = random.nextInt(j+1);
            if (r < k) {
                result[r] = pool[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        setUp();
        for (int i: sampling(100)) {
            System.out.println(i);
        }
    }
}
