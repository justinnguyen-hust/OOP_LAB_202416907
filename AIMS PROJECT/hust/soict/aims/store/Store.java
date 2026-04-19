package hust.soict.aims.store;

import hust.soict.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_STORED = 1000;
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_STORED];
    private int qtyStore = 0;

    public void addDVD(DigitalVideoDisc disc){
        if (disc == null) {
            System.out.println("Invalid disc.");
            return;
        }

        if(qtyStore >= MAX_NUMBERS_STORED){
            System.out.println("The store is full.");
            return;
        }

        itemsInStore[qtyStore] = disc;
        qtyStore++;
        System.out.println("The disc " + disc.getTitle() + " has been added.");
        if(qtyStore == MAX_NUMBERS_STORED) System.out.println("The store is full.");
    };

    public void addDVD(DigitalVideoDisc[] discList){
        for(DigitalVideoDisc disc : discList){
            if (qtyStore >= MAX_NUMBERS_STORED){
                System.out.println("hust.soict.aims.store.Store is full, Stop adding");
                break;
            }
            addDVD(disc);
        }
    }
    public void removeDVD(DigitalVideoDisc disc){
        for(int i = 0; i < qtyStore; i++){
            if(itemsInStore[i] == disc){
                for(int j = i+1; j < qtyStore; j++){
                    itemsInStore[j-1] = itemsInStore[j];
                }
                qtyStore--;
                itemsInStore[qtyStore] = null;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the store.");
    }
}
