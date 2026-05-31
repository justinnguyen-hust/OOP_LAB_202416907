package hust.soict.aims.screen;

import hust.soict.aims.Aims;
import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");

        // Thêm bộ lắng nghe sự kiện khi click vào nút Add to cart
        btnAddToCart.addActionListener(e -> {
            try {
                Aims.getCart().addMedia(media);

                // Hiển thị thông báo cho người dùng biết đã thêm thành công
                JOptionPane.showMessageDialog(null,
                        media.getTitle() + " has been added to your cart!",
                        "Cart Update",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                // Hiển thị lỗi nếu có vấn đề xảy ra (ví dụ giỏ hàng đầy)
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        container.add(btnAddToCart);



        // Nút Play chỉ được khởi tạo và thêm vào nếu mặt hàng này có thể phát được (implements Playable)
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");

            // Thêm bộ lắng nghe sự kiện khi click vào nút Play
            btnPlay.addActionListener(e -> {
                // Khởi tạo một JDialog mới
                JDialog dialog = new JDialog();
                dialog.setTitle("Media Player");
                dialog.setSize(400, 300);
                dialog.setLayout(new BorderLayout());

                // Tạo nhãn chứa tên Media đang phát
                JLabel playLabel = new JLabel("Now playing: " + media.getTitle());
                playLabel.setHorizontalAlignment(SwingConstants.CENTER);
                playLabel.setFont(new Font(playLabel.getFont().getName(), Font.BOLD, 24));
                playLabel.setForeground(Color.BLUE);

                // Thêm nhãn vào dialog
                dialog.add(playLabel, BorderLayout.CENTER);

                // Set vị trí hiển thị ở giữa màn hình và làm cho dialog hiện lên
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            });

            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
