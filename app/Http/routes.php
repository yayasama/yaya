<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

$router->group([
    'namespace' => 'Common',
    'middleware' => 'auth'
], function () {
    Route::get('/', 'IndexController@index');
});


$router->group([
    'namespace' => 'Member'
], function () {
    Route::get('user/login', 'UserController@login');
    Route::post('user/check', 'UserController@checkMsg');
    Route::get('user/logout', 'UserController@logout');
    Route::get('user/{id}/delete', 'UserController@destroy');
    Route::resource('user', 'UserController');
});


$router->group([
    'namespace' => 'Record',
    'middleware' => 'auth'
], function () {
    Route::resource('record', 'RecordController');
});

$router->group([
    'namespace' => 'Category',
    'middleware' => 'auth'
], function () {
    Route::get('category/{id}/delete', 'CategoryController@destroy');
    Route::resource('category', 'CategoryController');
});

$router->group([
    'namespace' => 'Member'
], function () {
    Route::resource('toDoList', 'ToDoListController');
}
);


// 发送密码重置链接路由
Route::get('password/email', 'Auth\PasswordController@getEmail');
Route::post('password/email', 'Auth\PasswordController@postEmail');

// 密码重置路由
Route::get('password/reset/{token}', 'Auth\PasswordController@getReset');
Route::post('password/reset', 'Auth\PasswordController@postReset');



