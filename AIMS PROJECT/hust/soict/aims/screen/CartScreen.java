package hust.soict.aims.screen; // Hoặc dùng tên package nhóm dsai của bạn

import hust.soict.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        // Khởi tạo JFXPanel và thêm vào JFrame của Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768);

        // Chạy JavaFX trên một luồng (thread) riêng biệt
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/soict/aims/screen/cart.fxml"));

                    // Khởi tạo Controller và truyền giỏ hàng vào
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);

                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}