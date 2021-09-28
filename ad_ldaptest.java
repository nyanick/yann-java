import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

public class ad_ldaptest1 {
  public static void main(String a[]) {

    // set the LDAP authentication method
    String auth_method  = "simple";
    // set the LDAP client Version
    String ldap_version = "3";
    // This is our LDAP Server's IP
    String ldap_host    = "172.16.1.1";
    // This is our LDAP Server's Port
    String ldap_port    = "389";
    // This is our access ID
    String ldap_dn      = "bhfm-cam\\s2c.outil";
    //String ldap_dn      = "chandler.njie-obaker";
   // This is our access PW
    String ldap_pw      = "Douala*2021";
    //String ldap_pw      = "";
    // This is our base DN
    String base_dn      = "OU=SGBC,DC=bhfm-cam,DC=fr,DC=socgen,DC=com";
    //String base_dn = "CN=Njie Obaker Theophile Chandler,OU=Users,OU=SGBC,DC=bhfm-cam,DC=fr,DC=socgen,DC=com";
    
    String usern = "Chandler";

    LdapContext ctx      = null;
    Hashtable env       = new Hashtable();

    // Here we store the returned LDAP object data
    String dn           = "";
    // This will hold the returned attribute list
    Attributes attrs;

    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL,"ldap://" + ldap_host + ":" + ldap_port);
    env.put(Context.SECURITY_AUTHENTICATION, auth_method);
    env.put(Context.SECURITY_PRINCIPAL, ldap_dn);
    env.put(Context.SECURITY_CREDENTIALS, ldap_pw);
    env.put("java.naming.ldap.version", ldap_version);

    try{
      System.out.println("Connecting to host " + ldap_host + " at port " + ldap_port + "...");
      System.out.println();

      ctx = new InitialLdapContext(env,null);
      System.out.println("LDAP authentication successful!");
      
      
      

      // Specify the attribute list to be returned
      //String[] attrIDs = { "memberOf" };
      //String[] attrIDs = { "distinguishedName","cn","name","uid","sn","givenname","memberOf","samaccountname","userPrincipalName" };
        
      SearchControls ctls = new SearchControls();
      //ctls.setReturningAttributes(attrIDs);
      ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

      // Specify the search filter to match
      //String filter = "(objectClass=user)";
      //String filter = "(&(objectCategory=person)(objectClass=user))";
      //String filter = "(&(objectClass=user)(cn=*" + usern+"*))";
      //String filter = "(|(cn=* " + usern+"*)(cn=ITSM - * " + usern+"*)(cn=alt prefix - * " + usern+"*))";
      String filter = "(&(objectClass=user)(cn=*" + usern+"*))";
      System.out.println(filter);

      // Search the subtree for objects using the given filter
      NamingEnumeration answer = ctx.search(base_dn, filter, ctls);
      // Print the answer
      //Search.printSearchEnumeration(answer);

      while (answer.hasMoreElements()) {
        System.out.println("see me yann1");

        SearchResult sr = (SearchResult)answer.next();
        dn = sr.getName();
        attrs = sr.getAttributes();
        String distinguishedName = sr.getNameInNamespace();

        System.out.println("Found Object: " + dn + "," + base_dn);
        System.out.println("Found Value userPrincipalName: " + attrs.get("userPrincipalName").get());
        System.out.println("Found Value sn: " + (String)attrs.get("sn").get());
         System.out.println("Found Value givenName: " + (String)attrs.get("givenName").get());
        System.out.println("Found Value cn: " + (String)attrs.get("cn").get());
        //System.out.println("Found Value middleName: " + (String)attrs.get("middleName").get());
        System.out.println("Found Value mail: " + (String)attrs.get("mail").get());
        System.out.println("Found Value telephoneNumber: " + (String)attrs.get("telephoneNumber").get());
        System.out.println("Found Value distinguishedName: " + distinguishedName);
        
        
        /*
        if (attrs != null) {
          // we have some attributes for this object
          NamingEnumeration ae = attrs.getAll();
          while (ae.hasMoreElements()) {
            Attribute attr = (Attribute)ae.next();
            String attrId = attr.getID();
            System.out.println("Found Attribute: " + attrId);
            
            Enumeration vals = attr.getAll();
            while (vals.hasMoreElements()) {
              try{
                String attr_val = (String)vals.nextElement();
                System.out.println(attrId + ": " + attr_val);
              }
              catch(Exception e){
                System.out.println(e.getMessage());
              
              }
              
            }
            
          }
        }
        */

     }
     System.out.println("see me yann");

      // Close the context when we're done
      ctx.close();
    } catch (AuthenticationException authEx) {
      authEx.printStackTrace();
      System.out.println("LDAP authentication failed!");
    } catch (NamingException namEx) {
      System.out.println("LDAP connection failed!");
      namEx.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
   }
  }
}
