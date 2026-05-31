package hust.soict.javafx; // Nhớ đổi tên package nếu bạn dùng nhóm dsai

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    // Khai báo thêm 2 RadioButton từ FXML
    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (eraserRadio.isSelected()) {
            // Chế độ CỤC TẨY: Xóa các điểm vẽ nằm gần con trỏ chuột
            double eraserRadius = 10.0; // Bán kính của vùng tẩy (càng to tẩy càng rộng)

            drawingAreaPane.getChildren().removeIf(node -> {
                if (node instanceof Circle) {
                    Circle circle = (Circle) node;
                    // Công thức tính khoảng cách từ vị trí chuột hiện tại đến tâm của hình tròn nét vẽ
                    double distance = Math.sqrt(
                            Math.pow(circle.getCenterX() - event.getX(), 2) +
                                    Math.pow(circle.getCenterY() - event.getY(), 2)
                    );

                    // Nếu khoảng cách nhỏ hơn bán kính tẩy, ném True để removeIf xóa Node này đi
                    return distance <= eraserRadius;
                }
                return false;
            });

        } else {
            // Chế độ CÂY BÚT: Vẽ bình thường
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}