package ru.ifmo.nds;

import ru.ifmo.nds.bos.Improved;
import ru.ifmo.nds.bos.ImprovedAdaptedForHybrid;
import ru.ifmo.nds.bos.ImprovedReverse;
import ru.ifmo.nds.bos.Proteek;

public class BestOrderSort {
    private BestOrderSort() {}

    private static final NonDominatedSortingFactory PROTEEK = Proteek::new;
    private static final NonDominatedSortingFactory IMPROVED = Improved::new;
    private static final NonDominatedSortingFactory IMPROVED_ADAPTED_FOR_HYBRID = ImprovedAdaptedForHybrid::new;
    private static final NonDominatedSortingFactory IMPROVED_REVERSE = ImprovedReverse::new;

    public static NonDominatedSortingFactory getProteekImplementation() {
        return PROTEEK;
    }
    public static NonDominatedSortingFactory getImprovedImplementation() {
        return IMPROVED;
    }
    public static NonDominatedSortingFactory getImprovedReverseImplementation() {
        return IMPROVED_REVERSE;
    }
    public static NonDominatedSortingFactory getImprovedAdaptedForHybridImplementation() {
        return IMPROVED_ADAPTED_FOR_HYBRID;
    }
}
