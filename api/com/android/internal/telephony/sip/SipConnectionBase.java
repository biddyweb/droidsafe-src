package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;
import android.net.sip.SipAudioCall;
import android.os.SystemClock;
import android.util.Log;
import android.telephony.PhoneNumberUtils;

abstract class SipConnectionBase extends Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "DF701BED26C9A6E82B434D3ADA19F19A", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

    private SipAudioCall mSipAudioCall;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "E672830D2E0B106901DACBA6E0B923A6")

    private String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "6F94828D80A08223A3D2C4840C810E5C")

    private String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "A0D8F46E603AB3E7C2624AFEC4BCC56F")

    private int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "899B35935BADAD00E40EEE48034FA777")

    private boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "2B7C094BB4119A5846E4078843652104")

    private long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "3A10CD6DE0D1F8841131E8E3B55CDF17")

    private long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "4A468F625B3893CC4E044A175513CACE")

    private long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "BD81C614EFF599A99945A7CA6F0301ED")

    private long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "B233BB93E83D178371054578F279C542", hash_generated_field = "B71E8F5397B52F575D65D0F3A413011B")

    private long duration = -1L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.155 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "0C720B6C915AEB7736CF4596137134F0")

    private long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.156 -0400", hash_original_field = "2C3EDA892EC57CCBFC8A3FC4EDCA5971", hash_generated_field = "A263BBCF4D1AE1517BA0D25DE4E6D1FC")

    private DisconnectCause mCause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.156 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "D20AEA8FE258625EB4F340AF843F84F8")

    private PostDialState postDialState = PostDialState.NOT_STARTED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.156 -0400", hash_original_method = "D12ADA666E21FFAC81BC845F1B1B388F", hash_generated_method = "0A147067DDC7E6520776E477ED6F8818")
      SipConnectionBase(String dialString) {
        this.dialString = dialString;
        postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        isIncoming = false;
        createTime = System.currentTimeMillis();
        // ---------- Original Method ----------
        //this.dialString = dialString;
        //postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        //isIncoming = false;
        //createTime = System.currentTimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.157 -0400", hash_original_method = "9D87CB1ACC156683FA215308BE25D1D9", hash_generated_method = "FDADB566493F2FF7E3602A795DC631BD")
    protected void setState(Call.State state) {
        addTaint(state.getTaint());
switch(state){
        case ACTIVE:
    if(connectTime == 0)        
        {
            connectTimeReal = SystemClock.elapsedRealtime();
            connectTime = System.currentTimeMillis();
        } //End block
        break;
        case DISCONNECTED:
        duration = getDurationMillis();
        disconnectTime = System.currentTimeMillis();
        break;
        case HOLDING:
        holdingStartTime = SystemClock.elapsedRealtime();
        break;
}
        // ---------- Original Method ----------
        //switch (state) {
            //case ACTIVE:
                //if (connectTime == 0) {
                    //connectTimeReal = SystemClock.elapsedRealtime();
                    //connectTime = System.currentTimeMillis();
                //}
                //break;
            //case DISCONNECTED:
                //duration = getDurationMillis();
                //disconnectTime = System.currentTimeMillis();
                //break;
            //case HOLDING:
                //holdingStartTime = SystemClock.elapsedRealtime();
                //break;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.157 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "378E2199DF3D70EFEDA80B8D61E9C491")
    @Override
    public long getCreateTime() {
        long var1ED2E1B19B6E55D52D2473BE17A4AFD9_1884111808 = (createTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1279857499 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1279857499;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.158 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "746DA34C3C1FF43B9187EB075D919383")
    @Override
    public long getConnectTime() {
        long var2A390E9117109AD2E2B8D0011E8B167F_1895675908 = (connectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_354835945 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_354835945;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.158 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "C123EE14DD295B345BBA31E4FD667534")
    @Override
    public long getDisconnectTime() {
        long varAD92DC1F9C0B5401DB7C9C68DE643AD5_1154641751 = (disconnectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1644734627 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1644734627;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.158 -0400", hash_original_method = "8E0034C90F1E75659D16C0CDCE6F5793", hash_generated_method = "F3D9DF647EF9F5E9571B9E0C9EE0CA09")
    @Override
    public long getDurationMillis() {
    if(connectTimeReal == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_468031803 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_683608326 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_683608326;
        } //End block
        else
    if(duration < 0)        
        {
            long var0E51B42E3AFE6CDC7CBD85F000104A04_123605450 = (SystemClock.elapsedRealtime() - connectTimeReal);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_317710879 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_317710879;
        } //End block
        else
        {
            long varB85EC314BF443B797EF8A66B3B03F8A4_957883087 = (duration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_764025860 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_764025860;
        } //End block
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration < 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.159 -0400", hash_original_method = "2CFF5FB4AC83B238AC9B892D795EB1DE", hash_generated_method = "63A51D5258A6EEBE5BC04C9A9208A9C9")
    @Override
    public long getHoldDurationMillis() {
    if(getState() != Call.State.HOLDING)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1208704688 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_99258823 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_99258823;
        } //End block
        else
        {
            long var4D3CB05626CB322D40708E297E465B19_1261001997 = (SystemClock.elapsedRealtime() - holdingStartTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1307238995 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1307238995;
        } //End block
        // ---------- Original Method ----------
        //if (getState() != Call.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.159 -0400", hash_original_method = "28455B27DA94996FB17C07BF72898FB4", hash_generated_method = "298AC2390E01AFF0382F969A458E4B36")
    @Override
    public DisconnectCause getDisconnectCause() {
DisconnectCause var60156825EF99DA17AB9694F744F3E9A9_2016479274 =         mCause;
        var60156825EF99DA17AB9694F744F3E9A9_2016479274.addTaint(taint);
        return var60156825EF99DA17AB9694F744F3E9A9_2016479274;
        // ---------- Original Method ----------
        //return mCause;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.159 -0400", hash_original_method = "04AFA3AB4AAFB99A0A1522AC045EFCCB", hash_generated_method = "CC2251B1F2D7B949CA5CE6AAB3C0D01C")
     void setDisconnectCause(DisconnectCause cause) {
        mCause = cause;
        // ---------- Original Method ----------
        //mCause = cause;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.159 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "53E3E8B79EA785AC954DE6FB5FA22390")
    @Override
    public PostDialState getPostDialState() {
PostDialState varA5212BBA7CEDC5476DB20427B201984F_261314949 =         postDialState;
        varA5212BBA7CEDC5476DB20427B201984F_261314949.addTaint(taint);
        return varA5212BBA7CEDC5476DB20427B201984F_261314949;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.160 -0400", hash_original_method = "0751315CA6FC4E16145F947C7FEC6A28", hash_generated_method = "BB3C4E9784C28AF1655F838F726D7EED")
    @Override
    public void proceedAfterWaitChar() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.160 -0400", hash_original_method = "1CC81519C3754B491F6AACE2E776B1AA", hash_generated_method = "9904AF5CB47E02718508F28B9EA971B1")
    @Override
    public void proceedAfterWildChar(String str) {
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.160 -0400", hash_original_method = "A990DB72552DFD3D94264491EEB59CEC", hash_generated_method = "34D7B16591BBD4AA8BCBE387281F2D17")
    @Override
    public void cancelPostDial() {
        // ---------- Original Method ----------
    }

    
    protected abstract Phone getPhone();

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.161 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "D68436F4B6006827CAA4C42E9211DCD1")
    @Override
    public String getRemainingPostDialString() {
    if(postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_167638759 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_167638759.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_167638759;
        } //End block
String var1129EB08E954CD256D4EF667275C80A7_1203851448 =         postDialString.substring(nextPostDialChar);
        var1129EB08E954CD256D4EF667275C80A7_1203851448.addTaint(taint);
        return var1129EB08E954CD256D4EF667275C80A7_1203851448;
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
            //|| postDialState == PostDialState.COMPLETE
            //|| postDialString == null
            //|| postDialString.length() <= nextPostDialChar) {
            //return "";
        //}
        //return postDialString.substring(nextPostDialChar);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.161 -0400", hash_original_method = "780D5AE6347C99C37A99BA1F1D4E1D8E", hash_generated_method = "A88AD19EFB9A9466F8AF36631B462DDA")
    private void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[SipConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SipConn] " + msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.161 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "852AF4B9C6A4B1BE0EC481A485E12A9F")
    @Override
    public int getNumberPresentation() {
        int var1CD3F9AC750C03CA9ABE084F6B1E42A4_268128904 = (Connection.PRESENTATION_ALLOWED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802864529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802864529;
        // ---------- Original Method ----------
        //return Connection.PRESENTATION_ALLOWED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.162 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "593595A1C8FACBA91E1D9087D0F4B384")
    @Override
    public UUSInfo getUUSInfo() {
UUSInfo var540C13E9E156B687226421B24F2DF178_1864159031 =         null;
        var540C13E9E156B687226421B24F2DF178_1864159031.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1864159031;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.162 -0400", hash_original_field = "37941D035922D251546A654E3A92595A", hash_generated_field = "A3F8AA293EF1D8E9E944DD7FF4AA0255")

    private static final String LOG_TAG = "SIP_CONN";
}

