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
//package org.keepnotes.ui.presenter;
//
//import org.keepnotes.domain.tvshow.Chapter;
//import org.keepnotes.domain.tvshow.TvShow;
//import org.keepnotes.ui.activity.MainActivity;
//import org.keepnotes.ui.activity.NotesActivity;
//import org.keepnotes.ui.fragment.TvShowCatalogFragment;
//import org.keepnotes.ui.fragment.TvShowDraggableFragment;
//import org.keepnotes.ui.fragment.TvShowFragment;
//import org.keepnotes.ui.renderer.chapter.ChapterRenderer;
//import org.keepnotes.ui.renderer.chapter.ChapterRendererBuilder;
//import org.keepnotes.ui.renderer.chapterviewmodel.ChapterViewModelRenderer;
//import org.keepnotes.ui.renderer.chapterviewmodel.ChapterViewModelRendererBuilder;
//import org.keepnotes.ui.renderer.tvshow.TvShowRenderer;
//import org.keepnotes.ui.renderer.tvshow.TvShowRendererBuilder;
//import org.keepnotes.ui.viewmodel.ChapterViewModel;
//import com.pedrogomez.renderers.Renderer;
//import dagger.Module;
//import dagger.Provides;
//import java.util.LinkedList;
//
///**
// * Dagger module created to provide TvShows UI dependencies like RendererBuilders or presenters.
// *
// * @author Pedro Vicente Gómez Sánchez
// */
//@Module(complete = false,
//    injects = {
//        MainActivity.class, TvShowCatalogFragment.class, TvShowDraggableFragment.class,
//        TvShowFragment.class, NotesActivity.class
//    }) public final class TvShowUIModule {
//
//  @Provides TvShowRendererBuilder provideTvShowRendererBuilder(TvShowRenderer tvShowRenderer) {
//    LinkedList<Renderer<TvShow>> renderers = new LinkedList<Renderer<TvShow>>();
//    renderers.add(tvShowRenderer);
//    return new TvShowRendererBuilder(renderers);
//  }
//
//  @Provides ChapterRendererBuilder provideChapterRendererBuilder(ChapterRenderer chapterRenderer) {
//    LinkedList<Renderer<Chapter>> renderers = new LinkedList<Renderer<Chapter>>();
//    renderers.add(chapterRenderer);
//    return new ChapterRendererBuilder(renderers);
//  }
//
//  @Provides ChapterViewModelRendererBuilder provideChapterRendererBuilder(
//      ChapterViewModelRenderer chapterRenderer) {
//    LinkedList<Renderer<ChapterViewModel>> renderers = new LinkedList<Renderer<ChapterViewModel>>();
//    renderers.add(chapterRenderer);
//    return new ChapterViewModelRendererBuilder(renderers);
//  }
//}
