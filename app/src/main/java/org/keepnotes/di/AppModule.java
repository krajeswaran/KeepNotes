package org.keepnotes.di;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.squareup.picasso.Picasso;

import org.keepnotes.KeepNotesApplication;
import org.keepnotes.config.AppConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krajeswaran on 23/12/15.
 */
@Module
public class AppModule {
    private final KeepNotesApplication keepNotesApp;

    public AppModule(KeepNotesApplication keepNotesApp) {
        this.keepNotesApp = keepNotesApp;
    }

    @Provides @Singleton public Picasso providePicasso() {
        return Picasso.with(keepNotesApp);
    }

    @Provides @Singleton
    public KeepNotesApplication provideAppContext() {
        return keepNotesApp;
    }

    @Provides @Singleton
    public AppConfig provideAppConfig() {
        return new AppConfig();
    }

    @Provides @Singleton
    public SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(keepNotesApp);
    }
}
