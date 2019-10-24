package models.util;

/**
 * <h1>My Observable Interface</h1>
 */
public interface Observable {
    /**
     * <p>registerObserver to add observer to Observable's observers</p>
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * <p>notifies the observers. Calls their update method</p>
     */
    public void notifyObservers();

    /**
     * <p>Removes observer from the Observable's observers</p>
     * @param observer
     */
    public void removeObserver(Observer observer);
}
