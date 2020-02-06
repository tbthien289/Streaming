import sys, traceback, Ice
from pygame import mixer

Ice.loadSlice('Stream.ice')
import streaming

def menu():
    print("""
###################### [ Player MP3 ] #####################
1/ Add new track
2/ Search track
3/ Delete track
4/ Play track
5/ Music information
6/ Exit
Enter your choice :
""")

def addTrack(player):
    sys.stdout.write("Name of track : ")
    sys.stdout.flush()
    name = sys.stdin.readline().strip()

    sys.stdout.write("Album : ")
    sys.stdout.flush()
    album = sys.stdin.readline().strip()

    sys.stdout.write("Author : ")
    sys.stdout.flush()
    author = sys.stdin.readline().strip()

    sys.stdout.write("Singer : ")
    sys.stdout.flush()
    singer = sys.stdin.readline().strip()

    sys.stdout.write("Path : ")
    sys.stdout.flush()
    path = sys.stdin.readline().strip()
    
    player.addTrack(name, album, author, singer, path)

def deleteTrack(player):
    sys.stdout.write("Name of track : ")
    sys.stdout.flush()
    name = sys.stdin.readline().strip()

    if player.deleteTrack(name) == 1:
        print("Delete track success!")
    else:
        print("Can't delete track")

def searchTrack(player):
    sys.stdout.write("Name of track : ")
    sys.stdout.flush()
    name = sys.stdin.readline().strip()
    
    result = player.searchTrack(name)
    if result != "":
        print("Found Track: ")
        print(result)
    else:
        print("Can't find track")

def getAllTrack(player):
    result = player.getListTrack()
    print(result)

def playTrack(player):
    sys.stdout.write("Name of track : ")
    sys.stdout.flush()
    name = sys.stdin.readline().strip()
    
    path = player.playTrack(name)
    mixer.init()
    mixer.music.load(path)
    mixer.music.play()

def init(player):
    player.addTrack("Miss you", "Love Songs", "Westlife", "Westlife", "missyou.mp3")
    
class Client():

    def printString(self, s, current=None):
        print(s)

status = 0
ic = None

try:
    ic = Ice.initialize(sys.argv)
    base = ic.stringToProxy("PlayerMp3:default -h localhost -p 10000")
    playerMp3 = streaming.PlayerPrx.checkedCast(base)
    if not playerMp3:
        raise RuntimeError("Invalid proxy")

    menu()
    # init data
    init(playerMp3)
    
    c = None
    while c != '6':
        try:
            sys.stdout.write("==> ")
            sys.stdout.flush()
            c = sys.stdin.readline().strip()
            if c == '1':
                addTrack(playerMp3)
            elif c == '2':
                searchTrack(playerMp3)
            elif c == '3':
                deleteTrack(playerMp3)
            elif c == '4':
                playTrack(playerMp3)
            elif c == '5':
                getAllTrack(playerMp3)
            else:
                print("unknown command `" + c + "'")
                menu()
        except KeyboardInterrupt:
                break
        except EOFError:
                break
        except Ice.Exception as ex:
                print(ex)
    getAllTrack(playerMp3)
except:
    traceback.print_exc()
    status = 1
if ic:
# Clean up
    try:
        ic.destroy()
    except:
        traceback.print_exc()
        status = 1
sys.exit(status)
