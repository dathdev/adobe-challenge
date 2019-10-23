package lru;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    @RequestMapping("/getImagesUrl")
    @ResponseStatus(HttpStatus.OK)
    public LruResponse getImagesUrl(@RequestParam(value = "Lat", defaultValue = "0") float Lat, @RequestParam(value = "Long", defaultValue = "0") float Long) {
        return LruCache.getInstance().getImagesUrl(Lat, Long);
    }

    @RequestMapping("/clearCache")
    @ResponseStatus(HttpStatus.OK)
    public String clearCache() {
        LruCache.getInstance().clearCache();
        return "Cache cleared!";
    }

    @RequestMapping("/clearHitCounter")
    @ResponseStatus(HttpStatus.OK)
    public String clearHitCounter() {
        LruCache.getInstance().clearHitCounter();
        return "Hit counter cleared!";
    }

    @RequestMapping("/getCache")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<Coordinate, CachedImage> getCache() {
        return LruCache.getInstance().getCache();
    }
}