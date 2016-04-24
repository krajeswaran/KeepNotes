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

package domain.notes.di.module;


import domain.notes.di.scope.PerApp;
import domain.notes.network.RestDataSource;
import domain.notes.usecase.GetNoteCollection;
import domain.notes.usecase.PutNoteCollection;
import domain.notes.usecase.SyncNoteCollection;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by krajeswaran on 30/12/15.
 */
@Module
public class NoteCollectionModule {
    @PerApp @Provides
    public GetNoteCollection provideGetNoteCollection(Realm realm) {
        return new GetNoteCollection(realm);
    }

    @PerApp @Provides
    public PutNoteCollection providePutNoteCollection(Realm realm) {
        return new PutNoteCollection(realm);
    }

    @PerApp @Provides
    public SyncNoteCollection provideSyncNoteCollection(RestDataSource dataSource, Realm realm) {
        return new SyncNoteCollection(realm, dataSource);
    }
}
