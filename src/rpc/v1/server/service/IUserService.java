package rpc.v1.server.service;

import rpc.v1.server.domain.User;

public interface IUserService {

    User getUserByUserId(Integer id);

    Integer insertUserId(User user);
}

