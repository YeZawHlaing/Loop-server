package com.server.loop.service.serviceImpl;


import com.server.loop.dto.requestDto.RoleRequestDto;
import com.server.loop.dto.responseDto.RoleResponseDto;
import com.server.loop.models.Role;
import com.server.loop.repositories.RoleRepository;
import com.server.loop.service.RoleService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoleResponseDto createRole(final RoleRequestDto requestDto) {
        final String normalizedName = requestDto.getName().trim().toUpperCase();

        if (roleRepository.existsByNameIgnoreCase(normalizedName)) {
            throw new EntityExistsException("Role already exists with name: " + normalizedName);
        }

        final Role role = modelMapper.map(requestDto, Role.class);
        role.setName(normalizedName);

        final Role savedRole = roleRepository.save(role);
        return modelMapper.map(savedRole, RoleResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleResponseDto getRoleById(final Long id) {
        final Role role = findRoleEntityById(id);
        return modelMapper.map(role, RoleResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleResponseDto getRoleByName(final String name) {
        final Role role = roleRepository.findByNameIgnoreCase(name.trim())
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + name));
        return modelMapper.map(role, RoleResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleResponseDto.class))
                .toList();
    }

    @Override
    public RoleResponseDto updateRole(final Long id, final RoleRequestDto requestDto) {
        final Role existingRole = findRoleEntityById(id);
        final String normalizedName = requestDto.getName().trim().toUpperCase();

        if (!existingRole.getName().equalsIgnoreCase(normalizedName)
                && roleRepository.existsByNameIgnoreCase(normalizedName)) {
            throw new EntityExistsException("Role already exists with name: " + normalizedName);
        }

        modelMapper.map(requestDto, existingRole);
        existingRole.setName(normalizedName);

        final Role updatedRole = roleRepository.save(existingRole);
        return modelMapper.map(updatedRole, RoleResponseDto.class);
    }

    @Override
    public void deleteRole(final Long id) {
        final Role role = findRoleEntityById(id);
        roleRepository.delete(role);
    }

    private Role findRoleEntityById(final Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
    }
}
