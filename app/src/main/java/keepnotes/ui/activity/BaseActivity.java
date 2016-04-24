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
package keepnotes.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import keepnotes.KeepNotesApplication;
import keepnotes.di.component.AppComponent;
import domain.notes.di.component.NotesDomainComponent;

import keepnotes.ui.viewmodel.BaseViewModel;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeSubscription = new CompositeSubscription();
    }

    protected abstract void initializeButterknife();
    protected abstract void initializeDatabinding();
    protected abstract void initializeDependencies();
    protected abstract BaseViewModel getViewModel();

    protected void registerSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getViewModel().onAttach();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getViewModel().onDetach();
    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeSubscription.unsubscribe();
    }

    public KeepNotesApplication getApp() {
        return ((KeepNotesApplication) getApplication());
    }
}
