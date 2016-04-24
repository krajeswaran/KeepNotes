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

package domain.notes.util;

import domain.notes.di.component.DaggerNotesDomainComponent;
import domain.notes.di.component.NotesDomainComponent;
import domain.notes.di.module.NoteCollectionModule;
import domain.notes.di.module.NoteModule;
import domain.notes.di.module.NotesDomainModule;

/**
 * Created by krajeswaran on 10/1/16.
 */
public class TestHelper {

    private static NotesDomainComponent sNotesDomainComponent;
    private static TestClassInjector sTestClassInjector;

    public static NotesDomainComponent getNotesDomainComponent(){
        if(sNotesDomainComponent == null){
            sNotesDomainComponent = DaggerNotesDomainComponent.builder()
                    .notesDomainModule(new NotesDomainModule())
                    .noteCollectionModule(new NoteCollectionModule())
                    .noteModule(new NoteModule())
                    .build();
        }
        return sNotesDomainComponent;
    }

    public static TestClassInjector getTestClassInjector(){
        if(sTestClassInjector == null){
            sTestClassInjector = DaggerTestClassInjector.builder()
                    .baseComponent(getNotesDomainComponent())
                    .build();
        }

        return sTestClassInjector;
    }

    public static void waitFor(IWaitingCallback callback){
        waitFor(10, callback);
    }

    public static void waitFor(int maxCycles, IWaitingCallback callback){
        while(true){
            maxCycles --;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(callback.checkCondition()){
                break;
            }
            if(maxCycles <= 0){
                break;
            }
        }
    }

    public static interface IWaitingCallback{
        /**
         *
         * @return true if condition is met, false if we should keep waiting
         */
        public boolean checkCondition();
    }

}
