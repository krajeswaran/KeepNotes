/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keepnotes.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import org.keepnotes.KeepNotesApplication;
import org.keepnotes.di.AppComponent;
import org.keepnotes.domain.notes.di.NotesDomainComponent;

import rx.subscriptions.CompositeSubscription;

import java.util.List;

import javax.inject.Inject;

/**
 * Base activity created to be extended by every activity in this application. This class provides
 * dependency injection configuration, ButterKnife Android library configuration and some methods
 * common to every activity.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class BaseActivity extends AppCompatActivity {

    private CompositeSubscription compositeSubscription = new CompositeSubscription();
    @Inject KeepNotesApplication app;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeButterknife();
        initializeDatabinding();
        initializeDependencies(getApp().getAppComponent(), getApp().getNotesDomainComponent());
//        GetNote get = new GetNote();
//        compositeSubscription.add(get.execute().subscribe();
    }

    protected abstract void initializeButterknife();
    protected abstract void initializeDatabinding();
    protected abstract void initializeDependencies(AppComponent component, NotesDomainComponent notesDomainComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeSubscription.unsubscribe();
    }

    public KeepNotesApplication getApp() {
        return ((KeepNotesApplication) getApplication());
    }
}
