package com.servent;

import Ice.Current;
import streaming.*;

public class TrackI extends Track   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrackI(String name, String album, String author, String singer, String path) {
		super(name, album, author, singer, path);
	}
	
	public void viewAllTract(Current __current) {
		// TODO Auto-generated method stub
		System.out.println("[+] Track's name   : " + this.getName());
        System.out.println("[+] Track's singer : " + this.getSinger());
        System.out.println("[+] Track's Album  : " + this.getAlbum());
        System.out.println("[+] Track's Author : " + this.getAuthor());
        System.out.println("[+] Track's Path   : " + this.getPath());
	}
	
	public String toString() {
		return this.name + " - " + this.album + " - " + this.author;
	}
	
    public String getName() {
        return this.name;
    }

    public String getSinger() {
        return this.singer;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getAlbum() {
        return this.album;
    }
    
    public String getPath() {
        return this.path;
    }

}
