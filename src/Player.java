import java.util.ArrayList;
import java.util.List;

// OBSERVER PATTERN
/* Questo pattern ti permette di definire una dipendenza uno-a-molti tra oggetti,
 in modo che quando un oggetto cambia stato, tutti i suoi osservatori vengano notificati
  e aggiornati automaticamente. In questo caso, potresti avere un oggetto Player
  che viene osservato da oggetti StatisticheGiocatori che tengono traccia
  delle statistiche di ciascun giocatore
 */

// Classe osservata
class Player {
    private String name;
    private int matchesPlayed;
    private int setsWon;
    private List<PlayerObserver> observers;

    public Player(String name) {
        this.name = name;
        this.matchesPlayed = 0;
        this.setsWon = 0;
        this.observers = new ArrayList<>();
    }

    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PlayerObserver observer) {
        observers.remove(observer);
    }

    public void playMatch(int setsWon) {
        matchesPlayed++;
        this.setsWon += setsWon;
        notifyObservers();
    }

    private void notifyObservers() {
        for (PlayerObserver observer : observers) {
            observer.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getSetsWon() {
        return setsWon;
    }
}
