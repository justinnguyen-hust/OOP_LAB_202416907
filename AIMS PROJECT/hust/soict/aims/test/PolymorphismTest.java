package hust.soict.aims.test;

import hust.soict.aims.media.Book;
import hust.soict.aims.media.CompactDisc;
import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các đối tượng cụ thể
        CompactDisc cd = new CompactDisc(1, "Greatest Hits", "Music", 15.99f, "Various Artists");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-Fi","Wachowskis", 136, 19.99f);
        Book book = new Book(3, "Effective Java", "Education", 45.00f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
