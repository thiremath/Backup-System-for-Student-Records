package projectName.algorithm;

public interface SubjectInterface {
    public void registerObserver(ObserverInterface Observer, Filter f) ;
    public void notifyAllListeners() ;
}
