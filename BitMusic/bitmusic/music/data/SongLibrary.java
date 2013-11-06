/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;
 
import java.util.ArrayList;
import java.util.Iterator;


public class SongLibrary 
{
    
   private ArrayList<Song> library; 

  
   // constructor  
   SongLibrary(ArrayList<Song> songs)
   {
    library = new ArrayList<>();
    library=songs;
   }
   
   //returns the list of song
   public ArrayList<Song> getlibrary()
   {
       return library;
   }
   
   //set the list of song
   public void setlibrary (ArrayList<Song> lib)
   {
       library=lib;
   }
   
   //returns true if the song with the ID songId is in the list
   public boolean islocal(String songId)
   {
    
    Iterator<Song> it=library.iterator();
    
    while (it.hasNext())
      {  
        Song s=it.Next();
        if (s.getSongId().equals(songId))
            return true;
        else
            return false;
       }  
    return false;
 } 
   
   //returns the song songId
   public Song getSong(String songId)
   {
       Song s = new Song();
       return s;//BRUNO 
   }
   
   //removes the song songId
   public void removeSong (String songId)
   {
       //DOHA 
   }
   
   //adds song to the song list
   public void addSong(Song song)
   {
    //JB
   }
   
   //adds the category name to each song of the list song
   public void addCategory (String name, Rights rights)
   {
   Iterator<Song> it=library.iterator();
   while(it.hasNext())
       {
           Song song=it.Next();
           song.updateCategory(name,rights);
       }
   }
   
   
   //removes the category name to each song of the list song
   public void removeCategory (String name)
   {
   Iterator<Song> it=library.iterator();
   while(it.hasNext()) //while there is still a song in the library
    {
       Song song=it.next();
       song.deleteCategory(name);// put default parameters to category name
   
    }
   }
}
   
   
   
   


   
   
   
   
   
   
   
   
   

