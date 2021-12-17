import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place>locations;
    private final List<String>languages;
    private final List<String>genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;


    public static class Builder {
        private final String title;
        private final int year;
        private final Person director;
        
        private Person writer = new Person();
        private String series = "";
        private List<Person> cast = new ArrayList<Person>();
        private List<Place>locations = new ArrayList<Place>();
        private List<String>languages = new ArrayList<String>();
        private List<String>genres = new ArrayList<String>();
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;

        public Builder(String title, int year, Person director) {
            this.title = title;
            this.year = year;
            this.director = director;
        }
        public Builder writer(Person person) {
            writer = person;
            return this;
        }
        public Builder series(String word) {
            series = word;
            return this;
        }
        public Builder cast(List<Person> people) {
            cast = people;
            return this;
        }
        public Builder locations(List<Place> places) {
            locations = places;
            return this;
        }
        public Builder languages(List<String> idioms) {
            languages = idioms;
            return this;
        }
        public Builder genres(List<String> types) {
            genres = types;
            return this;
        }
        public Builder isTelevision(boolean val) {
            isTelevision = val;
            return this;
        }
        public Builder isNetflix(Boolean val) {
            isNetflix = val;
            return this;
        }
        public Builder isIndependent(Boolean val) {
            isIndependent = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }


    private Movie(Builder builder) {
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix= builder.isNetflix;
        isIndependent = builder.isIndependent;
    }
    

}

