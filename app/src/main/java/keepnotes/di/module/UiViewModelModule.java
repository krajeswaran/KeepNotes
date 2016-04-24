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

package keepnotes.di.module;

import dagger.Module;
import dagger.Provides;
import domain.notes.di.scope.PerActivity;
import keepnotes.ui.viewmodel.NoteCollectionViewModel;

/**
 * Created by krajeswaran on 8/1/16.
 */
@Module
public class UiViewModelModule {

    @Provides
    @PerActivity
    NoteCollectionViewModel providesNoteCollectionViewModel() {
        return new NoteCollectionViewModel();
    }
}
