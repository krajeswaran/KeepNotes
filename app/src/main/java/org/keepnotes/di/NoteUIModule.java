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
package org.keepnotes.di;

import android.content.Context;

import org.keepnotes.domain.notes.di.NoteCollectionComponent;
import org.keepnotes.domain.notes.di.NoteComponent;
import org.keepnotes.domain.notes.di.NoteModule;
import org.keepnotes.domain.notes.di.PerActivity;
import org.keepnotes.ui.activity.NoteCollectionActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public final class NoteUIModule {

    private final Context context;

    public NoteUIModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideViewContext() {
        return context;
    }
}
