package domain.notes.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by krajeswaran on 22/12/15.
 */
public class Note extends RealmObject {
    @PrimaryKey
    private String id;

    private String title;
    private String content;
    private int color;
    private boolean isCheckList;
    private long timeSynced;
    private long timeUpdated;

//    private List<Bitmap> images;
//    private  List<String> labels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isCheckList() {
        return isCheckList;
    }

    public void setIsCheckList(boolean isCheckList) {
        this.isCheckList = isCheckList;
    }

    public long getTimeSynced() {
        return timeSynced;
    }

    public void setTimeSynced(long timeSynced) {
        this.timeSynced = timeSynced;
    }

    public long getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(long timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}
