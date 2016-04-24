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

package keepnotes.di.component;

import dagger.Component;
import domain.notes.di.component.NotesDomainComponent;
import domain.notes.di.scope.PerActivity;
import keepnotes.di.module.UiViewModelModule;
import keepnotes.ui.activity.NoteCollectionActivity;
import keepnotes.ui.adapter.NoteCollectionViewAdapter;
import keepnotes.ui.fragment.NoteFragment;
import keepnotes.ui.viewmodel.NoteCollectionViewModel;

/**
 * Created by krajeswaran on 8/1/16.
 */
@PerActivity
@Component(dependencies = {NotesDomainComponent.class}, modules = UiViewModelModule.class)
public interface UiInjectorComponent {
    void inject(NoteCollectionActivity activity);
    void inject(NoteCollectionViewAdapter adapter);
    void inject(NoteFragment fragment);
    void inject(NoteCollectionViewModel viewModel);
}
