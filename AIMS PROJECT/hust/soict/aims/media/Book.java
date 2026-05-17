package hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors){
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else{
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
        else{
            System.out.println("Author '" + authorName + "' not found in the list.");
        }
    }

    public List<String> getAuthor(){
        return authors;
    }
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - "
                + String.join(", ", authors) + " - "
                + this.getCategory() + ": "
                + this.getCost() + " $";
    }
}
