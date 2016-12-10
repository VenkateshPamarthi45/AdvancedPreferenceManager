# AdvancedPreferenceManager
This manager helps developers to reduce boilerplate code for storing values and even able to store complex dataStructures/Objects(ArrayList, HashSet...) without using 3rd libraries GSON/ObjectMapper
Used Java native serialize concept to convert object into byte array and later converted to String using Base64.

Example:
// Storing string
AdvancedPreferenceManager.getInstance(this).storeString("firstName","venky");

// Storing user model class
User user = new User("Betty", 23, 405);
AdvancedPreferenceManager.getInstance(this).storeObjectValue("LoggedUser",user);

// Store multi values at same time
AdvancedPreferenceManager.getInstance(this)
                .storeString("firstName","venky")
                .storeString("lastName","smith")
                .storeInt("age",25)
                .storeBoolean("isValidUser",true);

