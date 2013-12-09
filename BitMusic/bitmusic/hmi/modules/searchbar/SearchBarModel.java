/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author unkedeuxke
 */
public final class SearchBarModel extends AbstractModel {

    public SearchBarModel() {
        super();
    }

    public ArrayList<Song> searchSongsWithoutFilter(final int tabId, final String keywords) {
        // TODO
        WindowComponent win = WindowComponent.getInstance();

//        // --------------- À supprimer dès que possible (pour le test) ------------------
//        ArrayList<Song> songResults = new ArrayList();
//        songResults.add(new Song("1", "Title1", "Author1", "SEARCH - NONE", new LinkedList()));
//        songResults.add(new Song("2", "Title2", "Author2", "SEARCH - NONE", new LinkedList()));
//        // ------------------------------------------------------------------------------
//        return songResults;

        List<String> list = Arrays.asList(keywords.split(" "));
        SongLibrary songResults = win.getApiMusic().searchSongsByAll(Integer.toString(tabId), list);

        return songResults.getlibrary();
    }

    public ArrayList<Song> searchSongsWithTitleFilter(final int tabId, final String keywords) {
        // TODO
        WindowComponent win = WindowComponent.getInstance();

//        // --------------- À supprimer dès que possible (pour le test) ------------------
//        ArrayList<Song> songResults = new ArrayList();
//        songResults.add(new Song("1", "Title1", "Author1", "SEARCH - TITLE", new LinkedList()));
//        songResults.add(new Song("2", "Title2", "Author2", "SEARCH - TITLE", new LinkedList()));
//        // ------------------------------------------------------------------------------
//        return songResults;

        List<String> titleList = Arrays.asList(keywords.split(" "));
        SongLibrary songResults = win.getApiMusic().searchSongsByTitle(Integer.toString(tabId), titleList);

        return songResults.getlibrary();
    }

    public ArrayList<Song> searchSongsWithAuthorFilter(final int tabId, final String keywords) {
        // TODO
        WindowComponent win = WindowComponent.getInstance();

//        // --------------- À supprimer dès que possible (pour le test) ------------------
//        ArrayList<Song> songResults = new ArrayList();
//        songResults.add(new Song("1", "Title1", "Author1", "SEARCH - AUTHOR", new LinkedList()));
//        songResults.add(new Song("2", "Title2", "Author2", "SEARCH - AUTHOR", new LinkedList()));
//        // ------------------------------------------------------------------------------
//        return songResults;

        List<String> authorList = Arrays.asList(keywords.split(" "));
        SongLibrary songResults = win.getApiMusic().searchSongsByArtist(Integer.toString(tabId), authorList);

        return songResults.getlibrary();
    }

    public ArrayList<Song> searchSongsWithTagFilter(final int tabId, final String keywords) {
        WindowComponent win = WindowComponent.getInstance();
        List<String> tagList = Arrays.asList(keywords.split(" "));
        SongLibrary songResults = win.getApiMusic().searchSongsByTags(Integer.toString(tabId), tagList);

        return songResults.getlibrary();
    }
}
