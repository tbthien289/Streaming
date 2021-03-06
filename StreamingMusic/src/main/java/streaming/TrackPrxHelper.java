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

public final class TrackPrxHelper extends Ice.ObjectPrxHelperBase implements TrackPrx
{
    private static final String __viewAllTract_name = "viewAllTract";

    public void viewAllTract()
    {
        viewAllTract(null, false);
    }

    public void viewAllTract(java.util.Map<String, String> __ctx)
    {
        viewAllTract(__ctx, true);
    }

    private void viewAllTract(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        final Ice.Instrumentation.InvocationObserver __observer = IceInternal.ObserverHelper.get(this, "viewAllTract", __ctx);
        int __cnt = 0;
        try
        {
            while(true)
            {
                Ice._ObjectDel __delBase = null;
                try
                {
                    __delBase = __getDelegate(false);
                    _TrackDel __del = (_TrackDel)__delBase;
                    __del.viewAllTract(__ctx, __observer);
                    return;
                }
                catch(IceInternal.LocalExceptionWrapper __ex)
                {
                    __handleExceptionWrapper(__delBase, __ex, __observer);
                }
                catch(Ice.LocalException __ex)
                {
                    __cnt = __handleException(__delBase, __ex, null, __cnt, __observer);
                }
            }
        }
        finally
        {
            if(__observer != null)
            {
                __observer.detach();
            }
        }
    }

    public Ice.AsyncResult begin_viewAllTract()
    {
        return begin_viewAllTract(null, false, null);
    }

    public Ice.AsyncResult begin_viewAllTract(java.util.Map<String, String> __ctx)
    {
        return begin_viewAllTract(__ctx, true, null);
    }

    public Ice.AsyncResult begin_viewAllTract(Ice.Callback __cb)
    {
        return begin_viewAllTract(null, false, __cb);
    }

    public Ice.AsyncResult begin_viewAllTract(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_viewAllTract(__ctx, true, __cb);
    }

    public Ice.AsyncResult begin_viewAllTract(Callback_Track_viewAllTract __cb)
    {
        return begin_viewAllTract(null, false, __cb);
    }

    public Ice.AsyncResult begin_viewAllTract(java.util.Map<String, String> __ctx, Callback_Track_viewAllTract __cb)
    {
        return begin_viewAllTract(__ctx, true, __cb);
    }

    private Ice.AsyncResult begin_viewAllTract(java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __viewAllTract_name, __cb);
        try
        {
            __result.__prepare(__viewAllTract_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            __result.__writeEmptyParams();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_viewAllTract(Ice.AsyncResult __result)
    {
        __end(__result, __viewAllTract_name);
    }

    public static TrackPrx checkedCast(Ice.ObjectPrx __obj)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TrackPrx)
            {
                __d = (TrackPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    TrackPrxHelper __h = new TrackPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static TrackPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TrackPrx)
            {
                __d = (TrackPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    TrackPrxHelper __h = new TrackPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static TrackPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    TrackPrxHelper __h = new TrackPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static TrackPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    TrackPrxHelper __h = new TrackPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static TrackPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TrackPrx)
            {
                __d = (TrackPrx)__obj;
            }
            else
            {
                TrackPrxHelper __h = new TrackPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static TrackPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        TrackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            TrackPrxHelper __h = new TrackPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::streaming::Track"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM __createDelegateM()
    {
        return new _TrackDelM();
    }

    protected Ice._ObjectDelD __createDelegateD()
    {
        return new _TrackDelD();
    }

    public static void __write(IceInternal.BasicStream __os, TrackPrx v)
    {
        __os.writeProxy(v);
    }

    public static TrackPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            TrackPrxHelper result = new TrackPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
