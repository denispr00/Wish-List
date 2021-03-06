package owish.rest.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

    private final Long id;

	private final String userName;
	private final String firstName;
	private final String lastName;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;

    public JwtUser(
          Long id,
			String userName, String firstName, String lastName,
          String email,
          String password, Collection<? extends GrantedAuthority> authorities,
			boolean enabled
    ) {
        this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
	public String getUsername() {
		return userName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
		return firstName;
    }

    public String getLastname() {
		return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
