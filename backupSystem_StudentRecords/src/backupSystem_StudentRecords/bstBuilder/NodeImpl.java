package backupSystem_StudentRecords.bstBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeImpl implements SubjectInterface, ObserverInterface{
    int b_Number ;
    String name ;
    NodeImpl left, right ;
    HashMap<Filter,ArrayList<ObserverInterface>> observersList ;
    ArrayList<ObserverInterface> observers ;

    public NodeImpl(int b_NumberIn, String nameIn){
        b_Number = b_NumberIn ;
        name = nameIn ;
        left = right = null ;
        observersList = new HashMap<Filter,ArrayList<ObserverInterface>>()  ;
    }

    @Override
    public void registerObserver(ObserverInterface obIn, Filter f) {
        observers = new ArrayList<ObserverInterface>() ;
        if(observersList.containsKey(f)){
            observers = observersList.get(f) ;
        }
        observers.add(obIn) ;
        observersList.put(f,observers) ;
    }

    @Override
    public void notifyAllListeners() {
        for (HashMap.Entry<Filter,ArrayList<ObserverInterface>> entry : observersList.entrySet()) {
            Filter filter = entry.getKey();
            ArrayList<ObserverInterface> nodeObservers ;
            nodeObservers = entry.getValue();

            for(int i=0;i<nodeObservers.size();i++){

                NodeImpl Observer = (NodeImpl) nodeObservers.get(i);
                if(filter.fPrimeImpl != null){
                    if(filter.fPrimeImpl.Prime(b_Number)){
                        Observer.update(b_Number);
                    }
                    continue ;
                }
                else if(filter.fAllImpl != null){
                    if(filter.fAllImpl.check()){
                        Observer.update(b_Number);
                    }
                }
            }            
        }
    }
    

    @Override
    public void update(int b_NumberIn) {
        b_Number = b_NumberIn ;
    }


}
