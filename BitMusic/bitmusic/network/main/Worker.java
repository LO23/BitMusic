/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.main;
import network.message.*;
import network.strategy.*;
/**
 *
 * @author Pak
 * 
 * A worker thread must implement Thread or Runnable.
 * Runnable can't return results. Use Callable if a return is needed.   
 */
public class Worker implements Runnable {
    
    //constructor
    Worker(AbstractMessage message) {
          strategy = chooseStrategy(message);
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
     * @param message
     * @return Strategy the worker will use
     */
    public final Strategy chooseStrategy(AbstractMessage message){
           
          Strategy str = null;
          
          if (message instanceof MessageAddComment){
              str = new StrategyAddComment();
               return str;
          }
          else if (message instanceof MessageErrorNotification){
              str = new StrategyErrorNotification();
              return str;
          }
          else if (message instanceof MessageGetSongFile){
              str = new StrategyGetSongFile();
              return str;
          }
          else if (message instanceof MessageGetSongsByUser){
              str = new StrategyGetSongsByUser();
              return str;
          }
          else if (message instanceof MessageGetUser){
              str = new StrategyGetUser();
              return str;
          }
          else if (message instanceof MessageLogOut){
              str = new StrategyLogOut();
              return str;
          }
          else if(message instanceof MessageNotifyNewConnection){
              str = new StrategyNotifyNewConnection();
              return str;
          }
          else if(message instanceof MessageReplyConnectionUser){
              str = new StrategyReplyConnectionUser();
              return str;
          }
          else if(message instanceof MessageSearchSongsByTag){
              str = new StrategySearchSongsByTag();
              return str;
          }
          else if(message instanceof MessageSendSongFile){
             // Why is that not implemented?
             //str = new StrategySendSongFile();
              return str;
          }
          else if(message instanceof MessageSendSongList){
              str = new StrategySendSongList();
              return str;
          }
          else if(message instanceof MessageSendUser){
              str = new StrategySendUser();
              return str;
          }
          else if(message instanceof MessageTagRequest){
              str = new StrategyTagRequest();
              return str;
          }
          else if(message instanceof MessageUpdateCommentNotification){
              str = new StrategyUpdateCommentNotification();
              return str;
          }
          
          else return str;
          //else should throw exception, need exception support

      }
    
    //message to work on
    private AbstractMessage message;

    public AbstractMessage getMessage() {
        return message;
    }
    
    private final Strategy strategy;
    public Strategy getStrategy() {
        return strategy;
    }
    

  
}
