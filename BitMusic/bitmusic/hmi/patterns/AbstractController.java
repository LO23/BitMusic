/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 *
 * @author hebergui, unkedeuxke
 * @param <M>
 * @param <V>
 */
public abstract class AbstractController<M extends AbstractModel, V extends AbstractView> {

    private M model;
    private V view;

    /**
     *
     */
    protected final String ORIGIN_SEARCH_BAR = "SearchBar";

    /**
     *
     */
    protected final String ORIGIN_MY_PROFILE = "MyProfile";

    /**
     *
     */
    protected final String ORIGIN_ONLINE_USERS = "OnlineUsers";

    /**
     *
     */
    protected final String FILTER_NONE = "none";

    /**
     *
     */
    protected final String FILTER_TITLE = "title";

    /**
     *
     */
    protected final String FILTER_AUTHOR = "author";

    /**
     *
     */
    protected final String FILTER_TAG = "tag";

    /**
     *
     */
    protected final String FILTER_USER = "user";

    /**
     *
     * @param model
     * @param view
     */
    public AbstractController(final M model, final V view) {
        this.model = model;
        this.view = view;
    }

    /**
     *
     * @return
     */
    public final M getModel() {
        return this.model;
    }

    /**
     *
     * @param model
     */
    public final void setModel(final M model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public final V getView() {
        return this.view;
    }

    /**
     *
     * @param view
     */
    public final void setView(final V view) {
        this.view = view;
    }

    /**
     *
     * @return
     */
    public String getORIGIN_SEARCH_BAR() {
        return ORIGIN_SEARCH_BAR;
    }

    /**
     *
     * @return
     */
    public String getORIGIN_MY_PROFILE() {
        return ORIGIN_MY_PROFILE;
    }

    /**
     *
     * @return
     */
    public String getORIGIN_ONLINE_USERS() {
        return ORIGIN_ONLINE_USERS;
    }

    /**
     *
     * @return
     */
    public String getFILTER_NONE() {
        return FILTER_NONE;
    }

    /**
     *
     * @return
     */
    public String getFILTER_TITLE() {
        return FILTER_TITLE;
    }

    /**
     *
     * @return
     */
    public String getFILTER_AUTHOR() {
        return FILTER_AUTHOR;
    }

    /**
     *
     * @return
     */
    public String getFILTER_TAG() {
        return FILTER_TAG;
    }


}
