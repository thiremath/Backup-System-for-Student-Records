package backupSystem_StudentRecords.algorithm;

public interface SubjectInterface {
    public void registerObserver(ObserverInterface Observer, Filter f) ;
    public void notifyAllListeners() ;
}
