package com.hxh.dao;

import com.hxh.pojo.User;

public interface UserDao {


    /**
     * 根 据 用 户 名 查 询 用 户 信 息
     * * @param username 用 户 名
     * * @return 如 果 返 回 null, 说 明 没 有 这 个 用 户 。 反 之 亦 然
     */
    public User queryUserByUsername(String username);

    /**
     * 根 据 用 户 名 和 密 码 查 询 用 户 信 息
     * * @param username * @param password
     * * @return 如 果 返 回 null, 说 明 用 户 名 或 密 码 错 误 , 反 之 亦 然
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保 存 用 户 信 息
     * * @param user
     * * @return 返 回 -1
     * 表 示 操 作 失 败 ， 其 他 是 sql
     * 语 句 影 响 的 行 数
     */
    public int saveUser(User user);
}
