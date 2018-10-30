package com.web.resourceserver.model.utils;

import com.web.resourceserver.model.utils.pattern.LastModification;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author Prometej
 */
public class StaticFunction {

    /**
     * @author Prometej
     */
    public static Long getResourceLastModified(Timestamp timestamp) {
        return timestamp.toInstant().toEpochMilli();
    }

    /**
     * @author Prometej
     */
    public static String getResourceLastModifiedCounts(LastModification lastModification, Integer count) {
        return "date:" + lastModification.getLastModified().toInstant().toEpochMilli() + "id:" + lastModification.getId() + "count:" + (count);
    }

    /**
     * @author Prometej
     */
    public static String getResourceLastModifiedCountsList(List<? extends LastModification> lastModification, Integer count) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < lastModification.size(); i++) {
            stringBuffer.append(getResourceLastModifiedCounts(lastModification.get(i), count));
        }
        return new String(Base64.getEncoder().encode(stringBuffer.toString().getBytes()));
    }

    /**
     * @author Prometej
     */
    public static Long getResourceLastModified(LastModification lastModification) {
        return getResourceLastModified(lastModification.getLastModified());
    }

    /**
     * @author Prometej
     */
    public static List<Long> getResourceLastModified(List<Timestamp> timestamp) {
        return timestamp.stream().map(StaticFunction::getResourceLastModified).collect(toList());
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModified(Long aLong, WebRequest webRequest) {
        return webRequest.checkNotModified(aLong);
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModified(List<Long> longs, WebRequest webRequest) {
        return longs.stream().filter(aLong -> !checkResourceLastModified(aLong, webRequest)).count() == 0;
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModifieds(List<? extends LastModification> lastModifications, WebRequest webRequest) {
        return lastModifications.stream().filter(lastModification -> !checkResourceLastModified(lastModification, webRequest)).count() == 0;
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModifiedsCount(List<? extends LastModification> lastModifications, WebRequest webRequest) {
        return lastModifications.stream().filter(lastModification -> !checkResourceLastModifiedCounts(lastModification, webRequest, lastModifications.size())).count() == 0;
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModified(LastModification lastModification, WebRequest webRequest) {
        return checkResourceLastModified(getResourceLastModified(lastModification.getLastModified()), webRequest);
    }

    /**
     * @author Prometej
     */
    public static Boolean checkResourceLastModifiedCounts(LastModification lastModification, WebRequest webRequest, Integer count) {
        return webRequest.checkNotModified(getResourceLastModifiedCounts(lastModification, count));
    }

    /**
     * @author Prometej
     */
    public static  Boolean  checkResourceLastModifiedCountsList(List<? extends LastModification> lastModification, WebRequest webRequest) {
        return webRequest.checkNotModified(getResourceLastModifiedCountsList(lastModification, lastModification.size()));
    }

    /**
     * @author Prometej
     */
    public static ResponseEntity getResponseEntityWithLastMod(WebRequest webRequest, List<? extends LastModification> actives) {
        if (checkResourceLastModifieds(actives, webRequest)) {
            System.out.println("caches getResponseEntityWithLastMod");
            return ResponseEntity.ok().build();
        } else {
            if (actives.size() > 0)
                return ResponseEntity.ok().lastModified(getResourceLastModified(actives.get(0).getLastModified())).body(actives);
            else
                return ResponseEntity.ok(new ArrayList<>());
        }
    }

    /**
     * @author Prometej
     */
    public static ResponseEntity<List<? extends LastModification>> getResponseEntityWithLastModCount(WebRequest webRequest, List<? extends LastModification> actives) {
        if (checkResourceLastModifiedCountsList(actives, webRequest)) {
            System.out.println("caches getResponseEntityWithLastModCount");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } else {
            if (actives.size() > 0) {
                System.out.println(getResourceLastModifiedCountsList(actives, actives.size()));
                return ResponseEntity.status(HttpStatus.OK).eTag(getResourceLastModifiedCountsList(actives, actives.size())).body(actives);
            } else
                return ResponseEntity.ok(new ArrayList<>());
        }
    }

    /**
     * @author Prometej
     */
    public static <T extends LastModification,Z extends LastModification> ResponseEntity<List<? extends LastModification<Z>>> getResponseEntityWithLastModCount(WebRequest webRequest, List<? extends LastModification<T>> actives, Function<List<T>,List<? extends LastModification<Z>>> func) {
        if (checkResourceLastModifiedCountsList(actives, webRequest)) {
            System.out.println("caches getResponseEntityWithLastModCount");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } else {
            if (actives.size() > 0) {
                System.out.println(getResourceLastModifiedCountsList(actives, actives.size()));
                return ResponseEntity.status(HttpStatus.OK).eTag(getResourceLastModifiedCountsList(actives, actives.size())).body(func.apply((List<T>) actives));
            } else
                return ResponseEntity.ok(new ArrayList<>());
        }
    }   /**
     * @author Prometej
     */
    public static <T extends LastModification,Z extends LastModification> ResponseEntity<Page<? extends LastModification<Z>>> getResponseEntityWithLastModCount(WebRequest webRequest, Page<? extends LastModification<T>> actives, Page<? extends LastModification<Z>> pageret) {
        if (checkResourceLastModifiedCountsList(actives.getContent(), webRequest)) {
            System.out.println("caches getResponseEntityWithLastModCount");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } else {
            if (actives.getSize() > 0) {
                System.out.println(getResourceLastModifiedCountsList(actives.getContent(), actives.getContent().size()));
                return ResponseEntity.status(HttpStatus.OK).eTag(getResourceLastModifiedCountsList(actives.getContent(), actives.getContent().size())).body(pageret);
            } else
                return ResponseEntity.noContent().build();
        }
    }
}
