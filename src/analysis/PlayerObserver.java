package analysis;

import Models.Player;

// OBSERVER PATTERN
// Interfaccia osservata
public interface PlayerObserver {
    void update(Player player);
}
