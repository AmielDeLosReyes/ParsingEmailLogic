import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {

        // hardcoded string
        String str2 = "First Name: Amiel\nLast Name: De Los Reyes\nLDAP: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nAcceptance: Yes\nDevelopment: Yes\nOMS Admin (All Roles): Yes\nOMS MF Builder: Yes";

        String str3 = "First Name: Amiel\nLast Name: De Los Reyes\nLDAP: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nAcceptance: Yes\nDevelopment: Yes\nProduction: Yes\nOMS Admin (All Roles): Yes\nOMS MF Builder: Yes\nTesting: Yes\nAno pa: Yes";

        // split the string into semicolons and new lines
        String[] s = str3.split("[:\n]");

        // put the key-value pair result into a linked hash map
        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

        // create an ArrayList for the fields and values
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        // odd index are key, even index are value
        for(int i = 0; i < s.length; i++) {
            if(i % 2 == 0) {
                switch(s[i]) {
                    case "First Name":
                        s[i] = "first_name";
                        break;

                    case "Last Name":
                        s[i] = "last_name";
                        break;

                    case "LDAP":
                        s[i] = "user_id";
                        break;

                    case "Email Address":
                        s[i] = "email";
                        break;
                }

                fields.add(s[i]);
            }else {
                values.add(s[i].trim());
            }
        }

        // insert appropriate key-value pairs into hash map
        for(int j = 0; j < fields.size(); j++) {
            result.put(fields.get(j), values.get(j));
        }

        System.out.println("The result set is: \n" + result);

    }
}
