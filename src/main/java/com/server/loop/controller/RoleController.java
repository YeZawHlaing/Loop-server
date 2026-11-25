package com.server.loop.controller;

import com.server.loop.dto.requestDto.RoleRequestDto;
import com.server.loop.dto.responseDto.RoleResponseDto;
import com.server.loop.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@Valid @RequestBody final RoleRequestDto requestDto) {
        final RoleResponseDto createdRole = roleService.createRole(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable final Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RoleResponseDto> getRoleByName(@PathVariable final String name) {
        return ResponseEntity.ok(roleService.getRoleByName(name));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(
            @PathVariable final Long id,
            @Valid @RequestBody final RoleRequestDto requestDto) {
        return ResponseEntity.ok(roleService.updateRole(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable final Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
