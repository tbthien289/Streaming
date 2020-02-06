// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `Stream.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package streaming;

public abstract class Track extends Ice.ObjectImpl
                            implements _TrackOperations,
                                       _TrackOperationsNC
{
    public Track()
    {
    }

    public Track(String name, String album, String author, String singer, String path)
    {
        this.name = name;
        this.album = album;
        this.author = author;
        this.singer = singer;
        this.path = path;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::streaming::Track"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public final void viewAllTract()
    {
        viewAllTract(null);
    }

    public static Ice.DispatchStatus ___viewAllTract(Track __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.readEmptyParams();
        __obj.viewAllTract(__current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "viewAllTract"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___ice_id(this, in, __current);
            }
            case 1:
            {
                return ___ice_ids(this, in, __current);
            }
            case 2:
            {
                return ___ice_isA(this, in, __current);
            }
            case 3:
            {
                return ___ice_ping(this, in, __current);
            }
            case 4:
            {
                return ___viewAllTract(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.writeString(name);
        __os.writeString(album);
        __os.writeString(author);
        __os.writeString(singer);
        __os.writeString(path);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        name = __is.readString();
        album = __is.readString();
        author = __is.readString();
        singer = __is.readString();
        path = __is.readString();
        __is.endReadSlice();
    }

    public String name;

    public String album;

    public String author;

    public String singer;

    public String path;

    public static final long serialVersionUID = -1838192183L;
}
