import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int[] randomMass;

    public Randoms(int min, int max) {
        random = new Random();
        randomMass = new int[max - min + 1];
        for (int i = 0; i < randomMass.length; i++) {
            if (i == 0) {
                randomMass[i] = min;
            } else {
                randomMass[i] = randomMass[i - 1] + 1;
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            int index;

            @Override
            public boolean hasNext() {
                return index < randomMass.length;
            }

            @Override
            public Integer next() {
                index = random.nextInt(randomMass.length);
                return randomMass[index];
            }
        };
    }
}