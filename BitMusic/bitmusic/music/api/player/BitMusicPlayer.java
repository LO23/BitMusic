/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.api.player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author Thomas
 */
public class BitMusicPlayer extends PlaybackListener {
 
    private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private int firstFrame = 0;
    private int totalFrame = 0;
    private BufferedInputStream bufferedStream;
    private Thread currentThread = null;
    private String filePath;
    
    // Player singleton
    private static BitMusicPlayer playerInstance = null;

    // the player actually doing all the work
    private AdvancedPlayer player;
    

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;
    
    // Constructor private.
    private BitMusicPlayer(){
    };
    
    // Synchronized in case where more than one thrad want to acceed to the player for the first time.
    public static synchronized BitMusicPlayer getInstance() {
        if (playerInstance == null) {
            playerInstance = new BitMusicPlayer();
        }
        return playerInstance;
    }
    
    
    
    /**
     * Allows to play a song from the beginning.
     * @param filePath
     * @throws JavaLayerException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void play(String filePath) throws JavaLayerException, FileNotFoundException, IOException {
        play(filePath, 0);
    }
    
    /**
     * Allows to play a song from from a spacific frame.
     * @param filePath
     * @param frame
     * @throws JavaLayerException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void play(String filePath, int frame) throws JavaLayerException, FileNotFoundException, IOException {
        this.filePath = filePath;
        
        if (currentThread != null) {
            if (player.getStopStatus() == false)
                player.stop();
            this.firstFrame = frame;
            this.totalFrame = 0;
        }
        
        this.playerStatus = NOTSTARTED;

        play();
        
    }
    
        /**
     * Allow to play a song at a frame when the song is already known.
     * @param frame
     * @throws JavaLayerException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void play(int frame) throws JavaLayerException, FileNotFoundException, IOException {
        if (frame > totalFrame)
            return;
        player.stop();
        this.firstFrame = frame;
        play();
        
    }
    
    /**
     * Allows to play a song when the song is already known. 
     * @throws FileNotFoundException
     * @throws BitstreamException
     * @throws JavaLayerException
     * @throws IOException 
     */
    public void play() throws FileNotFoundException, BitstreamException, JavaLayerException, IOException {      
        if(filePath == null) 
            return;
        
        bufferedStream = new BufferedInputStream(new FileInputStream(filePath));
        Bitstream bitStreamAnalyse = new Bitstream(bufferedStream);
        bufferedStream.mark(Integer.MAX_VALUE);
       
        
        if (playerStatus == NOTSTARTED) {
            Header h = bitStreamAnalyse.readFrame();
            bitStreamAnalyse.closeFrame();
            while(h != null){
                    this.totalFrame++;
                    h = bitStreamAnalyse.readFrame();
                    bitStreamAnalyse.closeFrame();
            }
            bufferedStream.reset();
        }
        
        synchronized (playerLock) {
            playerStatus = PLAYING;
            this.player = new AdvancedPlayer(bufferedStream);
            this.player.setPlayBackListener(this);
            final Runnable r = new Runnable() {
                public void run() {
                    playInternal();
                }
            };
            Thread t = new Thread(r);
            currentThread = t;
            t.setName("AudioPlayer");
            t.setDaemon(true);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
    }
    
    /**
     * Allow to stop a song. It is possible to resume it later.
     */
    public void pause() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED)
                return;
            this.player.stop();
            playerStatus = PAUSED;
        }
    }
    
    /**
     * Allows to resume a song.
     * @throws JavaLayerException
     * @throws IOException 
     */
    public void resume() throws JavaLayerException, IOException {
        synchronized (playerLock) {
            if (playerStatus == PAUSED)
                play();
        }
    }
    
    /**
     * DO NOT TOUCH THAT DEADFULL AND DANGEROUS FUNCTION.
     */
    private void playInternal() {
            try {               
                player.play(this.firstFrame, this.totalFrame);
            } catch (final JavaLayerException e) {
                e.printStackTrace();
            }
    }
    
    /**
     * Get the number total of frame of a song.
     * @return 
     */
    public int getTotalFrame() {
        return totalFrame;
    }
  
    /**
     * Event executed when the song is starded.
     * @param evt 
     */
    public void playbackStarted(PlaybackEvent evt){
    }
    
    /**
     * Event executed when the song is stopped.
     * @param evt 
     */
    public void playbackFinished(PlaybackEvent evt){
        this.firstFrame = evt.getFrame();
    }
}
