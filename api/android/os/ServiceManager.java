package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.os.BinderInternal;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class ServiceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.565 -0400", hash_original_method = "C0ECF0E19363472551754760850E1958", hash_generated_method = "C0ECF0E19363472551754760850E1958")
    public ServiceManager ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
    private static IServiceManager getIServiceManager() {
        if (sServiceManager != null) {
            return sServiceManager;
        }
        sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
        return sServiceManager;
    }

    
        @DSModeled(DSC.SPEC)
    public static IBinder getService(String name) {
        try {
            IBinder service = sCache.get(name);
            if (service != null) {
                return service;
            } else {
                return getIServiceManager().getService(name);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "error in getService", e);
        }
        return null;
    }

    
        @DSModeled(DSC.SPEC)
    public static void addService(String name, IBinder service) {
        try {
            getIServiceManager().addService(name, service);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }

    
        @DSModeled(DSC.SPEC)
    public static IBinder checkService(String name) {
        try {
            IBinder service = sCache.get(name);
            if (service != null) {
                return service;
            } else {
                return getIServiceManager().checkService(name);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "error in checkService", e);
            return null;
        }
    }

    
        public static String[] listServices() throws RemoteException {
        try {
            return getIServiceManager().listServices();
        } catch (RemoteException e) {
            Log.e(TAG, "error in listServices", e);
            return null;
        }
    }

    
        public static void initServiceCache(Map<String, IBinder> cache) {
        if (sCache.size() != 0) {
            throw new IllegalStateException("setServiceCache may only be called once");
        }
        sCache.putAll(cache);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.568 -0400", hash_original_field = "21B1BB14D1BF9F027E0FD038B5D9606A", hash_generated_field = "D08E65FF3FC18CA9D021769624546E55")

    private static final String TAG = "ServiceManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.568 -0400", hash_original_field = "692B2024B43FC26291FC4A38CE60DC6E", hash_generated_field = "3BB7F9DC69203897D3C71ABD26F66EDE")

    private static IServiceManager sServiceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.569 -0400", hash_original_field = "E77ABE56B1746B96F7CDEB0B4280718F", hash_generated_field = "6C748830FB2F6F43238FB57437EDD7E8")

    private static HashMap<String, IBinder> sCache = new HashMap<String, IBinder>();
}

