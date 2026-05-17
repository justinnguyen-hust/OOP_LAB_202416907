package hust.soict.aims.test;

import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media; // Import thêm Media
// import hust.soict.aims.media.CompactDisc; // Thử bỏ comment dòng này nếu bạn muốn test thêm CD
import hust.soict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);

        Media[] mediaList = {dvd3};
        store.addMedia(mediaList);

        store.removeMedia(dvd2);

        store.removeMedia(dvd2);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Batman");

        Media[] moreMedia = {dvd4, dvd5};
        store.addMedia(moreMedia);
    }
}