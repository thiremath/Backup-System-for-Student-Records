package backupSystem_StudentRecords.bstBuilder;

import backupSystem_StudentRecords.utils.checkPrime;

public class FilterPrimeImpl implements FilterInterface{
    @Override
    public boolean check(int Number){
        return checkPrime.checkPrimefunc(Number) ;
    }
}
