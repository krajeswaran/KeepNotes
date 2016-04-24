package domain.notes.entities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Required;

/**
 * Created by krajeswaran on 23/12/15.
 */
public class NoteCollection extends RealmObject {
    private RealmList<Note> notes;
    @Required
    private String label;
    @Ignore
    private boolean isSingleColumnView;

    public enum CollectionType { Main, Archive, Trash }

    public RealmList<Note> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isSingleColumnView() {
        return isSingleColumnView;
    }

    public void setIsSingleColumnView(boolean isSingleColumnView) {
        this.isSingleColumnView = isSingleColumnView;
    }
}
