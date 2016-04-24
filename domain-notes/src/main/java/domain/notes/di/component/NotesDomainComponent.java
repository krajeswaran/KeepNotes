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
package domain.notes.di.component;

import javax.inject.Singleton;

import domain.notes.di.module.NoteCollectionModule;
import domain.notes.di.module.NoteModule;
import domain.notes.di.module.NotesDomainModule;
import domain.notes.di.scope.PerApp;
import domain.notes.network.RestDataSource;
import domain.notes.usecase.GetNote;
import domain.notes.usecase.GetNoteCollection;
import domain.notes.usecase.PutNote;
import domain.notes.usecase.PutNoteCollection;
import domain.notes.usecase.SyncNote;
import domain.notes.usecase.SyncNoteCollection;

import dagger.Component;
import io.realm.Realm;

@PerApp
@Component(modules = {NotesDomainModule.class, NoteCollectionModule.class, NoteModule.class})
public interface NotesDomainComponent {
    // inject to local domain classes
//    // TODO inject by base usecase
//    void inject(GetNoteCollection getNoteCollection);
//    void inject(PutNoteCollection putNoteCollection);
//    void inject(SyncNoteCollection syncNoteCollection);
//    void inject(GetNote getNote);
//    void inject(PutNote putNote);
//    void inject(SyncNote syncNote);

    Realm provideRealm();
    RestDataSource provideDataSource();

    GetNoteCollection getNoteCollection();
    PutNoteCollection putNoteCollection();
    SyncNoteCollection syncNoteCollection();

    GetNote getNote();
    PutNote putNote();
    SyncNote syncNote();

//    NoteCollectionComponent plus(NoteCollectionModule module);
//    NoteComponent plus(NoteModule module);
}
