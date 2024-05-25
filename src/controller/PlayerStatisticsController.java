package controller;

import model.Player;
import model.PlayerStatisticsModel;
import view.PlayerStatisticsView;
import model.analysis.PlayerObserver;

public class PlayerStatisticsController implements PlayerObserver {
    private PlayerStatisticsModel model;
    private PlayerStatisticsView view;

    public PlayerStatisticsController(PlayerStatisticsModel model, PlayerStatisticsView view) {
        this.model = model;
        this.view = view;
    }

    // Metodo dell'interfaccia PlayerObserver per ricevere gli aggiornamenti dai giocatori
    @Override
    public void update(Player player) {
        model.updateStats(player);
        view.displayStats(model, player);
    }
}


