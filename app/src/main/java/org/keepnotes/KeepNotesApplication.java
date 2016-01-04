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
package org.keepnotes;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import org.keepnotes.di.AppComponent;
import org.keepnotes.di.AppModule;
import org.keepnotes.di.DaggerAppComponent;
import org.keepnotes.domain.notes.di.DaggerNotesDomainComponent;
import org.keepnotes.domain.notes.di.NoteCollectionModule;
import org.keepnotes.domain.notes.di.NotesDomainComponent;
import org.keepnotes.domain.notes.di.NotesDomainModule;

public class KeepNotesApplication extends Application {

    private AppComponent appComponent;
    private NotesDomainComponent notesDomainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjectors();
        LeakCanary.install(this);
    }

    private void initializeInjectors() {
        notesDomainComponent = DaggerNotesDomainComponent.builder()
                .notesDomainModule(new NotesDomainModule(this))
                .build();

        appComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this)).
                notesDomainComponent(notesDomainComponent).
                build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public NotesDomainComponent getNotesDomainComponent() {
        return notesDomainComponent;
    }
}
