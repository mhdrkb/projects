package com.mhd.realstate.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter First Name")
    @Size(min = 1, max = 50, message = "Hey, Size must be between 1 and 50")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Enter Last Name")
    @Size(min = 1, max = 50, message = "Hey, Size must be between 1 and 50")
    @Column(nullable = false)
    private String lastName;


    @Size(min = 4, max = 100, message = "UserName at lest 5 character")
    @Column(nullable = false , unique = true)
    private String userName;

    @Size(min = 4, max = 300, message = "Password at lest 4 character")
    @Column(nullable = true)
    private String password;

    @NotBlank(message = "Enter your email")
    @Column(nullable = false)
    private String email;

    @Column(unique = true)
    private String mobile;


    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;

    //////Token Activation ==============
    private boolean enabled;

    @Column(nullable = false)
    private String confirmationToken;

    private boolean tokenExpired;

    //////File Upload==============
    @Column(nullable = true)
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(@NotEmpty(message = "Enter First Name") @Size(min = 1, max = 50, message = "Hey, Size must be between 1 and 50") String firstName, @NotEmpty(message = "Enter Last Name") @Size(min = 1, max = 50, message = "Hey, Size must be between 1 and 50") String lastName, @Size(min = 4, max = 100, message = "UserName at lest 5 character") String userName, @Size(min = 4, max = 300, message = "Password at lest 4 character") String password, @NotBlank(message = "Enter your email") String email, Date birthDate, boolean enabled, String confirmationToken, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
    }

    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.mobile = user.mobile;
        this.gender = user.gender;
        this.regiDate = user.regiDate;
        this.lastModifiedDate = user.lastModifiedDate;
        this.birthDate = user.birthDate;
        this.enabled = user.enabled;
        this.confirmationToken = user.confirmationToken;
        this.tokenExpired = user.tokenExpired;
        this.fileSize = user.fileSize;
        this.fileName = user.fileName;
        this.filePath = user.filePath;
        this.fileExtension = user.fileExtension;
        this.roles = user.roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                tokenExpired == user.tokenExpired &&
                fileSize == user.fileSize &&
                Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(regiDate, user.regiDate) &&
                Objects.equals(lastModifiedDate, user.lastModifiedDate) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(confirmationToken, user.confirmationToken) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(filePath, user.filePath) &&
                Objects.equals(fileExtension, user.fileExtension) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, email, mobile, gender, regiDate, lastModifiedDate, birthDate, enabled, confirmationToken, tokenExpired, fileSize, fileName, filePath, fileExtension, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", birthDate=" + birthDate +
                ", enabled=" + enabled +
                ", confirmationToken='" + confirmationToken + '\'' +
                ", tokenExpired=" + tokenExpired +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", roles=" + roles +
                '}';
    }
    //    public User() {
//    }
//
//    public User(@NotEmpty(message = "Enter First Name") @Size(min = 1, max = 50, message = "Hey, Size must be between 1 and 50") String firstName, String lastName, @NotEmpty(message = "Enter Username") String userName, @NotEmpty @Email @NotEmpty(message = "Enter An Email") String email, Date birthDate, boolean enabled, String confirmationToken, boolean tokenExpired, Set<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.email = email;
//        this.birthDate = birthDate;
//        this.enabled = enabled;
//        this.confirmationToken = confirmationToken;
//        this.tokenExpired = tokenExpired;
//        this.roles = roles;
//    }
//
//    public User(User user) {
//        this.firstName = user.firstName;
//        this.lastName = user.lastName;
//        this.userName = user.userName;
//        this.password = user.password;
//        this.email = user.email;
//        this.mobile = user.mobile;
//        this.gender = user.gender;
//        this.regiDate = user.regiDate;
//        this.lastModifiedDate = user.lastModifiedDate;
//        this.birthDate = user.birthDate;
//        this.enabled = user.enabled;
//        this.confirmationToken = user.confirmationToken;
//        this.tokenExpired = user.tokenExpired;
//        this.fileSize = user.fileSize;
//        this.fileName = user.fileName;
//        this.filePath = user.filePath;
//        this.fileExtension = user.fileExtension;
//        this.roles = user.roles;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getRegiDate() {
//        return regiDate;
//    }
//
//    public void setRegiDate(Date regiDate) {
//        this.regiDate = regiDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public String getConfirmationToken() {
//        return confirmationToken;
//    }
//
//    public void setConfirmationToken(String confirmationToken) {
//        this.confirmationToken = confirmationToken;
//    }
//
//    public boolean isTokenExpired() {
//        return tokenExpired;
//    }
//
//    public void setTokenExpired(boolean tokenExpired) {
//        this.tokenExpired = tokenExpired;
//    }
//
//    public long getFileSize() {
//        return fileSize;
//    }
//
//    public void setFileSize(long fileSize) {
//        this.fileSize = fileSize;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public String getFileExtension() {
//        return fileExtension;
//    }
//
//    public void setFileExtension(String fileExtension) {
//        this.fileExtension = fileExtension;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return isEnabled() == user.isEnabled() &&
//                getFileSize() == user.getFileSize() &&
//                Objects.equals(getId(), user.getId()) &&
//                Objects.equals(getFirstName(), user.getFirstName()) &&
//                Objects.equals(getLastName(), user.getLastName()) &&
//                Objects.equals(getUserName(), user.getUserName()) &&
//                Objects.equals(getPassword(), user.getPassword()) &&
//                Objects.equals(getEmail(), user.getEmail()) &&
//                Objects.equals(getMobile(), user.getMobile()) &&
//                Objects.equals(getGender(), user.getGender()) &&
//                Objects.equals(getRegiDate(), user.getRegiDate()) &&
//                Objects.equals(getLastModifiedDate(), user.getLastModifiedDate()) &&
//                Objects.equals(getBirthDate(), user.getBirthDate()) &&
//                Objects.equals(getConfirmationToken(), user.getConfirmationToken()) &&
//                Objects.equals(getFileName(), user.getFileName()) &&
//                Objects.equals(getFilePath(), user.getFilePath()) &&
//                Objects.equals(getFileExtension(), user.getFileExtension()) &&
//                Objects.equals(getRoles(), user.getRoles());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getFirstName(), getLastName(), getUserName(), getPassword(), getEmail(), getMobile(), getGender(), getRegiDate(), getLastModifiedDate(), getBirthDate(), isEnabled(), getConfirmationToken(), getFileSize(), getFileName(), getFilePath(), getFileExtension(), getRoles());
//    }
}
