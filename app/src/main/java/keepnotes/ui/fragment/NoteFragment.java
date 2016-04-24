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

package keepnotes.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import keepnotes.KeepNotesApplication;
import keepnotes.R;
import domain.notes.di.module.NoteModule;
import domain.notes.entities.Note;

import butterknife.Bind;

/**
 * Created by krajeswaran on 5/1/16.
 */
public class NoteFragment extends BaseFragment {

    Note mNote;

    KeepNotesApplication app;

    @Nullable @Bind(R.id.lv_note_content)
    ListView mNoteContentList;

    @Bind(R.id.et_note_title)
    EditText mEtNoteTitle;

    public static NoteFragment newInstance(Note note) {
        NoteFragment newFragment = new NoteFragment();
        newFragment.mNote = note;
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        mEtNoteTitle.setText(mNote.getTitle());

        if (!mNote.isCheckList()) {
            mNoteContentList.setAdapter(new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, mNote.getContent().split("\\n")));
        }

        return v;
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
//        noteComponent = app.getNotesDomainComponent().plus(new NoteModule(new Note()));
//        noteComponent.inject(mNote);
//        noteComponent.getNote("blah").execute().subscribeOn()

//        NoteUIComponent uiComponent = app.getAppComponent().plus(new NoteUIModule(context));
        // TODO do something with uiComponent
    }

    @Override
    protected void setupDatabinding() {
    }
}
