package correct;

public interface ElementSet<T extends Element> {
    void add(T newServer);
    void remove(T serverToRemove);
    T getRandomElement();
}

