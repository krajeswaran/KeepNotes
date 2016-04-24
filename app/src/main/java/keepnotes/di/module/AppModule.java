package keepnotes.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.squareup.picasso.Picasso;

import keepnotes.KeepNotesApplication;
import keepnotes.config.AppConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krajeswaran on 23/12/15.
 */
@Module
public class AppModule {
    private static KeepNotesApplication sKeepNotesApp;

    public AppModule(KeepNotesApplication app) {
        sKeepNotesApp = app;
    }

    @Provides @Singleton public Picasso providePicasso() {
        return Picasso.with(sKeepNotesApp);
    }

    @Provides @Singleton
    public KeepNotesApplication provideAppContext() {
        return sKeepNotesApp;
    }

    @Provides @Singleton
    public AppConfig provideAppConfig() {
        return new AppConfig();
    }

    @Provides @Singleton
    public SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(sKeepNotesApp);
    }
}
