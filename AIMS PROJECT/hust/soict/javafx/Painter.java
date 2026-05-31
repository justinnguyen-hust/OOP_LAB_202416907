package hust.soict.javafx; // Hãy nhớ kiểm tra và đổi lại tên package cho đúng với của bạn

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Tải file giao diện FXML vào đối tượng gốc (root node)
        // LƯU Ý KỸ: Chỉnh sửa lại đường dẫn này cho khớp với cấu trúc thư mục thực tế của bạn!
        Parent root = FXMLLoader.load(getClass()
                .getResource("/hust/soict/javafx/Painter.fxml"));

        // Khởi tạo một Scene (Cảnh diễn) với nút gốc vừa tải
        Scene scene = new Scene(root);

        // Đặt tiêu đề cho cửa sổ và gắn Scene vào Stage (Sân khấu chính)
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Hàm launch sẽ khởi động vòng đời của ứng dụng JavaFX (bao gồm init, start, và stop)
        launch(args);
    }
}