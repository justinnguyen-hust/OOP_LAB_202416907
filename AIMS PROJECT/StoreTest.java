public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);

        DigitalVideoDisc[] dvdList = {dvd3};
        store.addDVD(dvdList);

        store.removeDVD(dvd2);

        //Test loi
        store.removeDVD(dvd2);

        // Test thêm nhiều phần tử
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Batman");

        DigitalVideoDisc[] moreDVDs = {dvd4, dvd5};
        store.addDVD(moreDVDs);
    }
}