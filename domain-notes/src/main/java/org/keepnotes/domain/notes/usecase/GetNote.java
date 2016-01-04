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

import org.keepnotes.domain.notes.entities.Note;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import rx.Observable;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class GetNote implements Usecase<Note> {

    @Inject
    Realm realm;
    String noteId;

    @Inject
    public GetNote(Note note) {
        this.noteId = note.getId();
    }

    @Override
    public Observable<Note> execute() {
        RealmQuery<Note> query = realm.where(Note.class)
                                            .equalTo("id", noteId);

        return query.findAllAsync().first().asObservable();
    }
}
