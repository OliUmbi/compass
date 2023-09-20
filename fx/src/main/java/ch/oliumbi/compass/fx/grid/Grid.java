package ch.oliumbi.compass.fx.grid;

import java.util.List;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Grid extends GridPane {

  public void columns(int columns) {
    for (int i = 0; i < columns; i++) {
      ColumnConstraints columnConstraints = new ColumnConstraints();
      columnConstraints.setPercentWidth(100 / (double) columns);

      getColumnConstraints().add(columnConstraints);
    }
  }

  public void rows(int rows) {

    for (int i = 0; i < rows; i++) {
      RowConstraints rowConstraints = new RowConstraints();
      rowConstraints.setPercentHeight(100 / (double) rows);

      getRowConstraints().add(rowConstraints);
    }
  }
}
