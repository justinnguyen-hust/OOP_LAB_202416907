package hust.soict.aims;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.Book;
import hust.soict.aims.media.CompactDisc;
import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;
import hust.soict.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo một số dữ liệu mẫu cho Store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f ));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new CompactDisc(1,"Greatest Hits", "Music", 15.99f, "Various Artists"));
        store.addMedia(new Book(2, "Effective Java", "Education", 45.00f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm enter

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng AIMS. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // ================== MAIN MENU ==================
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // ================== STORE MENU ==================
    public static void viewStore() {
        int choice;
        do {
            System.out.println("\n--- ITEMS IN STORE ---");
            store.printStore(); // Bạn cần viết thêm hàm này trong Store
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // See a media's details
                    System.out.print("Nhập tiêu đề Media muốn xem: ");
                    String titleDetails = scanner.nextLine();
                    Media mediaDetails = store.searchByTitle(titleDetails); // Cần thêm hàm searchByTitle trả về Media trong Store
                    if (mediaDetails != null) {
                        System.out.println(mediaDetails.toString());
                        mediaDetailsMenu(mediaDetails);
                    } else {
                        System.out.println("Không tìm thấy media này trong cửa hàng.");
                    }
                    break;
                case 2: // Add a media to cart
                    System.out.print("Nhập tiêu đề Media muốn thêm vào giỏ: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } else {
                        System.out.println("Không tìm thấy media này trong cửa hàng.");
                    }
                    break;
                case 3: // Play a media
                    System.out.print("Nhập tiêu đề Media muốn Play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("Sản phẩm này không hỗ trợ Play (Ví dụ: Sách).");
                        }
                    } else {
                        System.out.println("Không tìm thấy media này trong cửa hàng.");
                    }
                    break;
                case 4: // See current cart
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // ================== MEDIA DETAILS MENU ==================
    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("Sản phẩm này không hỗ trợ Play.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // ================== CART MENU ==================
    public static void seeCurrentCart() {
        int choice;
        do {
            cart.printList();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Filter medias in cart
                    System.out.println("1. Lọc theo ID | 2. Lọc theo Tiêu đề");
                    int filterChoice = scanner.nextInt(); scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Nhập ID: ");
                        int id = scanner.nextInt(); scanner.nextLine();
                        cart.searchById(id);
                    } else {
                        System.out.print("Nhập Tiêu đề: ");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title); // Hàm này hiện tại đang in ra kết quả
                    }
                    break;
                case 2: // Sort medias in cart
                    System.out.println("1. Sắp xếp theo Tiêu đề -> Giá | 2. Sắp xếp theo Giá -> Tiêu đề");
                    int sortChoice = scanner.nextInt(); scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost(); // Cần thêm hàm này vào Cart
                    } else {
                        cart.sortByCostTitle(); // Cần thêm hàm này vào Cart
                    }
                    break;
                case 3: // Remove media from cart
                    System.out.print("Nhập tiêu đề Media muốn xóa: ");
                    String titleRemove = scanner.nextLine();
                    Media mediaRemove = cart.searchMedia(titleRemove); // Cần hàm trả về Media thay vì chỉ in
                    if (mediaRemove != null) {
                        cart.removeMedia(mediaRemove);
                    } else {
                        System.out.println("Không tìm thấy trong giỏ hàng.");
                    }
                    break;
                case 4: // Play a media from cart
                    System.out.print("Nhập tiêu đề Media muốn Play: ");
                    String titleCartPlay = scanner.nextLine();
                    Media mediaCartPlay = cart.searchMedia(titleCartPlay);
                    if (mediaCartPlay != null) {
                        if (mediaCartPlay instanceof Playable) {
                            ((Playable) mediaCartPlay).play();
                        } else {
                            System.out.println("Sản phẩm này không hỗ trợ Play.");
                        }
                    } else {
                        System.out.println("Không tìm thấy trong giỏ hàng.");
                    }
                    break;
                case 5: // Place order
                    System.out.println("Đơn hàng của bạn đã được tạo thành công!");
                    cart.emptyCart(); // Cần thêm hàm làm sạch giỏ hàng vào Cart
                    choice = 0; // Quay lại menu chính sau khi đặt hàng
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ================== UPDATE STORE ==================
    public static void updateStore() {
        System.out.println("1. Thêm Media vào cửa hàng | 2. Xóa Media khỏi cửa hàng");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Tính năng thêm mới Media đang được xây dựng (Cần hỏi loại Media, Title, Cost...)...");
            // Để đơn giản, phần này bạn có thể tự thiết kế thêm logic nhập liệu tạo Book/CD/DVD
        } else if (choice == 2) {
            System.out.print("Nhập tiêu đề Media muốn xóa khỏi cửa hàng: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
            } else {
                System.out.println("Không tìm thấy!");
            }
        }
    }

    public static Cart getCart() {
        return cart;
    }
}