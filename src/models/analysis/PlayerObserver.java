package models.analysis;

import models.Player;

// OBSERVER PATTERN
// Interfaccia osservata
public interface PlayerObserver {
    void update(Player player);
}
