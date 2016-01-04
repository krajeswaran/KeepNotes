/*
 * Copyright (c) $year  Kumaresan Rajeswaran
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.keepnotes.domain.notes.usecase;

import org.keepnotes.domain.notes.entities.NoteCollection;

import javax.inject.Inject;
import javax.security.auth.callback.Callback;

import io.realm.Realm;
import io.realm.RealmQuery;
import rx.Observable;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class GetNoteCollection implements Usecase<NoteCollection> {
    @Inject
    Realm realm;
    private String collectionLabel;

    @Inject
    public GetNoteCollection(NoteCollection noteCollection) {
        this.collectionLabel = noteCollection.getLabel();
    }

    @Override
    public Observable<NoteCollection> execute() {
        RealmQuery<NoteCollection> query = realm.where(NoteCollection.class).equalTo("label", collectionLabel);

        NoteCollection results = query.findFirstAsync();
        if (results == null) {
            final NoteCollection newCollection = new NoteCollection();
            newCollection.setLabel(NoteCollection.CollectionType.Main.name());
            realm.executeTransaction(realm1 -> {
                // create an empty collection and return it
                realm1.copyToRealm(newCollection);
            });
            return newCollection.asObservable();
        }
        return results.asObservable();
    }
}
