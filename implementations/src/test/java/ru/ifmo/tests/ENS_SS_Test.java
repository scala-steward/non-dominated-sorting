package ru.ifmo.tests;

import ru.ifmo.ENS;
import ru.ifmo.NonDominatedSortingFactory;

public class ENS_SS_Test extends CorrectnessTestsBase {
    @Override
    protected NonDominatedSortingFactory getFactory() {
        return ENS.getENS_SS();
    }
}