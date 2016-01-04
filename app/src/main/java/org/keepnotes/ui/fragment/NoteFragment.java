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

package org.keepnotes.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.keepnotes.KeepNotesApplication;
import org.keepnotes.R;
import org.keepnotes.di.AppComponent;
import org.keepnotes.di.NoteUIComponent;
import org.keepnotes.di.NoteUIModule;
import org.keepnotes.domain.notes.di.NoteComponent;
import org.keepnotes.domain.notes.di.NoteModule;
import org.keepnotes.domain.notes.entities.Note;

import javax.inject.Inject;

/**
 * Created by krajeswaran on 5/1/16.
 */
public class NoteFragment extends BaseFragment {

    @Inject
    Note note;

    KeepNotesApplication app;
    private NoteComponent noteComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_note;
    }

    @Override
    protected void injectDependencies(Context context) {
        app = ((KeepNotesApplication) getActivity().getApplication());
        noteComponent = app.getNotesDomainComponent().plus(new NoteModule(new Note()));
//        noteComponent.inject(note);
//        noteComponent.getNote("blah").execute().subscribeOn()

        NoteUIComponent uiComponent = app.getAppComponent().plus(new NoteUIModule(context));
        // TODO do something with uiComponent
    }

    @Override
    protected void setupDatabinding() {
    }
}
