<?php

namespace App\Http\Controllers\Member;

use App\Services\ToDoList\ToDoListService;
use App\Util\JsonUtil;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Psy\Util\Json;

class ToDoListController extends Controller
{

    protected $toDoListService;

    public function __construct(ToDoListService $toDoListService)
    {
        $this->toDoListService = $toDoListService;
    }


    /**
     * 新增一条to-do-list
     *
     * @param  Request $request
     * @return JSON
     */
    public function store(Request $request)
    {
        $params = [
            'userID' => $request->get('userID') ?: 0,
            'content' => $request->get('content') ?: '',
        ];
        if ($this->toDoListService->save($params)) {
            $toDoList = $this->toDoListService->getByUserIDAndContent($params);
            exit(JsonUtil::toJson(0, $toDoList));
        } else {
            exit(JsonUtil::toJson(1));
        }
    }


    /**
     * 返回某用户所有to-do-list
     *
     * @param  int $id
     * @return JSON
     */
    public function show($id)
    {
        $toDoList = $this->toDoListService->getAll($id) ?: [];
        exit(JsonUtil::toJson(0, $toDoList));
    }


    /**
     * 更新一条to-do-list的标记状态
     *
     * @param  Request $request
     * @param  int $id
     * @return JSON
     */
    public function update(Request $request, $id)
    {
        if ($this->toDoListService->update($id)) {
            $toDoList = $this->toDoListService->get($id);
            exit(JsonUtil::toJson(0, [$toDoList]));
        } else {
            exit(JsonUtil::toJson(2));
        }
    }


    /**
     * 删除特定to-do-list
     *
     * @param  int $id
     * @return JSON
     */
    public function destroy($id)
    {
        if ($this->toDoListService->drop($id ?: 0)) {
            exit(JsonUtil::toJson(0));
        } else {
            exit(JsonUtil::toJson(3));
        }
    }
}
