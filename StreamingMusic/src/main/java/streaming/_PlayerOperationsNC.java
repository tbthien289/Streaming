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

public interface _PlayerOperationsNC
{
    void addTrack(String name, String album, String author, String singer, String path);

    int deleteTrack(String name);

    String searchTrack(String name);

    String playTrack(String name);

    String getListTrack();

    String streamTrack(String name);
}
