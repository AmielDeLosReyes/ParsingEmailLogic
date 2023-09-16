import java.util.*;

public class Main {
    public static void main(String[] args) {
        String parsedEmail = "**AUTO-GENERATED - DO NOT REPLY TO THIS E-MAIL, THE MAILBOX IS NOT MONITORED.Dear Service Delivery - Offer ManagementPlease complete the pending task TASK326123 for the service Add/ModifyRemove user in OMS for all requested environments (see request details).First Name: AmielLast Name: De Los ReyesLDAP ID: ADELO71Email Address: adelo71@safeway.comRequest Type: AddSelect environment(s) needed: Production, QA, DevelopmentSelect your role(s): Admin, MF Read Only, SC Builder";

        // System.out.println(str);
        // System.out.println();
        // System.out.println(str.substring(12, 18));
        // System.out.println(str.substring(12));
        // String value = rightString.substring(array[i + 1]);
        // System.out.println(str.substring(12));

        String[] array = {"First Name: ", "Last Name: ", "LDAP ID: ", "Email Address: ", "Request Type: ", "Select environment(s) needed: ", "Select your role(s): "};

        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

        for(int i = 0; i < array.length - 1; i++) {
            int index = parsedEmail.indexOf(array[i]);
            int indexEnd = index + (array[i]).length();
            int indexNext = parsedEmail.indexOf(array[i + 1]);
            // String rightString = str.substring(indexEnd);
            String value = parsedEmail.substring(indexEnd, indexNext);

//            System.out.println(index);
//            System.out.println(indexEnd);
//            System.out.println(rightString);
//            System.out.println(indexNext);
            System.out.println(value);

            result.put(array[i].replaceAll("[:]", "").trim(), value.trim());
        }

        // To handle Roles:
        int index = parsedEmail.indexOf("Select your role(s):");
        String val = parsedEmail.substring(index + 21);
        result.put("Roles: ", val);
        System.out.println(result);

        List<String> listValues = new ArrayList<String>(result.values());
        List<String> listKeys = new ArrayList<String>(result.keySet());

        System.out.println("List contains:");


        // Work variables
        String firstName = null;
        String lastName = null;
        String LDAP = null;
        String email = null;
        String requestType = null;
        String environments = null;
        String roles = null;

        // Get the values in respective order.
        for(int i = 0; i < listValues.size(); i++) {

            System.out.println("Index " + i + " is " + listValues.get(i));

            switch(i) {
                case 0:
                    firstName = listValues.get(i);
                    break;
                    
                case 1:
                    lastName = listValues.get(i);
                    break;
                    
                case 2:
                    LDAP = listValues.get(i);
                    break;
                    
                case 3:
                    email = listKeys.get(i);
                    break;
                    
                case 4:
                    requestType = listKeys.get(i);
                    break;
                    
                case 5:
                    environments = listValues.get(i);
                    break;
            }
        }

        String rolesLastElement = listValues.get(listValues.size() - 1);

        System.out.println(rolesLastElement);
        String[] rolesArray = rolesLastElement.split(",");
        for(int i = 0; i < rolesArray.length; i++) {
            rolesArray[i] = rolesArray[i].trim();
            rolesArray[i] = "\"" + rolesArray[i] + "\"";
        }

        System.out.println(Arrays.toString(rolesArray));
        String rolesConverted = String.join(",", rolesArray);
        System.out.println("Roles are " + rolesConverted);

        // variable for role
        roles = rolesConverted;
        
        System.out.println("First Name is: " + firstName);
        System.out.println("Last Name is: " + lastName);
        System.out.println("LDAP is: " + LDAP);
        System.out.println("Email Address is: " + email);
        System.out.println("Environment(s) is/are: " + environments);
        System.out.println("Role(s) is/are: " + roles);
        
    } // end of main
} // end of class
