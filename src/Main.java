//Hernando.garcia 07-12
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        //Some own inputs to check if the code is working
        Album album = new Album("Devil interview", "Rolling-Stones");
        album.addSong("You can't always get what you want", 4.56);
        album.addSong("Angel", 4.56);
        album.addSong("Gimme Shelter", 4.56);
        album.addSong("I can't get now", 3.6);
        album.addSong("Angie", 4.09);
        album.addSong("Start me up", 4.16);
        album.addSong("Sympathy for the devil", 4.26);
        album.addSong("Just for fool", 3.56);
        album.addSong("Miss you", 2.56);
        albums.add(album);

        Album album2 = new Album("Eighties", "AC/DC");
        album2.addSong("Eighties", 3.45);
        album2.addSong("Rock or bust", 6.09);
        album2.addSong("T.N.T.", 4.09);
        album2.addSong("Highway to hell", 3.09);
        album2.addSong("Thunderstruck", 6.19);
        album2.addSong("Back in Black", 7.09);
        albums.add(album2);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addSongToPlayList("Angel", playList);
        albums.get(0).addSongToPlayList("Start me up", playList);
        albums.get(0).addSongToPlayList("Nobody knows", playList);
        albums.get(0).addSongToPlayList("Miss you", playList);
        albums.get(1).addSongToPlayList("Freaking on leash", playList);
        albums.get(1).addSongToPlayList("Invencinble", playList);
        albums.get(1).addSongToPlayList("Eighties", playList);
        albums.get(1).addSongToPlayList(1, playList);
        albums.get(0).addSongToPlayList(2, playList);
        albums.get(1).addSongToPlayList(13, playList);
        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No tracks in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printBoard();
        }
    /*looping in the songs to check the playlist*/
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist is complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printBoard();
                    break;

                case 6:
                    if(playList.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    /*Simple iterator*/
    private static void printList (LinkedList<Song> playList) {
        Iterator<Song> playListSongs = playList.iterator();
        System.out.println("=====================================");
        while (playListSongs.hasNext()){
            System.out.println(playListSongs.next());
        }
        System.out.println("=====================================");
    }

    /*A practical command board to check the functionality of the code*/
    private static void printBoard () {
        System.out.println("\n#############################\n" +
                           "Available options:" + "\nPlease enter the following options:");
        System.out.println("0 - to quit \n" +
                           "1 - to play next song \n" +
                           "2 - to reproduce the previous song \n" +
                           "3 - to replay the current song again \n" +
                           "4 - to list a song in the play list\n" +
                           "5 - to print the board again\n" +
                           "6 - to delete the current song from playlist\n" +
                           "###############################\n");
    }
}