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

package domain.notes.usecase;

import android.text.TextUtils;

import domain.notes.entities.NoteCollection;
import domain.notes.entities.NoteCollection.CollectionType;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class PutNoteCollection implements Usecase<NoteCollection> {

    private Realm realm;
    private NoteCollection noteCollection;

    public PutNoteCollection(Realm realm) {
        this.realm = realm;
    }

    public Observable<NoteCollection> executeWith(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
        return execute();
    }

    @Override
    public Observable<NoteCollection> execute() {
        return Observable.create(new Observable.OnSubscribe<NoteCollection>() {
            @Override
            public void call(Subscriber<? super NoteCollection> subscriber) {
                if (TextUtils.isEmpty(noteCollection.getLabel())) {
                    noteCollection.setLabel(CollectionType.Main.name());
                }

                realm.beginTransaction();
                NoteCollection result = realm.copyToRealmOrUpdate(noteCollection);
                realm.commitTransaction();

                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());
    }
}
