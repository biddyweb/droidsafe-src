package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;





public class MediaScannerConnection implements ServiceConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.817 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.817 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "A9DE3A256FB264536B7E2E88DEACCB5D")

    private MediaScannerConnectionClient mClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.817 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "2C76700CD7092FEC4FFAC484D89086E3")

    private IMediaScannerService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.817 -0400", hash_original_field = "6ABAB9C50B9F06402EFDC4803CC67A6F", hash_generated_field = "C3BBE48193464DA79FD826E783212B6D")

    private boolean mConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.818 -0400", hash_original_field = "32E089CCEEBCB20211A6736666324364", hash_generated_field = "08875F2CE3C391FDC01CF4BC15F196A4")

    private IMediaScannerListener.Stub mListener = new IMediaScannerListener.Stub() {        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.817 -0400", hash_original_method = "C8B58EDBD06F8EA7FBE41DD6A9CB7A63", hash_generated_method = "AFB977E21F05FF98EA1DDDD1D9573C80")
        public void scanCompleted(String path, Uri uri) {
            addTaint(uri.getTaint());
            addTaint(path.getTaint());
            MediaScannerConnectionClient client = mClient;
            if(client != null)            
            {
                client.onScanCompleted(path, uri);
            } //End block
            // ---------- Original Method ----------
            //MediaScannerConnectionClient client = mClient;
            //if (client != null) {
                //client.onScanCompleted(path, uri);
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.818 -0400", hash_original_method = "02F68DBADAE09ADC564FCBE9896B1B21", hash_generated_method = "CDCB08002AEEC269A77F7C9AB6532907")
    public  MediaScannerConnection(Context context, MediaScannerConnectionClient client) {
        mContext = context;
        mClient = client;
        // ---------- Original Method ----------
        //mContext = context;
        //mClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.819 -0400", hash_original_method = "103FF067C05F73BE25406E08AD5060BA", hash_generated_method = "AC2635B44CBE5C6FAEC600BAB70DD1B6")
    public void connect() {
        synchronized
(this)        {
            if(!mConnected)            
            {
                Intent intent = new Intent(IMediaScannerService.class.getName());
                mContext.bindService(intent, this, Context.BIND_AUTO_CREATE);
                mConnected = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mConnected) {
                //Intent intent = new Intent(IMediaScannerService.class.getName());
                //mContext.bindService(intent, this, Context.BIND_AUTO_CREATE);
                //mConnected = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.820 -0400", hash_original_method = "34ACB974A6A90DB83EA01EBFF6ED0425", hash_generated_method = "822E6A19247554FF257EE343D2E2D755")
    public void disconnect() {
        synchronized
(this)        {
            if(mConnected)            
            {
                if(false)                
                {
                } //End block
                try 
                {
                    mContext.unbindService(this);
                } //End block
                catch (IllegalArgumentException ex)
                {
                    if(false)                    
                    {
                    } //End block
                } //End block
                mConnected = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mConnected) {
                //if (false) {
                    //Log.v(TAG, "Disconnecting from Media Scanner");
                //}
                //try {
                    //mContext.unbindService(this);
                //} catch (IllegalArgumentException ex) {
                    //if (false) {
                        //Log.v(TAG, "disconnect failed: " + ex);
                    //}
                //}
                //mConnected = false;
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.845 -0400", hash_original_method = "585F124B91F8E6FD252A74E28C966933", hash_generated_method = "6E93E847EC3C5D4830A89BC11F440372")
    public synchronized boolean isConnected() {
        boolean varF28274E44CC48E20133A298DADA33A06_2120236896 = ((mService != null && mConnected));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421615820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421615820;
        // ---------- Original Method ----------
        //return (mService != null && mConnected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.845 -0400", hash_original_method = "44D1DDF3433D1A77012EDDEA6B43D1B6", hash_generated_method = "BC4A1499CEFD42FF9E6548338185D95F")
    public void scanFile(String path, String mimeType) {
        addTaint(mimeType.getTaint());
        addTaint(path.getTaint());
        synchronized
(this)        {
            if(mService == null || !mConnected)            
            {
                IllegalStateException var0773A7F613C6A1E4982B7A142442A13C_2097788412 = new IllegalStateException("not connected to MediaScannerService");
                var0773A7F613C6A1E4982B7A142442A13C_2097788412.addTaint(taint);
                throw var0773A7F613C6A1E4982B7A142442A13C_2097788412;
            } //End block
            try 
            {
                if(false)                
                {
                } //End block
                mService.requestScanFile(path, mimeType, mListener);
            } //End block
            catch (RemoteException e)
            {
                if(false)                
                {
                    Log.d(TAG, "Failed to scan file " + path);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mService == null || !mConnected) {
                //throw new IllegalStateException("not connected to MediaScannerService");
            //}
            //try {
                //if (false) {
                    //Log.v(TAG, "Scanning file " + path);
                //}
                //mService.requestScanFile(path, mimeType, mListener);
            //} catch (RemoteException e) {
                //if (false) {
                    //Log.d(TAG, "Failed to scan file " + path);
                //}
            //}
        //}
    }

    
    public static void scanFile(Context context, String[] paths, String[] mimeTypes,
            OnScanCompletedListener callback) {
        ClientProxy client = new ClientProxy(paths, mimeTypes, callback);
        MediaScannerConnection connection = new MediaScannerConnection(context, client);
        client.mConnection = connection;
        connection.connect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_method = "7C78D6E78099891228F7F6E86F5F98DF", hash_generated_method = "73ACE3BFCEA417A2F3698B588C8C2BEC")
    public void onServiceConnected(ComponentName className, IBinder service) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(className.getTaint());
        if(false)        
        {
        } //End block
        synchronized
(this)        {
            mService = IMediaScannerService.Stub.asInterface(service);
            if(mService != null && mClient != null)            
            {
                mClient.onMediaScannerConnected();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (false) {
            //Log.v(TAG, "Connected to Media Scanner");
        //}
        //synchronized (this) {
            //mService = IMediaScannerService.Stub.asInterface(service);
            //if (mService != null && mClient != null) {
                //mClient.onMediaScannerConnected();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_method = "95A47EFDF43A33BA0DC593830BA12E50", hash_generated_method = "7041D897E0D3AF354A42B1654CDF21A7")
    public void onServiceDisconnected(ComponentName className) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(className.getTaint());
        if(false)        
        {
        } //End block
        synchronized
(this)        {
            mService = null;
        } //End block
        // ---------- Original Method ----------
        //if (false) {
            //Log.v(TAG, "Disconnected from Media Scanner");
        //}
        //synchronized (this) {
            //mService = null;
        //}
    }

    
    static class ClientProxy implements MediaScannerConnectionClient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_field = "AF9CA817EC8A2628CC62FBCF5ABFA6DC", hash_generated_field = "EF5B6E8084A495EAE41C937C524F43C7")

        String[] mPaths;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_field = "5EE137557DDDE05463217DB32F89FE92", hash_generated_field = "97CE940966C9ECB62D16CE8136A149A4")

        String[] mMimeTypes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "964F174AE8F48E2B1464BEF981E40142")

        OnScanCompletedListener mClient;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "3482B5DC69035E590153D933BCD94862")

        MediaScannerConnection mConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_field = "BABB0124CEB0BCE9A25701AD1E71012E", hash_generated_field = "E574DF4683F79023C0C7ECB451E7D391")

        int mNextPath;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.846 -0400", hash_original_method = "507FCB3FA9852F504BF395AA069F1AE5", hash_generated_method = "898C52D43D16FACCB7CBCEF14110B6D7")
          ClientProxy(String[] paths, String[] mimeTypes, OnScanCompletedListener client) {
            mPaths = paths;
            mMimeTypes = mimeTypes;
            mClient = client;
            // ---------- Original Method ----------
            //mPaths = paths;
            //mMimeTypes = mimeTypes;
            //mClient = client;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.847 -0400", hash_original_method = "8C081453672AFB7A10A4B295346319E3", hash_generated_method = "2311342DD82275E9D1DDF78BD0209CBB")
        public void onMediaScannerConnected() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            scanNextPath();
            // ---------- Original Method ----------
            //scanNextPath();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.847 -0400", hash_original_method = "D5B152CD911B45918F84440EF851975F", hash_generated_method = "C1AC9A5AC48E28F380E86F736EA6C9FA")
        public void onScanCompleted(String path, Uri uri) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(uri.getTaint());
            addTaint(path.getTaint());
            if(mClient != null)            
            {
                mClient.onScanCompleted(path, uri);
            } //End block
            scanNextPath();
            // ---------- Original Method ----------
            //if (mClient != null) {
                //mClient.onScanCompleted(path, uri);
            //}
            //scanNextPath();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.847 -0400", hash_original_method = "867E90DE2F95BCDF3C69A0A29D034AD3", hash_generated_method = "8DDDFF2389E027A1B50841DD14B67F5A")
         void scanNextPath() {
            if(mNextPath >= mPaths.length)            
            {
                mConnection.disconnect();
                return;
            } //End block
            String mimeType = mMimeTypes != null ? mMimeTypes[mNextPath] : null;
            mConnection.scanFile(mPaths[mNextPath], mimeType);
            mNextPath++;
            // ---------- Original Method ----------
            //if (mNextPath >= mPaths.length) {
                //mConnection.disconnect();
                //return;
            //}
            //String mimeType = mMimeTypes != null ? mMimeTypes[mNextPath] : null;
            //mConnection.scanFile(mPaths[mNextPath], mimeType);
            //mNextPath++;
        }

        
    }


    
    public interface OnScanCompletedListener {
        
        public void onScanCompleted(String path, Uri uri);
    }
    
    public interface MediaScannerConnectionClient extends OnScanCompletedListener {
        
        public void onMediaScannerConnected();

        
        public void onScanCompleted(String path, Uri uri);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.847 -0400", hash_original_field = "CB9D3508DD6275CBE63F2456BF0EF436", hash_generated_field = "4C0BB6EBD7CFC593F55CEDF09E4F4A6A")

    private static final String TAG = "MediaScannerConnection";
}

