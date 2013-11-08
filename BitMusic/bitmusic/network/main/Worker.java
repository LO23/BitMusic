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

/**
 *@author Pak
 * Worker manages INCOMING message as tasks.
 */
public class Worker implements Runnable {

    /**
     * message.
     */
    private AbstractMessage message;

    /**
    *@param task task to do
    */
    Worker(final AbstractMessage task) {
          message = task;
    }

    /**
     * Thread running behavior (task to complete).
     */
    @Override
    public void run() {
        //achieve task here
    }

    /**
     *
     * @return message
     */
    public final AbstractMessage getMessage() {
        return message;
    }


}

