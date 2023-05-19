import java.util.ArrayList;

public interface Subject {

    void add(Observer observer);
    void remove(Observer observer);
    void notifyAllObservers();
}
