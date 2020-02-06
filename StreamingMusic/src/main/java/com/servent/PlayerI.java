package com.servent;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;
import streaming.*;

public class PlayerI extends _PlayerDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Track> listTrack = new ArrayList<Track>();
	
	public void addTrack(String name, String album, String author, String singer, String path, Current __current) {
		// TODO Auto-generated method stub
		TrackI tmp = new TrackI(name, album, author, singer, path);
		this.listTrack.add(tmp);
		
		System.out.println("Track added success!!!");
		tmp.viewAllTract();
	}

	public int deleteTrack(String name, Current __current) {
		// TODO Auto-generated method stub
		int tmp = this.searchTrackUtil(name);
		if (tmp != -1) {
			this.listTrack.remove(tmp);
			return 1;
		}
		return 0;
	}
	
	// Function to find position of track
	public int searchTrackUtil(String name) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.listTrack.size(); i++) {
			if (((TrackI) this.listTrack.get(i)).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public String streamTrack(String name, Current __current) {
		// TODO Auto-generated method stub
		int tmp = this.searchTrackUtil(name);
		if (tmp != -1) {
			String path = ((TrackI) this.listTrack.get(tmp)).getPath();
			return path;
		}
		return "";
	}

	public String searchTrack(String name, Current __current) {
		// TODO Auto-generated method stub
		int tmp = this.searchTrackUtil(name);
		if (tmp != -1) {
			return this.listTrack.get(tmp).toString();
		}
		return "";
	}

	public String playTrack(String name, Current __current) {
		// TODO Auto-generated method stub
		int tmp = this.searchTrackUtil(name);
		if (tmp != -1) {
			TrackI track = (TrackI) this.listTrack.get(tmp);
			System.out.println("Play music !!!");
			return track.getPath();
		}
		System.out.println("Can't play !!!");
		return "";
	}

	public String getListTrack(Current __current) {
		// TODO Auto-generated method stub
		String tracks = "";
		for (int i = 0; i < this.listTrack.size(); i++) {
			tracks = tracks + "\n" + this.listTrack.get(i).toString();
		}
		return tracks;
	}

}
