package lru;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.HashMap;
import java.util.Queue;

public class LruCache {
    private static final int CACHE_SIZE = 3000;
    private static LruCache singleInstance = null;
    private Queue<CachedImage> cachedImages;
    private HashMap<Coordinate, CachedImage> hashMap;

    private LruCache() {
        cachedImages = new CircularFifoQueue<>(CACHE_SIZE);
        hashMap = new HashMap<>();
    }

    public static LruCache getInstance() {
        if (singleInstance == null)
            singleInstance = new LruCache();
        return singleInstance;
    }

    public void clearCache() {
        cachedImages = new CircularFifoQueue<>(CACHE_SIZE);
        hashMap.clear();
    }

    public void clearHitCounter() {
        hashMap.forEach((key, value) -> hashMap.get(key).reset());
    }

    public HashMap<Coordinate, CachedImage> getCache() {
        return hashMap;
    }

    public LruResponse getImagesUrl(float Lat, float Long) {
        Coordinate requested = new Coordinate(Lat, Long);
        if (hashMap.containsKey(requested)) {
            hashMap.get(requested).hit();
            return new LruResponse(hashMap.get(requested).getHitCounter(), cachedImages.size() == 3000, hashMap.get(requested).getImage());
        } else {
            CachedImage newImage = new CachedImage(requested, Helper.GetImageURL(requested));
            boolean isCacheFull = cachedImages.size() == CACHE_SIZE;
            if (isCacheFull) {
                hashMap.remove(cachedImages.peek().getCoordinate());
            }
            cachedImages.offer(newImage);
            hashMap.put(newImage.getCoordinate(), newImage);
            return new LruResponse(0, isCacheFull, newImage.getImage());
        }
    }
}
