package hust.soict.aims.screen; // Đổi lại theo package của bạn

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import hust.soict.aims.media.Playable;

import javafx.event.ActionEvent;

import javafx.collections.transformation.FilteredList;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        // Khởi tạo FilteredList bọc lấy ObservableList của giỏ hàng
        FilteredList<Media> filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        // Bắt sự kiện mỗi khi người dùng gõ phím vào ô TextField
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filteredData.setPredicate(media -> {
                    // Nếu ô tìm kiếm trống, hiển thị lại toàn bộ danh sách
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    // Kiểm tra xem người dùng đang chọn lọc theo tiêu chí nào
                    if (radioBtnFilterTitle.isSelected()) {
                        return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                    } else if (radioBtnFilterId.isSelected()) {
                        // Giả sử class Media của bạn có thuộc tính ID và hàm getId()
                        return String.valueOf(media.getId()).contains(lowerCaseFilter);
                    }
                    return false;
                });
            }
        });

        // Cập nhật tổng tiền ngay khi mở màn hình
        updateTotalCost();

        // Mặc định ban đầu ẩn 2 nút này đi (vì chưa chọn gì cả)
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Thêm Listener để lắng nghe sự kiện chọn hàng trong bảng tblMedia
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            // Gọi hàm cập nhật trạng thái nút bấm mỗi khi chọn 1 đối tượng mới
                            updateButtonBar(newValue);
                        }
                    }
                }
        );
    }
    void updateButtonBar(Media media) {
        // Đã chọn một sản phẩm thì chắc chắn cho phép Xóa
        btnRemove.setVisible(true);

        // Kiểm tra xem sản phẩm này có implements interface Playable không?
        if (media instanceof Playable) {
            btnPlay.setVisible(true); // Có thì hiện nút Play
        } else {
            btnPlay.setVisible(false); // Không thì ẩn nút Play đi (Ví dụ: Book)
        }
    }

    // Nút Remove: Xóa mặt hàng khỏi giỏ
    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Lấy ra mặt hàng đang được chọn trong bảng
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        // Gọi hàm xóa của lớp Cart
        // (Vì itemsOrdered là ObservableList, khi xóa xong bảng TableView sẽ tự động cập nhật!)
        cart.removeMedia(media);
        updateTotalCost();
    }

    // Nút Play: Bật pop-up thông báo phát Media
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        // Tạo một cửa sổ thông báo (Alert) của JavaFX
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Media Player");
        alert.setHeaderText("Now playing...");
        alert.setContentText("Playing: " + media.getTitle() + "\nCategory: " + media.getCategory());

        // Hiển thị cửa sổ và chờ người dùng bấm OK
        alert.showAndWait();
    }

    // Hàm cập nhật nhãn hiển thị tổng tiền
    public void updateTotalCost() {
        // Giả định lớp Cart của bạn có phương thức totalCost() tính tổng giá
        lblCost.setText(cart.totalCost() + " $");
    }

    // Sự kiện khi bấm nút Place Order
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Hiện thông báo chốt đơn
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Notification");
        alert.setHeaderText("Order Placed Successfully!");
        alert.setContentText("Total amount: " + cart.totalCost() + " $\nYour cart has been cleared.");
        alert.showAndWait();

        // Xóa sạch giỏ hàng và cập nhật lại số tiền về 0
        cart.getItemsOrdered().clear();
        updateTotalCost();
    }
}