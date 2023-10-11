package projectName.algorithm;
import java.util.HashMap;

public class NodeImpl implements SubjectInterface, ObserverInterface{
    int b_Number ;
    String name ;
    NodeImpl left, right ;
    HashMap<ObserverInterface,Filter> observers ;

    public NodeImpl(int b_NumberIn, String nameIn){
        b_Number = b_NumberIn ;
        name = nameIn ;
        left = right = null ;
        observers = new HashMap<ObserverInterface,Filter>()  ;
    }

    @Override
    public void registerObserver(ObserverInterface obIn, Filter f) {
        observers.put(obIn,f);
    }

    @Override
    public void notifyAllListeners() {
        for (HashMap.Entry<ObserverInterface,Filter> entry : observers.entrySet()) {
            NodeImpl Observer = (NodeImpl) entry.getKey();
            Filter filter = entry.getValue();
            if(filter.fp != null){
                if(filter.fp.Prime(b_Number)){
                    Observer.update(b_Number);
                }
                continue ;
            }
            else if(filter.fall != null){
                if(filter.fall.check()){
                    Observer.update(b_Number);
                }
            }
        }
    }
    

    @Override
    public void update(int b_NumberIn) {
        b_Number = b_NumberIn ;
    }


}
