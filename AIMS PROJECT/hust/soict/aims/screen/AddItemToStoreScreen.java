package hust.soict.aims.screen;

import hust.soict.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    // Khai báo protected để các lớp con có thể truy cập và lấy dữ liệu
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    // Panel chứa các form nhập liệu, để protected để lớp con có thể add thêm ô nhập (ví dụ: Author, Director)
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Cấu hình thanh MenuBar giống hệt StoreScreen để người dùng có thể quay lại
        cp.add(createMenuBar(), BorderLayout.NORTH);

        // Khởi tạo khu vực nhập liệu
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Lưới 2 cột, giãn cách 10px
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Thêm các trường nhập liệu chung của lớp Media
        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField(20);
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField(20);
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost: "));
        tfCost = new JTextField(20);
        centerPanel.add(tfCost);

        cp.add(centerPanel, BorderLayout.CENTER);

        // Nút bấm xác nhận thêm sản phẩm
        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            // Khi bấm nút, gọi hàm abstract này để lớp con tự xử lý logic tạo đối tượng
            addItemToStore();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnAdd);
        cp.add(bottomPanel, BorderLayout.SOUTH);

        setTitle(title);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Copy lại thanh Menu từ StoreScreen để đảm bảo tính nhất quán
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addStoreBook = new JMenuItem("Add Book");
        JMenuItem addStoreCD = new JMenuItem("Add CD");
        JMenuItem addStoreDVD = new JMenuItem("Add DVD");

        // Bạn có thể thêm sự kiện cho các MenuItem này sau để chuyển qua lại giữa các màn hình
        smUpdateStore.add(addStoreBook);
        smUpdateStore.add(addStoreCD);
        smUpdateStore.add(addStoreDVD);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Hàm abstract bắt buộc các lớp con phải ghi đè để xử lý logic thêm item
    protected abstract void addItemToStore();
}