package lru;

public class Coordinate {
    private float Lat;
    private float Long;

    public Coordinate(float lat, float aLong) {
        Lat = lat;
        Long = aLong;
    }

    public float getLat() {
        return Lat;
    }

    public float getLong() {
        return Long;
    }

    public void setLat(float lat) {
        Lat = lat;
    }

    public void setLong(float aLong) {
        Long = aLong;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coordinate))
            return false;
        return Float.compare(Lat, ((Coordinate)o).getLat()) == 0 && Float.compare(Long, ((Coordinate)o).getLong()) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (Lat*31 + Long);
    }
}
