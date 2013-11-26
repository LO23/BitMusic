/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;


public class SongLibrary implements Serializable{
    
   private ArrayList<Song> library; 
   private static final long serialVersionUID = 300L;

   /**
    * default constructor   
    */
   public SongLibrary(){
      library = new ArrayList<Song>();
    }
   
   /**
    * constructor.
    * 
    * @param songs 
    */
    
   public SongLibrary(ArrayList<Song> songs)
   {
    library = new ArrayList();
    library = songs;
   }
   
   /**
    * Returns the list of songs.
    * 
    * @return library
    */
   public ArrayList<Song> getlibrary()
   {
       return library;
   }
   
   /**
    * Set the list of songs.
    * 
    * @param lib 
    */
   public void setlibrary (ArrayList<Song> lib)
   {
       library = lib;
   }
   
   /**
    * Returns true if the song with the ID songID is in the list.
    * 
    * @param songId
    * @return bool
    */
    public boolean islocal(String songId)
    {
    
    Iterator<Song> it = library.iterator();
    
    while (it.hasNext())
    {  
        Song s = it.next();
        if (s.getSongId().equals(songId))
            return true;
 
        }  
    return false;
 } 
   
   /**
    * returns the songID of a song.
    * @param songId
    * @return 
    */
    public Song getSong(String songId)
    {
	Iterator<Song> it = library.iterator();
		
	while (it.hasNext())
	{  
            Song s = it.next();
            if (s.getSongId().equals(songId))
		return s;
	}  
	return null;
    }
   
   /**
    * Removes the song songId.
    * 
    * @param songId 
    */
   public void removeSong (String songId)
   {
   Iterator<Song> it=library.iterator();
   while(it.hasNext()) //while there is still a song in the library
    {
       Song song=it.next();
       if(song.getSongId().equals(songId))
       library.remove(song); //removes the song with the id songId from the library
   
   }
   }
   
   /**
    * Adds song to the song list.
    * 
    * @param song 
    */
   public void addSong(Song song)
   {       
       this.library.add(song);       
   }
   
   /**
    * Adds the category name to each song og the list song.
    * 
    * @param name
    * @param rights 
    */
   public void addCategory (String name, Rights rights)
   {
   Iterator<Song> it = library.iterator();
   while(it.hasNext())
       {
           Song song = it.next();
           song.updateCategory(name, rights);
       }
   }
   
   /**
    * Removes the category name to each song of the song list.
    * 
    * @param name 
    */
   public void removeCategory (String name)
   {
   Iterator<Song> it = library.iterator();
   while(it.hasNext()) //while there is still a song in the library
    {
       Song song = it.next();
       song.deleteCategory(name);// put default parameters to category name
   
    }
   }
}
   
   
   
   


   
   
   
   
   
   
   
   
   

