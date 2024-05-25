package model.analysis;

import model.Player;

// OBSERVER PATTERN
// Interfaccia osservata
public interface PlayerObserver {
    void update(Player player);
}
