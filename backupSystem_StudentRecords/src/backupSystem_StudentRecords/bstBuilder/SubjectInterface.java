package backupSystem_StudentRecords.bstBuilder;

public interface SubjectInterface {
    public void registerObserver(ObserverInterface Observer, FilterInterface f) ;
    public void updateNode(int updateValueIn) ;    
    public void notifyAllObservers() ;
}
