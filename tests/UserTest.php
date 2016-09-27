<?php

use App\Services\User\UserService;
use Config;

class UserTest extends TestCase
{

    private $userService;

    /**
     * UserTest constructor.
     */
    public function __construct()
    {
        parent::__construct();
        $this->userService = new UserService();
    }


    /**
     * A basic test example.
     *
     * @return void
     */
    public function testExample()
    {
        $this->assertTrue(true);
    }


    public function testAddAdmin()
    {
        $name = 'caterina';
        $password = '123456';
        $role = 0;
        $email = '123@gmail.com';
        $params = compact('name', 'password', 'role', 'email');
        $this->userService->register($params);
    }


    public function testLogin()
    {
        $this->visit('/')->type('chw', 'name')->type('123456', 'password')->press('登录');
        echo session('user');
    }


    public function testGetUsersExpectManager()
    {
        echo $this->userService->getUsers();
    }

    public function testGetUserByID()
    {
        echo $this->userService->getUserByID(5);
    }

    public function testUpdate()
    {
        $id = 1;
        $name = 'chenwei';
        $user = compact('id', 'name');
        $this->userService->update($user);
    }

    public function test()
    {
        echo Config::get('member.auth.validator.name');
    }
}
