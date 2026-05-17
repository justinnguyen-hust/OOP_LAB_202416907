package hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String artist){
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("Track da ton tai trong CD.");
        }
        else{
            tracks.add(track);
            System.out.println("Da them track vao CD.");
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Da xoa track khoi CD");
        }
        else {
            System.out.println("Track khong ton tai trong CD.");
        }
    }

    public int getLength(){
        int totalLength = 0;
        for(Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD Artist: " + this.getArtist());
        System.out.println("Total Cd length: " + this.getLength());

        for(Track track : tracks){
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getArtist() + " - "
                + this.getLength() + " mins: "
                + this.getCost() + " $";
    }
}
