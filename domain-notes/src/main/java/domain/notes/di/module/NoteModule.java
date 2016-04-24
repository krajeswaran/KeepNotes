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
import domain.notes.usecase.GetNote;
import domain.notes.usecase.PutNote;
import domain.notes.usecase.SyncNote;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by krajeswaran on 30/12/15.
 */
@Module
public class NoteModule {
    @PerApp @Provides
    public GetNote provideGetNote(Realm realm) {
        return new GetNote(realm);
    }

    @PerApp @Provides
    public PutNote providePutNote(Realm realm) {
        return new PutNote(realm);
    }

    @PerApp @Provides
    public SyncNote provideSyncNote(Realm realm, RestDataSource dataSource) {
        return new SyncNote(dataSource, realm);
    }
}
