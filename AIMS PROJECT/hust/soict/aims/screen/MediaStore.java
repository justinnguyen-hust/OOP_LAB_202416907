package hust.soict.aims.screen;

import hust.soict.aims.Aims;
import hust.soict.aims.exception.PlayerException;
import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
            btnPlay.addActionListener(e -> {
                try {
                    // Cố gắng phát media. Nếu có lỗi (độ dài <= 0), nó sẽ nhảy xuống block catch
                    ((Playable) media).play();

                    // Nếu không có lỗi, hiển thị dialog báo đang phát (đoạn code cũ của bạn)
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Media Player");
                    dialog.setSize(400, 300);
                    dialog.setLayout(new BorderLayout());
                    JLabel playLabel = new JLabel("Now playing: " + media.getTitle());
                    playLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    playLabel.setFont(new Font(playLabel.getFont().getName(), Font.BOLD, 24));
                    playLabel.setForeground(Color.BLUE);
                    dialog.add(playLabel, BorderLayout.CENTER);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);

                } catch (PlayerException ex) {
                    // Bắt lỗi và hiển thị bảng thông báo lỗi cho người dùng
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Illegal DVD Length",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
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
