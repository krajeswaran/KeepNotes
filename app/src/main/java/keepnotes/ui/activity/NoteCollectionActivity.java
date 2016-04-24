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

package keepnotes.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import keepnotes.KeepNotesApplication;
import keepnotes.R;
import keepnotes.di.component.AppComponent;
import domain.notes.di.component.NotesDomainComponent;
import domain.notes.entities.Note;
import keepnotes.di.component.DaggerUiInjectorComponent;
import keepnotes.di.component.UiInjectorComponent;
import keepnotes.di.module.UiViewModelModule;
import keepnotes.ui.NoteItemClickListener;
import keepnotes.ui.adapter.NoteCollectionViewAdapter;
import keepnotes.ui.fragment.NoteFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import keepnotes.ui.viewmodel.NoteCollectionViewModel;

/**
 * Created by krajeswaran on 2/1/16.
 */
public class NoteCollectionActivity extends BaseActivity implements NoteItemClickListener {

    @Nullable @Bind(R.id.v_note_collection)
    RecyclerView noteCollectionView;
    StaggeredGridLayoutManager layoutManager;
    NoteCollectionViewAdapter adapter;

    @Inject NoteCollectionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_collection);

        initializeButterknife();

        setupRecyclerView();

        initializeDependencies();
    }

    private void setupRecyclerView() {
        adapter = new NoteCollectionViewAdapter(this);
        noteCollectionView.setAdapter(adapter);
        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        noteCollectionView.setLayoutManager(layoutManager);
        noteCollectionView.setHasFixedSize(true);
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
    protected void initializeDependencies() {
        UiInjectorComponent component = DaggerUiInjectorComponent.builder()
                .notesDomainComponent(getApp().getNotesDomainComponent())
                .uiViewModelModule(new UiViewModelModule())
                .build();
        component.inject(this);
        component.inject(adapter);
        component.inject(viewModel);
    }

    @Override
    protected NoteCollectionViewModel getViewModel() {
        if (viewModel == null) {
            initializeDependencies();
        }

        return viewModel;
    }

    // TODO move to view-model
    // You will also need to delegate back to the Activity for framework-specific things that require the Activity Context. (Which is a lot!) You could inject interface implementations into your ViewModels or set the Activity/Fragment as a listener on your ViewModel, or just use the ViewModel inside the fragment and call methods on it.
    @Override
    public void onItemClick(Note note) {

        NoteFragment fragment = NoteFragment.newInstance(note);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.f_note, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
