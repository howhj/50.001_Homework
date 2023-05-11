package a3;

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
