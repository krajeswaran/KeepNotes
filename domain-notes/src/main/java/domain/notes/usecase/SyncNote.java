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

import domain.notes.entities.Note;
import domain.notes.network.RestDataSource;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class SyncNote implements Usecase<Note> {

    private RestDataSource dataSource;
    private Realm realm;
    private Note note;

    public SyncNote(RestDataSource dataSource, Realm realm) {
        this.dataSource = dataSource;
        this.realm = realm;
    }

    public Observable<Note> executeWith(Note note) {
        this.note = note;
        return execute();
    }

    @Override
    public Observable<Note> execute() {
        // compare timestamps
        // if time synched > time updated, save it to realm
        // else put to parse
        return null;
    }
}
