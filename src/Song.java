public class Song {
     private String title;
     private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

   /* @Override
    public boolean equals (Object object) {
     if (object instanceof Song){
           Song track = (Song) object;
         boolean isEqual = track.title.equals(this.title);
           return isEqual;
   }
     return false;
   }*/

    @Override
    public String toString () {
        return this.title + ": " + this.duration;
    }
}
