# AdvancedPreferenceManager
This manager helps developers to reduce boilerplate code for storing values and even able to store complex dataStructures/Objects(ArrayList, HashSet...) without using 3rd libraries GSON/ObjectMapper

> Used Java native serialize concept to convert object into byte array and converted to String using Base64.

<b>Example:</b>
AdvancedPreferenceManager.getInstance(this).storeString("firstName","venky");

User user = new User("Betty", 23, 405);
AdvancedPreferenceManager.getInstance(this).storeObjectValue("LoggedUser",user);

AdvancedPreferenceManager.getInstance(this)
                .storeString("firstName","venky")
                .storeString("lastName","smith")
                .storeInt("age",25)
                .storeBoolean("isValidUser",true);
                
<b>Retrieving Values:</b>
String firstName  = AdvancedPreferenceManager.getInstance(this).getString("firstName");
        int age  = AdvancedPreferenceManager.getInstance(this).getInt("age");
        boolean isValidUser  = AdvancedPreferenceManager.getInstance(this).getBoolean("isValidUser", false);
        Set<String> rNames = AdvancedPreferenceManager.getInstance(this).getStringSet("names");
        Float fNum = AdvancedPreferenceManager.getInstance(this).getFloat("fNum");
        Long lNum = AdvancedPreferenceManager.getInstance(this).getLong("number");
        User sameUser = (User) AdvancedPreferenceManager.getInstance(this).getObjectValue("user");
