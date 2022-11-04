package com.cs4773.Main;
import com.cs4773.ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;
public class ScoreboardView {
    @FXML
    ListView<String> teams = new ListView<>();
    private ViewModel vm = new ViewModel();

    public void update(String[] teamList) {
        teams.getItems().setAll(teamList);
    }
    public void onSelection() throws IOException {
        int index = teams.getSelectionModel().getSelectedIndex();
        vm.loadEditor(index);
    }
    public void setVm(ViewModel vm) {
        this.vm = vm;
    }
}