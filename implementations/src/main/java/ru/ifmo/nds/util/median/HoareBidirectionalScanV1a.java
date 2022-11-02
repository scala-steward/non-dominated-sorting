package ru.ifmo.nds.util.median;

public final class HoareBidirectionalScanV1a implements DestructiveMedianFactory {
    private static final HoareBidirectionalScanV1a factoryInstance = new HoareBidirectionalScanV1a();

    public static HoareBidirectionalScanV1a instance() {
        return factoryInstance;
    }

    private static final DestructiveMedianAlgorithm algorithmInstance = new DestructiveMedianAlgorithm() {
        @Override
        public int maximumSize() {
            return Integer.MAX_VALUE;
        }

        @Override
        public double solve(double[] array, int from, int until) {
            switch (until - from) {
                case 1:
                    return array[from];
                case 2:
                    return Math.max(array[from], array[from + 1]);
            }

            int index = (from + until) >>> 1;
            int to = until - 1;
            while (to - from >= 3) {
                double pivot = Common.rearrange3(array, from, index, to);

                double vl, vr;
                int l = from + 1, r = to - 1;
                do {
                    while ((vl = array[l]) < pivot) ++l;
                    while ((vr = array[r]) > pivot) --r;
                    if (l <= r) {
                        array[l] = vr;
                        array[r] = vl;
                        ++l;
                        --r;
                    }
                } while (l <= r);
                if (index < r) {
                    to = r;
                } else if (l < index) {
                    from = l;
                } else if (r == index) {
                    return Common.maxUnchecked(array, from, r);
                } else if (l == index) {
                    return Common.minUnchecked(array, l, to);
                } else {
                    return pivot;
                }
            }

            return Common.solve3(array, from);
        }
    };

    @Override
    public DestructiveMedianAlgorithm createInstance(int maxSize) {
        return algorithmInstance;
    }
}
