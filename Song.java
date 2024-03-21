/*
    The Song class acts as a node in the Playlist list. The Song class holds the information
    for each song that is added to the playlist.
 */
public class Song
{
    private String name;
    private String artist;
    private String album;

    private static int songCounter = 0, totalSeconds = 0;


    private int length; //Length of the song in seconds.

    private Song next; //The song that follows this song in the list.
    private Song previous; //The song that precedes this song in the list.

    /**
     No-arg Constructor.
     */
    public Song()
    {
        name = " ";
        artist = " ";
        album = " ";
        length = 0;
        this.next = null;
        this.previous = null;
    }

    /**
     Constructor.
     @param name The name of the song.
     @param artist The artist of the song.
     @param album The album the song belongs to.
     @param length The length of the song in seconds.
     */
    public Song(String name, String artist, String album, int length)
    {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
        songCounter++;
        totalSeconds += length;
    }

    /**
     Copy constructor.
     @param obj The object to copy from.
     */
    public Song(Song obj)
    {
        name = obj.name;
        artist = obj.artist;
        album = obj.album;
        length = obj.length;
    }

    /**
     setName method.
     @param name The name of the song.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     getName method.
     @return The name of the song.
     */
    public String getName()
    {
        return name;
    }

    /**
     setArtist method.
     @param artist The artist of the song.
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     getArtist method.
     @return The artist of the song.
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     setAlbum method.
     @param album The album that the song belongs to.
     */
    public void setAlbum(String album)
    {
        this.album = album;
    }

    /**
     getAlbum method.
     @return The album that the song belongs to.
     */
    public String getAlbum()
    {
        return album;
    }

    /**
     setLength method.
     @param length The length of the song in seconds.
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     getLength method.
     @return The length of the song in seconds.
     */
    public int getLength()
    {
        return length;
    }

    /**
     setNext method.
     @param next The song that follows the current song.
     */
    public void setNext(Song next)
    {
        this.next = next;
    }

    /**
     getNext method.
     @return next The song that follows the current song.
     */
    public Song getNext()
    {
        return next;
    }

    /**
     setPrevious method.
     @param previous The song that precedes the current song.
     */
    public void setPrevious(Song previous)
    {
        this.previous = previous;
    }

    /**
     getPrevious method.
     @return The song that precedes the current song.
     */
    public Song getPrevious()
    {
        return previous;
    }

    /**
     getSongCounter method.
     @return The amount of songs in the list.
     */
    public int getSongCounter()
    {
        return songCounter;
    }

    /**
     The subFromTotalSeconds method will subtract the amount of seconds from the total
     seconds of the song that was removed.
     * @param seconds The amount of seconds to be removed
     */
    public void subFromTotalSeconds(int seconds)
    {
        totalSeconds -= seconds;
    }

    /**
     The subFromTotalSongs method will subtract a song from the amount of total songs.
     */
    public void subFromTotalSongs()
    {
        songCounter--;
    }

    /**
     getTotalSeconds method.
     @return The total duration of the playlist in seconds.
     */
    public int getTotalSeconds()
    {
        return totalSeconds;
    }

    /**
     The toString method will display the songs information as a String.
     @return The song's information.
     */
    @Override
    public String toString()
    {
        int duration = length / 60;
        int seconds = length % 60;
        String str = "\tName: " + name + "\n\tArtist: " + artist + "\n\tAlbum: "  + album
                + "\n\tDuration: " + duration + ":" + seconds;

        return str;
    }
}
