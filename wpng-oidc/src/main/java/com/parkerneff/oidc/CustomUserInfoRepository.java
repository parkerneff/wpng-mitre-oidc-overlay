package com.parkerneff.oidc;

import com.google.gson.JsonObject;
import org.mitre.openid.connect.model.Address;
import org.mitre.openid.connect.model.DefaultUserInfo;
import org.mitre.openid.connect.model.UserInfo;
import org.mitre.openid.connect.repository.UserInfoRepository;

public class CustomUserInfoRepository implements UserInfoRepository {
    @Override
    public UserInfo getByUsername(String s) {
        UserInfo userInfo = new DefaultUserInfo();
        userInfo.setName(s);
        userInfo.setPreferredUsername("JOE");
        userInfo.setEmail("parker@parkerneff.com");
        return userInfo;
    }

    @Override
    public UserInfo getByEmailAddress(String s) {


        return getByUsername(s);
    }
}
