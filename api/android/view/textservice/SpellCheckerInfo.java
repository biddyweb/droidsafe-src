package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;

public final class SpellCheckerInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.612 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "47A49524DB3D9D5011E27A061CD906FB")

    private ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.612 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.612 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "288F27297FDE0055206DB25B18D34AF5")

    private int mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.612 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.612 -0400", hash_original_field = "58B4845692446C00D28E793F604359BA", hash_generated_field = "116F12542346011C049323E2C901D79E")

    private final ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.614 -0400", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "DB491E529ADFD36784DE97DEA63E9F61")
    public  SpellCheckerInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        addTaint(context.getTaint());
        mService = service;
        ServiceInfo si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        final PackageManager pm = context.getPackageManager();
        int label = 0;
        String settingsActivityComponent = null;
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, SpellCheckerSession.SERVICE_META_DATA);
    if(parser == null)            
            {
                XmlPullParserException varC602F6C1B957072D22770670CBA58ADF_1269858853 = new XmlPullParserException("No "
                        + SpellCheckerSession.SERVICE_META_DATA + " meta-data");
                varC602F6C1B957072D22770670CBA58ADF_1269858853.addTaint(taint);
                throw varC602F6C1B957072D22770670CBA58ADF_1269858853;
            } //End block
            final Resources res = pm.getResourcesForApplication(si.applicationInfo);
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } //End block
            final String nodeName = parser.getName();
    if(!"spell-checker".equals(nodeName))            
            {
                XmlPullParserException varDB783856C63E4929C8DE12331A50C057_1341549167 = new XmlPullParserException(
                        "Meta-data does not start with spell-checker tag");
                varDB783856C63E4929C8DE12331A50C057_1341549167.addTaint(taint);
                throw varDB783856C63E4929C8DE12331A50C057_1341549167;
            } //End block
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.SpellChecker);
            label = sa.getResourceId(com.android.internal.R.styleable.SpellChecker_label, 0);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.SpellChecker_settingsActivity);
            sa.recycle();
            final int depth = parser.getDepth();
            while
(((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT)            
            {
    if(type == XmlPullParser.START_TAG)                
                {
                    final String subtypeNodeName = parser.getName();
    if(!"subtype".equals(subtypeNodeName))                    
                    {
                        XmlPullParserException var536FF78BE005993E0147609AECA04710_1161743289 = new XmlPullParserException(
                                "Meta-data in spell-checker does not start with subtype tag");
                        var536FF78BE005993E0147609AECA04710_1161743289.addTaint(taint);
                        throw var536FF78BE005993E0147609AECA04710_1161743289;
                    } //End block
                    final TypedArray a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.SpellChecker_Subtype);
                    SpellCheckerSubtype subtype = new SpellCheckerSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_label, 0),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeExtraValue));
                    mSubtypes.add(subtype);
                } //End block
            } //End block
        } //End block
        catch (Exception e)
        {
            XmlPullParserException varB6EED742DEFFBFD1A69F8473E03396C1_829539414 = new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
            varB6EED742DEFFBFD1A69F8473E03396C1_829539414.addTaint(taint);
            throw varB6EED742DEFFBFD1A69F8473E03396C1_829539414;
        } //End block
        finally 
        {
    if(parser != null)            
            parser.close();
        } //End block
        mLabel = label;
        mSettingsActivityName = settingsActivityComponent;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.615 -0400", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "C0D8D8F6984FB63466EE4BBD97721CF4")
    public  SpellCheckerInfo(Parcel source) {
        mLabel = source.readInt();
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
        // ---------- Original Method ----------
        //mLabel = source.readInt();
        //mId = source.readString();
        //mSettingsActivityName = source.readString();
        //mService = ResolveInfo.CREATOR.createFromParcel(source);
        //source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.616 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "C46FCFF9EAB5C20C16984C2F0798D3EA")
    public String getId() {
String var565D51511D15781AE576ED3D7A8F70E9_2000980574 =         mId;
        var565D51511D15781AE576ED3D7A8F70E9_2000980574.addTaint(taint);
        return var565D51511D15781AE576ED3D7A8F70E9_2000980574;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.616 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "E41CA55E9840BA57CFF173F6BD42BF57")
    public ComponentName getComponent() {
ComponentName var93E6F91556E618C88339096F31BDB937_1588331726 =         new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name);
        var93E6F91556E618C88339096F31BDB937_1588331726.addTaint(taint);
        return var93E6F91556E618C88339096F31BDB937_1588331726;
        // ---------- Original Method ----------
        //return new ComponentName(
                //mService.serviceInfo.packageName, mService.serviceInfo.name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.616 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "14C46B8344BA3888CF0FEE8CB9839C83")
    public String getPackageName() {
String var255A04E9345861413C0ACB855498FFE1_1356246342 =         mService.serviceInfo.packageName;
        var255A04E9345861413C0ACB855498FFE1_1356246342.addTaint(taint);
        return var255A04E9345861413C0ACB855498FFE1_1356246342;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.617 -0400", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "0701484475CDFF9D670AB496AC43BB5A")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mLabel);
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        // ---------- Original Method ----------
        //dest.writeInt(mLabel);
        //dest.writeString(mId);
        //dest.writeString(mSettingsActivityName);
        //mService.writeToParcel(dest, flags);
        //dest.writeTypedList(mSubtypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.617 -0400", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "F37C16A44FC2BFB7301F7479C717EBA6")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
    if(mLabel == 0 || pm == null)        
        {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_807688580 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_807688580.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_807688580;
        }
CharSequence varBFC2C4FE03EF33E1A481371165020B3B_1535502527 =         pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
        varBFC2C4FE03EF33E1A481371165020B3B_1535502527.addTaint(taint);
        return varBFC2C4FE03EF33E1A481371165020B3B_1535502527;
        // ---------- Original Method ----------
        //if (mLabel == 0 || pm == null) return "";
        //return pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.617 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "7EA3E326C0F319839BA990C88DA87875")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varFF3368A5083B43E8384DF7E2744DD5A3_845705938 =         mService.loadIcon(pm);
        varFF3368A5083B43E8384DF7E2744DD5A3_845705938.addTaint(taint);
        return varFF3368A5083B43E8384DF7E2744DD5A3_845705938;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.618 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "6E8BD56F154F5801A919C61B2E1ED158")
    public ServiceInfo getServiceInfo() {
ServiceInfo var28B71D71C22FF17E2913DF471BE53524_1336841012 =         mService.serviceInfo;
        var28B71D71C22FF17E2913DF471BE53524_1336841012.addTaint(taint);
        return var28B71D71C22FF17E2913DF471BE53524_1336841012;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.618 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "C7A776DDDF00440C4F6EA2FE2F3BD791")
    public String getSettingsActivity() {
String varF52598D579FB7EF6DE23C12DD22DC004_1790089261 =         mSettingsActivityName;
        varF52598D579FB7EF6DE23C12DD22DC004_1790089261.addTaint(taint);
        return varF52598D579FB7EF6DE23C12DD22DC004_1790089261;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.618 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "F17BC6D89C1264EA990961545F9EC2B8")
    public int getSubtypeCount() {
        int var4D00EFCF59D020D8587406D0543FA800_639518006 = (mSubtypes.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643173408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643173408;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.618 -0400", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "5DED6B5E36F348A0352C90E19819A241")
    public SpellCheckerSubtype getSubtypeAt(int index) {
        addTaint(index);
SpellCheckerSubtype var20D9F29322B7A583A76DDB79ACEBD923_594458988 =         mSubtypes.get(index);
        var20D9F29322B7A583A76DDB79ACEBD923_594458988.addTaint(taint);
        return var20D9F29322B7A583A76DDB79ACEBD923_594458988;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.618 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AB0862FFB19A5E4B8091EBE6E21DC917")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_460962808 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311878031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311878031;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.619 -0400", hash_original_field = "58FAD4C7527ECEFE39EC0BB22BC5051B", hash_generated_field = "B9C780B55162E0EEA102B93C8BE1103A")

    private static final String TAG = SpellCheckerInfo.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.619 -0400", hash_original_field = "7A612228AEBA5D53B0643FEBD5AE3BB8", hash_generated_field = "3A3EE9B5EE70A014F29E533D3D1BDF90")

    public static final Parcelable.Creator<SpellCheckerInfo> CREATOR
            = new Parcelable.Creator<SpellCheckerInfo>() {
        @Override
        public SpellCheckerInfo createFromParcel(Parcel source) {
            return new SpellCheckerInfo(source);
        }

        @Override
        public SpellCheckerInfo[] newArray(int size) {
            return new SpellCheckerInfo[size];
        }
    };
}

