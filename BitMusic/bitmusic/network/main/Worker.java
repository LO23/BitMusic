/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.main;
import network.message.*;
import network.strategy.*;
/**
 *@author Pak
 * A worker thread must implement Thread or Runnable.
 */
public class Worker implements Runnable {

    /**
    *@param task task to do
    */
    Worker(final AbstractMessage task) {
          message = task;
          strategy = chooseStrategy(task);
    }

    /**
     * Thread's running behaviour (task to complete)
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

          if (message instanceof MessageAddComment)
          {
              str = new StrategyAddComment();
               return str;
          }
          else if (message instanceof MessageErrorNotification)
          {
              str = new StrategyErrorNotification();
              return str;
          }
          else if (message instanceof MessageGetSongFile)
          {
              str = new StrategyGetSongFile();
              return str;
          }
          else if (message instanceof MessageGetSongsByUser)
          {
              str = new StrategyGetSongsByUser();
              return str;
          }
          else if (message instanceof MessageGetUser)
          {
              str = new StrategyGetUser();
              return str;
          }
          else if (message instanceof MessageLogOut)
          {
              str = new StrategyLogOut();
              return str;
          }
          else if(message instanceof MessageNotifyNewConnection)
          {
              str = new StrategyNotifyNewConnection();
              return str;
          }
          else if(message instanceof MessageReplyConnectionUser)
          {
              str = new StrategyReplyConnectionUser();
              return str;
          }
          else if(message instanceof MessageSearchSongsByTag)
          {
              str = new StrategySearchSongsByTag();
              return str;
          }
          else if(message instanceof MessageSendSongFile)
          {
             // Why is that not implemented?
             //str = new StrategySendSongFile();
              return str;
          }
          else if(message instanceof MessageSendSongList)
          {
              str = new StrategySendSongList();
              return str;
          }
          else if(message instanceof MessageSendUser)
          {
              str = new StrategySendUser();
              return str;
          }
          else if(message instanceof MessageTagRequest)
          {
              str = new StrategyTagRequest();
              return str;
          }
          else if(message instanceof MessageUpdateCommentNotification)
          {
              str = new StrategyUpdateCommentNotification();
              return str;
          }

          else return str;
          //else should throw exception, need exception support

      }

    /**
     * message.
     */
    private AbstractMessage message;

    public final AbstractMessage getMessage() {
        return message;
    }

    private final Strategy strategy;
    public final Strategy getStrategy() {
        return strategy;
    }



}

