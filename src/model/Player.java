package model;

import model.analysis.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

// OBSERVER PATTERN
/* Questo pattern ti permette di definire una dipendenza uno-a-molti tra oggetti,
 in modo che quando un oggetto cambia stato, tutti i suoi osservatori vengano notificati
  e aggiornati automaticamente. In questo caso, potresti avere un oggetto Models.Player
  che viene osservato da oggetti StatisticheGiocatori che tengono traccia
  delle statistiche di ciascun giocatore
 */

// Classe osservata
public class Player {
    private String name;
    private int matchesPlayed;
    private int setsWon;
    private int matchesWon;
    private List<PlayerObserver> observers;

    public Player(String name) {
        this.name = name;
        this.matchesPlayed = 0;
        this.setsWon = 0;
        this.matchesWon = 0;
        this.observers = new ArrayList<>();
    }

    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PlayerObserver observer) {
        observers.remove(observer);
    }

    public void playMatch(int setsWon, boolean wonMatch) {
        matchesPlayed++;
        this.setsWon += setsWon;
        if (wonMatch) {
            matchesWon++;
        }
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

    public int getMatchesWon() {
        return matchesWon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", setsWon=" + setsWon +
                ", matchesWon=" + matchesWon +
                '}';
    }
}

