/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 * Class of abstract controller
 * @author IHM
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
    protected final String FILTER_ALBUM = "album";
    /**
     *
     */
    protected final String FILTER_USER = "user";

    /**
     * Constructor of AbstractController
     * @param model
     * @param view
     */
    public AbstractController(final M model, final V view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Returns the model
     * @return model
     */
    public final M getModel() {
        return this.model;
    }

    /**
     * Updates the model
     * @param model
     */
    public final void setModel(final M model) {
        this.model = model;
    }

    /**
     * Returns the view
     * @return view
     */
    public final V getView() {
        return this.view;
    }

    /**
     * Updates the view
     * @param view
     */
    public final void setView(final V view) {
        this.view = view;
    }

    /**
     * Returns the origin search bar
     * @return String ORIGIN_SEARCH_BAR
     */
    public String getORIGIN_SEARCH_BAR() {
        return ORIGIN_SEARCH_BAR;
    }

    /**
     * Returns the origin profile
     * @return String ORIGIN_MY_PROFILE
     */
    public String getORIGIN_MY_PROFILE() {
        return ORIGIN_MY_PROFILE;
    }

    /**
     * Returns the origin online users
     * @return String ORIGIN_ONLINE_USERS
     */
    public String getORIGIN_ONLINE_USERS() {
        return ORIGIN_ONLINE_USERS;
    }

    /**
     * Returns the filter
     * @return String FILTER_NONE
     */
    public String getFILTER_NONE() {
        return FILTER_NONE;
    }

    /**
     * Returns the filter title
     * @return String FILTER_TITLE
     */
    public String getFILTER_TITLE() {
        return FILTER_TITLE;
    }

    /**
     * Returns the filter author
     * @return String FILTER_AUTHOR
     */
    public String getFILTER_AUTHOR() {
        return FILTER_AUTHOR;
    }

    /**
     * Returns the filter tag
     * @return String FILTER_TAG
     */
    public String getFILTER_TAG() {
        return FILTER_TAG;
    }

    /**
     * Returns the filter album
     * @return String FILTER_ALBUM
     */
    public String getFILTER_ALBUM() {
        return FILTER_ALBUM;
    }

    /**
     * Returns the filter user
     * @return String FILTER_USER
     */
    public String getFILTER_USER() {
        return FILTER_USER;
    }


}
