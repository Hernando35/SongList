import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String artist;
    private String nameAlbum;
    private ArrayList<Song> tracks;

    public Album(String nameAlbum, String artist) {
        this.artist = artist;
        this.nameAlbum = nameAlbum;
        this.tracks = new ArrayList<Song>();
    }

    public boolean addSong (String titleSong, double duration) {
        if(findSong(titleSong) == null){
            this.tracks.add(new Song(titleSong, duration));
        }
        return false;
    }

    private Song findSong (String title) {
        for ( Song checkedSong: this.tracks ) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSongToPlayList (int trackNumber, LinkedList<Song>playList) {
        int index = trackNumber - 1;
        if((index >= 0) && (index <= this.tracks.size())){
            playList.add(this.tracks.get(index));
            return true;
        }
        System.out.println("This album has not a song with the track number: " + trackNumber);
        return false;
    }

    public boolean addSongToPlayList (String titleSong, LinkedList<Song>playList) {
        Song checkedSong = findSong(titleSong);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album has not a song with the track number: " + titleSong);
        return false;
    }
}
