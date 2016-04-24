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

package domain.notes.usecase;

import android.util.Log;

import domain.notes.entities.NoteCollection;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import rx.Observable;
import rx.functions.Func1;

import static domain.notes.entities.NoteCollection.*;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class GetNoteCollection implements Usecase<NoteCollection> {
    private Realm realm;
    private String collectionLabel;
    private final String TAG = GetNoteCollection.class.getSimpleName();

    public GetNoteCollection(Realm realm) {
        this.realm = realm;
    }

    public Observable<NoteCollection> executeWith(CollectionType collectionType) {
        this.collectionLabel = collectionType.name();
        return execute();
    }

    @Override
    public Observable<NoteCollection> execute() {
        RealmQuery<NoteCollection> query = realm.where(NoteCollection.class).equalTo("label", collectionLabel);

        return  query.findFirstAsync()
                .<NoteCollection>asObservable()
                .switchIfEmpty(writeEmptyCollection());
    }

    private Observable<NoteCollection> writeEmptyCollection() {
        NoteCollection newCollection = new NoteCollection();
        newCollection.setLabel(CollectionType.Main.name());

        realm.beginTransaction();
        newCollection = realm.copyToRealm(newCollection);
        realm.commitTransaction();

        return newCollection.asObservable();
    }
}
