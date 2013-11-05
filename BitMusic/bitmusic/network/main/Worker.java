/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.MessageAddComment;
import bitmusic.network.message.MessageErrorNotification;
import bitmusic.network.message.MessageGetSongFile;
import bitmusic.network.message.MessageGetSongsByUser;
import bitmusic.network.message.MessageGetUser;
import bitmusic.network.message.MessageLogOut;
import bitmusic.network.message.MessageNotifyNewConnection;
import bitmusic.network.message.MessageReplyConnectionUser;
import bitmusic.network.message.MessageSearchSongsByTag;
import bitmusic.network.message.MessageSendSongFile;
import bitmusic.network.message.MessageSendSongList;
import bitmusic.network.message.MessageSendUser;
import bitmusic.network.message.MessageTagRequest;
import bitmusic.network.message.MessageUpdateCommentNotification;
import bitmusic.network.strategy.Strategy;
import bitmusic.network.strategy.StrategyAddComment;
import bitmusic.network.strategy.StrategyErrorNotification;
import bitmusic.network.strategy.StrategyGetSongFile;
import bitmusic.network.strategy.StrategyGetSongsByUser;
import bitmusic.network.strategy.StrategyGetUser;
import bitmusic.network.strategy.StrategyLogOut;
import bitmusic.network.strategy.StrategyNotifyNewConnection;
import bitmusic.network.strategy.StrategyReplyConnectionUser;
import bitmusic.network.strategy.StrategySearchSongsByTag;
import bitmusic.network.strategy.StrategySendSongList;
import bitmusic.network.strategy.StrategySendUser;
import bitmusic.network.strategy.StrategyTagRequest;
import bitmusic.network.strategy.StrategyUpdateCommentNotification;
/**
 *@author Pak
 * A worker thread must implement Thread or Runnable.
 */
public class Worker implements Runnable {


    /**
     * strategy
     */
    private final Strategy strategy;

    /**
     * message.
     */
    private AbstractMessage message;

    /**
    *@param task task to do
    */
    Worker(final AbstractMessage task) {
          message = task;
          strategy = chooseStrategy(task);
    }

    /**
     * Thread's running behaviour (task to complete).
     */
    @Override
    public void run() {
        //use strategy to achieve task here
    }

    /**
    *
    * @param message message to choose strategy for
    * @return Strategy the worker will use
    */
    public final Strategy chooseStrategy(final AbstractMessage message) {

        Strategy str = null;

        if (message instanceof MessageAddComment) {
            str = new StrategyAddComment();
        } else if (message instanceof MessageErrorNotification) {
            str = new StrategyErrorNotification();
        } else if (message instanceof MessageGetSongFile) {
            str = new StrategyGetSongFile();
        } else if (message instanceof MessageGetSongsByUser) {
            str = new StrategyGetSongsByUser();
        } else if (message instanceof MessageGetUser) {
            str = new StrategyGetUser();
        } else if (message instanceof MessageLogOut) {
            str = new StrategyLogOut();
        } else if (message instanceof MessageNotifyNewConnection) {
            str = new StrategyNotifyNewConnection();
        } else if (message instanceof MessageReplyConnectionUser) {
            str = new StrategyReplyConnectionUser();
        } else if (message instanceof MessageSearchSongsByTag) {
            str = new StrategySearchSongsByTag();
        } else if (message instanceof MessageSendSongFile) {
            // Why is that not implemented?
            //str = new StrategySendSongFile();
        } else if (message instanceof MessageSendSongList) {
            str = new StrategySendSongList();
        } else if (message instanceof MessageSendUser) {
            str = new StrategySendUser();
        } else if (message instanceof MessageTagRequest) {
            str = new StrategyTagRequest();
        } else if (message instanceof MessageUpdateCommentNotification) {
            str = new StrategyUpdateCommentNotification();
        } else {
            //else should throw exception, need exception support
        }
        return str;
    }

    /**
     *
     * @return message
     */
    public final AbstractMessage getMessage() {
        return message;
    }

    /**
     *
     * @return strategy
     */
    public final Strategy getStrategy() {
        return strategy;
    }

}

