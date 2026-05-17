package hust.soict.aims.store;

import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_STORED = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media){
        if (media == null) {
            System.out.println("Khong hop le");
            return;
        }

        if(itemsInStore.size() >= MAX_NUMBERS_STORED){
            System.out.println("Cua hang da day");
            return;
        }

        if(itemsInStore.contains(media)){
            System.out.println("San pham da ton tai trong cua hang.");
        }
        else{
            itemsInStore.add(media);
            System.out.println("San pham " + media.getTitle() + " da duoc them vao cua hang.");
            if(itemsInStore.size() == MAX_NUMBERS_STORED){
                System.out.println("Cua hang da day.");
            }
        }
    };

    public void addMedia(Media[] mediaList){
        for(Media media : mediaList){
            if(itemsInStore.size() >= MAX_NUMBERS_STORED){
                System.out.println("Cua hang da day, ngung them san pham moi.");
                break;
            }
            addMedia(media);
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("San pham " + media.getTitle() + " da duoc xoa khoi cua hang");
        }
        else{
        System.out.println("The disc is not in the store.");
        }
    }
}
