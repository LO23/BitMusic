/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/**
 * Model class of EditSongPopUp
 * @author IHM
 */
public final class EditSongPopUpModel extends AbstractModel {

    private Song song;
    private DefaultListModel listTagsModel = new DefaultListModel();

    /**
     * Contructor of EditSongPopUpModel
     * @param song
     */
    public EditSongPopUpModel(Song song) {
        super();
        this.setSong(song);
        this.setListModel(this.song.getTags());
    }

    /**
     * Returns a song to edit
     * @return Song song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Updates a song
     * @param song
     */
    public void setSong(Song song) {
        this.song = song;
        this.notifyObservers("UPDATE_SONG_INFOS");
    }

    /**
     * Returns a list of tags
     * @return listTagsModel
     */
    public DefaultListModel getListModel() {
        return listTagsModel;
    }

    /**
     * Sets a list of tags
     * @param listTags
     */
    public void setListModel(DefaultListModel listTags) {
        this.listTagsModel = listTags;

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Updates a list of tags
     * @param listTags
     */
    public void setListModel(ArrayList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listTagsModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Updates a list of tags
     * @param listTags
     */
    public void setListModel(LinkedList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listTagsModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Adds a tag
     * @param tag
     */
    public void addTag(String tag) {
        this.listTagsModel.addElement(tag);
        this.notifyObservers("ADD_TAG");
    }

    /**
     * Deletes a tag from the tag list
     * If the tag to delete deosn't exist, an error message is shown
     * @param tag
     */
    public void removeTag(String tag) {
        boolean tagRemoved = false;
        for ( int i=0; i<listTagsModel.size(); i++) {
            if (listTagsModel.get(i).equals(tag)) {
                listTagsModel.remove(i);
                tagRemoved = true;
            }
        }

        if (tagRemoved == true) {
            this.notifyObservers("REMOVE_TAG");
        }
        else {
            System.out.println("--- Error: Tag doesn't exist");
        }
    }

}
