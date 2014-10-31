package com.google.android.gms.maps;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class GoogleMapOptionsCreator implements android.os.Parcelable.Creator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:33.440 -0400", hash_original_field = "BE7571FEE68510C5B2ABCBF2C7161CA5", hash_generated_field = "A4CA75FA70F636AD154C8D958F52817C")

    public static final int CONTENT_DESCRIPTION = 0;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:33.521 -0400", hash_original_method = "30366B87AFEC637BAA5E05D3B236D25E", hash_generated_method = "BC5EA8986C0360590F8351CDBD17229D")
    
public Object createFromParcel(Parcel  r1)
    {
    	GoogleMapOptions opt = new GoogleMapOptions();
    	float f = r1.readFloat();
    	boolean b = ((f) == 1);
    	opt.compassEnabled(b);
    	opt.rotateGesturesEnabled(b);
    	opt.scrollGesturesEnabled(b);
    	opt.tiltGesturesEnabled(b);
    	
    	opt.camera(CameraPosition.fromLatLngZoom(new LatLng(f, f), f));
    	return opt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:33.513 -0400", hash_original_method = "CA11DFF75F0E87181B5E1251583553C5", hash_generated_method = "A10880B56629EEA2D9F33229531F720D")
    
public Object[] newArray(int  i0)
    {
        return new GoogleMapOptions[i0];
    }

}
