package hust.soict.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory(){
        return category;
    }
     public void setCategory(String category){
        this.category = category;
     }

     public float getCost(){
        return cost;
     }

     public void setCost(float cost){
        this.cost = cost;
     }

    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem có trỏ cùng vào một ô nhớ không
        if (this == obj) {
            return true;
        }

        // Sử dụng instanceof để kiểm tra NullPointerException (nếu obj null sẽ trả về false)
        // và ClassCastException (nếu obj không phải là Media thì cũng trả về false)
        if (!(obj instanceof Media)) {
            return false;
        }

        // Ép kiểu an toàn sau khi đã kiểm tra bằng instanceof
        Media otherMedia = (Media) obj;

        // Kiểm tra tiếp trường hợp Title bị null để tránh NullPointerException khi gọi hàm equals của String
        if (this.getTitle() != null && otherMedia.getTitle() != null) {
            return this.getTitle().equals(otherMedia.getTitle());
        }

        return false;
    }
}
