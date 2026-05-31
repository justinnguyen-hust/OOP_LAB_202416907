package hust.soict.aims.cart;

import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media){
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Gio hang da day, khong the them san pham");
        }
        else if(itemsOrdered.contains(media)){
            System.out.println("San pham da co trong gio hang.");
        }
        else{
            itemsOrdered.add(media);
            System.out.println("Da them san pham vao gio hang.");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println("Da xoa san pham khoi gio hang.");
        }
        else{
            System.out.println("San pham khong ton tai trong gio hang.");
        }
    }

    public float totalCost(){
        float total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    public void printList(){
        System.out.println("****************************CART*************************");
        System.out.println("Ordered Items:");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.printf("%d. %s\n", i+1, itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f\n", this.totalCost());
        System.out.println("*****************************************************");
    }

    public void searchByTitle(String title){
        boolean isFound = false;

        // Dùng vòng lặp for-each cho gọn
        for(Media media : itemsOrdered){
            // Chuyển cả 2 chuỗi về chữ thường để tìm kiếm chính xác hơn
            if(media.getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.println(media.toString()); // Hoặc in ra thông tin bạn muốn
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("Not found");
        }
    }

    public void searchById(int id){
        boolean isFound = false;

        for(Media media : itemsOrdered){
            if(media.getId() == id){
                System.out.println(media.toString());
                isFound = true;
                return; // Nếu ID là duy nhất thì tìm thấy 1 cái là thoát luôn
            }
        }
        if(!isFound){
            System.out.println("Not found.");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tiêu đề -> Giá.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá -> Tiêu đề.");
    }
    // Hàm tìm kiếm và TRẢ VỀ Media trong giỏ hàng (để dùng cho chức năng Remove và Play trong cart)
    public Media searchMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return media;
            }
        }
        return null;
    }

    // Hàm dọn dẹp giỏ hàng khi người dùng chọn "Place order"
    public void emptyCart() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}