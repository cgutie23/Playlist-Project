/*
    The Playlist class acts as a Doubly Linked List that will be manipulated in the PlayListDemo class.
*/
public class Playlist
{
    private Song head;
    private Song tail;
    private Song currentSong;


    private int size;

    /**
     No-arg Constructor.
     */
    public Playlist()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     Constructor.
     @param head The head of the list.
     @param tail The tail of the list.
     @param size The size of the list.
     */
    public Playlist(Song head, Song tail, int size)
    {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    /**
     setHead method.
     @param head The head of the list.
     */
    public void setHead(Song head)
    {
        this.head = head;
    }

    /**
     getHead method.
     @return The head of the list.
     */
    public Song getHead()
    {
        return this.head;
    }

    /**
     setTail method.
     @param tail The tail of the list.
     */
    public void setTail(Song tail)
    {
        this.tail = tail;
    }

    /**
     getTail method.
     @return The tail of the list.
     */
    public Song getTail()
    {
        return this.tail;
    }

    /**
     setCurrentSong method.
     @param currentSong The song the user is currently listening to.
     */
    public void setCurrentSong(Song currentSong)
    {
        this.currentSong = currentSong;
    }

    /**
     getCurrentSong method.
     @return The song the user is currently listening to.
     */
    public Song getCurrentSong()
    {
        return this.currentSong;
    }

    /**
     The addToEnd method will append a new song to the end of the Playlist.
     @param song The song to be appended.
     */
    public void addToEnd(Song song)
    {
        //If the list is empty, assign song to the head and tail.
        if(head == null)
        {
            this.setHead(song);
            this.setTail(song);
        }
        else //If the list is not empty.
        {
            Song curr = this.head; //Current node.

            //While curr's next node is not null, step to the next node.
            while (curr.getNext() != null)
            {
                curr = curr.getNext();
            }

            //When curr's next pointer is null, add the new song to curr's next pointer
            //(end of the list).
            curr.setNext(song);
            song.setPrevious(curr);
        }
    }

    /**
     The addAfterCurr method will add a new song after the current song.
     @param newSong The new song to be added.
     @param curSong The current song.
     */
    public void addAfterCurr(Song newSong, Song curSong)
    {
        Song sucSong;

        if(this.head == null) //List is empty
        {
            this.setHead(newSong);
            this.setTail(newSong);
        }
        else if(curSong == this.tail) //Insert after tail.
        {
            this.getTail().setNext(newSong);
            newSong.setPrevious(this.tail);
            this.setTail(newSong);
        }
        else if(curSong == this.head) //Insert after head
        {
            sucSong = head.getNext();
            newSong.setPrevious(this.head);
            newSong.setNext(sucSong);
            this.head.setNext(newSong);
            sucSong.setPrevious(newSong);
        }
        else //Insert in middle
        {
            sucSong = curSong.getNext();
            newSong.setNext(sucSong);
            newSong.setPrevious(curSong);
            curSong.setNext(newSong);
            sucSong.setPrevious(newSong);
        }
    }

    /**
     The removeSong method will remove the song that is passed as an argument from the playlist.
     @param song The song to be removed from the playlist.
     */
    public void removeSong(Song song)
    {
        Song sucSong = song.getNext();
        Song predSong = song.getPrevious();

        if(sucSong != null)
        {
            sucSong.setPrevious(predSong);
        }

        if(predSong != null)
        {
            predSong.setNext(sucSong);
        }

        if(song == this.head) //Remove head.
        {
            setHead(sucSong);
        }

        if(song == this.tail) //Remove tail.
        {
            setTail(predSong);
        }

        //Removing the duration of the song from the total duration, and the song from total songs.
        song.subFromTotalSeconds(song.getLength());
        song.subFromTotalSongs();
    }

    /**
     The skipToNext method will skip to the next song in the playlist.
     @param curSong The song currently playing.
     */
    public void skipToNext(Song curSong)
    {
        //If curSong is the last song in playlist, go back to the first song.
        if(curSong.getNext() == null)
        {
            this.currentSong = this.getHead();
        }
        else
        {
            this.currentSong = curSong.getNext();
        }

        this.setCurrentSong(currentSong);
    }

    /**
     The reverseToLast method will reverse to the previous song in the playlist.
     @param curSong The song currently playing.
     */
    public void reverseToLast(Song curSong)
    {
        //If on the first song, reverse to the tail.
        if(curSong.getPrevious() == null)
        {
            this.currentSong = this.getTail();
        }
        else
        {
            this.currentSong = curSong.getPrevious();
        }

        this.setCurrentSong(currentSong);
    }

    /**
     The printInfo method displays the list's contents as a String.
     @return The list as a String.
     */
    public void printInfo()
    {
        int totalMinutes = currentSong.getTotalSeconds() / 60;
        int totalSeconds = currentSong.getTotalSeconds() % 60;
        System.out.println();
        System.out.println("Number of Songs: " + currentSong.getSongCounter() + "\nTotal Duration: " + totalMinutes + ":" + totalSeconds);
        System.out.println();

        //Start at head of list.
        Song current = head;
        int iterator = 1;

        //Until the end of the list.
        while(current != null)
        {
            System.out.println("Song " + iterator + ":");
            System.out.println(current); //Display the song information.
            current = current.getNext(); //Moving to the next song.
            iterator++;
        }
    }
}
