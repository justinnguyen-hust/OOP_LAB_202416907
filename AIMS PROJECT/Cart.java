public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("Cannot add \"" + disc.getTitle() + "\": The cart is already full.");
                break;
            }
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
}