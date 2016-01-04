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

package org.keepnotes.ui.activity;

import android.os.Bundle;

import org.keepnotes.R;
import org.keepnotes.di.AppComponent;
import org.keepnotes.di.NoteCollectionUIModule;
import org.keepnotes.di.NoteCollectionUIComponent;
import org.keepnotes.domain.notes.di.NoteCollectionComponent;
import org.keepnotes.domain.notes.di.NoteCollectionModule;
import org.keepnotes.domain.notes.di.NotesDomainComponent;
import org.keepnotes.domain.notes.entities.NoteCollection;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by krajeswaran on 2/1/16.
 */
public class NoteCollectionActivity extends BaseActivity {
    @Inject
    NoteCollection noteCollection;
    @Inject
    NoteCollectionComponent noteCollectionComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_collection);
    }

    @Override
    protected void initializeButterknife() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initializeDatabinding() {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void initializeDependencies(AppComponent component, NotesDomainComponent notesDomainComponent) {
        noteCollectionComponent = notesDomainComponent.plus(new NoteCollectionModule(new NoteCollection()));
//        noteCollectionComponent.inject(noteCollection);

        NoteCollectionUIComponent uiComponent = component.plus(new NoteCollectionUIModule(this));
        // TODO do something with uiComponent, get viewmodel/presenter
    }
}
