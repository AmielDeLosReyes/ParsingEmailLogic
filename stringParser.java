import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {

        // PARSING EMAIL CODE

        // hardcoded string
        String str2 = "First Name: Amiel\nLast Name: De Los Reyes\nLDAP: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nAcceptance: Yes\nDevelopment: Yes\nOMS Admin (All Roles): Yes\nOMS MF Builder: Yes";

        String str3 = "First Name: Amiel\nLast Name: De Los Reyes\nLDAP: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nAcceptance: Yes\nDevelopment: Yes\nProduction: Yes\nOMS Admin (All Roles): Yes\nOMS MF Builder: Yes\nTesting: Yes\nAno pa: Yes";

        String parsedEmail = "**AUTO-GENERATED - DO NOT REPLY TO THIS E-MAIL, THE MAILBOX IS NOT MONITORED.\nDear Service Delivery - Offer Management\nPlease complete the pending task TASK326123 for the service Add/ModifyRemove user in OMS for all requested environments (see request details).\nFirst Name: Amiel\nLast Name: De Los Reyes\nLDAP ID: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nSelect environment(s) needed: Production, QA, Development\nSelect your role(s): Admin, MF Read Only, SC Builder";

        // start the string where First Name is located
        String str4 = parsedEmail.substring(parsedEmail.indexOf("First Name: "));


        // split the string into semicolons and new lines
        String[] s = str4.split("[:\n]");


        // put the key-value pair result into a linked hash map
        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

        // create an ArrayList for the fields and values
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        //
        for(int i = 0; i < s.length; i++) {
            // if index is even, then it is the fields
            if(i % 2 == 0) {
                switch (s[i]) {
                    case "First Name" -> s[i] = "first_name";
                    case "Last Name" -> s[i] = "last_name";
                    case "LDAP ID" -> s[i] = "user_id";
                    case "Email Address" -> s[i] = "email";
                    case "Select environment(s) needed" -> s[i] = "Environments";
                    case "Select your role(s)" -> s[i] = "roles";
                }

                fields.add(s[i]);
            } else { // else it is the values
                values.add(s[i].trim());
            }
        }

        // insert appropriate key-value pairs into hash map
        for(int j = 0; j < fields.size(); j++) {
            result.put(fields.get(j), values.get(j));
        }

        System.out.println("The result set is: \n" + result);

        System.out.println();
        System.out.println("First Name is " + result.get("first_name"));
        System.out.println("Last Name is " + result.get("last_name"));
        System.out.println("LDAP is " + result.get("user_id"));
        System.out.println("Email is " + result.get("email"));
        System.out.println("Request Type is " + result.get("Request Type"));
        System.out.println("Environments is " + result.get("Environments"));

        // INSERTING TO DATABASE CODE
//        String firstName = result.get("first_name");
//        String lastName = result.get("last_name");
//        String LDAP = result.get("user_id");
//        String email = result.get("email");
        String requestType = result.get("Request Type");
        String environments = result.get("Environments");
        String roles = result.get("roles");

        // split the environments
        String[] environmentsArray = environments.split(",");

        // split the roles
        String[] rolesArray = roles.split(",");

        // check each environments and insert the user there.
        for (int i = 0; i < environmentsArray.length; i++) {
            String trimmedString = environmentsArray[i].trim();

            if(trimmedString.equals("Acceptance")) {
                System.out.println("Do this in Acceptance.");
            }

            if(trimmedString.equals("QA")) {
                System.out.println("Do this in QA.");
            }

            if(trimmedString.equals("Development")) {
                System.out.println("Do this in Development.");
            }

            if(trimmedString.equals("Production")) {
                System.out.println("Do this in Production.");
            }
        }

        // add double-quotations to the roles for formatting
        for (int i = 0; i < rolesArray.length; i++) {
            rolesArray[i] = rolesArray[i].trim();
            rolesArray[i] = "\"" + rolesArray[i] + "\"";
        }

        // convert roles array into a single string
        String rolesConverted = String.join(",", rolesArray);

        System.out.println("Roles are " + rolesConverted);

        switch (requestType) {
            case "Add" -> {
                System.out.println("We are adding a user to the database");
                System.out.println("@Query(\"INSERT INTO users (user_id, create_ts, create_user_id, email, first_name, last_name, preference, roles, solr_query_update, user_id) VALUES (LDAP, dateof(now()), 'sysusr', email, firstName, lastName, null, roles, null, dateof(now()), 'sysusr');");
            }
            case "Modify" -> System.out.println("Modify Roles Query");
            case "Remove" -> System.out.println("Remove Roles Query");
        }


        // @Query("INSERT INTO users (user_id, create_ts, create_user_id, email, first_name, last_name, preference, roles, solr_query_update, user_id) VALUES (LDAP, dateof(now()), 'sysusr', email, firstName, lastName, null, roles, null, dateof(now()), 'sysusr');

        //  @Query("INSERT INTO users (user_id, create_ts, create_user_id, email, first_name, last_name, preference, roles, solr_query_update, user_id) VALUES (?1, dateof(now()), 'sysusr', ?2, ?3, ?4, null, ?5, null, dateof(now()), 'sysusr');
        // void insertUser(String LDAP, String email, String firstName, String lastName, String roles)
    }
}
