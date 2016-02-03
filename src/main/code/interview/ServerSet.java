package interview;

import java.util.HashSet;
import java.util.Set;

public class ServerSet implements ElementSet<ServerElement> {
    private final Set<ServerElement> set = new HashSet<>();

    @Override
    public void add(ServerElement newServer){
        set.add(newServer);
    }

//    @Override
//    public void remove(ServerElement serverToRemove){
//        if(!set.contains(serverToRemove){
//            throw new RuntimeException("server does not exist");
//        }
//        set.remove(serverToRemove);
//    }

//    @Override
//    public ServerElement getRandomElement(){
//        if(set.size() == 0){
//            throw new RuntimeException("No more servers");
//        }
//        int random = (int)Math.random()* set.size();
//        ServerElement[] array = set.toArray();
//        return array[random];
//    }

    @Override
    public void remove(ServerElement serverToRemove){
        if(!set.contains(serverToRemove)){
            throw new RuntimeException("server does not exist");
        }
        set.remove(serverToRemove);
    }

    @Override
    public ServerElement getRandomElement(){
        if(set.size() == 0){
            throw new RuntimeException("No more servers");
        }
        int random = (int)(Math.random()* set.size());
        return (ServerElement)set.toArray()[random];
    }
}
