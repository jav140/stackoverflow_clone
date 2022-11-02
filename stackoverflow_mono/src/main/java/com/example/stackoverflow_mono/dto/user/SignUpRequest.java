package com.example.stackoverflow_mono.dto.user;

import com.example.stackoverflow_mono.dto.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignUpRequest implements Dto {
    @NotBlank
    private String fullName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private Set<String> role;

    //    private List<SocialNetwork> socialNetworks;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String image_url;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

//    public List<SocialNetwork> getSocialNetworks() {
//        return socialNetworks;
//    }
//
//    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
//        this.socialNetworks = socialNetworks;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
