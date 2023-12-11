package com.ground.sswm.auth.oauth.model;

public interface OAuthUserInfo {

    String getProviderId();

    String getProvider();

    String getEmail();

    String getName();

    String getProfileImg();

    String getNickname();
}
