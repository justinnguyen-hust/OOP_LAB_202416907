public class Aims {
    public static void main(String[] args) {
        //Tao object cart
        Cart anOrder = new Cart();

        //Tao doi tuong dvd moi, them vao cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 97, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //Test tinh nang
        anOrder.printList();
        anOrder.searchByTitle("Star wars");
        anOrder.searchByTitle("Khanh Duy");
        anOrder.searchByID(1);
        anOrder.searchByID(4);
    }
}