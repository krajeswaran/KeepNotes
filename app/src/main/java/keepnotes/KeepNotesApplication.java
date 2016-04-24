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
package keepnotes;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import keepnotes.di.component.AppComponent;
import keepnotes.di.module.AppModule;
import keepnotes.di.component.DaggerAppComponent;
import domain.notes.di.component.DaggerNotesDomainComponent;
import domain.notes.di.component.NotesDomainComponent;
import domain.notes.di.module.NotesDomainModule;

public class KeepNotesApplication extends Application {

    private AppComponent mAppComponent;
    private NotesDomainComponent mNotesDomainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjectors();
        LeakCanary.install(this);
    }

    private void initializeInjectors() {
        mNotesDomainComponent = DaggerNotesDomainComponent.builder()
                .notesDomainModule(new NotesDomainModule(this))
                .build();

        mAppComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this)).
                build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public NotesDomainComponent getNotesDomainComponent() {
        return mNotesDomainComponent;
    }
}
