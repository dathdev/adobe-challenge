package lru;

public class CachedImage {
    private Coordinate coordinate;
    private String image;
    private int hitCounter;

    public CachedImage(Coordinate _coordinate, String _image) {
        hitCounter = 0;
        coordinate = _coordinate;
        image = _image;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getImage() {
        return image;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void hit() {
        hitCounter++;
    }

    public void reset() {
        hitCounter = 0;
    }

    public int getHitCounter() {
        return hitCounter;
    }
}
