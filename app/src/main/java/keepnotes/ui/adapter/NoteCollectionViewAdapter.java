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

package keepnotes.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keepnotes.R;
import domain.notes.entities.Note;
import domain.notes.entities.NoteCollection;
import domain.notes.usecase.GetNoteCollection;
import keepnotes.ui.NoteItemClickListener;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import keepnotes.ui.activity.BaseActivity;
import keepnotes.ui.activity.NoteCollectionActivity;
import keepnotes.ui.viewmodel.BaseViewModel;
import keepnotes.ui.viewmodel.NoteCollectionViewModel;
import rx.android.schedulers.AndroidSchedulers;

import static domain.notes.entities.NoteCollection.*;

/**
 * Created by krajeswaran on 5/1/16.
 */
public class NoteCollectionViewAdapter extends RecyclerView.Adapter<NoteCollectionViewAdapter.ViewHolder> {

    private NoteCollection mNoteCollection;
    private NoteItemClickListener mItemClickListener;

    @Inject
    GetNoteCollection mGetNoteCollection; // TODO should be from viewmodel
    @Inject
    NoteCollectionViewModel mViewModel;

    public NoteCollectionViewAdapter(NoteItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_note, parent, false);

        return new ViewHolder(v, mItemClickListener, mNoteCollection);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindNote(mNoteCollection.getNotes().get(position));
    }

    @Override
    public int getItemCount() {
        if (mNoteCollection == null) {
            mGetNoteCollection.executeWith(CollectionType.Main)
                    .subscribe(noteCollection -> {
                        mNoteCollection = noteCollection;
                    });
            return 0;
        }
        return mNoteCollection.isLoaded() && mNoteCollection.getNotes().isValid()? mNoteCollection.getNotes().size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final NoteCollection mNoteCollection;

        @Nullable @Bind(R.id.tv_note_title)
        TextView mNoteTitle;
        @Nullable @Bind(R.id.tv_note_content)
        TextView mNoteContent;

        public ViewHolder(View v, NoteItemClickListener clickListener, NoteCollection noteCollection) {
            super(v);
            ButterKnife.bind(this, v);
            this.mNoteCollection = noteCollection;
            bindClickListener(v, clickListener);
        }

        public void bindNote(Note note) {
            mNoteTitle.setText(note.getTitle());
            mNoteContent.setText(note.getContent());
        }

        private void bindClickListener(View v, NoteItemClickListener clickListener) {
            v.setOnClickListener(v1 -> {
                Note item = mNoteCollection.getNotes().get(getAdapterPosition());
                clickListener.onItemClick(item);
            });
        }
    }
}
