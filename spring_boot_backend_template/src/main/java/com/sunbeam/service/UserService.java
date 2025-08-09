package com.sunbeam.service;

import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;

public interface UserService {
	String signUp(UserReqDTO dto);
	UserRespDTO SignIn(AuthRequest dto);

}
