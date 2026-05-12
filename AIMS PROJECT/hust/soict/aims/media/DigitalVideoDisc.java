package hust.soict.aims.media;

public class DigitalVideoDisc extends Disc {
    private String director;
    private int length;

    private static int nbDigitalVideoDiscs = 0;


    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }


    public DigitalVideoDisc(String title){
        super(++nbDigitalVideoDiscs, title, "", 0, 0, "");
    }
    public DigitalVideoDisc(String title, String category, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost, 0, "");
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }
    public String toString(){
        return String.format("DVD - %s - %s - %s - %d: %.2f$", getTitle(), getCategory(), director, length, getCost());
    }

    //Ham isMatch
    public boolean isMatch(String title) {
        if (title == null) return false;
        return getTitle().equalsIgnoreCase(title);
    }
}