package net.muroc;

/**
 * Created by Brendan on 7/31/2017.
 */
import org.json.JSONException;
import org.json.JSONObject;

public class FLTrackPoint {

    private String flightUID;
    private String flightHex;

    public String getFlightHex() {
        return flightHex;
    }

    public void setFlightHex(String flightHex) {
        this.flightHex = flightHex;
    }

    private String flightSquawk;

    public String getFlightSquawk() {
        return flightSquawk;
    }

    public void setFlightSquawk(String flightSquawk) {
        this.flightSquawk = flightSquawk;
    }

    private String flightNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    private double fLat;

    public double getfLat() {
        return fLat;
    }

    public void setfLat(double fLat) {
        this.fLat = fLat;
    }

    private double fLon;

    public double getfLon() {
        return fLon;
    }

    public void setfLon(double fLon) {
        this.fLon = fLon;
    }

    private Double fNucp;

    public double getfNucp() {
        return fNucp;
    }

    public void setfNucp(double fNucp) {
        this.fNucp = fNucp;
    }

    private double fSeen_Pos;

    public double getfSeen_Pos() {
        return fSeen_Pos;
    }

    public void setfSeen_Pos(double fSeen_Pos) {
        this.fSeen_Pos = fSeen_Pos;
    }

    private int fAltitude;

    public int getfAltitude() {
        return fAltitude;
    }

    public void setfAltitude(int fAltitude) {
        this.fAltitude = fAltitude;
    }

    private int fVert_Rate;

    public int getfVert_Rate() {
        return fVert_Rate;
    }

    public void setfVert_Rate(int fVert_Rate) {
        this.fVert_Rate = fVert_Rate;
    }

    private int fTrack;

    public int getfTrack() {
        return fTrack;
    }

    public void setfTrack(int fTrack) {
        this.fTrack = fTrack;
    }

    private int fSpeed;

    public int getfSpeed() {
        return fSpeed;
    }

    public void setfSpeed(int fSpeed) {
        this.fSpeed = fSpeed;
    }

    private String fCategory;
    private String fMlat;
    private String fTisb;
    private int fMessages;

    public int getfMessages() {
        return fMessages;
    }

    public void setfMessages(int fMessages) {
        this.fMessages = fMessages;
    }

    private int fSeen;

    public int getfSeen() {
        return fSeen;
    }

    public void setfSeen(int fSeen) {
        this.fSeen = fSeen;
    }

    private double fRssi;

    public double getfRssi() {
        return fRssi;
    }

    public void setfRssi(double fRssi) {
        this.fRssi = fRssi;
    }

    public FLTrackPoint(JSONObject fl_info) {
        try {
            flightSquawk = fl_info.getString("squawk");
            flightHex = fl_info.getString("hex");
            flightNumber = fl_info.getString("flight");
            fLat = fl_info.getDouble("lat");
            fLon = fl_info.getDouble("lon");
            fNucp = fl_info.getDouble("nucp");
            fSeen = fl_info.getInt("seen_pos");
            fAltitude = fl_info.getInt("altitude");
            fVert_Rate = fl_info.getInt("vert_rate");
            fTrack = fl_info.getInt("track");
            fSpeed = fl_info.getInt("speed");
            fMessages = fl_info.getInt("messages");
            fSeen = fl_info.getInt("seen");
            fRssi = fl_info.getDouble("rssi");

        } catch (JSONException je) {
            System.out.println(je.getMessage());
        }
    }
}