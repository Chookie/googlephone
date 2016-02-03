package correct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServerSet implements ElementSet<ServerElement> {
    private final Set<ServerElement> set = new HashSet<>();

    @Override
    public void add(ServerElement newServer){
        if(newServer == null){
            throw new RuntimeException("server does not exist");
        }
        set.add(newServer);
    }

    @Override
    public void remove(ServerElement serverToRemove){
        if(serverToRemove == null || !set.contains(serverToRemove)){
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
        ServerElement randomElement = (ServerElement)set.toArray()[random];
        System.out.printf("Random=%d, Name=%s%n",random,randomElement.getName());

        return randomElement;
//        for(ServerElement e : set){
//            if(random-- <= 0){
//                return e;
//            }
//        }
//        return null;
    }
}
