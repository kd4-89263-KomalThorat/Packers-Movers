package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exception.ApiException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.pojos.User;
import com.sunbeam.pojos.UserRole;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String signUp(UserReqDTO dto) {
		User UserEntity=modelMapper.map(dto, User.class);
		User persistentUser = userdao.save(UserEntity);
		persistentUser.setRole(UserRole.CUSTOMER);
		persistentUser.setDeleteStatus(false);
		return "Added new category with ID="+ persistentUser.getId();
	}

	@Override
	public UserRespDTO SignIn(AuthRequest dto) {
      User userEntity = userdao.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(() ->new ApiException("Invalid Email or password !!!!!"));
		return modelMapper.map(userEntity, UserRespDTO.class);
	}
}
	
