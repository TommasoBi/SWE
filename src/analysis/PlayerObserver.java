package analysis;

import analysis.Player;

// OBSERVER PATTERN
// Interfaccia osservata
interface PlayerObserver {
    void update(Player player);
}
