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

package keepnotes.ui.viewmodel;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;

import javax.inject.Inject;

import domain.notes.entities.Note;
import domain.notes.usecase.GetNote;
import domain.notes.usecase.GetNoteCollection;
import domain.notes.usecase.PutNote;
import domain.notes.usecase.PutNoteCollection;
import domain.notes.usecase.SyncNote;
import domain.notes.usecase.SyncNoteCollection;
import keepnotes.KeepNotesApplication;
import keepnotes.R;
import keepnotes.ui.NoteItemClickListener;
import keepnotes.ui.fragment.NoteFragment;

/**
 * Created by krajeswaran on 8/1/16.
 */
public class NoteCollectionViewModel extends BaseViewModel {
    @Inject
    GetNoteCollection getNoteCollection;
    @Inject
    PutNoteCollection putNoteCollection;
    @Inject
    SyncNoteCollection syncNoteCollection;
    @Inject
    GetNote getNote;
    @Inject
    PutNote putNote;
    @Inject
    SyncNote syncNote;


    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }

}
