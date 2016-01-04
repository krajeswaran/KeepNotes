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

package org.keepnotes.domain.notes.usecase;

import org.keepnotes.domain.notes.entities.Note;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by krajeswaran on 26/12/15.
 */
public class PutNote implements Usecase<Note> {

    @Inject
    Realm realm;
    Note note;

    @Inject
    public PutNote(Note note) {
        this.note = note;
    }

    @Override
    public Observable<Note> execute() {
        return Observable.create(new Observable.OnSubscribe<Note>() {
            @Override
            public void call(Subscriber<? super Note> subscriber) {
                realm.beginTransaction();
                Note result = realm.copyToRealmOrUpdate(note);
                realm.commitTransaction();

                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());
    }
}
