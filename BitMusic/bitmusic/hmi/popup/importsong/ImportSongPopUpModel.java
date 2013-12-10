/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractModel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpModel extends AbstractModel {

    private DefaultListModel listTagsModel = new DefaultListModel();

    /**
     *
     */
    public ImportSongPopUpModel() {
        super();
    }

    /**
     *
     * @return
     */
    public DefaultListModel getListModel() {
        return listTagsModel;
    }

    /**
     *
     * @param listTags
     */
    public void setListModel(DefaultListModel listTags) {
        this.listTagsModel = listTags;

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     *
     * @param listTags
     */
    public void setListModel(ArrayList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listTagsModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    /**
     *
     * @param tag
     */
    public void addTag(String tag) {
        this.listTagsModel.addElement(tag);
        this.notifyObservers("ADD_TAG");
    }

    /**
     *
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
