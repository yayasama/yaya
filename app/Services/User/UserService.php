<?php

namespace App\Services\User;

use App\Services\Service;
use DB;
use App\Model\User;

class UserService extends Service
{


    /**
     * 用户注册
     *
     * @param array $data
     */
    function register($data = [])
    {
        User::create([
            'name' => $data['name'],
            'email' => $data['email'],
            'password' => bcrypt($data['password']),
        ]);
    }


    /**
     * 更新用户信息
     *
     * @param array $params
     */
    function update($params = [])
    {
        $user = User::find($params['id']);
        if ($user) {
            $user->name = $params['name'];
            $user->email = $params['email'];
            $user->save();
        }
    }


    /**
     * 获取所有用户信息
     *
     * @return array
     */
    function getUsers()
    {
        return User::all() ?: [];
    }


    /**
     * 根据id获取特定用户
     *
     * @param int $id
     * @return mixed
     */
    function getUserByID($id = 0)
    {
        return User::find($id);
    }


    /**
     * 根据id删除特定用户
     *
     * @param int $id
     */
    function dropUserByID($id = 0)
    {
        User::destroy($id);
    }

}