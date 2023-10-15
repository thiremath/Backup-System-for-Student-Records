package backupSystem_StudentRecords.algorithm;

public class Filter {
    FilterAllImpl fAllImpl ;
    FilterPrimeImpl fPrimeImpl ;
    Filter(FilterAllImpl fAllImplIn,FilterPrimeImpl fPrimeImplIn){
            fAllImpl = fAllImplIn ;
            fPrimeImpl = fPrimeImplIn ;
    }
}
