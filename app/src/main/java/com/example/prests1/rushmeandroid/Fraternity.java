package com.example.prests1.rushmeandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


// This class determines the structure of the 'Fraternity' object.
public class Fraternity implements  Serializable{

    //Private variables storing information for an individual fraternity.
    //To be extended... limited data being used at first for testing purposes.
    private String name;
    private String chapter;
    private int memberCount;
    private String desc;
    private String key;
    //private String imgURL;
    //private String calendarURL;

    //Constructor sets variables as these need only be determined on start/require no local update.
    //public Fraternity(String fraternityName, String fraternityChapter, int fraternityMembers, String fraternityDecription, String img, String cal) {
    public Fraternity(String fraternityName, String key, String fraternityChapter, int fraternityMembers, String fraternityDecription)  {
        this.key = key;
        this.name = fraternityName;
        this.chapter = fraternityChapter;
        this.memberCount = fraternityMembers;
        this.desc = fraternityDecription;
        //this.imgURL = img;
        //this.calendarURL = cal;
    }

    //Getters for info that is displayed.
    public String getName() { return this.name; }
    public String getChapter() { return this.chapter; }
    public int getMemberCount() { return this.memberCount; }
    public String getDescription() { return this.desc; }
    public String getKey() { return this.key; }
    //public String getImage() { return this.imgURL; }
    //public String getCalendar() { return this.calendarURL; }

    public static class Event implements Serializable{
        //        static func ==(lhs: Fraternity.Event, rhs: Fraternity.Event) -> Bool {
//            return lhs.frat == rhs.frat && lhs.starting == rhs.starting && lhs.name == rhs.name
//        }
        Date starting;
        Date ending;
        String name;
        String location;
        Fraternity frat;
        private Calendar calendar = Calendar.getInstance();

        Event(String name, String location, Fraternity frat, Date starting, Integer durationInMinutes) {
            this.name = name;
            this.location = location;
            this.frat = frat;
            this.starting = starting;

            this.ending = starting;
        }

        /*
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(starting.getTime());
            dest.writeLong(ending.getTime());
            dest.writeString(name);
            dest.writeString(location);
            dest.writeParcelable(frat);
        }

        private void readFromParcel(Parcel in){
            starting = new Date(in.readLong());
            ending = new Date(in.readLong());

        }
        */


////        let coordinates : CLLocationCoordinate2D?
//                init?(withName name : String,
//                on date : Date,
//                heldBy : Fraternity,
//                duration : TimeInterval = 0,
//                at location : String? = nil,
//                coordinates : CLLocationCoordinate2D? = nil
//          ) {
//
//            self.name = name
//            self.frat = heldBy
//            self.location = location
//            self.coordinates = coordinates
//            self.starting = date
//            self.ending = starting.addingTimeInterval(duration)
//        }



    }

}