import java.util.*;
import java.util.function.Consumer;

/**
 * Created by DoDo on 2017-06-09.
 */
public class Algorithms {
    public static void main(String[] args) {
        Set<Integer> A = new HashSet<>();
        Collections.addAll(A, 1,2,3);
        Set<Integer> B = new HashSet<>();
        Collections.addAll(B, 5);
        Set<Integer> C = new HashSet<>();
        Collections.addAll(C, 4,5,6);
        double start = System.currentTimeMillis();
        System.out.printf("result: %d; time: %f%n", new Algorithms().tripletsEfficiently(A, B, C),System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        System.out.printf("result: %d; time: %f", new Algorithms().triplets(A, B, C),System.currentTimeMillis()-start);
    }

    private int tripletsEfficiently(final Set<Integer> A, final Set<Integer> B,final Set<Integer> C) {
        int result = 0;
        final int maxB = Collections.max(B);
        Iterator<Integer> aterator = A.iterator();
        Iterator<Integer> cterator = C.iterator();
        Iterator<Integer> bterator = B.iterator();
        ArrayList<Integer> aList = new ArrayList<>(A.size());
        ArrayList<Integer> cList = new ArrayList<>(C.size());
        int a = 0, b = 0, c = 0;
        int sumA = 0, sumC = 0;
        while(aterator.hasNext()){
            a = aterator.next();
            if(a > maxB);
        }
        cterator.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if ((integer) <= maxB) {
                    cList.add(integer);
                }
            }
        });
        for (int x : aList){
            sumA += x;
        }
        for (int z : cList){
            sumC += z;
        }

        while (bterator.hasNext()) {
            b = bterator.next();
            result += (sumA + A.size() * b) * (sumC + C.size() * b);
        }
        return result;
    }


    private int singleTriplet(Set<Integer> A, int b, Set<Integer> C) {
        int result = 0;
        Iterator<Integer> aterator = A.iterator();
        Iterator<Integer> cterator = C.iterator();
        int a = 0, c = 0;
        while (aterator.hasNext()) {
            a = aterator.next();
            while (cterator.hasNext()) {
                c = cterator.next();
                result += calc_triplets(a, b, c);
            }
        }
        return result;
    }

    private int triplets(Set<Integer> A, Set<Integer> B, Set<Integer> C) {
        Iterator<Integer> bterator = B.iterator();
        Iterator<Integer> aterator = A.iterator();
        Iterator<Integer> cterator = C.iterator();
        int x = 0, y = 0, z = 0;
        int result = 0;
        while (bterator.hasNext()) {
            y = bterator.next();
            while (aterator.hasNext()) {
                x = aterator.next();
//                System.out.printf("x:y %d:%d%n", x, y);
                if (y < x)
                    continue;
                while (cterator.hasNext()) {
                    z = cterator.next();
//                    System.out.printf("z:y %d:%d%n", z, y);
                    if (z > y)
                        continue;
                    if (x <= y && y >= z) {
//                        System.out.printf("(%d+%d)*(%d+%d)%n", x, y, y, z);
                        result += calc_triplets(x, y, z);
                    }
                }
                cterator = C.iterator();
            }
            aterator = A.iterator();
        }
        return result;
    }

    private int calc_triplets(int x, int y, int z) {
        return (x + y) * (y + z);
    }
}
