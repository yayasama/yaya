<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 8/10/2016
 * Time: 1:49 PM
 */

namespace tests;

use App\Model\ToDoList;
use App\Services\ToDoList\ToDoListService;
use TestCase;
use Config;

class ToDoListTest extends TestCase
{

    private $toDoListService;

    /**
     * ToDoListTest constructor.
     */
    public function __construct()
    {
        parent::__construct();
        $this->toDoListService = new ToDoListService(new ToDoList());
    }


    public function testDB()
    {
        echo json_encode($this->toDoListService->getAll(0));
    }

    public function testSave()
    {
        $params = [
            'user_id' => 2,
            'content' => 'todo'
        ];
        $this->toDoListService->save($params);
    }

    public function testDrop()
    {
        $this->toDoListService->drop(1);
    }

    public function testUpdate()
    {
        $param = [
            'id' => 2,
            'userID' => 1,
            'content' => 'todo then',
            'isMarked' => 1
        ];
        $this->toDoListService->update($param);
    }

    public function testGetAll()
    {
        echo json_encode($this->toDoListService->getAll(1));
    }

}