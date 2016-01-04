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

import org.keepnotes.domain.notes.entities.Note;
import org.keepnotes.domain.notes.network.RestDataSource;
import org.keepnotes.domain.notes.usecase.GetNote;
import org.keepnotes.domain.notes.usecase.PutNote;
import org.keepnotes.domain.notes.usecase.SyncNote;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by krajeswaran on 30/12/15.
 */
@Module
public class NoteModule {
    private Note note;

    @Inject
    public NoteModule(Note note) {
        this.note = note;
    }

    @Provides
    public GetNote provideGetNote() {
        return new GetNote(note);
    }

    @Provides
    public PutNote providePutNote() {
        return new PutNote(note);
    }

    @Provides
    public SyncNote provideSyncNote() {
        return new SyncNote(note);
    }
}
