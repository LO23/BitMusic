/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import java.util.ArrayList;

/**
 * Message to search songs with tags in a specific distant user library.
 * @author alexis
 */
public final class MessageTagRequest extends AbstractMessage {
    /**
     * ID of the user that asked for the search.
     */
    private String operator;

    /**
     * ID of the user that owns the library.
     */
    private String askedUser;

    /**
     * ID of the research.
     */
    private String researchId;

    /**
     * List of tags.
     */
    private ArrayList<String> keywordsList;

    /**
     * Option.
     *
     * 0 -> all keywords (default)
     * 1 -> any keyword
     */
    private int option;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramOperator ID of the user that asked fir the research
     * @param paramAskedUser ID of the user that owns the library
     * @param paramResearchId ID of the research
     * @param paramKeywordsList List of keywords
     * @param paramOption Option of the research
     */
    public MessageTagRequest(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramOperator, final String paramAskedUser,
            final String paramResearchId,
            final ArrayList<String> paramKeywordsList, final int paramOption) {
        super(paramType, paramIpSource, paramIpDest);
        this.operator = paramOperator;
        this.askedUser = paramAskedUser;
        this.researchId = paramResearchId;
        this.keywordsList = paramKeywordsList;
        this.option = paramOption;
    }

    /**
     * Constructor without the option parameter.
     * Default value is 0.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramOperator ID of the user that asked fir the research
     * @param paramAskedUser ID of the user that owns the library
     * @param paramResearchId ID of the research
     * @param paramKeywordsList List of keywords
     */
    public MessageTagRequest(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramOperator, final String paramAskedUser,
            final String paramResearchId,
            final ArrayList<String> paramKeywordsList) {
        super(paramType, paramIpSource, paramIpDest);
        this.operator = paramOperator;
        this.askedUser = paramAskedUser;
        this.researchId = paramResearchId;
        this.keywordsList = paramKeywordsList;
        this.option = 0;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter of the operator attribute.
     * @param paramOperator ID of the User that asked for the research
     */
    public void setOperator(final String paramOperator) {
        this.operator = paramOperator;
    }

    /**
     * Setter of the askedUser attribute.
     * @param paramAskedUser ID of the user that owns the list
     */
    public void setAskedUser(final String paramAskedUser) {
        this.askedUser = paramAskedUser;
    }

    /**
     * Setter of the researchId attribute.
     * @param paramResearchId ID of the research
     */
    public void setResearchId(final String paramResearchId) {
        this.researchId = paramResearchId;
    }

    /**
     * Setter of the keywordsList attribute.
     * @param paramKeywordsList List of tags
     */
    public void setKeywordsList(final ArrayList<String> paramKeywordsList) {
        this.keywordsList = paramKeywordsList;
    }

    /**
     * Setter of the option attribute.
     * @param paramOption Option of the research
     */
    public void setOption(final int paramOption) {
        this.option = paramOption;
    }

    /**
     * Getter of the operator attribute.
     * @return String ID of the user that asked for the research
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Getter of th askedUser attribute.
     * @return String ID of the user that owns the library
     */
    public String getAskedUser() {
        return askedUser;
    }

    /**
     * Getter of the researchId attribute.
     * @return String ID of the research
     */
    public String getResearchId() {
        return researchId;
    }

    /**
     * Getter of the keywordsList attribute.
     * @return ArrayList<String> List of tags
     */
    public ArrayList<String> getKeywordsList() {
        return keywordsList;
    }

    /**
     * Getter of the option attribute.
     * @return int Option of th research
     */
    public int getOption() {
        return option;
    }


}
