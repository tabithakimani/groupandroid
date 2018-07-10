package com.example.android.group;

    public class Structure {
        private String name;
        private String numOfSongs;
        private int thumbnail;

        public Structure() {
        }

        public Structure(String name, String numOfSongs, int thumbnail) {
            this.name = name;
            this.numOfSongs = numOfSongs;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumOfSongs() {
            return numOfSongs;
        }

        public void setNumOfSongs(String numOfSongs) {
            this.numOfSongs = numOfSongs;
        }

        public int getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(int thumbnail) {
            this.thumbnail = thumbnail;
        }
    }