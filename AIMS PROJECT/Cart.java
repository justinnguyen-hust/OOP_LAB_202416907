import java.sql.SQLOutput;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is already full.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc " + disc.getTitle() + " has been added.");
        if(qtyOrdered == MAX_NUMBERS_ORDERED) System.out.println("The cart is full.");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc((dvd2));
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is full. Stop adding.");
                break;
            }
            addDigitalVideoDisc(disc);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i].equals(disc)){
                for(int j = i+1; j < qtyOrdered; j++){
                    itemsOrdered[j-1] = itemsOrdered[j];
                }
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }
    public float totalCost(){
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void printList(){
        System.out.println("****************************CART*************************");
        System.out.println("Ordered Items:");
        for(int i = 0; i < qtyOrdered; i++){
            System.out.printf("%d. %s\n", i+1, itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f\n", this.totalCost());
        System.out.println("*****************************************************");
    }

    public void searchByTitle(String title){
        boolean isFound = false;

        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i].isMatch(title)){
                System.out.println(itemsOrdered[i]);
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("Not found");
        }
    }


}