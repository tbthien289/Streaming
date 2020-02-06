#include <iostream>
#include <Ice\Ice.h>

// #include <Stream.h>

using namespace std;

static void addTrack(PlayerPrx player);

int main(int argc, char* argv[]) {
    int status = 0;
	Ice::CommunicatorPtr ic;
	try	{
        ic = Ice::initialize(argc, argv);
        
        string tarject="PlayerMp3:default -h " + string(argv[1]) + " -p 10000";
            
        Ice::ObjectPrx base = ic->stringToProxy(tarject);

        PlayerPrx playerMp3 = PlayerPrx::checkedCast(base);

        if(!playerMp3) {
              throw "Invalide proxy";
        }

        addTrack(playerMp3);
    }
	catch (const Ice::Exception& e)	{
	   cerr << e << endl;
	   status = 1;
	}
	catch (const char* msg)	{
           cerr << msg << endl;
           status = 1;
 	}

    if (ic)
	{
	   try
	   {
	       ic->destroy();
	   }
	   catch (const Ice::Exception& e)
	   {
	       cerr << e << endl;
	       status = 1;
	   }
	}
	return status;
}

static void addTrack(PlayerPrx player)
{
    cout << "Track's name   : " << endl;
    string name;
    cin >> name ;
    cout << "Track's singer : " << endl;
    string singer;
    cin >> singer;
    cout << "Track's album  : " << endl;
    string album;
    cin >> album;
    cout << "Track's author : " << endl;
    string author;
    cin >> author;
    cout << "Track's path   : " << endl;
    string path;
    cin >> path;

    player->addTrack(name, singer, author, album, path);
}

// g++ ClientCpp.cpp Stream.cpp -o ClientCpp -lIce -lIceUtil
