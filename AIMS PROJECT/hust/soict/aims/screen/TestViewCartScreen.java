package hust.soict.aims.screen;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.DigitalVideoDisc;
// Import thêm Book, CompactDisc nếu bạn muốn test cả các loại này

public class TestViewCartScreen {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo một số mặt hàng mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Thêm mặt hàng vào giỏ
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // 3. Khởi tạo và hiển thị màn hình CartScreen
        new CartScreen(cart);
    }
}