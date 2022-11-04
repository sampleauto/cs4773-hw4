package com.cs4773.Main;
import com.cs4773.ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.text.SimpleDateFormat;
import java.util.Date;
public class EditorView {
    private int index;
    private ViewModel vm = new ViewModel();
    @FXML
    Button save = new Button();
    @FXML
    TextField name = new TextField();
    @FXML
    TextField score = new TextField();
    @FXML
    TextField date = new TextField();

    public void updateFields(String name, int score, String date, int index) {
        this.index = index;
        this.name.setText(name);
        this.score.setText(String.valueOf(score));
        if(date != null)
            this.date.setText(date);
    }
    public void actionOnClickSave(ActionEvent ignoredEvent) {
        String name = this.name.getText();
        int score = Integer.parseInt(String.valueOf(this.score.getText()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.vm.save(name, score, sdf.format(new Date()), index);
    }
    public int getIndex() {
        return index;
    }
    public void setVm(ViewModel vm) {
        this.vm = vm;
    }
}