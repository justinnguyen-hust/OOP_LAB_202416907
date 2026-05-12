package hust.soict.aims.test;

import hust.soict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        //TODO Auto_generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderelle dvd title: " + cinderellaDVD.getTitle());
   //   changeTitle(jungleDVD, cinderellaDVD.getTitle());
     //System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        //Ham swap moi
        DVDWrapper w1 = new DVDWrapper(jungleDVD);
        DVDWrapper w2 = new DVDWrapper(cinderellaDVD);
        System.out.println("jungle dvd title: " + w1.disc.getTitle());
        System.out.println("cinderella dvd title: " + w2.disc.getTitle());
        swapper(w1, w2);
        System.out.println("after swap, jungle dvd title: " + w1.disc.getTitle());
        System.out.println("after swap, cinderella dvd title: " + w2.disc.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    static class DVDWrapper{
        DigitalVideoDisc disc;
        DVDWrapper(DigitalVideoDisc disc){
            this.disc = disc;
        }
    }
    public static void swapper(DVDWrapper w1, DVDWrapper w2){
        DigitalVideoDisc tmp = w1.disc;
        w1.disc = w2.disc;
        w2.disc = tmp;
    }
}

