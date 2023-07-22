package org.shopManager.controller;

import org.shopManager.model.entity.Profile;
import org.shopManager.model.entity.User;
import org.shopManager.model.service.ProfileService;

public class SessionManager {

    private static User loggedUser;
    private static Profile profile;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User user) {
        loggedUser = user;
        try {
            profile = new ProfileService().getProfileByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Profile getProfile() {
        return profile;
    }

}
