package a3;

import java.util.ArrayList;

class AirPollutionAlert implements Subject{
    private double airPollutionIndex;

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        if (airPollutionIndex > 100) { notifyObservers(); }
    }

    private ArrayList<Observer> observers = new ArrayList();

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister (Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this.airPollutionIndex);
        }
    }
}

