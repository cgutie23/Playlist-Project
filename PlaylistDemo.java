import java.util.*;

/*
    The PlayListDemo class allows the user to interact with the Playlist class.
*/

public class PlaylistDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String name = " ", artist = " ", album = " ";
        int option = 0, length = 0;
        boolean ranOnce = false;
        Playlist playlist = new Playlist();

        //do-while loop allows user to continue choosing options until they decide to exit the program.
        do
        {
            //Displaying menu and gathering option from user.
            printMenu();
            System.out.print("Choice: ");
            option = keyboard.nextInt();

            while(option < 1 || option > 8) //Input validation.
            {
                System.out.println("You must select a number on the menu. Please enter a menu option:");
                option = keyboard.nextInt();
            }

            if(option == 1) //Add song to end.
            {
                //Gather information about the song.
                System.out.println();
                keyboard.nextLine();
                System.out.print("Song Name: ");
                name = keyboard.nextLine();
                System.out.print("Song Artist: ");
                artist = keyboard.nextLine();
                System.out.print("Song Album: ");
                album = keyboard.nextLine();
                System.out.print("Song Length (in seconds): ");
                length = keyboard.nextInt();

                //Create a new Song object and add it to Playlist.1
                playlist.addToEnd(new Song(name, artist, album, length));
            }

            //Setting the first song as current after the first song is added.
            while(!ranOnce)
            {
                //Setting the current song.
                playlist.setCurrentSong(playlist.getHead());
                ranOnce = true;
            }

            if(option == 2) //Add song after current song.
            {
                //Gather information about the song.
                System.out.println();
                keyboard.nextLine();
                System.out.print("Song Name: ");
                name = keyboard.nextLine();
                System.out.print("Song Artist: ");
                artist = keyboard.nextLine();
                System.out.print("Song Album: ");
                album = keyboard.nextLine();
                System.out.print("Song Length (in seconds): ");
                length = keyboard.nextInt();

                //Creating a new Song object and adding it after the current song.
                playlist.addAfterCurr((new Song(name, artist, album, length)), playlist.getCurrentSong());
            }
            else if(option == 3) //Printing the playlist.
            {
                playlist.printInfo();
            }
            else if(option == 4) //Display current song.
            {
                System.out.println(playlist.getCurrentSong());
            }
            else if(option == 5) //Remove current song.
            {
                playlist.removeSong(playlist.getCurrentSong());
            }
            else if(option == 6) //Skip to the next song.
            {
                playlist.skipToNext(playlist.getCurrentSong());
            }
            else if(option == 7) //Return to previous song.
            {
                playlist.reverseToLast(playlist.getCurrentSong());
            }
        }while(option != 8);
    }//End of main method.

    /**
     The printMenu method will print the menu options.
     */
    public static void printMenu()
    {
        System.out.println();
        System.out.println("Menu");
        System.out.println("\t1. Add a song to the playlist");
        System.out.println("\t2. Insert a new song after the current song");
        System.out.println("\t3. Print contents of the playlist");
        System.out.println("\t4. Display current song");
        System.out.println("\t5. Remove current song");
        System.out.println("\t6. Skip to the next song");
        System.out.println("\t7. Return to the previous song");
        System.out.println("\t8. Exit");
        System.out.println();
    }//End of printMenu method.

}
