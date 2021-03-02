package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.function.Consumer;

public class Benchmark_UF {
    private static double BM_HWQUPC(int n) {
        Consumer<Integer> c = xs -> UF_HWQUPC.count(xs);
        Benchmark_Timer<Integer> bt = new Benchmark_Timer<Integer>("Test UF_HWQUPC",c);
        return bt.run(n,1000);
    }

    private static double BM_HWQU(int n) {
        Consumer<Integer> c = xs -> UF_HWQU.count(xs);
        Benchmark_Timer<Integer> bt = new Benchmark_Timer<Integer>("Test UF_HWQU",c);
        return bt.run(n,1000);
    }

    public static void main(String[] args) {
        int n = 200;

        for (int i =0; i < 6; i++) {
            double time = BM_HWQUPC(n);
            System.out.println("Runtime of " + n + " times of HWQUPC is: " + time);
            n *= 2;
        }

        n = 200;
        for (int i =0; i < 6; i++) {
            double time = BM_HWQU(n);
            System.out.println("Runtime of " + n + " times of HWQU is: " + time);
            n *= 2;
        }
    }

}
