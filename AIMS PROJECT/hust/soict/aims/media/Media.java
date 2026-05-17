package hust.soict.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

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
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.getTitle());
    }
}
