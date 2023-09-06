import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        String str = "First Name: Amiel\nLast Name: De Los Reyes\nLDAP: ADELO71\nEmail Address: adelo71@safeway.com\nRequest Type: Add\nEnvironment: QA, Development\nRoles: Admin, MF Read Only";

        // System.out.println(str);
        // System.out.println();
        // System.out.println(str.substring(12, 18));
        // System.out.println(str.substring(12));
        // String value = rightString.substring(array[i + 1]);
        // System.out.println(str.substring(12));

        String array[] = {"First Name: ", "Last Name: ", "LDAP: ", "Email Address: ", "Request Type: ", "Environment: ", "Roles: "};

        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

        for(int i = 0; i < array.length - 1; i++) {
            int index = str.indexOf(array[i]);
            int indexEnd = index + (array[i]).length();
            int indexNext = str.indexOf(array[i + 1]);
            // String rightString = str.substring(indexEnd);
            String value = str.substring(indexEnd, indexNext);

//            System.out.println(index);
//            System.out.println(indexEnd);
//            System.out.println(rightString);
//            System.out.println(indexNext);
            System.out.println(value);

            result.put(array[i], value);
        }

        // To handle Roles:
        int index = str.indexOf("Roles: ");
        String val = str.substring(index + 7);
        result.put("Roles: ", val);
        System.out.println(result);

    }
}
