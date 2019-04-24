package tk.giaiphapchannuoi.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Permissions;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.model.Roles;
import tk.giaiphapchannuoi.server.model.Users;
import tk.giaiphapchannuoi.server.repository.PermissionRepository;
import tk.giaiphapchannuoi.server.repository.RolePermissionRepository;
import tk.giaiphapchannuoi.server.repository.RolesRepository;
import tk.giaiphapchannuoi.server.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Users user = userRepository.findByUsernameAndDelFlag(username,false)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + username)
        );

        List<String> permissionsName = findPermissionsName(user);

        return UserPrincipal.create(user, permissionsName);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        Optional<Users> users = userRepository.findById(id);
        Users user = users.get();

        List<String> permissionsName = findPermissionsName(user);

        return UserPrincipal.create(user, permissionsName);
    }

    //Tim tat ca ten permission cua role
    private List<String> findPermissionsName(Users user){
        //xac dinh role cua user
        Roles role = rolesRepository.findByIdAndDelFlag(user.getRole().getId(),false).get();

        //Tim ten cac permission cua role
        List<RolePermission> rolePermissionsList = rolePermissionRepository.findAllByRoleAndDelFlag(role,false);
        List<Permissions> PermissionsList = new ArrayList<Permissions>();
        List<String> permissionsName = new ArrayList<String>();

        for (RolePermission r : rolePermissionsList) {
            //Lay tat ca permission co Role vưa tim o tren
            Optional<Permissions> permissions = permissionRepository.findByIdAndDelFlag(r.getPermission().getId(),false);
            if(permissions.isPresent()){
                PermissionsList.add(permissions.get());
            }
        }

        //Lay name permission
        for (Permissions p: PermissionsList){
            permissionsName.add(p.getCode());
        }

        return permissionsName;
    }
}