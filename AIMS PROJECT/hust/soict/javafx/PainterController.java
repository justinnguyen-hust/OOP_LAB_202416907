package hust.soict.javafx; // Nhớ đổi tên package nếu bạn dùng nhóm dsai

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    // Nối với fx:id "drawingAreaPane" của Pane trong Scene Builder
    @FXML
    private Pane drawingAreaPane;

    // Hàm xử lý sự kiện khi bấm nút Clear
    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ các đối tượng hình học đang có trên bảng vẽ
        drawingAreaPane.getChildren().clear();
    }

    // Hàm xử lý sự kiện khi di chuột (kéo lê) trên bảng vẽ
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Lấy tọa độ X, Y của chuột, tạo một hình tròn nhỏ (bán kính 4) màu đen
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);

        // Thêm hình tròn đó vào danh sách các thành phần con của Pane
        drawingAreaPane.getChildren().add(newCircle);
    }
}