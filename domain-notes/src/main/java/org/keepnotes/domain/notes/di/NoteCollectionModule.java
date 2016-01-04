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

package org.keepnotes.domain.notes.di;

import org.keepnotes.domain.notes.entities.NoteCollection;
import org.keepnotes.domain.notes.network.RestDataSource;
import org.keepnotes.domain.notes.usecase.GetNoteCollection;
import org.keepnotes.domain.notes.usecase.PutNoteCollection;
import org.keepnotes.domain.notes.usecase.SyncNoteCollection;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by krajeswaran on 30/12/15.
 */
@Module
public class NoteCollectionModule {
    private NoteCollection noteCollection;

    @Inject
    public NoteCollectionModule(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Provides
    public GetNoteCollection provideGetNoteCollection() {
        return new GetNoteCollection(noteCollection);
    }

    @Provides
    public PutNoteCollection providePutNoteCollection() {
        return new PutNoteCollection(noteCollection);
    }

    @Provides
    public SyncNoteCollection provideSyncNoteCollection() {
        return new SyncNoteCollection(noteCollection);
    }
}
