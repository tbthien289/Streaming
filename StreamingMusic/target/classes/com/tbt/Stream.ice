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
        int deleteTrack(string name);
       	string searchTrack(string name);
        string playTrack(string name);
   		string getListTrack();
   		string streamTrack(string name);
   
    };
    
};