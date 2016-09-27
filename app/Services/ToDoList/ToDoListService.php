<?php

namespace App\Services\ToDoList;

use App\Model\ToDoList;
use App\Services\Service;

class ToDoListService extends Service
{

    protected $toDoList;

    /**
     * ToDoListService constructor.
     * @param $toDoList
     */
    public function __construct(ToDoList $toDoList)
    {
        $this->toDoList = $toDoList;
    }


    /**
     * 保存计划
     *
     * @param array $params
     * @return boolean
     */
    public function save($params = [])
    {
        $toDoList = new ToDoList;
        $toDoList->user_id = $params['userID'];
        $toDoList->content = $params['content'];
        $toDoList->is_marked = 0;
        return $toDoList->save();
    }


    /**
     * 删除计划
     *
     * @param int $id
     */
    public function drop($id = 0)
    {
        $toDoList = ToDoList::find($id);
        return $toDoList->delete();
    }


    /**
     * 更新计划
     *
     * @param int $id
     */
    public function update($id = 0)
    {
        $toDoList = ToDoList::find($id);
        $toDoList->is_marked = $toDoList->is_marked === 0 ? 1 : 0;
        return $toDoList->save();
    }


    /**
     * 获取所有计划
     *
     * @param int $userID
     * @return mixed
     */
    public function getAll($userID = 0)
    {
        return $this->toDoList->getAllByUser($userID);
    }


    /**
     * 获取某条特定to-do-list
     *
     * @param array $params
     * @return mixed
     */
    public function getByUserIDAndContent($params)
    {
        $userID = $params['userID'] ?: 0;
        $content = $params['content'] ?: '';
        return $this->toDoList->getByUserIDAndContent($userID, $content) ?: null;
    }


    public function get($id = 0)
    {
        return ToDoList::find($id);
    }

}