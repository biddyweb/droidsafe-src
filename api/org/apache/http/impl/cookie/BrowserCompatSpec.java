package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class BrowserCompatSpec extends CookieSpecBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.447 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.449 -0400", hash_original_method = "6F0554959345610814E9AA8C15D0E733", hash_generated_method = "7B00CB1E8E6C6203AECEE4862522224D")
    public  BrowserCompatSpec(final String[] datepatterns) {
        super();
    if(datepatterns != null)        
        {
            this.datepatterns = datepatterns.clone();
        } //End block
        else
        {
            this.datepatterns = DATE_PATTERNS;
        } //End block
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        // ---------- Original Method ----------
        //if (datepatterns != null) {
            //this.datepatterns = datepatterns.clone();
        //} else {
            //this.datepatterns = DATE_PATTERNS;
        //}
        //registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        //registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        //registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        //registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        //registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                //this.datepatterns));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.449 -0400", hash_original_method = "C508CCBAE435AF6EA5073D1CDD101081", hash_generated_method = "E42222EFF27A1027FCCB81D80EC19544")
    public  BrowserCompatSpec() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.451 -0400", hash_original_method = "D6912D1F98189529AD0F723836603277", hash_generated_method = "6B0912EB697CBC626F056685A1A43254")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
    if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_1306771928 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_1306771928.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_1306771928;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_361697645 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_361697645.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_361697645;
        } //End block
        String headervalue = header.getValue();
        boolean isNetscapeCookie = false;
        int i1 = headervalue.toLowerCase(Locale.ENGLISH).indexOf("expires=");
    if(i1 != -1)        
        {
            i1 += "expires=".length();
            int i2 = headervalue.indexOf(';', i1);
    if(i2 == -1)            
            {
                i2 = headervalue.length();
            } //End block
            try 
            {
                DateUtils.parseDate(headervalue.substring(i1, i2), this.datepatterns);
                isNetscapeCookie = true;
            } //End block
            catch (DateParseException e)
            {
            } //End block
        } //End block
        HeaderElement[] elems = null;
    if(isNetscapeCookie)        
        {
            NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
            CharArrayBuffer buffer;
            ParserCursor cursor;
    if(header instanceof FormattedHeader)            
            {
                buffer = ((FormattedHeader) header).getBuffer();
                cursor = new ParserCursor(
                        ((FormattedHeader) header).getValuePos(), 
                        buffer.length());
            } //End block
            else
            {
                String s = header.getValue();
    if(s == null)                
                {
                    MalformedCookieException var559921376C3ECF399D4F4743EF8ED9B9_512348195 = new MalformedCookieException("Header value is null");
                    var559921376C3ECF399D4F4743EF8ED9B9_512348195.addTaint(taint);
                    throw var559921376C3ECF399D4F4743EF8ED9B9_512348195;
                } //End block
                buffer = new CharArrayBuffer(s.length());
                buffer.append(s);
                cursor = new ParserCursor(0, buffer.length());
            } //End block
            elems = new HeaderElement[] { parser.parseHeader(buffer, cursor) };
        } //End block
        else
        {
            elems = header.getElements();
        } //End block
List<Cookie> var244203BCE4724537DC84FE61D4419CE6_706581900 =         parse(elems, origin);
        var244203BCE4724537DC84FE61D4419CE6_706581900.addTaint(taint);
        return var244203BCE4724537DC84FE61D4419CE6_706581900;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.452 -0400", hash_original_method = "A80B57E4EF4EED165A6AA62FBF374996", hash_generated_method = "0A7D76DEE53A41AA1316E879F43AD4B0")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
    if(cookies == null)        
        {
            IllegalArgumentException varF8FD3AA86899D4A0D763F37D49D2DC0B_1519759418 = new IllegalArgumentException("List of cookies may not be null");
            varF8FD3AA86899D4A0D763F37D49D2DC0B_1519759418.addTaint(taint);
            throw varF8FD3AA86899D4A0D763F37D49D2DC0B_1519759418;
        } //End block
    if(cookies.isEmpty())        
        {
            IllegalArgumentException varA9E78185ACB38B15D24741774F0DBD8F_1665852491 = new IllegalArgumentException("List of cookies may not be empty");
            varA9E78185ACB38B15D24741774F0DBD8F_1665852491.addTaint(taint);
            throw varA9E78185ACB38B15D24741774F0DBD8F_1665852491;
        } //End block
        CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
for(int i = 0;i < cookies.size();i++)
        {
            Cookie cookie = cookies.get(i);
    if(i > 0)            
            {
                buffer.append("; ");
            } //End block
            buffer.append(cookie.getName());
            buffer.append("=");
            String s = cookie.getValue();
    if(s != null)            
            {
                buffer.append(s);
            } //End block
        } //End block
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
List<Header> var6937E37BAD8D53F9D49A0E32C69A3A2C_2040271547 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_2040271547.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_2040271547;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.452 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "6A28AED12F5118B23C4CA4F888677A19")
    public int getVersion() {
        int varCFCD208495D565EF66E7DFF9F98764DA_257106923 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197085863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197085863;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.453 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "E5324F18919765A96E43A7F614F46759")
    public Header getVersionHeader() {
Header var540C13E9E156B687226421B24F2DF178_1235930025 =         null;
        var540C13E9E156B687226421B24F2DF178_1235930025.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1235930025;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.453 -0400", hash_original_field = "6EB8F596E5B4290D58EA6D0E959CFB4C", hash_generated_field = "0A51A84F6A48C700CC30A9F8BE2AB7A0")

    protected static final String[] DATE_PATTERNS = new String[] {
            DateUtils.PATTERN_RFC1123,
            DateUtils.PATTERN_RFC1036,
            DateUtils.PATTERN_ASCTIME,
            "EEE, dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MMM-yyyy HH-mm-ss z",
            "EEE, dd MMM yy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH:mm:ss z",
            "EEE dd MMM yyyy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH-mm-ss z",
            "EEE dd-MMM-yy HH:mm:ss z",
            "EEE dd MMM yy HH:mm:ss z",
            "EEE,dd-MMM-yy HH:mm:ss z",
            "EEE,dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MM-yyyy HH:mm:ss z",                
        };
}

