package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Collection<Movie> movies;
    private Collection<Photo> photos;
    private Collection<Song> songs;

    public iPod(String name) {
        this.name = name;
        movies = new ArrayList<>();
        photos = new ArrayList<>();
        songs = new ArrayList<>();
    }

    public void add(AbstractMedia m) {
        if (m instanceof Movie) {
            movies.add((Movie) m);
        }
        else if (m instanceof Photo) {
            photos.add((Photo) m);
        }
        else {
            songs.add((Song) m);
        }
    }


    // getters
    public String getName() { return name; }


    @Override
    public Iterator<AbstractMedia> iterator() {
        return new MediaIterator();
    }

    private class MediaIterator implements Iterator<AbstractMedia> {

        private Iterator<Movie> itM = movies.iterator();
        private Iterator<Photo> itP = photos.iterator();
        private Iterator<Song> itS = songs.iterator();

        @Override
        public boolean hasNext() {
            return itM.hasNext() || itP.hasNext() || itS.hasNext();
        }

        @Override
        public AbstractMedia next() {
            if (itM.hasNext()) {
                return itM.next();
            } else if (itP.hasNext()) {
                return itP.next();
            } else {
                return itS.next();
            }
        }
    }
}