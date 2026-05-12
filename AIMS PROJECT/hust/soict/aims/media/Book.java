package hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<String> authors = new ArrayList<String>();

    public Book(){
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
}
