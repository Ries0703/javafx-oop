package hust.soict.globalict.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
        setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        setDirector(director);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0,title, category, cost, length, director);
    }

    public boolean isMatch(String title) {
        return title.equalsIgnoreCase(getTitle());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}
