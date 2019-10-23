package lru;

public class LruResponse {
    private int cacheHit;
    private boolean cacheFull;
    private String image;

    public LruResponse(int _cacheHit, boolean _cacheFull, String _image) {
        cacheFull = _cacheFull;
        cacheHit = _cacheHit;
        image = _image;
    }
    public boolean isCacheFull() {
        return cacheFull;
    }

    public int getCacheHit() {
        return cacheHit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCacheFull(boolean cacheFull) {
        this.cacheFull = cacheFull;
    }

    public void setCacheHit(int cacheHit) {
        this.cacheHit = cacheHit;
    }
}
