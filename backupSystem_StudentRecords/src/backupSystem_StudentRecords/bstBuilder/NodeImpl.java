package backupSystem_StudentRecords.bstBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeImpl implements SubjectInterface, ObserverInterface{
    int b_Number ;
    String name ;
    NodeImpl left, right ;
    HashMap<FilterInterface,ArrayList<ObserverInterface>> observersList ;
    ArrayList<ObserverInterface> observers ;

    public NodeImpl(int b_NumberIn, String nameIn){
        b_Number = b_NumberIn ;
        name = nameIn ;
        left = right = null ;
        observersList = new HashMap<FilterInterface,ArrayList<ObserverInterface>>()  ;
    }

    @Override
    public void registerObserver(ObserverInterface obIn, FilterInterface filterIn) {
        observers = new ArrayList<ObserverInterface>() ;
        if(observersList.containsKey(filterIn)){
            observers = observersList.get(filterIn) ;
        }
        observers.add(obIn) ;
        observersList.put(filterIn,observers) ;
    }

    @Override
    public void notifyAllObservers() {
        for (HashMap.Entry<FilterInterface,ArrayList<ObserverInterface>> entry : observersList.entrySet()) {
            FilterInterface currFilter = entry.getKey();
            ArrayList<ObserverInterface> nodeObservers ;
            nodeObservers = entry.getValue();

            for(int i=0;i<nodeObservers.size();i++){

                // NodeImpl Observer = (NodeImpl) nodeObservers.get(i);
                ObserverInterface Observer = nodeObservers.get(i);
                if(currFilter.check(b_Number)){
                    Observer.update(b_Number);
                }

            }            
        }
    }
    
    @Override
    public void updateNode(int updateValueIn){
        b_Number += updateValueIn ;
    }
    

    @Override
    public void update(int b_NumberIn) {
        b_Number = b_NumberIn ;
    }


}
