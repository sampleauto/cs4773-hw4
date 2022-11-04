package com.cs4773.ViewModel;

import com.cs4773.Main.EditorView;
import com.cs4773.Main.ScoreboardView;
import com.cs4773.Model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewModel extends Application {
    private final Scoreboard scoreboard = new Scoreboard();
    ScoreboardView svc;
    List<EditorView> evcList = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scoreboard.fxml"));
        Parent root = loader.load();
        svc = loader.getController();
        svc.setVm(this);
        svc.update(scoreboard.getTeams());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Scoreboard");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void loadEditor(int i) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Editor.fxml"));
        Parent root = loader.load();
        EditorView con = loader.getController();
        con.updateFields(scoreboard.getTeam(i).getName(), scoreboard.getTeam(i).getScore(),
                scoreboard.getTeam(i).getDate(), i);
        con.setVm(this);
        evcList.add(con);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Editor");
        stage.show();
    }
    public void save(String name, int score, String date, int index) {
        if(!checkDifference(name, score, index) || !followsRules(name, score)) {
            return;
        }
        updateTeam(name, score, date, index);
        svc.update(scoreboard.getTeams());
        for(EditorView evc : evcList) {
            if(evc.getIndex() == index) {
                evc.updateFields(name, score, date, index);
            }
        }
    }
    public boolean checkDifference(String name, int score, int index) {
        if((!name.equals(scoreboard.getTeam(index).getName()))) {
            return true;
        }
        if(score != scoreboard.getTeam(index).getScore()) {
            return true;
        }
        System.out.println("Team name/score are the same, not updating.");
        return false;
    }
    public boolean followsRules(String name, int score) {
        if(score > 2000 || score < 0) {
            System.out.println("Invalid score, not updating.");
            return false;
        }
        if(name.length() < 5 || name.length() > 50) {
            System.out.println("Invalid team name length, not updating.");
            return false;
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        if(pattern.matcher(name).find()) {
            System.out.println("Invalid character, not updating.");
            return false;
        }
        return true;
    }
    public void updateTeam(String name, int score, String date, int index) {
        scoreboard.getTeam(index).setName(name);
        scoreboard.getTeam(index).setScore(score);
        scoreboard.getTeam(index).setDate(date);
    }
}