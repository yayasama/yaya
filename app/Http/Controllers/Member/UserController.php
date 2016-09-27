<?php

namespace App\Http\Controllers\Member;

use App\Services\User\UserService;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Config;

class UserController extends Controller
{
    private $userService;

    public function __construct(UserService $userService)
    {
        $this->userService = $userService;
    }


    /**
     * 返回所有用户信息
     *
     * @return mixed
     */
    public function index()
    {
        $users = $this->userService->getUsers();
        return view('user.list', ['users' => $users]);
    }


    /**
     * 跳转至登录页面
     *
     * @return mixed
     */
    public function login()
    {
        return view('user.login');
    }


    /**
     * 校验登录信息
     *
     * @param Request $request
     * @return mixed
     */
    public function checkMsg(Request $request)
    {
        $name = $request->get('name');
        $password = $request->get('password');
        $remember = $request->get('remember');
        $userInfo = compact('name', 'password');

        if (Auth::attempt($userInfo, $remember)) {
            $request->session()->put('user', Auth::getUser());
            return redirect('/');
        } else {
            return view('user.login', ['error' => '用户名或密码错误']);
        }
    }


    /**
     * 跳转至注册页面
     *
     * @return mixed
     */
    public function create()
    {
        return view('user.register');
    }


    /**
     * 注册用户信息
     *
     * @param  Request $request
     * @return mixed
     */
    public function store(Request $request)
    {
        $messages = Config::get('member.auth.messages');
        $validator = Config::get('member.auth.validator');
        $this->validate($request, $validator, $messages);

        $name = $request->get('name');
        $password = $request->get('password');
        $email = $request->get('email');

        $param = compact('name', 'password', 'email');
        $this->userService->register($param);

        return redirect('user/login');
    }


    /**
     * 用户注销
     *
     * @return mixed
     */
    public function logout()
    {
        Auth::logout();
        return view('user.login');
    }


    /**
     * 返回特定用户信息
     *
     * @param  int $id
     * @return mixed
     */
    public function show($id)
    {
        $user = $this->userService->getUserByID($id);

        return view('', ['user' => $user]);
    }


    /**
     * 跳转至用户编辑页面
     *
     * @param  int $id
     * @return mixed
     */
    public function edit($id)
    {
        $user = $this->userService->getUserByID($id);

        return view('user.update', ['user' => $user]);
    }


    /**
     * 更新单用户信息
     *
     * @param  Request $request
     * @param  int $id
     * @return mixed
     */
    public function update(Request $request, $id)
    {
        $messages = Config::get('member.update.messages');
        $validator = Config::get('member.update.validator');
        $this->validate($request, $validator, $messages);

        $name = $request->get('name');
        $email = $request->get('email');

        $param = compact('id', 'name', 'email');

        $this->userService->update($param);

        return redirect()->action('Member\UserController@index');
    }


    /**
     * 删除特定用户
     *
     * @param  int $id
     * @return mixed
     */
    public function destroy($id)
    {
        $this->userService->dropUserByID($id);
        return redirect()->action('Member\UserController@index');
    }

}
