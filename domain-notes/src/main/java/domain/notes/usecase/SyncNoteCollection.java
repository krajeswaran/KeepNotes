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

import domain.notes.entities.NoteCollection;
import domain.notes.network.RestDataSource;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import rx.Observable;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class SyncNoteCollection implements Usecase<NoteCollection> {
    private Realm realm;
    private RestDataSource dataSource;
    private NoteCollection noteCollection;

    public SyncNoteCollection(Realm realm, RestDataSource dataSource) {
        this.realm = realm;
        this.dataSource = dataSource;
    }

    public Observable<NoteCollection> executeWith(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
        return execute();
    }

    @Override
    public Observable<NoteCollection> execute() {
        RealmQuery<NoteCollection> query = realm.where(NoteCollection.class);

        return query.findAll().first().asObservable();
        // TODO Add user module
        // query.equalTo("creator", User.id);
    }
}
