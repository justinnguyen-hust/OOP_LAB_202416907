package hust.soict.aims.screen;

import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

// Kế thừa khung giao diện từ AddItemToStoreScreen
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    // Khai báo thêm các ô nhập liệu riêng cho DVD
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");

        // Bổ sung thêm các trường nhập liệu vào centerPanel của lớp cha
        centerPanel.add(new JLabel("Director: "));
        tfDirector = new JTextField(20);
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length: "));
        tfLength = new JTextField(20);
        centerPanel.add(tfLength);

        // Cập nhật lại giao diện để hiển thị các ô vừa thêm
        revalidate();
        repaint();
    }

    // Bắt buộc phải ghi đè hàm này để xử lý sự kiện khi bấm nút "Add to Store"
    @Override
    protected void addItemToStore() {
        try {
            // 1. Lấy dữ liệu từ các ô nhập text
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());

            // 2. Tạo đối tượng DVD mới
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

            // 3. Thêm vào Store
            store.addMedia(dvd);

            // 4. Báo cáo thành công và xóa trắng các ô nhập liệu
            JOptionPane.showMessageDialog(this, "DVD '" + title + "' has been added successfully!");
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfDirector.setText("");
            tfLength.setText("");

        } catch (NumberFormatException e) {
            // Bắt lỗi nếu người dùng nhập chữ vào ô Giá tiền (Cost) hoặc Độ dài (Length)
            JOptionPane.showMessageDialog(this,
                    "Error: Cost and Length must be valid numbers!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}