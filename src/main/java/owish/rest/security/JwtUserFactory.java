package owish.rest.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import owish.model.user.Authority;
import owish.model.user.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
				user.getEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}
	/*private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		List<GrantedAuthority> grantedAuthorityList = new ArrayList();
	
		Map<Authority,SimpleGrantedAuthority> map = new HashMap();
		for (Authority authority : authorities) {
			
			map.put(authority, new SimpleGrantedAuthority(authority.getName().name()));
			
		}
		List<Object> grantedAuthorityList = map.values().stream().collect(Collectors.toList());
		authorities.stream().ma
		Collectors.toList()
	    return authorities.stream()
	            .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
	            .collect(Collectors.toList());
	}*/
}
