package projectName.algorithm;
import java.util.HashMap;

public class Node implements SubjectInterface, ObserverInterface{
    int b_Number ;
    String name ;
    Node left, right ;
    HashMap<Node,Filter> observers ;

    public Node(int b_NumberIn, String nameIn){
        b_Number = b_NumberIn ;
        name = nameIn ;
        left = right = null ;
        observers = new HashMap<Node,Filter>()  ;
    }

    @Override
    public void registerObserver(Node ObserverIn, Filter f) {
        observers.put(ObserverIn,f);
    }

    @Override
    public void notifyAllListeners() {
        for (HashMap.Entry<Node,Filter> entry : observers.entrySet()) {
            Node Observer = entry.getKey();
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
