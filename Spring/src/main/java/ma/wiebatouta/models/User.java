package ma.wiebatouta.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.models.enums.ServerRole;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails, Serializable, Comparable<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username", unique = true, length = 30, nullable = false)
	@Length(min = 5, max = 20, message = "Veuillez respecter les contraintes pour valider votre username")
	@Pattern(regexp = ".*([a-zA-Z0-9]{4}$)")
	@NotEmpty
	@JsonIgnore
	@NotNull(message = "Le nom d'utilisateur ne doit pas être vide")
	private String username;
	private String password;

	private String roles;

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles.split(";")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return authorities;
	}

	public void addRole(ServerRole role) {
		roles = roles + role.getRole() + ";";
	}

	public void removeRole(ServerRole role) {
		String rolesTemp = roles;
		roles = "";
		for (String roleString : rolesTemp.split(";")) {
			if (roleString.equals(role.getRole()))
				continue;
			else
				roles = roles + roleString + ";";
		}
	}

	@Override
	public int compareTo(User o) {
		return username.compareTo(o.getUsername());
	}

}
