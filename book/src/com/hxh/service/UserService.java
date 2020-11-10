package com.hxh.service;

import com.hxh.pojo.User;

public interface UserService {

    /**
     * 注 册 用 户 * @param user
     */
    public void registUser(User user);

    /**
     * 登 录 * @param user * @return 如 果 返 回 null ， 说 明 登 录 失 败 ， 返 回 有 值 ， 是 登 录 成 功
     */
    public User login(User user);

    /**
     * 检 查 用 户 名 是 否 可 用 * @param username * @return 返 回 true 表 示 用 户 名 已 存 在 ， 返 回 false
     * 表 示 用 户 名 可 用
     */
    public boolean existsUsername(String username);

}
