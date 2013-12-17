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
 * Classe du modèle de EditSongPopUp
 * @author IHM
 */
public final class EditSongPopUpModel extends AbstractModel {

    private Song song;
    private DefaultListModel listTagsModel = new DefaultListModel();

    /**
     * Contructeur de EditSongPopUpModel
     * @param song
     */
    public EditSongPopUpModel(Song song) {
        super();
        this.setSong(song);
        this.setListModel(this.song.getTags());
    }

    /**
     * Retourne le son à éditer
     * @return song le son à éditer sous forme d'un objet de type song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Met à jour le son à éditer
     * @param song
     */
    public void setSong(Song song) {
        this.song = song;
        this.notifyObservers("UPDATE_SONG_INFOS");
    }

    /**
     * Retourne la liste des tags
     * @return listTagsModel
     */
    public DefaultListModel getListModel() {
        return listTagsModel;
    }

    /**
     * Set une liste de tags
     * @param listTags
     */
    public void setListModel(DefaultListModel listTags) {
        this.listTagsModel = listTags;

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Met à jour la liste des tags
     * @param listTags
     */
    public void setListModel(ArrayList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listTagsModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Met à jour la liste des tags
     * @param listTags
     */
    public void setListModel(LinkedList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listTagsModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     * Ajouter un tag à la liste des tags
     * @param tag Objet de type string
     */
    public void addTag(String tag) {
        this.listTagsModel.addElement(tag);
        this.notifyObservers("ADD_TAG");
    }

    /**
     * Supprime un tag de la liste des tags
     * On parcourt la liste des tags
     * Si le tag existe alors il est supprimé
     * Si le tag à supprimer n'existe pas on affiche un message d'erreur
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
