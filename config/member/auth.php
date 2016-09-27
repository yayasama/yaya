<?php
return [
    'messages' => [
        'name.required' => '用户名为必填项',
        'email.required' => '邮箱为必填项',
        'password.required' => '密码为必填项',
        'password.min' => '密码不得少于6位'
    ],

    'validator' => [
        'name' => 'required|max:255',
        'email' => 'required|email|max:255|unique:users',
        'password' => 'required|min:6',
    ]
];