package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509V2AttributeCertificate;

public class MiscPEMGenerator implements PemObjectGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "03657E147A117C299E988405DFDF1FE0")

    private Object obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.205 -0400", hash_original_method = "C02D6ACBF889CF35766B7871B784307D", hash_generated_method = "2850ED16A7B9528D560ED52741366F34")
    public  MiscPEMGenerator(Object o) {
        this.obj = o;
        // ---------- Original Method ----------
        //this.obj = o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.206 -0400", hash_original_method = "AD2D21FAE267AE7BA19486B70A7A435E", hash_generated_method = "9975F4F1D94CD2D098CEA7C2FCAAB346")
    public  MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        Provider     provider) {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;
        this.provider = provider;
        // ---------- Original Method ----------
        //this.obj = obj;
        //this.algorithm = algorithm;
        //this.password = password;
        //this.random = random;
        //this.provider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.208 -0400", hash_original_method = "FC3CFC06395928A5BA1B88C136A7A3A1", hash_generated_method = "AE994627F64060E3BB76140C587A390E")
    public  MiscPEMGenerator(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random,
        String       provider) throws NoSuchProviderException {
        this.obj = obj;
        this.algorithm = algorithm;
        this.password = password;
        this.random = random;
    if(provider != null)        
        {
            this.provider = Security.getProvider(provider);
    if(this.provider == null)            
            {
                NoSuchProviderException varD4FD1BAEDE90D1A20C4A64680E596441_1676077272 = new NoSuchProviderException("cannot find provider: " + provider);
                varD4FD1BAEDE90D1A20C4A64680E596441_1676077272.addTaint(taint);
                throw varD4FD1BAEDE90D1A20C4A64680E596441_1676077272;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.obj = obj;
        //this.algorithm = algorithm;
        //this.password = password;
        //this.random = random;
        //if (provider != null)
        //{
            //this.provider = Security.getProvider(provider);
            //if (this.provider == null)
            //{
                //throw new NoSuchProviderException("cannot find provider: " + provider);
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.211 -0400", hash_original_method = "BB771E0C3864CDE92E08322A05A8C925", hash_generated_method = "46785912F2365383770D7E64C0D03B4F")
    private PemObject createPemObject(Object o) throws IOException {
        addTaint(o.getTaint());
        String type;
        byte[] encoding;
    if(o instanceof PemObject)        
        {
PemObject var0557F2A4B2A9CA2E0F4664FCB0094582_357748354 =             (PemObject)o;
            var0557F2A4B2A9CA2E0F4664FCB0094582_357748354.addTaint(taint);
            return var0557F2A4B2A9CA2E0F4664FCB0094582_357748354;
        } //End block
    if(o instanceof PemObjectGenerator)        
        {
PemObject var6335C0C6CD56F8EACF5115120B4E7904_43828943 =             ((PemObjectGenerator)o).generate();
            var6335C0C6CD56F8EACF5115120B4E7904_43828943.addTaint(taint);
            return var6335C0C6CD56F8EACF5115120B4E7904_43828943;
        } //End block
    if(o instanceof X509Certificate)        
        {
            type = "CERTIFICATE";
            try 
            {
                encoding = ((X509Certificate)o).getEncoded();
            } //End block
            catch (CertificateEncodingException e)
            {
                PemGenerationException var2C3917E8F4F5D0753E6044900336438C_1662816833 = new PemGenerationException("Cannot encode object: " + e.toString());
                var2C3917E8F4F5D0753E6044900336438C_1662816833.addTaint(taint);
                throw var2C3917E8F4F5D0753E6044900336438C_1662816833;
            } //End block
        } //End block
        else
    if(o instanceof X509CRL)        
        {
            type = "X509 CRL";
            try 
            {
                encoding = ((X509CRL)o).getEncoded();
            } //End block
            catch (CRLException e)
            {
                PemGenerationException var2C3917E8F4F5D0753E6044900336438C_493292005 = new PemGenerationException("Cannot encode object: " + e.toString());
                var2C3917E8F4F5D0753E6044900336438C_493292005.addTaint(taint);
                throw var2C3917E8F4F5D0753E6044900336438C_493292005;
            } //End block
        } //End block
        else
    if(o instanceof KeyPair)        
        {
PemObject var6839675AF7579D1BFF8565C3DA62C7A3_1904644107 =             createPemObject(((KeyPair)o).getPrivate());
            var6839675AF7579D1BFF8565C3DA62C7A3_1904644107.addTaint(taint);
            return var6839675AF7579D1BFF8565C3DA62C7A3_1904644107;
        } //End block
        else
    if(o instanceof PrivateKey)        
        {
            PrivateKeyInfo info = new PrivateKeyInfo(
                (ASN1Sequence) ASN1Object.fromByteArray(((Key)o).getEncoded()));
    if(o instanceof RSAPrivateKey)            
            {
                type = "RSA PRIVATE KEY";
                encoding = info.getPrivateKey().getEncoded();
            } //End block
            else
    if(o instanceof DSAPrivateKey)            
            {
                type = "DSA PRIVATE KEY";
                DSAParameter p = DSAParameter.getInstance(info.getAlgorithmId().getParameters());
                ASN1EncodableVector v = new ASN1EncodableVector();
                v.add(new DERInteger(0));
                v.add(new DERInteger(p.getP()));
                v.add(new DERInteger(p.getQ()));
                v.add(new DERInteger(p.getG()));
                BigInteger x = ((DSAPrivateKey)o).getX();
                BigInteger y = p.getG().modPow(x, p.getP());
                v.add(new DERInteger(y));
                v.add(new DERInteger(x));
                encoding = new DERSequence(v).getEncoded();
            } //End block
            else
    if(((PrivateKey)o).getAlgorithm().equals("ECDSA"))            
            {
                type = "EC PRIVATE KEY";
                encoding = info.getPrivateKey().getEncoded();
            } //End block
            else
            {
                IOException var1DD6EC4C93116E7BD72BA1ABFC4BA583_1404904359 = new IOException("Cannot identify private key");
                var1DD6EC4C93116E7BD72BA1ABFC4BA583_1404904359.addTaint(taint);
                throw var1DD6EC4C93116E7BD72BA1ABFC4BA583_1404904359;
            } //End block
        } //End block
        else
    if(o instanceof PublicKey)        
        {
            type = "PUBLIC KEY";
            encoding = ((PublicKey)o).getEncoded();
        } //End block
        else
    if(o instanceof X509AttributeCertificate)        
        {
            type = "ATTRIBUTE CERTIFICATE";
            encoding = ((X509V2AttributeCertificate)o).getEncoded();
        } //End block
        else
    if(o instanceof PKCS10CertificationRequest)        
        {
            type = "CERTIFICATE REQUEST";
            encoding = ((PKCS10CertificationRequest)o).getEncoded();
        } //End block
        else
    if(o instanceof ContentInfo)        
        {
            type = "PKCS7";
            encoding = ((ContentInfo)o).getEncoded();
        } //End block
        else
        {
            PemGenerationException varA78F3BDB76DCA3CBAF9349AF4912018E_363291416 = new PemGenerationException("unknown object passed - can't encode.");
            varA78F3BDB76DCA3CBAF9349AF4912018E_363291416.addTaint(taint);
            throw varA78F3BDB76DCA3CBAF9349AF4912018E_363291416;
        } //End block
PemObject var8F3B58E96848E0C08AAC47F156725822_1788023165 =         new PemObject(type, encoding);
        var8F3B58E96848E0C08AAC47F156725822_1788023165.addTaint(taint);
        return var8F3B58E96848E0C08AAC47F156725822_1788023165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.212 -0400", hash_original_method = "DE836D95AE95CC4B16EC27C37C4EBA2F", hash_generated_method = "DF0A70EB00F92FFC97440B989734D2E8")
    private String getHexEncoded(byte[] bytes) throws IOException {
        addTaint(bytes[0]);
        bytes = Hex.encode(bytes);
        char[] chars = new char[bytes.length];
for(int i = 0;i != bytes.length;i++)
        {
            chars[i] = (char)bytes[i];
        } //End block
String var300818D7D4F603E5F4346D4E090224B6_1434307510 =         new String(chars);
        var300818D7D4F603E5F4346D4E090224B6_1434307510.addTaint(taint);
        return var300818D7D4F603E5F4346D4E090224B6_1434307510;
        // ---------- Original Method ----------
        //bytes = Hex.encode(bytes);
        //char[] chars = new char[bytes.length];
        //for (int i = 0; i != bytes.length; i++)
        //{
            //chars[i] = (char)bytes[i];
        //}
        //return new String(chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.214 -0400", hash_original_method = "C0940F4479949D8BE443C2F5943EB650", hash_generated_method = "5A9EDAD5ACCA2B25C4B19880B2201AAF")
    private PemObject createPemObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random) throws IOException {
        addTaint(random.getTaint());
        addTaint(password[0]);
        addTaint(algorithm.getTaint());
        addTaint(obj.getTaint());
    if(obj instanceof KeyPair)        
        {
PemObject var4A07F0B3B8987EC3B88B5CDF52242DDE_1414100939 =             createPemObject(((KeyPair)obj).getPrivate(), algorithm, password, random);
            var4A07F0B3B8987EC3B88B5CDF52242DDE_1414100939.addTaint(taint);
            return var4A07F0B3B8987EC3B88B5CDF52242DDE_1414100939;
        } //End block
        String type = null;
        byte[] keyData = null;
    if(obj instanceof RSAPrivateCrtKey)        
        {
            type = "RSA PRIVATE KEY";
            RSAPrivateCrtKey k = (RSAPrivateCrtKey)obj;
            RSAPrivateKeyStructure keyStruct = new RSAPrivateKeyStructure(
                k.getModulus(),
                k.getPublicExponent(),
                k.getPrivateExponent(),
                k.getPrimeP(),
                k.getPrimeQ(),
                k.getPrimeExponentP(),
                k.getPrimeExponentQ(),
                k.getCrtCoefficient());
            keyData = keyStruct.getEncoded();
        } //End block
        else
    if(obj instanceof DSAPrivateKey)        
        {
            type = "DSA PRIVATE KEY";
            DSAPrivateKey k = (DSAPrivateKey)obj;
            DSAParams p = k.getParams();
            ASN1EncodableVector v = new ASN1EncodableVector();
            v.add(new DERInteger(0));
            v.add(new DERInteger(p.getP()));
            v.add(new DERInteger(p.getQ()));
            v.add(new DERInteger(p.getG()));
            BigInteger x = k.getX();
            BigInteger y = p.getG().modPow(x, p.getP());
            v.add(new DERInteger(y));
            v.add(new DERInteger(x));
            keyData = new DERSequence(v).getEncoded();
        } //End block
        else
    if(obj instanceof PrivateKey && "ECDSA".equals(((PrivateKey)obj).getAlgorithm()))        
        {
            type = "EC PRIVATE KEY";
            PrivateKeyInfo privInfo = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(((PrivateKey)obj).getEncoded()));
            keyData = privInfo.getPrivateKey().getEncoded();
        } //End block
    if(type == null || keyData == null)        
        {
            IllegalArgumentException var021E0AFEDC0B104C3DF8251384FB5750_38521236 = new IllegalArgumentException("Object type not supported: " + obj.getClass().getName());
            var021E0AFEDC0B104C3DF8251384FB5750_38521236.addTaint(taint);
            throw var021E0AFEDC0B104C3DF8251384FB5750_38521236;
        } //End block
        String dekAlgName = Strings.toUpperCase(algorithm);
    if(dekAlgName.equals("DESEDE"))        
        {
            dekAlgName = "DES-EDE3-CBC";
        } //End block
        int ivLength = dekAlgName.startsWith("AES-") ? 16 : 8;
        byte[] iv = new byte[ivLength];
        random.nextBytes(iv);
        byte[] encData = PEMUtilities.crypt(true, provider, keyData, password, dekAlgName, iv);
        List headers = new ArrayList(2);
        headers.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        headers.add(new PemHeader("DEK-Info", dekAlgName + "," + getHexEncoded(iv)));
PemObject var79A72CD62B537839C32B7D798B57EB9A_2045118461 =         new PemObject(type, headers, encData);
        var79A72CD62B537839C32B7D798B57EB9A_2045118461.addTaint(taint);
        return var79A72CD62B537839C32B7D798B57EB9A_2045118461;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.215 -0400", hash_original_method = "E9B86B455C150CA2FE6340A6ABEAFEB2", hash_generated_method = "6F66F4556173AD08253F6D154CE4AD46")
    public PemObject generate() throws PemGenerationException {
        try 
        {
    if(algorithm != null)            
            {
PemObject var0D425B93EA0F5CFC7CE482DC18F6A7D9_834031453 =                 createPemObject(obj, algorithm, password, random);
                var0D425B93EA0F5CFC7CE482DC18F6A7D9_834031453.addTaint(taint);
                return var0D425B93EA0F5CFC7CE482DC18F6A7D9_834031453;
            } //End block
PemObject var91CB8476853FA00A57326519F50A2259_373193359 =             createPemObject(obj);
            var91CB8476853FA00A57326519F50A2259_373193359.addTaint(taint);
            return var91CB8476853FA00A57326519F50A2259_373193359;
        } //End block
        catch (IOException e)
        {
            PemGenerationException var5DA133951ACB92A3B1BFF8614E877F26_884442722 = new PemGenerationException("encoding exception: " + e.getMessage(), e);
            var5DA133951ACB92A3B1BFF8614E877F26_884442722.addTaint(taint);
            throw var5DA133951ACB92A3B1BFF8614E877F26_884442722;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //if (algorithm != null)
            //{
                //return createPemObject(obj, algorithm, password, random);
            //}
            //return createPemObject(obj);
        //}
        //catch (IOException e)
        //{
            //throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        //}
    }

    
}

