module streaming {
    
    class Track {
		string name;
    	string album;
    	string author;
    	string singer;
    	string path;
    	
    	void viewAllTract();
    };
    
    interface Player {
    
        void addTrack(string name, string album, string author, string singer, string path);
        void deleteTrack(string name);
        Track searchTrack(string name);
        void playTrack(string name);
        
    };
    
};