package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class ASN1Primitive extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.665 -0400", hash_original_method = "6E01D122B93A51FA632034F321085BC1", hash_generated_method = "9D56F69B9803BBDA89E5C889018CDCB2")
    public  ASN1Primitive(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.665 -0400", hash_original_method = "C1AED137C8D8FCE0695617840DD29190", hash_generated_method = "2D9173B0D9FBBF857C2158B373272CD9")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean varA325FA0FD7DDE53B938E2EF72F7A2A48_1866977587 = (this.id == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806521712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806521712;
        // ---------- Original Method ----------
        //return this.id == identifier;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.666 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "48F131D00A1E1D9FE33198C4F5017853")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeTag(id);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
}

